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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author ruberg
 */
public class WebclientMeeting {
    static private final Integer interval = 5000;
    
    static void WaitUntilXpathClickable(WebDriver driver, String xpathExpression) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));        
    }

    static void WaitUntilNameClickable(WebDriver driver, String name) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.name(name)));        
    }

    static WebDriver StartSolution() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://ruberg-meeting.dev.elo/ix-Solutions/plugin/de.elo.ix.plugin.proxy/web/");
        return driver;
    }
    
    static void LoginSolution(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"field-focustext-1020-inputEl\"]")).sendKeys("Administrator");
        driver.findElement(By.xpath("//*[@id=\"textfield-1021-inputEl\"]")).sendKeys("elo");
        driver.findElement(By.xpath("//*[@id=\"button-1023-btnIconEl\"]")).click();
        WaitUntilXpathClickable(driver, "//*[@id=\"tile-1013\"]");        
    } 
    
    static void CreateMeetingBoard(WebDriver driver) throws InterruptedException {
        
        // start create meetingboard
        driver.findElement(By.xpath("//*[@id=\"tile-1013\"]")).click(); // Solutions
        driver.findElement(By.xpath("//*[@id=\"button-1218-btnIconEl\"]")).click(); // Neu
        driver.findElement(By.xpath("//*[@id=\"button-1280-btnIconEl\"]")).click(); // Meeting
        WebElement elem = driver.findElement(By.xpath("//*[@id=\"ext-comp-1274-textEl\"]")); // Neues Meeting Board
        Thread.sleep(interval);
        elem.click();
        Thread.sleep(interval);

        // set elements
        WebElement actelem = driver.switchTo().activeElement();
        WebDriver frame = driver.switchTo().frame(actelem); 
        WaitUntilNameClickable(driver, "IX_GRP_MEETING_BOARD_NAME");
        
        
        
        // Allgemein
        frame.findElement(By.name("IX_GRP_MEETING_BOARD_NAME")).sendKeys("Meetingboard1");
        frame.findElement(By.name("IX_GRP_MEETING_BOARD_CODE")).sendKeys("MB1");
        frame.findElement(By.name("IX_GRP_MEETING_BOARD_MINUTE_TAKER")).sendKeys("Bodo Kraft" + Keys.TAB);
        frame.findElement(By.name("IX_MAP_MEETING_BOARD_ORGANIZER1")).clear();
        frame.findElement(By.name("IX_MAP_MEETING_BOARD_ORGANIZER1")).sendKeys("Jan Eichner" + Keys.TAB);
        frame.findElement(By.name("JS_ADDLINE")).click();
        frame.findElement(By.name("IX_MAP_MEETING_BOARD_ORGANIZER2")).sendKeys("Sandra Renz" + Keys.TAB);
        frame.findElement(By.name("IX_DESC")).sendKeys("Beschreibung Meetingboard1");    
        
        // Mitglieder 
        
        List<WebElement> listTabs =frame.findElements(By.xpath("/html/body/form/div/div[1]/ul/li"));
        for (WebElement tab: listTabs) {
            // System.out.println(tab.getText());
            String tabText = tab.getText();
            if (tabText.contentEquals("Mitglieder")) {
                tab.click();
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
            }
        }
    }    
}
