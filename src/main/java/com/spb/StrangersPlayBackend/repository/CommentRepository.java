package com.spb.StrangersPlayBackend.repository;

import com.spb.StrangersPlayBackend.model.CommentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentModel, Integer> {
    CommentModel findCommentModelById (int id);

    List<CommentModel> findCommentModelByAuthorUsername (String authorUsername);
}
