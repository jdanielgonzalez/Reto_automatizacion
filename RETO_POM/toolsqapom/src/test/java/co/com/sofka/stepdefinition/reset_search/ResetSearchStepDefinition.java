package co.com.sofka.stepdefinition.reset_search;

import co.com.sofka.model.panel_login.PanelLoginModel;
import co.com.sofka.page.panel_login.PanelLogin;
import co.com.sofka.stepdefinition.panel_login.PanelLoginStepDefinition;
import co.com.sofka.stepdefinition.setup.WebUI;
import co.com.sofka.util.EmployeeName;
import co.com.sofka.util.UserName;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.util.Numbers.NUMBER0;
import static co.com.sofka.util.Numbers.NUMBER3;
import static co.com.sofka.util.Seconds.TEN_SECONDS;

public class ResetSearchStepDefinition extends WebUI {
    private static final Logger LOGGER = Logger.getLogger(PanelLoginStepDefinition.class);
    private PanelLoginModel panelLoginModel;
    private PanelLogin p_login;
    private static final String ASSERTION_EXCEPTION_MESSAGE = "No se reseteo de manera correcta";

    @Given("como administrador deseo resetar la busqueda")
    public void comoAdministradorDeseoResetarLaBusqueda() {
        try {
            generalSetUp();
        } catch (Exception exception) {
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }
    @When("desee hacer otra bsuqueda")
    public void deseeHacerOtraBsuqueda() {
        try {
            ingresarDatosAdmin();
            p_login = new PanelLogin(driver, panelLoginModel, TEN_SECONDS.getValue());
            p_login.llenarLogin();
            p_login.llenarBusquedad();

        } catch (Exception exception) {
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @Then("todos lo campos deben de resetearse")
    public void todosLoCamposDebenDeResetearse() {
        try {
            Assertions.assertEquals(p_login.getSearchUserNameLocator(),"",
                    "chillin");

        }
        catch (Exception exception) {
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
        }
    }

    public void ingresarDatosAdmin()
    {
        panelLoginModel = new PanelLoginModel();
        panelLoginModel.setUser("Admin");
        panelLoginModel.setPassword("admin123");
        panelLoginModel.setEmployeeName(EmployeeName.NAME3);
        panelLoginModel.setUsename(UserName.NAME3);
    }

    private String expected(int casos) {
        switch (casos) {
            case 0:
                return "Welcome";
            case 1:
                return "Invalid credentials";

            case 2:
                return "Invalid credentials";

            case 3:
                return "Username cannot be empty";

            default:
                return "Default";
        }
    }
}
