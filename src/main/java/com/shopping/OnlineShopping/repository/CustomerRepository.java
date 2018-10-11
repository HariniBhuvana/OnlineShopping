package com.shopping.OnlineShopping.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.shopping.OnlineShopping.entity.Customer;

public interface CustomerRepository extends MongoRepository<Customer,Integer> {

}
