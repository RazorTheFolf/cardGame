import java.util.InputMismatchException;
import java.util.Scanner;

public class _old {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deck_old deck = new Deck_old();
        boolean exit = false;
        int choice;

        while (!exit) {
            printMenu();
            System.out.print("Choose an option: ");

            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice. Please enter a number between 0 and 4.");
                scanner.next();
                continue;
            }

            switch (choice) {
                case 0:
                    printMenu();
                    break;
                case 1:
                    deck.printInfo();
                    break;
                case 2:
                    deck.shuffle();
                    System.out.println("Deck shuffled.");
                    break;
                case 3:
                    System.out.println("Deck length: " + deck.Length());
                    break;
                case 4:
                    System.out.println("Enter the player you want the first available card to be given (int): ");
                    int playerToGive = scanner.nextInt();
                    deck.giveNextAvailable(playerToGive);
                    System.out.println("The first available card is given to player " + playerToGive);
                    break;
                case 5:
                    System.out.println("Enter the player you want the first available card to be given (int): ");
                    int playerToPrintDeck = scanner.nextInt();
                    deck.printPlayerDeck(playerToPrintDeck);
                    break;
                case 6:
                    System.out.println("Goodbye !");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 0 and 4.");
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("Menu:");
        System.out.println("0. Display this menu");
        System.out.println("1. Print deck information");
        System.out.println("2. Shuffle deck");
        System.out.println("3. Print deck length");
        System.out.println("4. Give a card from the deck to a player");
        System.out.println("5. Print a specific player deck");
        System.out.println("6. Exit");
    }
}