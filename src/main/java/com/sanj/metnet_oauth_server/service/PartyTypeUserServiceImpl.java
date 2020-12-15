package com.sanj.metnet_oauth_server.service;

import com.sanj.metnet_oauth_server.entity.PartyTypeUser;
import com.sanj.metnet_oauth_server.repository.PartyTypeUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartyTypeUserServiceImpl implements PartyTypeUserService{
    @Autowired
    PartyTypeUserRepository partyTypeUserRepository;

    @Override
    public PartyTypeUser findByUsername(String username) {
        return partyTypeUserRepository.findByUsername(username);
    }
}
