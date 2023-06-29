package com.xue.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWord {
    public static void main(String[] args) {
        String chromedriverPath = HelloWord.class.getClassLoader().getResource("chromedriver").getPath();
        System.out.println("chromedriverPath:"+chromedriverPath);
        //设置驱动
        System.setProperty("webdriver.chrome.driver", chromedriverPath);
        //创建驱动
        WebDriver driver = new ChromeDriver();
        //与将要爬取的网站建立连接
        driver.get("https://www.baidu.com");
        //关闭浏览器
        driver.close();
        //释放资源
        driver.quit();
    }
}
