package com.sanj.metnet_oauth_server.repository;

import com.sanj.metnet_oauth_server.entity.Party;
import com.sanj.metnet_oauth_server.entity.PartyTypeUser;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyRepository extends JpaRepository<Party, ID> {
    Party findByPartyTypeUser(PartyTypeUser partyTypeUser);
}
