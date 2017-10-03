package com.onecreation.services

import com.onecreation.models.Customer
import org.springframework.data.neo4j.repository.GraphRepository

interface CustomerService extends GraphRepository<Customer> {
    Customer findByFacebookId(String facebookId)
}