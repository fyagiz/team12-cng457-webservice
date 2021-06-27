package com.team12.entity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIdentityInfo(scope=CommentAndRating.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "commentAndRatingID")
public class CommentAndRating{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentAndRatingID;
    private int rating;
    private String customerComment;
    @ManyToOne
    private Product product;


}
