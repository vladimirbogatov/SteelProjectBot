package model;

public class Jsk {
    private static Jsk jsk = new Jsk(); //синглтон
    private static final int FLAT_NUMBER_FROM = 1; //start of flats numbering
    private static final int FLAT_NUMBER_TILL = 144; // end of flats numbering

    public static int getFlatNumberFrom() {
        return FLAT_NUMBER_FROM;
    }

    public static int getFlatNumberTill() {
        return FLAT_NUMBER_TILL;
    }

    private Jsk() {
    }

    public static Jsk getJSK() {
        return jsk;
    }
}
