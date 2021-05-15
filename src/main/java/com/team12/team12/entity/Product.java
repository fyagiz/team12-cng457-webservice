package com.team12.team12.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "productID")
    private int productID;
    private float screenSize;
    private float price;
    private String model;
    @ManyToOne
    private Brand brand;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<CommentAndRating> commentAndRatingList;
    @ManyToMany
    @JoinTable(name="ProductAdditionalFeatureRelationship", joinColumns=@JoinColumn(name = "additionalFeatureID"), inverseJoinColumns=@JoinColumn(name = "productID"))
    private List<AdditionalFeature> additionalFeatureList;

}
