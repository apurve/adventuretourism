package com.adventure.users.model;

import com.adventure.users.model.util.Create;
import com.adventure.users.model.util.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Null;
import java.util.Set;

@ApiModel(description = "Class representing a user of the application.")
public class UserInfoTO extends BaseTO {

    @NotBlank
    @Length(min = 3)
    @ApiModelProperty(value = "Unique name of the user.", example = "theNomadicBaniya")
    private String username;

    @NotBlank(groups = Create.class)
    @Null(groups = Update.class)
    @Length(min = 8)
    @ApiModelProperty(value = "Password mandatory for user creation.", example = "Test@123")
    private String password;

    @NotEmpty
    @ApiModelProperty(value = "Authorities to perform system actions.")
    private Set<String> authorities;

    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    public UserInfoTO(String password, String username,
                      Set<String> authorities, boolean accountNonExpired,
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

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
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
