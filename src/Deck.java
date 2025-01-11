import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    private final List<Card> deck = new ArrayList<>(52);

    public Deck() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                var card = new Card(j + 1, j + 1, i + 1);
                deck.add(card);
            }
        }
        shuffle();
    }

    public void shuffle() {
        Random rand = new Random();
        for (int i = 0; i < deck.size(); i++) {
            int randomIndexToSwap = rand.nextInt(deck.size());
            Card temp = deck.get(randomIndexToSwap);
            deck.set(randomIndexToSwap, deck.get(i));
            deck.set(i, temp);
        }
    }

    public void drawCard(Player player) {
        if (!deck.isEmpty()) {
            Card card = deck.removeFirst();
            player.addCardToDeck(card);
        } else {
            System.out.println("No more cards available in the deck.");
        }
    }

    public void printPlayerDeck(Player player) {
        if (player == null) {
           System.out.println("There is no player to print his deck");
        } else {
            List<Card> playerDeck = player.getHand();

            if (playerDeck.isEmpty()) {
                System.out.println("Player " + player + " has no cards.");
            }

            for (Card card : playerDeck) {
                System.out.println(card.getName());
            }
        }
    }

    public int getSize() {
        return deck.size();
    }
}
