package com.team12.service;
import com.team12.entity.Processor;
import com.team12.repository.ProcessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessorService {
    @Autowired
    ProcessorRepository processorRepository;

    public Processor saveProcessor(Processor newProcessor){
        return processorRepository.save(newProcessor);
    }

    public List<Processor> getProcessors(){
        return processorRepository.findAll();
    }

    public Processor getProcessorById(int processorID){
        return processorRepository.findById(processorID).orElse(null);
    }

    public Processor getProcessorByModelName(String modelName){
        return processorRepository.findProcessorByModelName(modelName);
    }
}
