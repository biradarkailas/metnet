package com.sanj.metnet_oauth_server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "party_type_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PartyTypeUser {
    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(generator = "gen")
    @GenericGenerator(name = "gen", strategy = "foreign", parameters = @org.hibernate.annotations.Parameter(name = "property", value = "party"))
    Long id;

    @JsonIgnore
    @OneToOne
    @PrimaryKeyJoinColumn
    @ToString.Exclude
    Party party;

    private String username;
    private String password;
    private String firstName;
    private String middleName;
    private String lastName;
    private boolean enabled;
    private boolean accountExpired;
    private boolean credentialsExpired;
    private boolean accountLocked;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String modifiedBy;
}
