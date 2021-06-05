package com.team12.service;

import com.team12.entity.CommentAndRating;
import com.team12.repository.CommentAndRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentAndRatingService {
    @Autowired
    CommentAndRatingRepository commentAndRatingRepository;

    public CommentAndRating saveCommentAndRating(CommentAndRating newCommentAndRating){
        return commentAndRatingRepository.save(newCommentAndRating);
    }

}
