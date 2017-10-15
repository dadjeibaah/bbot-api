package com.onecreation.services

import com.onecreation.models.Customer
import org.springframework.data.mongodb.repository.MongoRepository

interface CustomerService extends MongoRepository<Customer, String> {
    Customer findByFacebookId(String facebookId)
}