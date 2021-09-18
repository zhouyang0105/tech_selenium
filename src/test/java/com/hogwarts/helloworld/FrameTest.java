package com.hogwarts.helloworld;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FrameTest {

    public static WebDriver driver;
    //public static WebDriverWait wait;
    @BeforeAll
    public static void initData(){  //driver实例化。静态方法中不能引用非静态变量。
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        //System.setProperty("webdriver.gecko.driver","/User/Downloads/geckodriver");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // 隐式等待 5s
    }

    @Test
    public void frameTest(){
        driver.get("https://www.runoob.com/try/try.php?filename=jqueryui-api-droppable");

        driver.switchTo().frame("iframeResult");

        System.out.println(driver.findElement(By.id("draggable")).getText());

        driver.switchTo().parentFrame();
        System.out.println(driver.findElement(By.id("submitBIN")).getText());
    }


    @AfterAll
    public static void tearDown(){
        driver.quit();
    }

}
