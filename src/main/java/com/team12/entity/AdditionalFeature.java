package com.team12.team12.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AdditionalFeature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "additionalFeatureID")
    private int additionalFeatureID;
    private String additionalFeature;

    @ManyToMany(mappedBy = "additionalFeatureList", cascade = CascadeType.ALL)
    private List<Product> productList;
}
