package uno;

public class Card {
    public enum Color {
        RED, BLUE, GREEN, YELLOW, WILD;
    }

    public enum Value {
        ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE,
        SKIP, REVERSE, DRAW_TWO, WILD, WILD_DRAW_FOUR;
    }

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
        return "Card{color=" + color + ", value=" + value + '}';
    }
}
