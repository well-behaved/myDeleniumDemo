package com.xue.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

/**
 * 编写一个使用 浏览器 请求百度的检测测试例子
 */
public class HelloWord {
    public static void main(String[] args) throws InterruptedException {
        String chromedriverPath = HelloWord.class.getClassLoader().getResource("chromedriver").getPath();
        System.out.println("chromedriverPath:"+chromedriverPath);
        //设置驱动
        System.setProperty("webdriver.chrome.driver", chromedriverPath);

        //设置手机模式
        HashMap<String,String> mobileEmulation = new HashMap<String, String>();
        mobileEmulation.put("deviceName","iPhone SE");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("mobileEmulation",mobileEmulation);

        //创建驱动
        WebDriver driver = new ChromeDriver(options);
        Thread.sleep(6000);
        //与将要爬取的网站建立连接
        driver.get("https://www.baidu.com");
        for (int i = 0; i < 50; i++) {
            //搜索框
            WebElement kw = null;
            if(i ==0){
                kw = driver.findElement(By.id("index-kw"));
            }else {
                kw = driver.findElement(By.id("kw"));
            }
            kw.clear();
            kw.sendKeys("你好中国"+i);

            //百度一下 按钮
            WebElement element = null;
            if(i ==0){
                element = driver.findElement(By.id("index-bn"));
            }else {
                element = driver.findElement(By.id("se-bn"));
            }
            element.click();
            Thread.sleep(4000);
        }

        //关闭浏览器
        driver.close();
        //释放资源
        driver.quit();
    }
}
