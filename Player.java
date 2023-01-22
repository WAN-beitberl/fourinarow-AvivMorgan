import java.util.*;

public class Player {
    private String TokenColor;
    private int score;

    public Player(String color){
        this.TokenColor = color;
        this.score = 0;
    }

    public String GetColor() {
        return this.TokenColor;
    }

    public void AddWin() {
        this.score++;
    }
}
