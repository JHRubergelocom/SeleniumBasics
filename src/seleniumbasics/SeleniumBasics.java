/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seleniumbasics;

import org.openqa.selenium.WebDriver;

/**
 *
 * @author ruberg
 */
public class SeleniumBasics {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        // System.setProperty("webdriver.chrome.driver", "C:\\Users\\ruberg\\Documents\\Entwicklung\\Selenium\\chromedriver_win32\\chromedriver.exe");
        // WebDriver driver = new ChromeDriver();
        // driver.get("http://www.google.de");
        // Cookies akzeptieren
        // driver.findElement(By.id("L2AGLb")).click();
        /* Locator By.name
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Hallo Welt");
        element.submit();
        */
        /* Locator By.linkText        
        driver.findElement(By.linkText("Gmail")).click();
        */
        // driver.findElement(By.partialLinkText("Über G")).click();
        
        
        /*
        FirstScriptTest fst = new FirstScriptTest();
        fst.setup();
        fst.eightComponents();
        fst.quit();
        */
        
        WebclientMeeting wcm = new WebclientMeeting();
        wcm.SetSolution();
        wcm.LoginSolution();
        wcm.CreateMeetingBoard();

        // XpathFollowingSibling.Create();
    }
    
}
