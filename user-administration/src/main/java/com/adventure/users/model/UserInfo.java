package com.adventure.users.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class UserInfo extends BaseModel {

    @Column(unique=true)
    private String username;

    private String password;

    @ManyToMany
    private Set<UserAuthority> authorities;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    private boolean enabled;

    public UserInfo() {
        super();
    }

    public UserInfo(String password, String username,
                    Set<UserAuthority> authorities, boolean accountNonExpired,
                    boolean accountNonLocked, boolean credentialsNonExpired,
                    boolean enabled) {
        super();
        this.password = password;
        this.username = username;
        this.authorities = authorities;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
    }

    /*public UserInfo(UserInfoTO userInfoTO) {
        this.password = userInfoTO.getPassword();
        this.username = userInfoTO.getUsername();
        this.authorities = new HashSet<UserAuthority>();
        this.accountNonExpired = userInfoTO.isAccountNonExpired();
        this.accountNonLocked = userInfoTO.isAccountNonLocked();
        this.credentialsNonExpired = userInfoTO.isCredentialsNonExpired();
        this.enabled = userInfoTO.isEnabled();
    }*/

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<UserAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<UserAuthority> authorities) {
        this.authorities = authorities;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}