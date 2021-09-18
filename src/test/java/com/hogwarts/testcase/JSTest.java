package com.hogwarts.testcase;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;

public class JSTest extends BaseTest{

    /**
     * 执行js脚本
     * 终端执行c测试用例
     * @throws InterruptedException
     */
    @Test
    public void jsTest() throws InterruptedException {
        driver.get("https://www.12306.cn/index/");

        JavascriptExecutor jsDriver = (JavascriptExecutor)driver;

        Thread.sleep(3000);

        jsDriver.executeScript("document.getElementById('train_data').value='2021-09-11'");  //直接对元素进行value值修改
       // System.out.println(jsDriver.executeScript(" return document.getElementById('train_data').value"));  //打印修改后的值
        Object data = jsDriver.executeScript("document.getElementById('train_data').value");
        System.out.println(data);
    }


}
