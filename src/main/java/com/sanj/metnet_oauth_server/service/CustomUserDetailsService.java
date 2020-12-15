package com.sanj.metnet_oauth_server.service;

import com.sanj.metnet_oauth_server.entity.Party;
import com.sanj.metnet_oauth_server.entity.PartyTypeUser;
import com.sanj.metnet_oauth_server.repository.PartyRepository;
import com.sanj.metnet_oauth_server.repository.PartyTypeUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


@Service(value = "userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private PartyTypeUserRepository partyTypeUserRepository;

	@Autowired
	private PartyRepository partyRepository;

	@Override
	public UserDetails loadUserByUsername(String input) {
		PartyTypeUser partyTypeUser = partyTypeUserRepository.findByUsername(input);
		Party party = partyRepository.findByPartyTypeUser(partyTypeUser);

		if (party == null)
			throw new BadCredentialsException("Username And Password Does Not Match Our Records.");

		new AccountStatusUserDetailsChecker().check(party);

		return party;
	}
}