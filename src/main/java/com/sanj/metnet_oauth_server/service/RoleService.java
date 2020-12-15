package com.sanj.metnet_oauth_server.service;

import com.sanj.metnet_oauth_server.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    public Optional<Role> findById(Long id);

    public List<Role> findAll();
}
