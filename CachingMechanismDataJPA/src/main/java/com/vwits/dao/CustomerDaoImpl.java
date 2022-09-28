package com.vwits.dao;


import com.vwits.model.Customer;
import com.vwits.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerDaoImpl {

    @Autowired
    CustomerRepository customerRepositoryImpl;

    public Customer saveData(Customer customer){

        return customerRepositoryImpl.save(customer);
    }

    public Customer updateData(Customer customer){

        return  customerRepositoryImpl.save(customer);
    }

    public List<Customer> getAllData(){
        return customerRepositoryImpl.findAll();
    }

    public Optional<Customer> getDataById(int custId){
        return customerRepositoryImpl.findById(custId);
    }

    public void deleteDataById(int custId){
         customerRepositoryImpl.deleteById(custId);
    }
}
