package co.com.sofka.util;

public enum EmployeeName {
    NAME1("Aaliyah Haq"),
    NAME2("Alice Duval"),
    NAME3("Anthony Nolan"),
    NAME4("Cassidy Hope"),
    NAME5("Cecil Bonaparte"),
    NAME6("Charlie Carter"),
    NAME7("Chenzira Chuki"),
    NAME8("David Morris"),
    NAME9("Dominic Chase"),
    NAME10("Dominic Chase"),
    NAME11("Odis Adalwin");

    private final String value;

    public String getValue() {
        return value;
    }

    EmployeeName(String value) {
        this.value = value;
    }
}
