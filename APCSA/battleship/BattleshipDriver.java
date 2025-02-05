import java.util.Scanner;

public class BattleshipDriver {
    public static void main(String[] args) {
        Battleship game = new Battleship(10);

        game.printWelcome();
        // game.printBoard(false);

        game.setShip();
        game.printBoard(false);
        Scanner input = new Scanner(System.in);
        System.out.println("Enter coordinates:");
        String coordinates = input.nextLine();

        game.fire(coordinates);
        game.printBoard(false);
    }
}
