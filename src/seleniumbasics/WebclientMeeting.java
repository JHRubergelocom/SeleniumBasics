/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seleniumbasics;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

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
    
    static void CreateMeetingBoard(WebDriver driver) throws InterruptedException {
        
        // start create meetingboard
        driver.findElement(By.xpath("//*[@id=\"tile-1013\"]")).click(); // Solutions
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));        
        Thread.sleep(3000);        
        
        
        driver.findElement(By.xpath("//*[@id=\"button-1218-btnIconEl\"]")).click(); // Neu
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        driver.findElement(By.xpath("//*[@id=\"button-1280-btnIconEl\"]")).click(); // Meeting
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        
        WebElement elem = driver.findElement(By.xpath("//*[@id=\"ext-comp-1274-textEl\"]")); // Neues Meeting Board
        Thread.sleep(3000);
        elem.click();
        Thread.sleep(3000);

        // set elements
        WebElement actelem = driver.switchTo().activeElement();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        
        WebDriver frame = driver.switchTo().frame(actelem); 
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        
        frame.findElement(By.name("IX_GRP_MEETING_BOARD_NAME")).sendKeys("Meetingboard1");
        frame.findElement(By.name("IX_GRP_MEETING_BOARD_CODE")).sendKeys("MB1");
        frame.findElement(By.name("IX_GRP_MEETING_BOARD_MINUTE_TAKER")).sendKeys("Adrian Smith");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        frame.findElement(By.name("IX_DESC")).sendKeys("Test");        
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        
        // click OK
        List<WebElement> listNextButtons =frame.findElements(By.name("NEXTNODE"));
        for (WebElement buttonNext: listNextButtons) {
            System.out.println(buttonNext.getText());
            String buttonText = buttonNext.getText();
            if (buttonText.contentEquals("OK")) {
                buttonNext.click();
            }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(50000));
    }    
}
