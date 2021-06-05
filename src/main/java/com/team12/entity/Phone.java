package com.team12.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "phoneID")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "productID")
public class Phone extends Product{

    private String internalMemory;

}
