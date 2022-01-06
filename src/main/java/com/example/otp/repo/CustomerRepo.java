package com.example.otp.repo;

import com.example.otp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Pramuda Liyanage <pramudatharika@gmail.com>
 * @since 1/6/22
 **/
@Repository
public interface CustomerRepo extends JpaRepository<Customer, String> {

    Customer findByUsername(String username);
}
