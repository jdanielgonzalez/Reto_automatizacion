package co.com.sofka.stepdefinition.panel_login;

import co.com.sofka.model.panel_login.PanelLoginModel;
import co.com.sofka.page.panel_login.PanelLogin;
import co.com.sofka.stepdefinition.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;


import static co.com.sofka.util.Seconds.TEN_SECONDS;
import static co.com.sofka.util.Numbers.*;

public class PanelLoginStepDefinition extends WebUI {
    private static final Logger LOGGER = Logger.getLogger(PanelLoginStepDefinition.class);
    private PanelLoginModel panelLoginModel;
    private PanelLogin p_login;

    private static final String ASSERTION_EXCEPTION_MESSAGE = "Los valores suministrados no son los esperados.";

    /**+++++++++++Inicio de sesion exitoso+++++++++++++++**/
    @Given("que quiero iniciar sesion como administrador")
    public void queQuieroIniciarSesionComoAdministrador() {
        try {
            generalSetUp();
        } catch (Exception exception) {
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @When("ingrese las credenciales correctas")
    public void ingreseLasCredencialesCorrectas() {
        try {
            configuracionDatos(NUMBER0.getValue());
            p_login = new PanelLogin(driver, panelLoginModel, TEN_SECONDS.getValue());
            p_login.llenarLogin();
        } catch (Exception exception) {
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @Then("se deberia el login de manera correcta.")
    public void seDeberiaElLoginDeManeraCorrecta() {
        try {
            Assertions.assertTrue(
                    p_login.isDisplayed(p_login.getAssertionLoginExitoso()),
                    ASSERTION_EXCEPTION_MESSAGE
            );
            quitDriver();
        } catch (Exception exception) {
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    /**+++++++-------Inicio de sesión donde el password es inválido.------++++++++++++**/
    @When("ingrese el Password incorrecto")
    public void ingreseElPasswordIncorrecto() {
        try {
            configuracionDatos(NUMBER1.getValue());
            p_login = new PanelLogin(driver, panelLoginModel, TEN_SECONDS.getValue());
            p_login.llenarLogin();
        } catch (Exception exception) {
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @Then("deberia fallar el login por culpa del password")
    public void deberiaFallarElLoginPorCulpaDelPassword() {
        try {
            Assertions.assertEquals(
                    expected(NUMBER1.getValue()),
                    p_login.getAssertionLoginFail(),
                    ASSERTION_EXCEPTION_MESSAGE
            );
            quitDriver();
        } catch (Exception exception) {
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    /**=====================Inicio de sesión donde el usuario es inválido.=======================**/

    @When("ingrese el user incorrecto")
    public void ingreseElUserIncorrecto() {
        try {
            configuracionDatos(NUMBER2.getValue());
            p_login = new PanelLogin(driver, panelLoginModel, TEN_SECONDS.getValue());
            p_login.llenarLogin();
        } catch (Exception exception) {
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }


    @Then("deberia fallar el login por culpa del user")
    public void deberiaFallarElLoginPorCulpaDelUser() {
        try {
            Assertions.assertEquals(
                    expected(NUMBER2.getValue()),
                    p_login.getAssertionLoginFail(),
                    ASSERTION_EXCEPTION_MESSAGE
            );
            quitDriver();
        } catch (Exception exception) {
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    /**=====================Inicio de sesión donde no se introducen credenciales..=======================**/


    @When("no ingrese ninguna credencial")
    public void noIngreseNingunaCredencial() {
        try {
            configuracionDatos(NUMBER3.getValue());
            p_login = new PanelLogin(driver, panelLoginModel, TEN_SECONDS.getValue());
            p_login.llenarLogin();
        } catch (Exception exception) {
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @Then("deberia fallar el login por falta de credenciales")
    public void deberiaFallarElLoginPorFaltaDeCredenciales() {
        try {
            Assertions.assertEquals(
                    expected(NUMBER3.getValue()),
                    p_login.getAssertionLoginFail(),
                    ASSERTION_EXCEPTION_MESSAGE
            );
            quitDriver();
        } catch (Exception exception) {
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    private void configuracionDatos(int select) {
        switch (select) {
            case 0:
                panelLoginModel = new PanelLoginModel();
                panelLoginModel.setUser("Admin");
                panelLoginModel.setPassword("admin123");
                break;
            case 1:
                panelLoginModel = new PanelLoginModel();
                panelLoginModel.setUser("Admin");
                panelLoginModel.setPassword("ad33123");
                break;
            case 2:
                panelLoginModel = new PanelLoginModel();
                panelLoginModel.setUser("aDministrador");
                panelLoginModel.setPassword("admin123");
                break;
            case 3:
                panelLoginModel = new PanelLoginModel();
                panelLoginModel.setUser("");
                panelLoginModel.setPassword("");
                break;


        }

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
