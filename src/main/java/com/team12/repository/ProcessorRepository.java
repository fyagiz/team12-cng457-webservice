package com.team12.repository;

import com.team12.entity.Brand;
import com.team12.entity.Processor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessorRepository extends JpaRepository<Processor,Integer> {
    public Processor findProcessorByModelName(String modelName);
    public Processor findProcessorByClockFrequency(float clockFrequency);
}
