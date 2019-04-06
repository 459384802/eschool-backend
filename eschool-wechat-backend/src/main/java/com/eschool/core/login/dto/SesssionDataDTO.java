package com.eschool.core.login.dto;

import com.eschool.core.system.entity.UserEntity;
import lombok.Data;

import java.io.Serializable;

@Data
public class SesssionDataDTO implements Serializable {
    private String token;
    private UserEntity userInfo;

    public SesssionDataDTO(String token, UserEntity userEntity) {
        this.token = token;
        this.userInfo = userEntity;
    }
}
