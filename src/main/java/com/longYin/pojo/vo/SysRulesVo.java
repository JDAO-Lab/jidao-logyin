package com.longYin.pojo.vo;

import com.longYin.enums.IsDeletedEnum;
import com.longYin.pojo.SysRules;
import lombok.Data;


@Data

public class SysRulesVo extends SysRules {

    private String isDeletedText;

    public SysRulesVo(SysRules sysRules){
        super.setId(sysRules.getId());
        super.setName(sysRules.getName());
        super.setIsDeleted(sysRules.getIsDeleted());
        super.setDescription(sysRules.getDescription());
        super.setCreatedAt(sysRules.getCreatedAt());
        super.setUpdatedAt(sysRules.getUpdatedAt());
        this.isDeletedText = IsDeletedEnum.getByCode(sysRules.getIsDeleted()).getValue();
    }

}
