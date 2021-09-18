package com.hogwarts.testcase;

import org.junit.jupiter.api.Test;

/** 0.6 -selenium处理多浏览器-录播
 * BaseTest 常用的方法
 */

public class BrowserTest extends BaseTest {

    @Test
    public void browserTest(){
        driver.get("https://ceshiren.com"); //BaseTest里的BeforAll 和AfterAll都会执行。

    }

}
