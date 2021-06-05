package com.team12.team12.entity;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "computerID")
public class Computer extends Product{

    private String screenResolution;
    private String storageCapacity;
    private String computerMemory;

    @ManyToOne
    private Processor processor;

}
