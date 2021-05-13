package com.team12.team12.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productID;
    private float screenSize;
    private float price;
    private String model;
    @ManyToOne
    private Brand brand;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<CommentAndRating> commentAndRatingList;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<AdditionalFeature> additionalFeatureList;
    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private Phone phone;
    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private Computer computer;
}
