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
public class Processor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int processorID;
    private String modelName;
    private float clockFrequency;

    @OneToMany(mappedBy = "processor", cascade = CascadeType.ALL)
    private List<Computer> computerList;
}
