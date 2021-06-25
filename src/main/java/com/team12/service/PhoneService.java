package com.team12.service;

import com.team12.entity.Phone;
import com.team12.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class PhoneService {
    @Autowired
    PhoneRepository phoneRepository;

    Lock lock = new ReentrantLock();

    public Phone savePhone(Phone newPhone){
        lock.lock();
        Phone p = phoneRepository.save(newPhone);
        lock.unlock();
        return p;
    }

    public  List<Phone> getPhones(){
        lock.lock();
        List<Phone> phoneList = phoneRepository.findAll();
        lock.unlock();
        return phoneList;
    }

    public Phone getPhoneById(int productID){
        lock.lock();
        Phone p = phoneRepository.findById(productID).orElse(null);
        lock.unlock();
        return p;
    }

    public List<Phone> getPhoneByBrandName(String brandName){
        lock.lock();
        List<Phone> phoneList = phoneRepository.findByBrandBrandName(brandName);
        lock.unlock();
        return phoneList;
    }


}
