package co.com.sofka.model.panel_login;

import co.com.sofka.util.EmployeeName;
import co.com.sofka.util.UserName;

public class PanelLoginModel {
    private String user;
    private String password;
    private EmployeeName employeeName;
    private UserName usename;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EmployeeName getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(EmployeeName employeeName) {
        this.employeeName = employeeName;
    }

    public UserName getUsename() {
        return usename;
    }

    public void setUsename(UserName usename) {
        this.usename = usename;
    }
}


