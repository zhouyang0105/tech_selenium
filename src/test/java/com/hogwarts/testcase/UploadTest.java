package com.hogwarts.testcase;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

/**
 * 文件上传
 */
public class UploadTest  extends BaseTest{

    @Test
    public void uploadTest(){
        try {
            driver.get("https://www.baidu.com");

            driver.findElement(By.xpath("//span[@class='soutu-btn']")).click(); //点击报读输入框中的相机

            Thread.sleep(4000);

            driver.findElement(By.xpath("//input[@class='upload-pic']")).sendKeys("/Users/xiaoyang/Desktop/1.jpg"); //上传文件

            Thread.sleep(40000); //图片上传可能会很慢 多等待一会

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
