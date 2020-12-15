package com.sanj.metnet_oauth_server.repository;

import com.sanj.metnet_oauth_server.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
