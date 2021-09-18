package com.hogwarts.testcase;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

/**
 * 弹窗处理
 */
public class AlertTest extends BaseTest{

    @Test
    public void alertTest(){
        try {
            driver.get("https://www.runoob.com/try/try.php?filename=jqueryui-api-droppable");
            driver.switchTo().frame("iframeResult"); //切换到frame 下 ，后续再去获取其下内容
            // 拖拽
            Actions actions= new Actions(driver);
            actions.dragAndDrop(driver.findElement(By.id("draggable")),driver.findElement(By.id("droppable")));
            actions.perform();
            Thread.sleep(5000);  //拖拽后等待5s

            driver.switchTo().alert().accept();//允许弹窗

            //切回默认的frame中
            driver.switchTo().parentFrame();

            System.out.println(driver.findElement(By.id("submitBTN")).getText()); //点击运行按钮

        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}
