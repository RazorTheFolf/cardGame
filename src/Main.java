import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Deck gameDeck = new Deck();
    static int playerCount = 0;
    static List<Player> playerList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Bienvenue dans le magnifique jeu de BlackJack !");
        SetPlayers();

        System.out.print("\nÊtes-vous prêts à jouer ?\nIndiquez votre choix (oui ou non) : ");
        String choice = scanner.next();

        if (choice.equals("oui") || choice.equals("o")) {
            StartGame();
        } else if (choice.equals("non") || choice.equals("n")) {
            SetPlayers();
        } else {
            System.out.println("Je prend cela comme un non, alors...");
        }
    }

    private static void SetPlayers() {
        playerCount = 0;
        playerList.clear();

        System.out.print("Pourquoi ne pas commencer par savoir combien vous êtes ?\nEntrez le nombre de joueurs : ");
        while (playerCount == 0) {
            try {
                playerCount = scanner.nextInt();
            } catch (InputMismatchException exception) {
                System.out.print("Veuillez entrer une réponse valide!\nEntrez le nombre de joueurs : ");
                scanner.next();
            }
        }

        for (int i = 0; playerCount > i; i++) {
            System.out.printf("\nVeuillez entrez le nom du joueur %d : ", i + 1);
            playerList.add(new Player(i + 1, scanner.next()));
        }
        playerList.add(new Player(0, "Croupier"));
    }

    private static void StartGame() {
        for (int i = 0; i < 2; i++) {
            for (Player player : playerList) {
                gameDeck.drawCard(player);
            }
        }

        System.out.println("\nLes cartes on été distribué !");
        System.out.printf("Le %s montre l'une de ses cartes :\n", playerList.getLast().getName());
        System.out.println(playerList.getLast().getHand().getFirst().getName());

        for (Player player : playerList) {
            if (player.getID() == 0) {
                break;
            }
            System.out.printf("\n%s, voici vos cartes :\n", player.getName());
            for (Card card : player.getHand()) {
                System.out.println(card.getName());
            }
            GetPlayerChoice(player);
        }
    }

    private static void GetPlayerChoice(Player player) {
        String choice;

        while (player.getHandTotalValue() <= 21) {
            System.out.printf("\n%s, souhaitez-vous piocher une carte supplémentaire ?\nIndiquez votre choix (oui ou non) : ", player.getName());
            choice = scanner.next();

            if (choice.equalsIgnoreCase("oui") || choice.equalsIgnoreCase("o")) {
                gameDeck.drawCard(player);
                System.out.println("Vous avez pioché : " + player.getHand().getLast().getName());
            } else if (choice.equalsIgnoreCase("non") || choice.equalsIgnoreCase("n")) {
                break;
            } else {
                System.out.println("Choix invalide !");
            }
        }

        if (player.getHandTotalValue() > 21) {
            player.isOut = true;
            System.out.printf("%s à perdu !\n", player.getName());
        }
    }
}