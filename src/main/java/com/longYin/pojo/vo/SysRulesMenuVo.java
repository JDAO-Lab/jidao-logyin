package com.longYin.pojo.vo;

import com.longYin.enums.IsAllowEnum;
import com.longYin.enums.IsEnableEnum;
import com.longYin.enums.IsHideEnum;
import com.longYin.enums.SysLogResultEnum;
import com.longYin.pojo.SysRulesMenu;
import lombok.Data;

import java.util.Date;

@Data
public class SysRulesMenuVo extends SysRulesMenu {
    //处理显示隐藏状态信息
    private String hideText;
    //处理通行状态信息
    private String allowText;
    //处理启用状态信息
    private String enableText;


    /**
     * vo实体类处理实体类枚举参数方法
     */
    public SysRulesMenuVo(SysRulesMenu sysRulesMenu) {
        super.setId(sysRulesMenu.getId());
        super.setTitle(sysRulesMenu.getTitle());
        super.setHref(sysRulesMenu.getHref());
        super.setPid(sysRulesMenu.getPid());
        super.setDescription(sysRulesMenu.getDescription());
        super.setIcon(sysRulesMenu.getIcon());
        super.setTarget(sysRulesMenu.getTarget());
        super.setHide(sysRulesMenu.getHide());
        super.setAllow(sysRulesMenu.getAllow());
        super.setSort(sysRulesMenu.getSort());
        super.setEnable(sysRulesMenu.getEnable());
        super.setIsDeleted(sysRulesMenu.getIsDeleted());
        super.setCreatedAt(sysRulesMenu.getCreatedAt());
        super.setUpdatedAt(sysRulesMenu.getUpdatedAt());
        this.hideText = IsHideEnum.getByCode(sysRulesMenu.getHide()).getValue();;
        this.allowText = IsAllowEnum.getByCode(sysRulesMenu.getAllow()).getValue();
        this.enableText = IsEnableEnum.getByCode(sysRulesMenu.getEnable()).getValue();
    }

}