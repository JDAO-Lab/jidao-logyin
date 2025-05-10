package com.longYin.pojo.vo;

import com.longYin.enums.IsDeletedEnum;
import com.longYin.pojo.AppCat;
import lombok.Data;

@Data
public class AppCatVo extends AppCat {
    private String isDeletedText;

    public AppCatVo(AppCat appCat){
        super.setId(appCat.getId());
        super.setName(appCat.getName());
        super.setDescription(appCat.getDescription());
        super.setIsDeleted(appCat.getIsDeleted());
        super.setCreatedAt(appCat.getCreatedAt());
        super.setUpdatedAt(appCat.getUpdatedAt());
        this.isDeletedText = IsDeletedEnum.getByCode(appCat.getIsDeleted()).getValue();
    }
}
