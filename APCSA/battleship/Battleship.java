import java.lang.reflect.Array;
import java.util.ArrayList;

public class Battleship {
    private int ammo;
    private String[][] gameBoard;
    private String[][] playerBoard;
    private ArrayList<Ship> ships;

    private static final int boardSize = 10;

    public Battleship(int startAmmo){
        ammo = startAmmo;

        ships = new ArrayList<Ship>();
        playerBoard = new String[boardSize][boardSize];
        gameBoard = new String[boardSize][boardSize];

        for(int row = 0; row < boardSize; row++)
        {
            for(int col = 0; col < boardSize; col++)
            {
                playerBoard[row][col] = " ";
            }
        }

        for(int row = 0; row < boardSize; row++)
        {
            for(int col = 0; col < boardSize; col++)
            {
                gameBoard[row][col] = " ";
            }
        }
    }

    public int getAmmo()
    {
        return ammo;
    }

    public void fire(String location)
    {
        String[] co = location.toUpperCase().split("[,]");

        int col = ((int) (co[0].charAt(0))) - 65;
        int row = Integer.parseInt(co[1]) - 1;

        // System.out.println(row + "," + col);

        if (gameBoard[col][row] != " ") {
            System.out.println("Hit!");
            playerBoard[col][row] = "X";
        }
        else
        {
            System.out.println("Miss!");
            playerBoard[col][row] = "O";
        }
    }

    public void setShip()
    {
        Ship boat = new Ship("a", 5, 0, 0);
        
        for(int i = boat.getY(); i < boat.getLength(); i++)
        {
            gameBoard[i][boat.getX()] = boat.getName();
        }

        ships.add(boat);
    }

    public void printBoard(boolean reveal)
    {
        if(reveal)
        {
            System.out.print("  ");
            for(int i = 0; i < 10; i++)
            {
                if(i != 10)
                {
                    System.out.print("| " + (i + 1) + " ");
                }
                else
                {
                    System.out.print("| " + (i + 1));
                }
                
            }
            System.out.println("|");
    
            for(int i = 0; i < 21; i++)
            {
                if(i % 2 == 0)
                {
                    System.out.println("--+---+---+---+---+---+---+---+---+---+---+");
                }
    
                if(i % 2 == 1)
                {
                    System.out.print((char)(i / 2 + 65) + " ");
                    
                    for(int j = 0; j < 10; j++)
                    {
                        System.out.print("| " + gameBoard[i/2][j] + " ");
                    }
                    System.err.println("|");
                }
            }
        }
        else
        {
            System.out.print("  ");
            for(int i = 0; i < 10; i++)
            {
                if(i != 10)
                {
                    System.out.print("| " + (i + 1) + " ");
                }
                else
                {
                    System.out.print("| " + (i + 1));
                }
                
            }
            System.out.println("|");
    
            for(int i = 0; i < 21; i++)
            {
                if(i % 2 == 0)
                {
                    System.out.println("--+---+---+---+---+---+---+---+---+---+---+");
                }
    
                if(i % 2 == 1)
                {
                    System.out.print((char)(i / 2 + 65) + " ");
                    
                    for(int j = 0; j < 10; j++)
                    {
                        System.out.print("| " + playerBoard[i/2][j] + " ");
                    }
                    System.err.println("|");
                }
            }
        }
        
    }

    public void printWelcome()
    {
        System.out.println("*************************\n* WELCOME TO BATTLESHIP *\n*************************");
        System.out.println();
        System.out.println("Five enemy ships are reported to be hidden in the water, ");
        System.out.println("the carrier, battleship, destroyer, submarine, and the patrol.");
        System.out.println("You must find and sink them all to save the day!");
        System.out.println("Fire wisely, you only have 50 torpedos in your hold.");
        System.out.println();
        System.out.println("Enter coordinates as: letter,number");
        System.out.println("For example, the top-left square is A,1");
        System.out.println();
        System.out.println("Good luck!");
        System.out.println();
    }
}