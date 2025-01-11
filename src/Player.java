import java.util.ArrayList;
import java.util.List;

public class Player {
    private final Integer id;
    private final String name;
    private final List<Card> hand = new ArrayList<>();
    public boolean isOut = false;

    public Player(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addCardToDeck(Card card) {
        hand.add(card);
    }

    public int getHandTotalValue() {
        int total = 0;

        for (Card card : hand) {
            total += card.getValue();
        }

        if (total > 21) {
            for (Card card : hand) {
                if (card.getValue() == 11 && card.getId() == 1) {
                    card.setValue(1);
                    total -= 10;
                    if (total <= 21) {
                        break;
                    }
                }
            }
        }

        return total;
    }

    public List<Card> getHand() {
        return hand;
    }
}

