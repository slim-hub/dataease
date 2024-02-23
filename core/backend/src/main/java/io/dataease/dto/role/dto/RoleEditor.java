package io.dataease.dto.role.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


import java.io.Serializable;

@Schema(description = "角色编辑器")
@Data
public class RoleEditor implements Serializable {

    private static final long serialVersionUID = -4071819873019095722L;
    @Schema(description = "ID")
    private Long id;
    @Schema(description = "名称")
    private String name;
    @Schema(description = "描述", hidden = true)
    private String description;
    @Schema(description = "更新者", hidden = true)
    private String updateBy;

}
