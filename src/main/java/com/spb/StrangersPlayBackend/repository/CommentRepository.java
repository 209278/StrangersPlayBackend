package com.spb.StrangersPlayBackend.repository;

import com.spb.StrangersPlayBackend.model.CommentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentModel, Integer> {
    CommentModel findCommentModelById (int id);

    CommentModel findCommentModelByAuthorUsername (String authorUsername);
}
