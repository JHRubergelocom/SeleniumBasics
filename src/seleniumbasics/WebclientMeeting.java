/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seleniumbasics;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author ruberg
 */
public class WebclientMeeting {
    static private final Integer interval = 10000;
    
    static WebDriver StartSolution() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(interval));        
        driver.get("http://ruberg-meeting.dev.elo/ix-Solutions/plugin/de.elo.ix.plugin.proxy/web/");
        return driver;
    }
    
    static void LoginSolution(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"field-focustext-1020-inputEl\"]")).sendKeys("Administrator");
        driver.findElement(By.xpath("//*[@id=\"textfield-1021-inputEl\"]")).sendKeys("elo");
        driver.findElement(By.xpath("//*[@id=\"button-1023-btnIconEl\"]")).click();
        Thread.sleep(interval);                
    } 
    
    static void CreateMeetingBoard(WebDriver driver) throws InterruptedException {
        
        // start create meetingboard
        driver.findElement(By.xpath("//*[@id=\"tile-1013\"]")).click(); // Solutions
        Thread.sleep(interval);        
        
        driver.findElement(By.xpath("//*[@id=\"button-1218-btnIconEl\"]")).click(); // Neu
        driver.findElement(By.xpath("//*[@id=\"button-1280-btnIconEl\"]")).click(); // Meeting
        
        WebElement elem = driver.findElement(By.xpath("//*[@id=\"ext-comp-1274-textEl\"]")); // Neues Meeting Board
        Thread.sleep(interval);
        elem.click();
        Thread.sleep(interval);

        // set elements
        WebElement actelem = driver.switchTo().activeElement();
        Thread.sleep(interval);        
        WebDriver frame = driver.switchTo().frame(actelem); 
        Thread.sleep(interval);
        
        // Allgemein
        frame.findElement(By.name("IX_GRP_MEETING_BOARD_NAME")).sendKeys("Meetingboard1");
        frame.findElement(By.name("IX_GRP_MEETING_BOARD_CODE")).sendKeys("MB1");
        frame.findElement(By.name("IX_GRP_MEETING_BOARD_MINUTE_TAKER")).sendKeys("Bodo Kraft" + Keys.TAB);
        Thread.sleep(interval);
        frame.findElement(By.name("IX_MAP_MEETING_BOARD_ORGANIZER1")).clear();
        frame.findElement(By.name("IX_MAP_MEETING_BOARD_ORGANIZER1")).sendKeys("Jan Eichner" + Keys.TAB);
        Thread.sleep(interval);
        frame.findElement(By.name("JS_ADDLINE")).click();
        frame.findElement(By.name("IX_MAP_MEETING_BOARD_ORGANIZER2")).sendKeys("Sandra Renz" + Keys.TAB);
        Thread.sleep(interval);
               
        frame.findElement(By.name("IX_DESC")).sendKeys("Beschreibung Meetingboard1");    
        Thread.sleep(interval);
        
        // Mitglieder 
        
        List<WebElement> listTabs =frame.findElements(By.xpath("/html/body/form/div/div[1]/ul/li"));
        for (WebElement tab: listTabs) {
            // System.out.println(tab.getText());
            String tabText = tab.getText();
            if (tabText.contentEquals("Mitglieder")) {
                tab.click();
                Thread.sleep(interval);                
            }            
        }
        
        // Themen
        
        // Benachrichtigungen
        
        // Einstellungwn
        
        
        
        // click OK
        List<WebElement> listNextButtons =frame.findElements(By.name("NEXTNODE"));
        for (WebElement buttonNext: listNextButtons) {
            // System.out.println(buttonNext.getText());
            String buttonText = buttonNext.getText();
            if (buttonText.contentEquals("OK")) {
                buttonNext.click();
                Thread.sleep(interval);                                
            }
        }
    }    
}
