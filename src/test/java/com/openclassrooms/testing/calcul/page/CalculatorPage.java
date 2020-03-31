package com.openclassrooms.testing.calcul.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorPage {
    public static final String     ADDITION_SYMBOL       = "+";
    public static final String     SUBTRACTION_SYMBOL    = "-";
    public static final String     DIVISION_SYMBOL       = "/";
    public static final String     MULTIPLICATION_SYMBOL = "x";
    private final       WebDriver  webdriver;
    @FindBy(id = "submit")
    private             WebElement submitButton;
    @FindBy(id = "left")
    private             WebElement leftArgument;
    @FindBy(id = "right")
    private             WebElement rightArgument;
    @FindBy(id = "typeOperation")
    private             WebElement calculationType;
    @FindBy(id = "solution")
    private             WebElement solution;

    public CalculatorPage(WebDriver webdriver) {
        this.webdriver = webdriver;
        PageFactory.initElements(webdriver, CalculatorPage.class);
    }

    public String add(String leftValue, String rightValue) {
        return calculate(ADDITION_SYMBOL, leftValue, rightValue);
    }

    public String subtract(String leftValue, String rightValue) {
        return calculate(SUBTRACTION_SYMBOL, leftValue, rightValue);
    }

    public String divide(String leftValue, String rightValue) {
        return calculate(DIVISION_SYMBOL, leftValue, rightValue);
    }

    public String multiply(String leftValue, String rightValue) {
        return calculate(MULTIPLICATION_SYMBOL, leftValue, rightValue);
    }

    private String calculate(String calculationTypeValue, String leftValue, String rightValue) {
        leftArgument.sendKeys(leftValue);
        calculationType.sendKeys(calculationTypeValue);
        rightArgument.sendKeys(rightValue);
        submitButton.click();
        WebDriverWait wait = new WebDriverWait(webdriver, 5);
        wait.until(ExpectedConditions.visibilityOf(solution));
        return solution.getText();
    }
}
