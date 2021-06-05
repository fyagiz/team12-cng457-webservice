package com.team12.controller;

import com.team12.entity.CommentAndRating;
import com.team12.service.CommentAndRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentAndRatingController {
    @Autowired
    CommentAndRatingService commentAndRatingService;

    @PostMapping("/addCommentAndRating")
    public CommentAndRating saveCommentAndRating(@RequestBody CommentAndRating newCommentAndRating){
        return commentAndRatingService.saveCommentAndRating(newCommentAndRating);
    }
}
