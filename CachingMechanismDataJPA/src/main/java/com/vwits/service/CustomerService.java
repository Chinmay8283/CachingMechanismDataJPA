package com.vwits.service;

import com.vwits.dao.CustomerDaoImpl;
import com.vwits.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CustomerService {

    @Autowired
    CustomerDaoImpl customerDaoImpl;

    public Customer saveData(Customer customer){

        return customerDaoImpl.saveData(customer);
    }

    public Customer updateData(Customer customer){

        return customerDaoImpl.updateData(customer);
    }

    public List<Customer> getAllData(){
        return customerDaoImpl.getAllData();
    }

    @Cacheable(value = "custId")
    public Optional<Customer> getDataById(int custId){

        log.info("****** TRYING TO FETCH DATA FROM DATABASE ******");
        return customerDaoImpl.getDataById(custId);
    }

    public void deleteDataById(int custId){
        customerDaoImpl.deleteDataById(custId);
    }
}
