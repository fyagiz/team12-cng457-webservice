package com.team12.team12.entity;

import lombok.*;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Phone {

    private String internalMemory;
    @OneToOne
    private Product product;
}
