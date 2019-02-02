package drawerlayout.demo.mjz.clock;

public class Display {
    private int limit, value;
    private Boolean b = false;

    Display(int value, int limit) {
        this.value = value;
        this.limit = limit;
    }

    public String getValue() {
        return Integer.toString(value);
    }


    public Display setValue(int value) {
        this.value = value;
        return this;
    }

    public Display decrease() {
        value = Integer.parseInt(this.getValue());

        if (value == 0) {
            b = true;
            value = limit - 1;
        } else {
            value -= 1;
            b = false;
        }
        return this;
    }

    public Display increase() {
        value = Integer.parseInt(this.getValue());

        if (value + 1 == limit) {
            value = 0;
            b = true;
        } else {
            value += 1;
            b = false;
        }
        return this;
    }

    public Boolean isLimited() {
        return b;
    }
}
