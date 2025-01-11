import java.util.Random;

public class Deck_old {
    Card[] deck = new Card[52];

    public Deck_old() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                var card = new Card(j + 1, i + 1);
                deck[i * 13 + j] = card;
            }
        }
    }

    public void shuffle() {
        Random rand = new Random();
        for (int i = 0; i < deck.length; i++) {
            int randomIndexToSwap = rand.nextInt(deck.length);
            Card temp = deck[randomIndexToSwap];
            deck[randomIndexToSwap] = deck[i];
            deck[i] = temp;
        }
    }

    public void printInfo() {
        for (Card card : deck) {
            System.out.println(card.Info());
        }
        System.out.println("Total size: " + deck.length);
    }

    public void printPlayerDeck(int player) {
        boolean hasCards = false;
        for (Card card : deck) {
            if (card.Player == player) {
                System.out.println(card.Info());
                hasCards = true;
            }
        }
        if (!hasCards) {
            System.out.println("Player " + player + " has no cards.");
        }
    }

    public void giveNextAvailable(int player) {
        for (Card card : deck) {
            if (card.Player == -1) {
                card.Player = player;
                break;
            }
        }
    }

    public int Length() {
        return deck.length;
    }
}
