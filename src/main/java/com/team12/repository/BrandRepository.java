package com.team12.repository;

import com.team12.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

    public Brand findBrandByBrandName(String brandName);
}
