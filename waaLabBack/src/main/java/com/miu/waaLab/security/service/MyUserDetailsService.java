package com.miu.waaLab.security.service;


import com.miu.waaLab.entity.User;
import com.miu.waaLab.repository.UserRepository;
import com.miu.waaLab.security.model.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
@Transactional
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
@Autowired
    public MyUserDetailsService(UserRepository userRepo) {
        this.userRepository = userRepo;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByEmail(username);
        var userDetails = new MyUserDetails(user);
        return userDetails;
    }
}