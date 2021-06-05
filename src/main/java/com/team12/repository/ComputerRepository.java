package com.team12.repository;

import com.team12.entity.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComputerRepository extends JpaRepository<Computer,Integer> {
    public List<Computer> findByBrandBrandName(String brandName);
    

}
