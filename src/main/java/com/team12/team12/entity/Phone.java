package com.team12.team12.entity;

import lombok.*;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "phoneID")
public class Phone extends Product{

    private String internalMemory;

}
