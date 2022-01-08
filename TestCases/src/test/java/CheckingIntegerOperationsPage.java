import com.sun.org.apache.xpath.internal.objects.XNull;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckingIntegerOperationsPage {
    public WebDriver driver;
    public CheckingIntegerOperationsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//span[text() = '0']//parent::button")
    private WebElement buttonZero;
    @FindBy(xpath = "//span[text() = '1']//parent::button")
    private WebElement buttonOne;
    @FindBy(xpath = "//span[text() = '2']//parent::button")
    private WebElement buttonTwo;
    @FindBy(xpath = "//span[text() = '3']//parent::button")
    private WebElement buttonThree;
    @FindBy(xpath = "//span[text() = '4']//parent::button")
    private WebElement buttonFour;
    @FindBy(xpath = "//span[text() = '5']//parent::button")
    private WebElement buttonFive;
    @FindBy(xpath = "//span[text() = '+']//parent::button")
    private WebElement buttonAdd;
    @FindBy(xpath = "//span[text() = '−']//parent::button")
    private WebElement buttonSub;
    @FindBy(xpath = "//span[text() = '×']//parent::button")
    private WebElement buttonMultiP;
    @FindBy(xpath = "//span[text() = '÷']//parent::button")
    private WebElement buttonDiv;
    @FindBy(xpath = "//span[text() = '( )']//parent::button")
    private WebElement buttonBracket;
    @FindBy(xpath = "//span[text() = '=']//parent::button")
    private WebElement buttonEquals;

    @FindBy(xpath = "//*[@Class=\"calculator-display__output calculator-display__output_clickable_yes\"]")
    private WebElement historyCalc;
    @FindBy(xpath = "//*[@Class=\"input__control calculator__control_size_l\"]")
    private WebElement result;
    public void EnterExpression() throws InterruptedException {
       buttonBracket.click();
       buttonOne.click();
       buttonAdd.click();
       buttonTwo.click();
       buttonBracket.click();
       buttonMultiP.click();
       buttonThree.click();
       buttonSub.click();
       buttonFour.click();
       buttonZero.click();
       buttonDiv.click();
       buttonFive.click();
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
