import java.util.ArrayList;
import java.util.List;

/**
 * Player entity: holds a name and personal hand.
 */
public class Player {
    private final List<Card> personalDeck = new ArrayList<>();
    private final String name;

    /** Creates a player with the given display name. */
    public Player(String name){
        this.name = name;
    }

    /** @return live list of cards held by the player */
    public List<Card> getPersonalDeck() {
        return personalDeck;
    }

    /** Adds a single card to the player's hand. */
    public void addCard(Card c) {
        personalDeck.add(c);
    }

    /** @return player display name */
    public String getName() {
        return name;
    }

}
