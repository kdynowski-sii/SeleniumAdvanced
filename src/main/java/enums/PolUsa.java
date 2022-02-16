package enums;

public enum PolUsa {
    POLAND (12),
    USA(21);

    PolUsa(int i) {
        numVal = i;
    }

    public int getNumVal() {
        return numVal;
    }

    private int numVal;
}
