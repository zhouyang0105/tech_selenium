package com.hogwarts.testcase;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * @data 2021-09-09
 */
public class AiceTest {
    public static WebDriver driver;
    public static WebDriverWait wait;
    @BeforeAll
    public static void initData(){  //driver实例化。静态方法中不能引用非静态变量。
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        //System.setProperty("webdriver.gecko.driver","/User/Downloads/geckodriver");
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // 隐式等待 5s
        wait=new WebDriverWait(driver,5); //显式等待
    }

    @Test
    public void login(){
        driver.get("https://ceshiren.com/"); //要访问网址

        driver.findElement(By.xpath("//span[contains(text(),'登录')]")).click(); // 3.xpath定位元素

        driver.findElement(By.id("login-account-name")).clear(); //用户名，清楚历史记录  1.通过id 定位元素
        driver.findElement(By.id("login-account-name")).sendKeys("1972741714@qq.com"); //输入用户名：sendKeys

        driver.findElement(By.id("login-account-password")).clear();
        driver.findElement(By.id("login-account-password")).sendKeys("ZHOUyang468");

        driver.findElement(By.id("login-button")).click();

        //Thread.sleep(200);  // 200 毫秒(ms)=0.2 秒
    }

    /**
     * 直接等待：不推荐使用
     */
    @Test
    public void timeSleepTest(){
        driver.get("https://ceshiren.com/");

        try {
            Thread.sleep(5000);
            driver.findElement(By.xpath("//span[contains(text(),'登录')]")).click(); //xpath定位元素
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void waitTest(){
        driver.get("https://ceshiren.com/");

        //driver.findElement(By.xpath("//span[contains(text(),'登录')]")).click();

        WebElement loginElement = wait.until(new ExpectedCondition<WebElement>() { //复制的，参考录播笔记
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("foo"));
            }
        });

        loginElement.click();

        //WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'登录')]")));
        //element.click();
    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }


}
