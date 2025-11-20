/**
 * Immutable-ish card record (mutable colour for wild recolouring).
 * <p>
 * For WILD/WILD_DRAW_TWO, colour may be null until chosen by a player.
 */
public class Card {
    private UnoModel.Colours colour;             // can be reassigned for wilds via wild()/wildDrawTwo()
    private final UnoModel.Values value;

    /**
     * Creates a card with the given colour and value.
     * For wilds, pass null for colour.
     */
    public Card(UnoModel.Colours colour, UnoModel.Values value) {
        this.colour = colour;
        this.value = value;
    }

    /** @return current colour; may be null for wilds until chosen */
    public UnoModel.Colours getColour() { return colour; }

    /** @return value of the card (number/action/wild) */
    public UnoModel.Values getValue() {
        return value;
    }

    /** Assigns a new colour (used when playing a wild). */
    public void setColour(UnoModel.Colours colour) {
        this.colour = colour;
    }

    /**
     * @return image file name for this card (assumes resources in /images).
     * Wilds do not include colour in the file name.
     */
    public String getFileName() {
        if(value == UnoModel.Values.WILD || value == UnoModel.Values.WILD_DRAW_TWO) {
            return "images/" + value + ".png";
        }
        return "images/" + colour.toString() + "_" + value.toString() + ".png";
    }

    /**
     * Logical equality: same colour and value.
     * (Note: no hashCode override—avoid using as hash keys unless added.)
     */
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if (!(o instanceof Card other)) {
            return false;
        }
        return this.colour == other.colour && this.value == other.value;
    }
}