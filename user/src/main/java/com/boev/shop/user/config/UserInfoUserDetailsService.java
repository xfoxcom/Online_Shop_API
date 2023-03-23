package com.boev.shop.user.config;

import com.boev.shop.user.entity.Account;
import com.boev.shop.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Account> account = userRepository.findByUsername(username);

        return account.map(UserInfoUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(""));
    }
}
