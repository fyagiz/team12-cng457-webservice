package com.team12.repository;

import com.team12.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PhoneRepository extends JpaRepository<Phone, Integer> {

    public List<Phone> findByBrandBrandName(String brandName);
}
