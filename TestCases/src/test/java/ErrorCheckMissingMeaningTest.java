import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class ErrorCheckMissingMeaningTest {
    public static ErrorCheckMissingMeaning ecmm;
    public static WebDriver driver_ecmm;
    @BeforeAll
    static void setUp() {
        driver_ecmm = new ChromeDriver();
        ecmm = new ErrorCheckMissingMeaning(driver_ecmm);
        driver_ecmm.manage().window().maximize();
        driver_ecmm.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver_ecmm.get("http://yandex.ru");
        //driver.get("http://google.com");
        WebElement poisk = driver_ecmm.findElement(By.xpath("//*[@Class=\"input__control input__input mini-suggest__input\"]"));
        poisk.sendKeys("Калькулятор");
        poisk.sendKeys(Keys.ENTER);
    }

    @Test
    public void Test01() throws InterruptedException { //Ввод математического выражения
        ecmm.EnterExpression();
    }

    @Test
    public void Test02() // сравнение ожидаемого математического выражения с выражением в истории вычислений
    {
        String expr = ecmm.getValueHistoryCalc();
        Assertions.assertEquals("sin() =", expr);
    }

    @Test
    public void Test03() // сравнение ожидаемого результата и фактического результата
    {
        String result = ecmm.getResult();
        Assertions.assertEquals("Error", result);
    }
        @AfterAll
    static void tearDown() {
        driver_ecmm.quit();
    }
}