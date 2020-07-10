package com.adventure.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class UserAuthority extends BaseModel implements GrantedAuthority {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Column(unique=true)
    private String authority;

    public UserAuthority() {
        super();
    }

    public UserAuthority(String authority) {
        super();
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

}