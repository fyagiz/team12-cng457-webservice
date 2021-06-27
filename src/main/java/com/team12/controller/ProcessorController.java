package com.team12.controller;


import com.team12.entity.Processor;
import com.team12.service.ProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProcessorController {
    @Autowired
    ProcessorService processorService;

    /***
     * This is the method that allows to save the new processor object to the service by sending the following parameters.
     * An example usage is as follows: {@code saveProcessor({"modelName": "Intel i5 6900", "clockFrequency": 2000.0});}
     * @param newProcessor represents the new processor object that is added to the processors.
     * @return new Processor object that is saved.
     */
    @PostMapping("/addProcessor")
    public Processor saveProcessor(@RequestBody Processor newProcessor){
        return processorService.saveProcessor(newProcessor);
    }

    /***
     * This is the method which allows to get the all processors.
     * An example usage is as follows: {@code getProcessors();}
     * @return all Processor objects that are taken from the service.
     */

    @GetMapping("/getProcessors")
    public List<Processor> getProcessor(){
        return processorService.getProcessors();
    }
}
