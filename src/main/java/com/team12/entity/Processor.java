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
@JsonIdentityInfo(scope=Processor.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "processorID")
public class Processor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int processorID;
    private String modelName;
    private float clockFrequency;

    @OneToMany(mappedBy = "processor", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Computer> computerList;
}
