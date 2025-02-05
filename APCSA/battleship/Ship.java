public class Ship {
    private String name;
    private int length;
    private int xCord;
    private int yCord;
    private boolean sunk;

    public Ship(String name, int length)
    {
        this.name = name;
        this.length = length;
        sunk = false;
    }

    public Ship(String name, int length, int x, int y)
    {
        this.name = name;
        this.length = length;
        xCord = x;
        yCord = y;
        sunk = false;
    }

    public String getName()
    {
        return name;
    }

    public int getLength()
    {
        return length;
    }

    public int getX()
    {
        return xCord;
    }

    public int getY()
    {
        return yCord;
    }

    public void setX(int x)
    {
        xCord = x;
    }

    public void setY(int y)
    {
        yCord = y;
    }
}