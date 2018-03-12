package com.mortgage.leads.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public class UserAccountService implements UserDetailsService {

	@Autowired
	private UserAccountRepository userAccountRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		return this.userAccountRepository.findByUserName(userName)
									.map( userAccount -> new User(
										  userAccount.getUserName(),
										  userAccount.getPassword(),
										  userAccount.isActive(), 
										  userAccount.isActive(), 
										  userAccount.isActive(), 
										  userAccount.isActive(),
										  AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER")
									))
									.orElseThrow(() -> new UsernameNotFoundException("User could not find in the Maps database." + userName));
		
	}

}
