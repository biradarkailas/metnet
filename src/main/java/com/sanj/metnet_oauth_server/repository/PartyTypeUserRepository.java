package com.sanj.metnet_oauth_server.repository;

import com.sanj.metnet_oauth_server.entity.PartyTypeUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyTypeUserRepository extends JpaRepository<PartyTypeUser, Long> {
    PartyTypeUser findByUsername(String username);
}
