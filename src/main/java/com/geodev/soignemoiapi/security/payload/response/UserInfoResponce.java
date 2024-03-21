package com.geodev.soignemoiapi.security.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UserInfoResponce {
    private Long id;
    private String email;
    private List<String> roles;
}
