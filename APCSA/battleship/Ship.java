public class Ship {
    private String name;
    private String symbol;
    private int orientaion;
    private int length;
    private int xCord;
    private int yCord;
    private boolean sunk;

    public Ship(String name, String symbol, int length)
    {
        this.name = name;
        this.symbol = symbol;
        this.length = length;
        sunk = false;
    }

    public Ship(String name, String symbol, int orientation, int length, int x, int y)
    {
        this.name = name;
        this.symbol = symbol;
        this.orientaion = orientation;
        this.length = length;
        xCord = x;
        yCord = y;
        sunk = false;
    }

    public String getName()
    {
        return name;
    }

    public String getSymbol()
    {
        return symbol;
    }

    public int getOrientation()
    {
        return orientaion;
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

    public boolean getSunk()
    {
        return sunk;
    }

    public void setOrientation(int orientation)
    {
        this.orientaion = orientation;
    }

    public void setX(int x)
    {
        xCord = x;
    }

    public void setY(int y)
    {
        yCord = y;
    }

    public void setSunk(boolean sunk)
    {
        this.sunk = sunk;
    }
}