package com.vwits.dao.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import com.vwits.dao.CustomerDaoImpl;
import com.vwits.model.Customer;
import com.vwits.repo.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomerDaoImplTest {

    @Autowired
    CustomerDaoImpl customerDaoImpl;

    @MockBean
    CustomerRepository customerRepositoryImpl;


    @Test
    public void saveDataTest() throws ParseException {

        Date dob = null;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        dob=simpleDateFormat.parse("26-09-1999");

        Customer customer = new Customer(101, "Chinmay","Chakan",52.0000,dob);

        customerDaoImpl.saveData(customer);
        verify(customerRepositoryImpl,times(1)).save(customer);
    }

    @Test
    public void updateDataTest() throws ParseException {

        Date dob1 = null;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dob1=simpleDateFormat.parse("26-09-1999");

        Customer customer = new Customer(101, "Chinmay","Chakan",52.0000,dob1);

        customerDaoImpl.updateData(customer);
        verify(customerRepositoryImpl,times(1)).save(customer);

    }

    @Test
    public void getAllDataTest() throws ParseException {

        Date dob2 = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dob2 = simpleDateFormat.parse("26-09-1999");

        when(customerRepositoryImpl.findAll()).thenReturn(Stream.of(new Customer(101,"Chinmay","Chakan",52000.00,dob2)).collect(Collectors.toList()));
        assertEquals(1,customerDaoImpl.getAllData().size());

    }

    @Test
    public void getDataByIdTest() throws ParseException {

        Date dob3 = null;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dob3=simpleDateFormat.parse("26-09-1999");

        Customer customer = new Customer(101, "Chinmay","Chakan",52000.00,dob3);

        customerDaoImpl.getDataById(customer.getCustId());
        verify(customerRepositoryImpl,times(1)).findById(customer.getCustId());


    }

    @Test
    public void deleteDataByIdTest() throws ParseException {

        Date dob4 = null;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        dob4 = simpleDateFormat.parse("26-09-1999");

        Customer customer = new Customer(101, "Chinmay","Chakan",52000.00,dob4);

        customerDaoImpl.deleteDataById(customer.getCustId());
        verify(customerRepositoryImpl,times(1)).deleteById(customer.getCustId());

    }



}
