package co.com.sofka.page.panel_login;

import co.com.sofka.model.panel_login.PanelLoginModel;
import co.com.sofka.page.common.CommonActionsOnPages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class PanelLogin extends CommonActionsOnPages{
    private static final Logger LOGGER = Logger.getLogger(PanelLogin.class);
    private PanelLoginModel orangeLoginModel;
    private static final String MODEL_NULL_MESSAGE = "El modelo del formulario es nulo.";


    private final By user = By.id("txtUsername");
    private final By password = By.id("txtPassword");
    private final By btnLogin = By.id("btnLogin");

    private final By adminMenuLocator = By.id("menu_admin_viewAdminModule");
    private final By searchEmployeeNameLocator = By.id("searchSystemUser_employeeName_empName");
    private final By searchUserNameLocator = By.id("searchSystemUser_userName");
    private final By btnSearch = By.id("searchBtn");
    private final By btnReset = By.id("resetBtn");


    //For Assertions test case.
    private final By assertionLoginFail = By.id("spanMessage");
    private final By assertionLoginExitoso = By.id("welcome");
    private final By assertionSearch = By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td[4]");
    private final By assertionReset = By.id("searchSystemUser_userName");

    public PanelLogin(WebDriver driver, PanelLoginModel orangeLogin) {
        super(driver);
        this.orangeLoginModel = orangeLogin;
    }

    public PanelLogin(WebDriver driver, PanelLoginModel orangeLogin, int secondsForExplicitWait) {
        super(driver, secondsForExplicitWait);
        if(orangeLogin == null)
            LOGGER.warn(MODEL_NULL_MESSAGE);
        this.orangeLoginModel= orangeLogin;
    }

    public void llenarLogin() throws IOException {
        try{
            scrollTo(user);
            withExplicitWaitClear(user);
            withExplicitWaitTypeInto(user,orangeLoginModel.getUser());

            scrollTo(password);
            withExplicitWaitClear(password);
            withExplicitWaitTypeInto(password,orangeLoginModel.getPassword());

            scrollTo(btnLogin);
            withExplicitWaitClickOn(btnLogin);
        }
        catch (Exception exception){
            LOGGER.warn(exception.getMessage());
        }
    }


    public void llenarBusquedad()throws IOException{
        try{
            scrollTo(adminMenuLocator);
            withExplicitWaitClickOn(adminMenuLocator);

            scrollTo(searchEmployeeNameLocator);
            withExplicitWaitClear(searchEmployeeNameLocator);
            withExplicitWaitTypeInto(searchEmployeeNameLocator,orangeLoginModel.getEmployeeName().getValue());

            scrollTo(searchUserNameLocator);
            withExplicitWaitClear(searchUserNameLocator);
            withExplicitWaitTypeInto(searchUserNameLocator,orangeLoginModel.getUsename().getValue());

            withExplicitWaitClickOn(btnSearch);
            scrollTo(btnReset);
            withExplicitWaitClickOn(btnReset);

        } catch (Exception exception){
            LOGGER.warn(exception.getMessage());
        }
    }


    public By getAssertionLoginExitoso() {
        return assertionLoginExitoso;
    }

    public String getAssertionLoginFail() {
        return getText(assertionLoginFail).trim();
    }

    public String getAssertionSearch(){
        return getText(assertionSearch).trim();
    }

    public By getAssertionReset() {
        return assertionReset;
    }

    public String getSearchUserNameLocator() {
        return getValue(searchUserNameLocator);
    }
}
