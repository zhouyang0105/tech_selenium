package com.hogwarts.testcase;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

/** 0.6 -selenium处理多浏览器-录播
 * 初始化driver对象
 */
public class BaseTest {

    public static WebDriver driver;

    @BeforeAll
    public static void initData(){  //driver初始化
        String browserName = System.getenv("browser");

        if("chrome".equals(browserName)){
            System.setProperty("webdriver.chrome.driver", "/Users/xiaoyang/Documents/Applications/webDriver/chromedriver");  //驱动路径
            driver=new ChromeDriver();
        }else if("firefox".equals(browserName)){
            //System.setProperty("webdriver.gecko.driver", "/path/to/geckodriver");
            driver=new FirefoxDriver();
        }else if("safari".equals(browserName)){
            driver=new SafariDriver();
        }
    }


    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
}
