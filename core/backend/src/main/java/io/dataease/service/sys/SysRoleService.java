package io.dataease.service.sys;


import io.dataease.commons.utils.BeanUtils;
import io.dataease.controller.sys.response.RoleUserItem;
import io.dataease.dto.role.dto.RoleCreator;
import io.dataease.dto.role.dto.RoleEditor;
import io.dataease.dto.role.vo.RoleDetailVO;
import io.dataease.ext.ExtSysRoleMapper;

import io.dataease.plugins.common.base.domain.SysRole;
import io.dataease.plugins.common.base.domain.SysUsersRolesKey;
import io.dataease.plugins.common.base.mapper.SysRoleMapper;
import io.dataease.plugins.common.request.KeywordRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SysRoleService {

    @Resource
    private ExtSysRoleMapper extSysRoleMapper;


    @Resource
    private SysRoleMapper sysRoleMapper;


    public List<SysRole> query(KeywordRequest request) {
        return extSysRoleMapper.query(request);
    }

    public List<RoleUserItem> allRoles() {
        return extSysRoleMapper.queryAll();
    }


    public boolean insertRole(RoleCreator roleCreator) {
        SysRole sysRole = BeanUtils.copyBean(new SysRole(), roleCreator);
        sysRole.setUpdateBy(roleCreator.getCreateBy());
        sysRole.setCreateTime(System.currentTimeMillis());
        sysRole.setUpdateTime(System.currentTimeMillis());
        return sysRoleMapper.insert(sysRole) > 0;
    }


    public boolean edit(RoleEditor roleEditor) {
        SysRole sysRole = BeanUtils.copyBean(new SysRole(), roleEditor);
        sysRole.setUpdateTime(System.currentTimeMillis());
        return sysRoleMapper.updateByPrimaryKeySelective(sysRole) > 0;
    }


    public RoleDetailVO get(Long rid) {
        SysRole sysRole = sysRoleMapper.selectByPrimaryKey(rid);
        return BeanUtils.copyBean(new RoleDetailVO(), sysRole);
    }

    public boolean delete(Long rid) {
        return sysRoleMapper.deleteByPrimaryKey(rid) > 1;
    }


    public boolean mountUser(Long rid, List<Long> uids) {
        List<SysUsersRolesKey> sysUsersRolesKeys = uids.stream().map(uid -> new SysUsersRolesKey(uid, rid)).collect(Collectors.toList());
        return extSysRoleMapper.batchInsertUsersRoles(sysUsersRolesKeys) >= uids.size();

    }

    public boolean unMountUser(Long rid, Long uid) {
        return extSysRoleMapper.deleteUsersRoles(rid, uid) > 1;
    }


}
