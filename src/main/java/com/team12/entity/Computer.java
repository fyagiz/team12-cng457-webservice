package com.team12.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "computerID")
@JsonIdentityInfo(scope=Computer.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "productID")
public class Computer extends Product{

    private String screenResolution;
    private String storageCapacity;
    private String computerMemory;

    @ManyToOne
    private Processor processor;

}
