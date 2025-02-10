import java.util.ArrayList;
import java.util.Random;


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

        setShips();
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
            gameBoard[col][row] = gameBoard[col][row].toUpperCase();

            for(Ship boat : ships)
            {
                if(gameBoard[col][row].equals(boat.getSymbol().toUpperCase()))
                {
                    updateSunk(boat);
                    break;
                }
            }
        }
        else
        {
            System.out.println("Miss!");
            playerBoard[col][row] = "O";
            gameBoard[col][row] = "O";
        }

        ammo--;
    }

    public void setShips()
    {
        Ship carrier = new Ship("Carrier", "c", 5);
        ships.add(carrier);
        Ship bship = new Ship("Battleship", "b", 4);
        ships.add(bship);
        Ship destroyer = new Ship("Destroyer", "d", 3);
        ships.add(destroyer);
        Ship sub = new Ship("Submarine", "s", 3);
        ships.add(sub);
        Ship patrol = new Ship("Patrol Boat", "p", 2);
        ships.add(patrol);

        Random rand = new Random();

        for(Ship boat : ships)
        {
            while(true)
            {
                int posX = rand.nextInt(10);
                int posY = rand.nextInt(10);
            
                while(!(gameBoard[posY][posX].equals(" ")))
                {
                    posX = rand.nextInt(10);
                    posY = rand.nextInt(10);
                }

                // 0 = Down, 1 = Up, 2 = Right, 3 = Left
                int orient = rand.nextInt(4);

                boolean ver = true;

                if (orient == 0) 
                {
                    if(posY + boat.getLength() > gameBoard.length)
                    {
                        ver = false;
                    }
                    else
                    {
                        for(int i = 0; i < boat.getLength(); i++)
                        {
                            if(!(gameBoard[posY + i][posX].equals(" ")))
                            {
                                ver = false;
                            }
                        }
                    }

                    if(ver)
                    {
                        for(int i = posY; i < boat.getLength() + posY; i++)
                        {
                            gameBoard[i][posX] = boat.getSymbol();
                        }

                        boat.setX(posX);
                        boat.setY(posY);
                        boat.setOrientation(orient);
                        break;
                    }
                }
                else if(orient == 1)
                {
                    if(posY - boat.getLength() < 0)
                    {
                        ver = false;
                    }
                    else
                    {
                        for(int i = 0; i < boat.getLength(); i++)
                        {
                            if(!(gameBoard[posY - i][posX].equals(" ")))
                            {
                                ver = false;
                            }
                        }
                    }

                    if(ver)
                    {
                        for(int i = posY; i > posY - boat.getLength(); i--)
                        {
                            gameBoard[i][posX] = boat.getSymbol();
                        }

                        boat.setX(posX);
                        boat.setY(posY);
                        boat.setOrientation(orient);
                        break;
                    }
                }
                else if(orient == 2)
                {
                    if(posX + boat.getLength() > gameBoard[0].length)
                    {
                        ver = false;
                    }
                    else
                    {
                        for(int i = 0; i < boat.getLength(); i++)
                        {
                            if(!(gameBoard[posY][posX + i].equals(" ")))
                            {
                                ver = false;
                            }
                        }
                    }

                    if(ver)
                    {
                        for(int i = posX; i < boat.getLength() + posX; i++)
                        {
                            gameBoard[posY][i] = boat.getSymbol();
                        }

                        boat.setX(posX);
                        boat.setY(posY);
                        boat.setOrientation(orient);
                        break;
                    }
                }
                else 
                {
                    if(posX - boat.getLength() < 0)
                    {
                        ver = false;
                    }
                    else
                    {
                        for(int i = 0; i < boat.getLength(); i++)
                        {
                            if(!(gameBoard[posY][posX - i].equals(" ")))
                            {
                                ver = false;
                            }
                        }
                    }

                    if(ver)
                    {
                        for(int i = posX; i > posX - boat.getLength(); i--)
                        {
                            gameBoard[posY][i] = boat.getSymbol();
                        }

                        boat.setX(posX);
                        boat.setY(posY);
                        boat.setOrientation(orient);
                        break;
                    }
                }
            }
        }
    }

    public void updateSunk(Ship boat)
    {
        String seg = "";
        if(boat.getOrientation() == 0)
        {
            for(int row = boat.getY(); row < boat.getLength() + boat.getY(); row++)
            {
                seg = seg + gameBoard[row][boat.getX()];
            }
            
            if(seg.toUpperCase().equals(seg))
            {
                boat.setSunk(true);

                System.out.println("You've sunk the " + boat.getName() + "!");
            }
        }
        else if(boat.getOrientation() == 1)
        {
            for(int row = boat.getY(); row > boat.getLength() - boat.getY(); row--)
            {
                seg = seg + gameBoard[row][boat.getX()];
            }
            
            if(seg.toUpperCase().equals(seg))
            {
                boat.setSunk(true);

                System.out.println("You've sunk the " + boat.getName() + "!");
            }
        }
        else if(boat.getOrientation() == 2)
        {
            for(int col = boat.getX(); col < boat.getLength() + boat.getX(); col++)
            {
                seg = seg + gameBoard[boat.getY()][col];
            }
            
            if(seg.toUpperCase().equals(seg))
            {
                boat.setSunk(true);

                System.out.println("You've sunk the " + boat.getName() + "!");
            }
        }
        else 
        {
            for(int col = boat.getX(); col > boat.getLength() - boat.getX(); col--)
            {
                seg = seg + gameBoard[boat.getY()][col];
            }
            
            if(seg.toUpperCase().equals(seg))
            {
                boat.setSunk(true);

                System.out.println("You've sunk the " + boat.getName() + "!");
            }
        }
    }

    public boolean checkWin()
    {
        boolean condition = true;

        for(Ship boat : ships)
        {
            if(boat.getSunk() == false)
            {
                condition = false;
                break;
            }
        }

        return condition;
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