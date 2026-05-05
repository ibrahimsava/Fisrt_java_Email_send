package org.example.execice_ticket_emailnotification.Services;

import org.example.execice_ticket_emailnotification.Enity.UsersImpl;
import org.example.execice_ticket_emailnotification.Repository.UsersImplrRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserdetailsServiceImpl implements UserDetailsService {

    public UsersImplrRepository repository;

    public UserdetailsServiceImpl(UsersImplrRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UsersImpl user = repository.findByUsername(email);
        if (user == null) {
            throw new UsernameNotFoundException("user not fund " + email);
        }
        return null;
    }
}
