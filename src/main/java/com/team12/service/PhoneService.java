package com.team12.service;

import com.team12.entity.Phone;
import com.team12.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService {
    @Autowired
    PhoneRepository phoneRepository;

    public Phone savePhone(Phone newPhone){
        return phoneRepository.save(newPhone);
    }

    public List<Phone> getPhones(){
        return phoneRepository.findAll();
    }

    public Phone getPhoneById(int productID){
        return phoneRepository.findById(productID).orElse(null);
    }

    public List<Phone> getPhoneByBrandName(String brandName){
        return phoneRepository.findByBrandBrandName(brandName);
    }


}
