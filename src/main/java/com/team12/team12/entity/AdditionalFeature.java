package com.team12.team12.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AdditionalFeature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int additionalFeatureID;
    private String additionalFeature;

    @ManyToOne
    private Product product;
}
