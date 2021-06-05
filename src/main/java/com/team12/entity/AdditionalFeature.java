package com.team12.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "additionalFeatureID")
public class AdditionalFeature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "additionalFeatureID")
    private int additionalFeatureID;
    private String additionalFeature;

    @ManyToMany(mappedBy = "additionalFeatureList", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Product> productList;
}
