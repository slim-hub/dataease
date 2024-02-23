package io.dataease.dto.role.dto;

import lombok.Data;


import java.io.Serializable;

@Data
public class RoleCopyRequest implements Serializable {


    private static final long serialVersionUID = 1631759805936434870L;

    private Long copyId;
    private String name;
    private String desc;
}
