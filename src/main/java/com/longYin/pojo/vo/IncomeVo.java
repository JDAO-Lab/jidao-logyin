package com.longYin.pojo.vo;

import com.longYin.enums.IsDeletedEnum;
import com.longYin.pojo.Income;
import lombok.Data;

@Data
public class IncomeVo extends Income{

    private String isDeletedText;

    public IncomeVo(Income income){
        super.setId(income.getId());
        super.setCreatedAt(income.getCreatedAt());
        super.setUpdatedAt(income.getUpdatedAt());
        super.setIsDeleted(income.getIsDeleted());
        super.setPrice(income.getPrice());
        super.setDescription(income.getDescription());
        super.setDiscount(income.getDiscount());
        super.setDuration(income.getDuration());
        super.setName(income.getName());
        super.setIcon(income.getIcon());
        this.isDeletedText = IsDeletedEnum.getByCode(income.getIsDeleted()).getValue();
    }
}
