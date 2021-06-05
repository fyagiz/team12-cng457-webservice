package com.team12.repository;

import com.team12.entity.CommentAndRating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentAndRatingRepository extends JpaRepository<CommentAndRating,Integer> {
}
