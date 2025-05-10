package com.longYin;

import com.longYin.mapper.SysAdminMapper;
import com.longYin.pojo.SysAdmin;
import com.longYin.service.SysAdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.List;

@SpringBootTest
class LogYinApplicationTests {

    @Autowired
    private SysAdminService sysAdminService;

    @Test
    public void testGetSysAdmin(){
        List<SysAdmin> sysAdminList = sysAdminService.list();
        sysAdminList.stream().forEach(sysAdmin -> {
            System.out.println(sysAdmin);
        });
    }

    @Test
    public void testGetOnlySysAdming(){
        Object sysAdminOnlyData = sysAdminService.getById(1);
        System.out.print(sysAdminOnlyData);
    }

    @Test
    public void testLoginAuthSql(){
        Object sysLoginData = sysAdminService.loginAuthSql("admin","7fef6171469e80d32c0559f88b377245");
        System.out.print(sysLoginData);
    }

    @Test
    public void testAddSysAdmin(){
        SysAdmin newSysAdmin = new SysAdmin();
        newSysAdmin.setUsername("newAdmin");
        newSysAdmin.setPassword("newPassword");
        newSysAdmin.setToken("newToken");
        newSysAdmin.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        newSysAdmin.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        newSysAdmin.setIsDeleted((short) 0);
        newSysAdmin.setRuleId(1);
        //保存用户数据
        sysAdminService.save(newSysAdmin);
        System.out.println("New SysAdmin added successfully.");
    }

    @Test
    public void testUpdateSysAdmin(){
        SysAdmin sysAdmin = sysAdminService.getById(2);
        if (sysAdmin != null) {
            sysAdmin.setUsername("updatedAdmin");
            sysAdmin.setPassword("updatedPassword");
            sysAdmin.setToken("updatedToken");
            sysAdmin.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

            sysAdminService.update(sysAdmin);
            System.out.println("SysAdmin updated successfully.");
        } else {
            System.out.println("SysAdmin not found.");
        }
    }

    @Test
    public void testDeleteSysAdmin(){
        sysAdminService.delete(2);
        System.out.println("SysAdmin with id 1 deleted successfully.");
    }


}
