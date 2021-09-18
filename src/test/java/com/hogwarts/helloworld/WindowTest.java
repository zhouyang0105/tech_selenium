package com.hogwarts.helloworld;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WindowTest {
    public static WebDriver driver;
    public static WebDriverWait wait;
    @BeforeAll
    public static void initData(){  //driver实例化。静态方法中不能引用非静态变量。
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // 隐式等待 5s
        //wait=new WebDriverWait(driver,5); //显式等待
    }

    /**
     * 多窗口切换
     * @throws Exception
     */
    @Test
    public void switchWindowTest() throws Exception{  //sleep()会报错
        driver.get("https://www.baidu.com");

        driver.manage().window().maximize(); //最大化,页面可能显示不全 ，找不到元素
        driver.findElement(By.xpath("//*[@id='u1']/a[last()]")).click(); //点击登录
        //百度首页的句柄窗口
        String baiduWin = driver.getWindowHandle();

        driver.findElement(By.xpath("//a[@class='pass-reglink pass-link']")).click(); //点击立即注册

        for(String win:driver.getWindowHandles()){
            if(!win.equals(baiduWin)){
                driver.switchTo().window(win); //句柄切换
                driver.findElement(By.id("TANGRAM__PSP_4__phone")).sendKeys("此处输入百度账号");
                driver.findElement(By.id("TANGRAM__PSP_4__password")).sendKeys("此处输入百度账号密码");

                driver.switchTo().window(baiduWin);

                driver.findElement(By.id("TANGRAM__PSP_11__userName")).sendKeys("登录账号"); //注册后点击用户名登录，输入用户名
                driver.findElement(By.id("TANGRAM__PSP_11__password")).sendKeys("登录密码");

                Thread.sleep(3000); //登录账号密码后等待一会
            }
        }



    }
}
