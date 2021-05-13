package com.team12.team12.entity;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Computer {

    private String screenResolution;
    private String storageCapacity;
    private String computerMemory;

    @OneToOne
    private Product product;
    @ManyToOne
    private Processor processor;

}
