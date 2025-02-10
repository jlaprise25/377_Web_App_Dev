import java.util.Scanner;

public class BattleshipDriver {
    public static void main(String[] args) {
        while(true)
        {
            Battleship game = new Battleship(50);
            game.printWelcome();
    
            Scanner input = new Scanner(System.in);
    
            while(true)
            {
                game.printBoard(true);
                game.printBoard(false);
                System.out.println("Enter coordinates:");
                String coordinates = input.nextLine();
    
                // if(coordinates.equals("break"))
                // {
                //     break;
                // }
    
                game.fire(coordinates);
    
                if(game.checkWin())
                {
                    System.out.println("You Win!");
                    break;
                }
                else if(game.getAmmo() == 0)
                {
                    System.out.println("You ran out of ammo.");
                    break;
                }
            }

            System.out.println("Would you like to play again? Y/N");
            String replay = input.nextLine();

            if(replay.toUpperCase().equals("N"))
            {
                break;
            }
        }
    }
}
