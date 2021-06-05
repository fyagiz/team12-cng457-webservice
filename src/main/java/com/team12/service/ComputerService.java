package com.team12.service;


import com.team12.entity.Computer;
import com.team12.repository.ComputerRepository;
import com.team12.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComputerService {
    @Autowired
    ComputerRepository computerRepository;

    public Computer saveComputer(Computer newComputer){
        return computerRepository.save(newComputer);
    }

    public List<Computer> getComputers(){
        return computerRepository.findAll();
    }

    public Computer getComputerById(int productID){
        return computerRepository.findById(productID).orElse(null);
    }

    public List<Computer> getComputerByBrandName(String brandName){
        return computerRepository.findByBrandBrandName(brandName);
    }

}
