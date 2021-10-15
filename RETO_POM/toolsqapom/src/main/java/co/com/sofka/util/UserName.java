package co.com.sofka.util;

public enum UserName {
    NAME1("Aaliyah.Haq"),
    NAME2("Aatmaram"),
    NAME3("Anthony.Nolan");


    private final String value;

    public String getValue() {
        return value;
    }

    UserName (String value) {
        this.value = value;
    }
}
