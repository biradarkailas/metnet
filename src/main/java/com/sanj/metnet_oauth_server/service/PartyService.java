package com.sanj.metnet_oauth_server.service;


import com.sanj.metnet_oauth_server.entity.Party;
import com.sanj.metnet_oauth_server.entity.PartyTypeUser;

public interface PartyService {
    Party findByPartyTypeUser(PartyTypeUser partyTypeUser);
}
