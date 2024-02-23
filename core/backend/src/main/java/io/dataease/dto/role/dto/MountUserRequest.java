package io.dataease.dto.role.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Schema(description = "用户绑定器")
@Data
public class MountUserRequest implements Serializable {

    @Schema(description = "组织ID")
    private Long rid;
    @Schema(description = "用户ID集合")
    private List<Long> uids;
}
