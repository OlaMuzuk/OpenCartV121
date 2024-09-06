package testBase;


import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class  BaseClass {

    public static WebDriver driver;
    public Logger logger;   //Log4j
    public Properties p;


    @BeforeClass(groups = {"Sanity", "Regression", "Master" })
    @Parameters({"os","browser"})
    public void setup(String os, String br) throws InterruptedException, IOException {

        //Loading config.properties file
        FileReader file=new FileReader("./src//main//resources//config.properties");
        p=new Properties();
        p.load(file);

        logger= LogManager.getLogger(this.getClass());      //LOG4J2


        //Selenium Grid
        if (p.getProperty("execution_env").equalsIgnoreCase("remote")){
            DesiredCapabilities capabilities=new DesiredCapabilities();

            //os
            if (os.equalsIgnoreCase("windows")){
                capabilities.setPlatform(Platform.WIN10);
            }
            else if (os.equalsIgnoreCase("mac")){
                capabilities.setPlatform(Platform.MAC);
            }
            else {
                System.out.println("No matching os");
                return;
            }
            //browser
            switch (br.toLowerCase()){
                case "chrome": capabilities.setBrowserName("chrome");break;
                case "edge": capabilities.setBrowserName("MicrosoftEdge");break;
                default:
                    System.out.println("No matching browser"); return;
            }
            driver=new RemoteWebDriver(new URL("http://192.168.0.14:4444/wd/hub"), capabilities);

        }
        if (p.getProperty("execution_env").equalsIgnoreCase("local")){
            switch (br.toLowerCase()){
                case "chrome" : driver=new ChromeDriver(); break;
                case "edge" : driver=new EdgeDriver(); break;
                //case "firefox" : driver=new FirefoxDriver(); break;
                default:
                    System.out.println("Invalid browser name.."); return;
            }

        }


        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
        //driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");

        driver.get(p.getProperty("appURL2")); //reading url from properties file(config.properties)


        //Thread.sleep(15000);
        driver.manage().window().maximize();
    }

    @AfterClass(groups = {"Sanity", "Regression", "Master"})
    public void tearDown(){
        driver.quit();
    }


    public String randomeString(){
        String generatestring= RandomStringUtils.randomAlphabetic(5 );
        return generatestring;
    }

    public String randomeNumber(){
        String generatenumber= RandomStringUtils.randomNumeric(7);
        return generatenumber;
    }

    public String randomAlphaNumeric(){
        String generatestring= RandomStringUtils.randomAlphabetic(3 );
        String generatenumber= RandomStringUtils.randomNumeric(3);
        return (generatestring+"@"+generatenumber);
    }

    public String captureScreen(String tname) throws IOException{
        String timeStamp = new SimpleDateFormat("yyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot= (TakesScreenshot) driver;
        File sourseFile=takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath= System.getProperty("user.dir")+ "//screenshots//" + tname + "_" +timeStamp + ".png";
        File targetFile= new File(targetFilePath);

        sourseFile.renameTo(targetFile);

        return targetFilePath;
    }




}
