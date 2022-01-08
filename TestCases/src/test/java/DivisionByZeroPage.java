import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DivisionByZeroPage {
    public WebDriver driver_dbzp;
    public DivisionByZeroPage(WebDriver driver_dbzp) {
        PageFactory.initElements(driver_dbzp, this);
        this.driver_dbzp = driver_dbzp; }
    @FindBy(xpath = "//span[text() = '6']//parent::button")
    private WebElement buttonSix;
    @FindBy(xpath = "//span[text() = '÷']//parent::button")
    private WebElement buttonDiv;
    @FindBy(xpath = "//span[text() = '0']//parent::button")
    private WebElement buttonZero;
    @FindBy(xpath = "//*[@Class=\"calculator-display__output calculator-display__output_clickable_yes\"]")
    private WebElement historyCalc;
    @FindBy(xpath = "//*[@Class=\"input__control calculator__control_size_l\"]")
    private WebElement result;
    @FindBy(xpath = "//span[text() = '=']//parent::button")
    private WebElement buttonEquals;

    public void EnterExpression() throws InterruptedException {
        buttonSix.click();
        buttonDiv.click();
        buttonZero.click();
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
