/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seleniumbasics;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author ruberg
 */
public class WebclientMeeting {
    
    static WebDriver StartSolution() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://ruberg-meeting.dev.elo/ix-Solutions/plugin/de.elo.ix.plugin.proxy/web/");
        return driver;
    }
    
    static void LoginSolution(WebDriver driver) {
        driver.findElement(By.xpath("//*[@id=\"field-focustext-1020-inputEl\"]")).sendKeys("Administrator");
        driver.findElement(By.xpath("//*[@id=\"textfield-1021-inputEl\"]")).sendKeys("elo");
        driver.findElement(By.xpath("//*[@id=\"button-1023-btnIconEl\"]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
    } 
    
    static void CreateMeetingBoard(WebDriver driver) {
        driver.findElement(By.xpath("//*[@id=\"tile-1013\"]")).click(); // Solutions
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        driver.findElement(By.xpath("//*[@id=\"button-1218-btnIconEl\"]")).click(); // Neu
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        driver.findElement(By.xpath("//*[@id=\"button-1280-btnIconEl\"]")).click(); // Meeting
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        driver.findElement(By.xpath("//*[@id=\"ext-comp-1274-iconEl\"]")).click(); // Neues Meeting Board
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
    }
    
}
