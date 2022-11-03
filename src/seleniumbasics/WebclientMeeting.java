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
    private final WebDriver driver = new ChromeDriver();
    
    private void WaitUntilXpathClickable(String xpathExpression) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));        
    }

    private void WaitUntilNameClickable(String name) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.name(name)));        
    }

    void SetSolution() {
        driver.get("http://ruberg-meeting.dev.elo/ix-Solutions/plugin/de.elo.ix.plugin.proxy/web/");
    }

    void FinishSolution() {
        driver.quit();
    }
    
    void LoginSolution() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"field-focustext-1020-inputEl\"]")).sendKeys("Administrator");
        driver.findElement(By.xpath("//*[@id=\"textfield-1021-inputEl\"]")).sendKeys("elo");
        driver.findElement(By.xpath("//*[@id=\"button-1023-btnIconEl\"]")).click();
        WaitUntilXpathClickable("//*[@id=\"tile-1013\"]");        
    } 
    
    private void SelectTab(WebDriver frame, String tabName, String startElement) {
        List<WebElement> listTabs =frame.findElements(By.xpath("/html/body/form/div/div[1]/ul/li"));
        for (WebElement tab: listTabs) {
            // System.out.println(tab.getText());
            String tabText = tab.getText();
            if (tabText.contentEquals(tabName)) {
                tab.click();
            }            
        }
        WaitUntilNameClickable(startElement);        
    }
    
    
    void CreateMeetingBoard() throws InterruptedException {
        
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
                
        // Allgemein
        SelectTab(frame, "Allgemein", "IX_GRP_MEETING_BOARD_NAME");        
        
        frame.findElement(By.name("IX_GRP_MEETING_BOARD_NAME")).sendKeys("Meetingboard1");
        frame.findElement(By.name("IX_GRP_MEETING_BOARD_CODE")).sendKeys("MB1");
        frame.findElement(By.name("IX_GRP_MEETING_BOARD_MINUTE_TAKER")).sendKeys("Bodo Kraft" + Keys.TAB);
        
        frame.findElement(By.name("IX_MAP_MEETING_BOARD_ORGANIZER1")).clear();
        frame.findElement(By.name("IX_MAP_MEETING_BOARD_ORGANIZER1")).sendKeys("Jan Eichner" + Keys.TAB);
        
        frame.findElement(By.xpath("//*[@addlineid='organizer']")).click();
        frame.findElement(By.name("IX_MAP_MEETING_BOARD_ORGANIZER2")).sendKeys("Sandra Renz" + Keys.TAB);
        
        frame.findElement(By.name("IX_DESC")).sendKeys("Beschreibung Meetingboard1");    
        
        // Mitglieder 
        SelectTab(frame, "Mitglieder", "WF_MAP_MEETING_PERSON_LASTNAME1");

        frame.findElement(By.name("WF_MAP_MEETING_PERSON_LASTNAME1")).clear();
        frame.findElement(By.name("WF_MAP_MEETING_PERSON_LASTNAME1")).sendKeys("Baum" + Keys.TAB);
        
        frame.findElement(By.name("WF_MAP_MEETING_PERSON_FIRSTNAME1")).clear();
        frame.findElement(By.name("WF_MAP_MEETING_PERSON_FIRSTNAME1")).sendKeys("Gerd" + Keys.TAB);
        
        frame.findElement(By.name("WF_MAP_MEETING_PERSON_EMAIL1")).clear();
        frame.findElement(By.name("WF_MAP_MEETING_PERSON_EMAIL1")).sendKeys("g.baum@contelo.de" + Keys.TAB);
        
        // frame.findElement(By.name("WF_MAP_MEETING_PERSON_COMPANYNAME1")).clear();
        // frame.findElement(By.name("WF_MAP_MEETING_PERSON_COMPANYNAME1")).sendKeys("Contelo AG");
        
        frame.findElement(By.name("WF_MAP_MEETING_PERSON_USERNAME1")).clear();
        frame.findElement(By.name("WF_MAP_MEETING_PERSON_USERNAME1")).sendKeys("Gerd Baum" + Keys.TAB);
        
        frame.findElement(By.xpath("//*[@addlineid='members']")).click();

        
        frame.findElement(By.name("WF_MAP_MEETING_PERSON_LASTNAME2")).clear();
        frame.findElement(By.name("WF_MAP_MEETING_PERSON_LASTNAME2")).sendKeys("Renz" + Keys.TAB);

        frame.findElement(By.name("WF_MAP_MEETING_PERSON_FIRSTNAME2")).clear();
        frame.findElement(By.name("WF_MAP_MEETING_PERSON_FIRSTNAME2")).sendKeys("Sandra" + Keys.TAB);
        
        frame.findElement(By.name("WF_MAP_MEETING_PERSON_EMAIL2")).clear();
        frame.findElement(By.name("WF_MAP_MEETING_PERSON_EMAIL2")).sendKeys("s.renz@contelo.de" + Keys.TAB);

        // frame.findElement(By.name("WF_MAP_MEETING_PERSON_COMPANYNAME2")).clear();
        // frame.findElement(By.name("WF_MAP_MEETING_PERSON_COMPANYNAME2")).sendKeys("Contelo AG" + Keys.TAB);
        
        frame.findElement(By.name("WF_MAP_MEETING_PERSON_USERNAME2")).clear();
        frame.findElement(By.name("WF_MAP_MEETING_PERSON_USERNAME2")).sendKeys("Sandra Renz" + Keys.TAB);
       
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
