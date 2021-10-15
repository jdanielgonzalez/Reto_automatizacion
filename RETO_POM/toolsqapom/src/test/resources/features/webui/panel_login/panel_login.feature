Feature: incio de sesion
  yo como usuario administrador quiero iniciar sesion en la pagina web
  OrangeHRM.

  Background:
    Given que quiero iniciar sesion como administrador

  Scenario: Inicio de sesion exitoso
    When ingrese las credenciales correctas
    Then se deberia el login de manera correcta.

  Scenario: inicio  de sesion donde el password es invalido
    When ingrese el Password incorrecto
    Then deberia fallar el login por culpa del password

  Scenario: Inicio  de sesión donde el usuario es inválido.
    When ingrese el user incorrecto
    Then deberia fallar el login por culpa del user

  Scenario: Inicio  de sesión donde no se introducen credenciales
    When no ingrese ninguna credencial
    Then deberia fallar el login por falta de credenciales