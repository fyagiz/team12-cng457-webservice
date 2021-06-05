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

    @PostMapping("/addProcessor")
    public Processor saveProcessor(@RequestBody Processor newProcessor){
        return processorService.saveProcessor(newProcessor);
    }

    @GetMapping("/getProcessors")
    public List<Processor> getProcessor(){
        return processorService.getProcessors();
    }
}
