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

/**
 *
 * @author ruberg
 */
public class XpathFollowingSibling {
    
    public static void Create() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://courses.letskodeit.com/practice");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<WebElement> listRadioButtons = driver.findElements(By.xpath("//legend[contains(text(), \"Radio\")]//following-sibling::label//following-sibling::input"));
        
        for (WebElement buttonAuto: listRadioButtons) {
            System.out.println(buttonAuto.getAttribute("value"));
            buttonAuto.click();
            Thread.sleep(3000);
        }
        
        driver.quit();
    }
   
}
