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
        String colorString = color.toString();
        String valueString = value.toString();
    
        int width = Math.max(colorString.length(), valueString.length()) + 4;
    
        StringBuilder card = new StringBuilder();
        card.append("#".repeat(width)).append("\n");
        card.append("# ").append(colorString).append(" ".repeat(width - colorString.length() - 3)).append("#\n");
        card.append("# ").append(valueString).append(" ".repeat(width - valueString.length() - 3)).append("#\n");
        card.append("#".repeat(width));
    
        return card.toString();
    }
}
