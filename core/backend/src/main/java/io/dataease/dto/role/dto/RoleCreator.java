package io.dataease.dto.role.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


import java.io.Serializable;

@Schema(description = "角色构造器")
@Data
public class RoleCreator implements Serializable {

    private static final long serialVersionUID = -5311145649863484035L;

    @Schema(description = "角色名称")
    private String name;

    @Schema(description = "描述", hidden = true)
    private String description;

    @Schema(description = "创建者", hidden = true)
    private String createBy;


}
