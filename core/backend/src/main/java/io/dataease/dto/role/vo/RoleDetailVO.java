package io.dataease.dto.role.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.dataease.dto.role.dto.RoleCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "角色详情VO")
@Data
public class RoleDetailVO extends RoleCreator {

    @Schema(description = "ID")
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;

    private Long createTime;

    private Long updateTime;
}
