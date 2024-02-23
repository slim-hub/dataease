package io.dataease.plugins.common.base.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysUsersRolesKey implements Serializable {
    private Long userId;

    private Long roleId;

    private static final long serialVersionUID = 1L;
}