package com.spb.StrangersPlayBackend.service;


import com.spb.StrangersPlayBackend.dto.CommentDto;
import com.spb.StrangersPlayBackend.exception.NoSuchUserException;
import com.spb.StrangersPlayBackend.mapper.DefaultMapper;
import com.spb.StrangersPlayBackend.model.AccountModel;
import com.spb.StrangersPlayBackend.model.CommentModel;
import com.spb.StrangersPlayBackend.repository.CommentRepository;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    AccountService accountService;

    private MapperFacade mapper = new DefaultMapper();

    @Override
    public List<CommentModel> getCommentForUser(String username) {
        AccountModel accountModel = accountService.getUser(username);
        if(accountModel == null){
            throw new NoSuchUserException("no account with " + username);
        }
        return accountModel.getCommentList();
    }

    @Override
    public CommentDto getComment(int id) {
        return mapper.map(commentRepository.findCommentModelById(id), CommentDto.class);
    }

    @Override
    public CommentDto getCommentByAuthorUsername(String authorUsername) {
        return mapper.map(commentRepository.findCommentModelByAuthorUsername(authorUsername), CommentDto.class);
    }

    @Override
    public CommentModel addNewCommentForUser(CommentDto commentDto, String username) {
        AccountModel accountModel = accountService.getUser(username);
        if (accountModel == null) {
            throw new NoSuchUserException("no account with " + username);
        }
        CommentModel commentModel = commentRepository.save(mapper.map(commentDto, CommentModel.class));
        if (accountModel.getCommentList() == null) {
            accountModel.setCommentList(new ArrayList<CommentModel>());
        }
        List<CommentModel> modelList = accountModel.getCommentList();
        modelList.add(commentModel);
        accountModel.setCommentList(modelList);
        accountService.updateUser(accountModel);

        return commentModel;

    }
}
