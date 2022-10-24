/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seleniumbasics;

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
    } 
    
}
