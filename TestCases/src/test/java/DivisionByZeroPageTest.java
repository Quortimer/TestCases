import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


class DivisionByZeroPageTest {
    public static DivisionByZeroPage dbzp;
    public static WebDriver driver_dbzp;

    @BeforeAll
    static void setUp() throws MalformedURLException {
        //System.setProperty("webdriver.chrome.driver","E:\\Exp\\TestCases\\chromedriver.exe");
        driver_dbzp = new ChromeDriver();
        /*ChromeOptions cap = new ChromeOptions();
        driver_dbzp = new RemoteWebDriver(new URL("http://localhost:9515"),cap);*/
        dbzp = new DivisionByZeroPage(driver_dbzp);
        driver_dbzp.manage().window().maximize();
        driver_dbzp.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver_dbzp.get("http://yandex.ru");
        //driver.get("http://google.com");
        WebElement poisk = driver_dbzp.findElement(By.xpath("//*[@Class=\"input__control input__input mini-suggest__input\"]"));
        poisk.sendKeys("Калькулятор");
        poisk.sendKeys(Keys.ENTER);
    }

    @Test
    public void Test01() throws InterruptedException { //Ввод математического выражения
        dbzp.EnterExpression();
    }

    @Test
    public void Test02() // сравнение ожидаемого математического выражения с выражением в истории вычислений
    {
        String expr = dbzp.getValueHistoryCalc();
        Assertions.assertEquals("6 ÷ 0 =", expr);
    }

    @Test
    public void Test03() // сравнение ожидаемого результата и фактического результата
    {
        String result = dbzp.getResult();
        Assertions.assertEquals("Infinity", result);
    }

    @AfterAll
    static void tearDown() {
        driver_dbzp.quit();
    }
}