package com.longYin.pojo.vo;

import com.longYin.enums.IsDeletedEnum;
import com.longYin.pojo.WebNavCat;
import lombok.Data;

@Data
public class WebNavCatVo extends WebNavCat {
    private String isDeletedText;

    public WebNavCatVo(WebNavCat webNavCat){
        super.setId(webNavCat.getId());
        super.setName(webNavCat.getName());
        super.setDescription(webNavCat.getDescription());
        super.setIsDeleted(webNavCat.getIsDeleted());
        super.setCreatedAt(webNavCat.getCreatedAt());
        super.setUpdatedAt(webNavCat.getUpdatedAt());
        this.isDeletedText = IsDeletedEnum.getByCode(webNavCat.getIsDeleted()).getValue();
    }
}
