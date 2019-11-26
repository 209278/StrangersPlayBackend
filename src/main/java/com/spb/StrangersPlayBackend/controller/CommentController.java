package com.spb.StrangersPlayBackend.controller;

import com.spb.StrangersPlayBackend.dto.CommentDto;
import com.spb.StrangersPlayBackend.exception.NoSuchUserException;
import com.spb.StrangersPlayBackend.model.CommentModel;
import com.spb.StrangersPlayBackend.response.CustomResponse;
import com.spb.StrangersPlayBackend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping("/comment/{username}")
    public ResponseEntity<CustomResponse> addComment(@PathVariable String username, @Valid @RequestBody CommentDto commentDto) {
        try {
            commentService.addNewCommentForUser(commentDto, username);
        }catch (NoSuchUserException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new CustomResponse(404, e.getMessage()));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(new CustomResponse(200, "comment created"));
    }

    @GetMapping(value = "/comment/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommentDto getCommentById(@PathVariable int id){
        return commentService.getComment(id);
    }

    @GetMapping(value = "/comment/user/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CommentModel> getCommentForUser(@PathVariable String username){
        return commentService.getCommentForUser(username);
    }

    @GetMapping(value = "/comment/author/{authorUsername}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CommentDto> getCommentByAuthor(@PathVariable String authorUsername){
        return commentService.getCommentByAuthorUsername(authorUsername);
    }


}
