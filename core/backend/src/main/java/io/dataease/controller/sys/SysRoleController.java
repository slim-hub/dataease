package io.dataease.controller.sys;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.dataease.auth.annotation.SqlInjectValidator;
import io.dataease.commons.utils.PageUtils;
import io.dataease.commons.utils.Pager;
import io.dataease.controller.sys.response.RoleUserItem;
import io.dataease.dto.role.dto.MountUserRequest;
import io.dataease.dto.role.dto.RoleCreator;
import io.dataease.dto.role.dto.RoleEditor;
import io.dataease.dto.role.dto.UnmountUserRequest;
import io.dataease.dto.role.vo.RoleDetailVO;
import io.dataease.plugins.common.base.domain.SysRole;
import io.dataease.plugins.common.request.KeywordRequest;
import io.dataease.service.sys.SysRoleService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.List;

@ApiIgnore
@RestController
@RequestMapping("/api/role")
public class SysRoleController {

    @Resource
    private SysRoleService sysRoleService;


    @ApiOperation("查询所有角色")
    @PostMapping("/all")
    public List<RoleUserItem> all() {
        return sysRoleService.allRoles();
    }

    @ApiIgnore("查询角色")
    @PostMapping("/roleGrid/{goPage}/{pageSize}")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "goPage", value = "页码", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "pageSize", value = "页容量", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "request", value = "查询条件", required = true)
    })
    @SqlInjectValidator({"create_time"})
    public Pager<List<SysRole>> roleGrid(@PathVariable int goPage, @PathVariable int pageSize, @RequestBody KeywordRequest request) {

        Page<Object> page = PageHelper.startPage(goPage, pageSize, true);
        return PageUtils.setPageInfo(page, sysRoleService.query(request));
    }

    @Operation(summary = "创建")
    @PostMapping("/create")
    public void create(@RequestBody RoleCreator creator){
        sysRoleService.insertRole(creator);
    }

    @Operation(summary = "编辑")
    @PostMapping("/edit")
    public void edit(@RequestBody RoleEditor editor){
        sysRoleService.edit(editor);
    }


    @Operation(summary = "角色详情")
    @Parameter(name = "rid", description = "角色ID", required = true, in = ParameterIn.PATH)
    @GetMapping("/detail/{rid}")
    public RoleDetailVO detail(@PathVariable("rid") Long rid){
       return sysRoleService.get(rid);
    }


    @Operation(summary = "删除角色")
    @Parameter(name = "rid", description = "角色ID", required = true, in = ParameterIn.PATH)
    @PostMapping("/delete/{rid}")
    public void delete(@PathVariable("rid") Long rid){
        sysRoleService.delete(rid);
    }

    @Operation(summary = "绑定用户")
    @PostMapping("/mountUser")
    public void mountUser(@RequestBody MountUserRequest request){
        Long rid = request.getRid();
        List<Long> uids = request.getUids();
        sysRoleService.mountUser(rid,uids);
    }


    @Operation(summary = "解绑用户")
    @PostMapping("/unMountUser")
    public void unMountUser(@RequestBody UnmountUserRequest request){
        Long rid = request.getRid();
        Long uid = request.getUid();
        sysRoleService.unMountUser(rid,uid);
    }


}
