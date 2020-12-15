package com.sanj.metnet_oauth_server.service;

import com.sanj.metnet_oauth_server.entity.PartyTypeUser;

public interface PartyTypeUserService {
    PartyTypeUser findByUsername(String username);
}
