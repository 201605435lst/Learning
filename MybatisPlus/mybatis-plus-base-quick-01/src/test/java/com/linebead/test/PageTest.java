package com.linebead.test;

import com.linebead.service.UsersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author liushengtao
 * @description 描述
 * @date 2024年12月07日22:32
 */
@SpringBootTest
public class PageTest {

    @Autowired
    private UsersService usersService;

    @Test
    public void test() {
        usersService.getPageList(1, 10);
    }

    @Test
    public void testQueryPage() {
        usersService.queryPage(1, 10,24);
    }
}
