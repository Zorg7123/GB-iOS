package Pages;

import com.github.romankh3.image.comparison.ImageComparison;
import com.github.romankh3.image.comparison.ImageComparisonUtil;
import com.github.romankh3.image.comparison.model.ImageComparisonResult;
import com.github.romankh3.image.comparison.model.ImageComparisonState;
import io.qameta.allure.Step;
import locators.MainPageLocators;

import java.awt.image.BufferedImage;
import java.io.File;

import com.github.romankh3.image.comparison.ImageComparison;
import com.github.romankh3.image.comparison.ImageComparisonUtil;
import com.github.romankh3.image.comparison.model.ImageComparisonResult;
import com.github.romankh3.image.comparison.model.ImageComparisonState;
import io.qameta.allure.Step;
import ru.gb.locators.LocatorService;
import ru.gb.locators.interfaces.MainPageLocators;

import java.awt.image.BufferedImage;
import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.AssertJUnit.assertEquals;

public class MainPage {

    private MainPageLocators locator() {
        return LocatorService.MAIN_PAGE_LOCATORS;
    }

    @Step("Кликаем по кнопке логина в меню и переходим на новую страницу логина")
    public LoginPage clickLoginMenuButton() {
        $(locator().loginButton()).click();
        return new LoginPage();
    }

    @Step("Кликаем по кнопке Forms в меню и переходим на новую страницу Forms")
    public FormsPage clickFormsMenuButton() {
        $(locator().FormsButton()).click();
        return new FormsPage();
    }

    @Step("Кликаем по кнопке Swipe в меню и переходим на новую страницу Forms")
    public SwipePage clickSwipeMenuButton() {
        $(locator().SwipeButton()).click();
        return new SwipePage();
    }


    @Step("Делаем скриншот главной страницы и сравниваем с требованием.")
    public MainPage checkScreenshot() {

        BufferedImage expectedImage = ImageComparisonUtil.readImageFromResources("src/main/resources/expectedScreenshots/mainPage.png");

        File actualScreenshot = $(locator().homeScreen()).screenshot();

        BufferedImage actualImage = ImageComparisonUtil.readImageFromResources("screenshots/actual/" + actualScreenshot.getName());


        File resultDestination = new File("diff/diff_CheckMainPageScreenshot.png");


        ImageComparisonResult imageComparisonResult = new ImageComparison(expectedImage, actualImage, resultDestination).compareImages();
        assertEquals(ImageComparisonState.MATCH, imageComparisonResult.getImageComparisonState());
        return this;
    }


    @Step("Делаем проверку падения теста по скриншоту.")
    public MainPage checkFailScreenshot() {

        BufferedImage expectedImage = ImageComparisonUtil.readImageFromResources("src/main/resources/expectedScreenshots/failTest.png");

        File actualScreenshot = $(locator().homeScreen()).screenshot();

        BufferedImage actualImage = ImageComparisonUtil.readImageFromResources("screenshots/actual/" + actualScreenshot.getName());


        File resultDestination = new File("diff/diff_CheckFailMainPageScreenshot.png");


        ImageComparisonResult imageComparisonResult = new ImageComparison(expectedImage, actualImage, resultDestination).compareImages();
        assertEquals(ImageComparisonState.MATCH, imageComparisonResult.getImageComparisonState());
        return this;
    }
}