package com.sanj.metnet_oauth_server.service;

import com.sanj.metnet_oauth_server.entity.Party;
import com.sanj.metnet_oauth_server.entity.PartyTypeUser;
import com.sanj.metnet_oauth_server.repository.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartyServiceImpl implements PartyService {
    @Autowired
    PartyRepository partyRepository;

    @Override
    public Party findByPartyTypeUser(PartyTypeUser partyTypeUser) {
        return partyRepository.findByPartyTypeUser(partyTypeUser);
    }
}
