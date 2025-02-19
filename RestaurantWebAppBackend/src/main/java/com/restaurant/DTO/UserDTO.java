package com.restaurant.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Long userId;
    private String name;
    private String email;
    private Long roleId;
    private String roleType;
}

