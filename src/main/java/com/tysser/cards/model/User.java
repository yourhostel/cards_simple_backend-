package com.tysser.cards.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "users")
@EqualsAndHashCode(callSuper = true)
public class User extends AbstractFields {
    private static final String DELIMITER = ":";

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
