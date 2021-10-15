package co.com.sofka.util;

public enum Numbers {
    NUMBER0(0),
    NUMBER1(1),
    NUMBER2(2),
    NUMBER3(3),
    NUMBER4(4);


    private final int value;

    Numbers(int value){
        this.value=value;
    }

    public int getValue() {
        return value;
    }
}




