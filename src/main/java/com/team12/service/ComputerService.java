package com.team12.service;


import com.team12.entity.Computer;
import com.team12.repository.ComputerRepository;
import com.team12.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class ComputerService {
    @Autowired
    ComputerRepository computerRepository;

    Lock lock = new ReentrantLock();

    public Computer saveComputer(Computer newComputer){
        lock.lock();
        Computer c = computerRepository.save(newComputer);
        lock.unlock();
        return c;
    }

    public List<Computer> getComputers(){
        lock.lock();
        List<Computer> computerList = computerRepository.findAll();
        lock.unlock();
        return computerList;
    }

    public Computer getComputerById(int productID){
        lock.lock();
        Computer c = computerRepository.findById(productID).orElse(null);
        lock.unlock();
        return c;
    }

    public List<Computer> getComputerByBrandName(String brandName){
        lock.lock();
        List<Computer> computerList = computerRepository.findByBrandBrandName(brandName);
        lock.unlock();
        return computerList;
    }

}
