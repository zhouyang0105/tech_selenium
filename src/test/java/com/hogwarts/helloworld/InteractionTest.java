package com.hogwarts.helloworld;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/** 录播-web控件的交互进阶
 * 交互测试
 *
 * 备注：
 * 1、键盘事件：google 不支持键盘粘贴复制，可以用火狐演示。
 */
public class InteractionTest {
    public static WebDriver driver;
    //public static WebDriverWait wait;
    public static Actions actions;

    @BeforeAll
    public static void initData(){  //driver实例化。静态方法中不能引用非静态变量。
        driver = new ChromeDriver();
        actions = new Actions(driver);
        //driver = new FirefoxDriver();
        //System.setProperty("webdriver.gecko.driver","/User/Downloads/geckodriver");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // 设置全局隐式等待 5s
        //wait=new WebDriverWait(driver,5); //显式等待
    }

    /**
     * Actions实例1:点击
     */
    @Test
    public void clickTest(){
        try {
            driver.get("http://sahitest.com/demo/click.htm");
            //Actions actions = new Actions(driver);
            ///html/body/form/input[3]
            actions.click(driver.findElement(By.xpath("//input[@value='click me']")));
            actions.doubleClick(driver.findElement(By.xpath("//input[@value='dbl click me']")));
            actions.contextClick(driver.findElement(By.xpath("//input[@value='right click me']")));

            actions.perform(); // 不加该语句，用例通过但是没看到点击效果
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Actions2：悬浮
     *  打开百度，鼠标悬停在设置上
     */
    @Test
    public void moveTest(){
        try {
            driver.get("https://www.baidu.com/");
            actions.moveToElement(driver.findElement(By.id("s-usersetting-top")));
            actions.perform();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Actions3: 拖拽
     */
    @Test
    public void dragTest(){
        driver.get("https://www.baidu.com/");
        actions.dragAndDrop(driver.findElement(By.id("dragger")), driver.findElement(By.xpath("//*[@cladd='item'][last()]")));
        actions.perform();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Actions4: 键盘操作 复制粘贴
     * 使用火狐浏览器驱动，google不支持键盘操作
     */
    @Test
    public void keyBoardTest(){

        try {
            driver.get("http://sahitest.com/demo/label.htm");
            driver.findElements(By.xpath("//input[@type='textbox']")).get(0).sendKeys("ashin");   //.findElements 因为返回是list 2个元素

            //键盘：选中 复制 粘贴
            actions.keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).perform(); //按下键盘上某个键 command + a
            actions.keyDown(Keys.COMMAND).sendKeys("c").keyUp(Keys.COMMAND).perform();
            actions.keyDown(driver.findElements(By.xpath("//input[@type='textbox']")).get(1),Keys.COMMAND).sendKeys("c").keyUp(Keys.COMMAND).perform();
           Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void scrollTest(){
        try {
            driver.get("https://www.baidu.com/");
            driver.findElement(By.id("kw")).sendKeys("霍格沃兹测试学院"); //输入框

            TouchActions actions= new TouchActions(driver);
            actions.click(driver.findElement(By.id("su"))); //点击'百度一下'

            JavascriptExecutor js= (JavascriptExecutor)driver;
            js.executeScript("window.scrollBy(0,document.bady.scrollHeight)");  // 从上到下滑动
            Thread.sleep(4000);  //滑动完成后做一个等待操作

            driver.findElement(By.xpath("//a[@class='n']")).click();
            Thread.sleep(4000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    @AfterAll
    public static void tearDown(){
        driver.quit();
    }

}
