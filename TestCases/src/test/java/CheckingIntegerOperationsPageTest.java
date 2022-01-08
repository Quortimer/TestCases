import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class CheckingIntegerOperationsPageTest {
    public static CheckingIntegerOperationsPage ciop;
    public static WebDriver driver;

    @BeforeAll
    public static void setup()
    {
        driver = new ChromeDriver();
        ciop = new CheckingIntegerOperationsPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("http://yandex.ru");
        //driver.get("http://google.com");
        WebElement poisk = driver.findElement(By.xpath("//*[@Class=\"input__control input__input mini-suggest__input\"]"));
        poisk.sendKeys("Калькулятор");
        poisk.sendKeys(Keys.ENTER);
    }

    @Test
    public void Test01() throws InterruptedException { //Ввод математического выражения
        ciop.EnterExpression();
    }

    @Test
    public void Test02() // сравнение ожидаемого математического выражения с выражением в истории вычислений
    {
        String expr = ciop.getValueHistoryCalc();
        Assertions.assertEquals("(1 + 2) × 3 - 40 ÷ 5 =", expr);
    }

    @Test
    public void Test03() // сравнение ожидаемого результата и фактического результата
    {
        String result = ciop.getResult();
        Assertions.assertEquals("1", result);
    }

    @AfterAll
    public static void tearDown()
    {
        driver.quit();
    }
}