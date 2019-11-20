package com.spb.StrangersPlayBackend.service;

import com.spb.StrangersPlayBackend.dto.CommentDto;
import com.spb.StrangersPlayBackend.model.CommentModel;

import java.util.List;

public interface CommentService {
    List<CommentModel> getCommentForUser(String username);

    CommentDto getComment(int id);

    List<CommentDto> getCommentByAuthorUsername(String authorUsername);

    CommentModel addNewCommentForUser(CommentDto commentDto, String username);
}
