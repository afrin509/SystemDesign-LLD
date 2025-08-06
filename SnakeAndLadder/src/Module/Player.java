package Module;

public class Player {
    public int playerId;
    public String name;
    public int score;
    public Player(int playerId, String name, int score)
    {
        this.playerId = playerId;
        this.name = name;
        this.score = score;
    }

    public String getName()
    {
        return this.name;
    }

    public int getScore()
    {
        return this.score;
    }

    public void setScore(int score)
    {
        this.score = score;
    }
}
