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

    /***
     * This is the post method which allows to set the new comment and rating.
     * An example usage is as follows: {@code saveCommentAndRating({
     *     "rating":3,
     *     "customerComment":"not bad",
     *     "product":{
     *         "productID":9
     *     }
     *
     * });}
     * @param newCommentAndRating represents the value of a comment and rating object that is added to the comment and rating list.
     * @return new CommentandRating object that is taken from the service.
     */
    @PostMapping("/addCommentAndRating")
    public CommentAndRating saveCommentAndRating(@RequestBody CommentAndRating newCommentAndRating){
        return commentAndRatingService.saveCommentAndRating(newCommentAndRating);
    }
}
