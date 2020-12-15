package com.sanj.metnet_oauth_server.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "party")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Party extends BaseIdEntity implements UserDetails {
    private static final long serialVersionUID = 1L;
    @OneToOne(mappedBy = "party", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    PartyTypeUser partyTypeUser;

    private String type;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String modifiedBy;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_party", joinColumns = {
            @JoinColumn(name = "party_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

        roles.forEach(r -> {
            authorities.add(new SimpleGrantedAuthority(r.getName()));
            r.getPermissions().forEach(p -> {
                authorities.add(new SimpleGrantedAuthority(p.getName()));
            });
        });

        return authorities;
    }

    @Override
    public String getPassword() {
        return partyTypeUser.getPassword();
    }

    @Override
    public String getUsername() {
        return partyTypeUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return !partyTypeUser.isAccountExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return !partyTypeUser.isAccountLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !partyTypeUser.isCredentialsExpired();
    }

    @Override
    public boolean isEnabled() {
        return partyTypeUser.isEnabled();
    }
}
