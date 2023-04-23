package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AmazonEmail {
    ChromeDriver driver = new ChromeDriver();
    @BeforeClass
    void setup()
    {

        WebDriverManager.chromedriver().setup();
        driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3F%26ext_vrnc%3Dhi%26tag%3Dgooghydrabk1-21%26ref%3Dnav_signin%26adgrpid%3D58355126069%26hvpone%3D%26hvptwo%3D%26hvadid%3D610644601173%26hvpos%3D%26hvnetw%3Dg%26hvrand%3D14856131913356457293%26hvqmt%3De%26hvdev%3Dc%26hvdvcmdl%3D%26hvlocint%3D%26hvlocphy%3D9144064%26hvtargid%3Dkwd-10573980%26hydadcr%3D14453_2316415&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");

        driver.manage().window().maximize();
    }
    @Test
    public void getTitleFromPage() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("str.life.satyam@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("Str@1516");
        driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();
        ////////HOVER////////
        WebElement ele = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span"));

        //Creating object of an Actions class
        Actions action = new Actions(driver);

        //Performing the mouse hover action on the target element.
        action.moveToElement(ele).perform();
///////////////////////////////////////////////////////////////////////
        /// CREATING WISHLIST
        driver.findElement(By.xpath("//span[normalize-space()='Create a Wish List']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@aria-labelledby='createList-announce']")).click();
        Thread.sleep(4000);

        driver.findElement(By.xpath("//input[@id='list-name']")).clear();
        Thread.sleep(4000);

        driver.findElement(By.xpath("//input[@id='list-name']")).sendKeys("My WishList");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"wl-redesigned-create-list\"]/span/span/input")).click();


        //// ITEM SEARCH CLICK
        Thread.sleep(4000);
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Mouse");
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("#nav-search-submit-button")).click();
        Thread.sleep(8000);

        /// ITEM CLICK
        driver.findElement(By.xpath("//div[contains(@class,'rush-component s-featured-result-item')]//span[@class='a-size-medium a-color-base a-text-normal'][contains(text(),'HP X1000 Wired USB Mouse with 3 Handy Buttons, Fas')]")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//input[@id='add-to-wishlist-button']")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//span[@id='atwl-list-privacy-12F0BI9R2UJA5']"));
        Thread.sleep(4000);
    }
}
