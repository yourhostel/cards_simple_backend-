package com.tysser.cards.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    private static final String DELIMITER = ":";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    private String roles;

    public void setRoles(String[] roles) {
        this.roles = String.join(DELIMITER, roles);
    }

    public String[] getRoles() {
        return this.roles.split(DELIMITER);
    }
}
