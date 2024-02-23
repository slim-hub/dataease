package io.dataease.dto.role.dto;

import io.dataease.plugins.common.request.KeywordRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;



@Schema(description = "用户过滤器")
@EqualsAndHashCode(callSuper = true)
@Data
public class UserRequest extends KeywordRequest {


    private static final long serialVersionUID = -2740015284392981297L;
    @Schema(description = "角色ID")
    private Long rid;
    @Schema(description = "排序规则")
    private String order;

}
