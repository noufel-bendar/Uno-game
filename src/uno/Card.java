package uno;

public class Card {
    private final Color color;
    private final Value value;

    public Card(Color color, Value value) {
        this.color = color;
        this.value = value;
    }

    public Color getColor() {
        return color;
    }

    public Value getValue() {
        return value;
    }

    public boolean isSpecial() {
        if (value == Value.SKIP) {
            return true;
        }
        if (value == Value.REVERSE) {
            return true;
        }
        if (value == Value.DRAW_TWO) {
            return true;
        }
        if (value == Value.WILD) {
            return true;
        }
        if (value == Value.WILD_DRAW_FOUR) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Card\uD83C\uDCCF{" + color + "," + value + "}";
    }
}
