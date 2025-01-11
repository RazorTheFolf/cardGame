public class Card {
    private final int id;
    private int value;
    private final int color;
    private final String name;

    public Card(int id, int Value, int Color) {
        if (Value > 13 || Value < 1) {
            throw new IllegalArgumentException("Valeur de carte invalide");
        }

        if (Color > 4 || Color < 1) {
            throw new IllegalArgumentException("Couleur de carte invalide");
        }

        this.id = id;
        this.value = Value;
        this.color = Color;
        this.name = constructName();

        if (this.value == 1) setValue(11);
    }

    public int getValue() {
        if (this.id == 1) {
            return value;
        } else {
            return Math.min(value, 10);
        }
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public void setValue(int newValue) {
        if (this.value != 1) return;
        this.value = newValue;
    }

    private String constructName() {
        return switch (this.color) {
            case 1 -> prefix(this.value) + " de Pique ♠";
            case 2 -> prefix(this.value) + " de Trèfle ♣";
            case 3 -> prefix(this.value) + " de Carreau ♦";
            case 4 -> prefix(this.value) + " de Coeur ♥";
            default -> throw new IllegalStateException("Unexpected value: " + this.color); // Satisfaire le compilateur
        };
    }

    private String prefix(int value) {
        return switch (value) {
            case 1 -> "As";
            case 11 -> "Valet";
            case 12 -> "Reine";
            case 13 -> "Roi";
            default -> String.valueOf(value);
        };
    }
}
