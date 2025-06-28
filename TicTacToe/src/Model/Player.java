package Model;

public class Player {
    public String name;
    public PeiceType p;
    public Player(String name1, PeiceType p2)
    {
        this.name=name1;
        this.p=p2;
    }
    public String getName()
    {
        return this.name;
    }
    public PeiceType getPeiceType()
    {
        return this.p;
    }
}
