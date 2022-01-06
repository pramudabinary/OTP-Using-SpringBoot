package com.example.otp.service;

import com.example.otp.entity.Customer;
import com.example.otp.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @author Pramuda Liyanage <pramudatharika@gmail.com>
 * @since 1/6/22
 **/
@Service
public class CustomerService implements UserDetailsService {

    @Autowired
    private CustomerRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customers = repo.findByUsername(username);
        GrantedAuthority authority = new SimpleGrantedAuthority(customers.getRole());
        UserDetails userDetails = (UserDetails) new User(customers.getUsername(),
                customers.getPassword(), Arrays.asList(authority));
        return userDetails;
    }
}
