import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ErrorCheckMissingMeaning {
    public WebDriver driver_ecmm;
    public ErrorCheckMissingMeaning(WebDriver driver_ecmm) {
        PageFactory.initElements(driver_ecmm, this);
        this.driver_ecmm = driver_ecmm; }
    @FindBy(xpath = "//span[text() = 'sin']//parent::button")
    private WebElement buttonSin;
    @FindBy(xpath = "//div[@Class=\"calculator-display__error\"]//parent::div")
    private WebElement historyCalc;
    @FindBy(xpath = "//*[@Class=\"input__control calculator__control_size_l\"]")
    private WebElement result;
    @FindBy(xpath = "//span[text() = '=']//parent::button")
    private WebElement buttonEquals;
    public void EnterExpression() throws InterruptedException {
        buttonSin.click();
        Thread.sleep(500);
        buttonEquals.click();
    }
    public String getValueHistoryCalc()
    {
        return historyCalc.getText();
    }

    public String getResult()
    {
        return result.getAttribute("value");
    }
}
