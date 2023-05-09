package com.applicationservices.security.services.impl;

import com.applicationpersistence.entity.User;
import com.applicationservices.security.services.UserDetailsPrincipal;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserDetailsPrincipalImpl implements UserDetailsPrincipal {

    private static final long serialVersionUID = 1L;

    private int user_id;
    private String username;
    @JsonIgnore
    private String password;

    private Integer age;
    private Collection<? extends GrantedAuthority> authorities;


    public UserDetailsPrincipalImpl(int user_id, String username, String password, Integer age,
                                    Collection<? extends GrantedAuthority> authorities) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.authorities = authorities;
    }
    public UserDetailsPrincipalImpl(){}

    public static UserDetailsPrincipalImpl build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());

        return new UserDetailsPrincipalImpl(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getAge(),
                authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public int getUser_id() {
        return user_id;
    }

    public Integer getAge(){
        return age;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsPrincipalImpl user = (UserDetailsPrincipalImpl) o;
        return Objects.equals(user_id, user.user_id);
    }
}
