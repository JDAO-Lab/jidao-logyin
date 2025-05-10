package com.longYin.pojo.vo;

import com.longYin.enums.IsDeletedEnum;
import com.longYin.pojo.WebPostCat;
import lombok.Data;

@Data
public class WebPostCatVo extends WebPostCat {

    private String isDeletedText;

    public WebPostCatVo(WebPostCat webPostCat){
        this.setId(webPostCat.getId());
        this.setName(webPostCat.getName());
        this.setDescription(webPostCat.getDescription());
        this.setIsDeleted(webPostCat.getIsDeleted());
        this.setCreatedAt(webPostCat.getCreatedAt());
        this.setUpdatedAt(webPostCat.getUpdatedAt());
        this.isDeletedText = IsDeletedEnum.getByCode(webPostCat.getIsDeleted()).getValue();
    }

}
