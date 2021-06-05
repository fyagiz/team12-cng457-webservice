package com.team12.team12.entity;
import lombok.*;
import javax.persistence.*;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CommentAndRating{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentAndRatingID;
    private int rating;
    private String customerComment;
    @ManyToOne
    private Product product;


}
