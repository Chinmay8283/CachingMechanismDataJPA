package com.vwits.controller;

import com.vwits.exception.RecordNotFoundException;
import com.vwits.model.Customer;
import com.vwits.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/welcome")
public class CustomerController {

    @Autowired
    CustomerService customerServiceImpl;

    @PostMapping("/savedata")
    public ResponseEntity<Customer> saveData(@RequestBody Customer customer){
        return ResponseEntity.ok(customerServiceImpl.saveData(customer));
    }

    @PutMapping("/updatedata/{custId}")
    public ResponseEntity<Customer> updateData(@PathVariable int custId, @RequestBody Customer customer) throws RecordNotFoundException {

        Customer customer1 = customerServiceImpl.getDataById(custId).orElseThrow(()->new RecordNotFoundException("Customer Record Not Available..."));

        customer1.setCustName(customer.getCustName());
        customer1.setCustAddress(customer.getCustAddress());
        customer1.setCustSalary(customer.getCustSalary());
        customer1.setCustDOB(customer.getCustDOB());

        return ResponseEntity.ok(customerServiceImpl.updateData(customer));
    }

    @GetMapping("/getalldata")
    public ResponseEntity<List<Customer>> getAllData(){
        return ResponseEntity.ok(customerServiceImpl.getAllData());
    }

    @GetMapping("/getdatabyid/{custId}")
    public ResponseEntity<Optional<Customer>> getDataById(@PathVariable int custId){
        return ResponseEntity.ok(customerServiceImpl.getDataById(custId));
    }

    @DeleteMapping("/deletedatabyid/{custId}")
    public ResponseEntity<String> deleteDataById(@PathVariable int custId){

        customerServiceImpl.deleteDataById(custId);
        return ResponseEntity.ok("Data Deleted Successfully...");

    }
}
