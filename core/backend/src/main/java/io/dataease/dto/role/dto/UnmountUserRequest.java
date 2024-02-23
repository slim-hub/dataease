package io.dataease.dto.role.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Schema(description = "用户解绑器")
@Data
public class UnmountUserRequest implements Serializable {

    private static final long serialVersionUID = 1361046648092771178L;
    @Schema(description = "角色ID")
    private Long rid;
    @Schema(description = "用户ID")
    private Long uid;
}
