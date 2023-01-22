import java.util.*;

public class main {
    public static void main(String args[]) {
        boolean isWin;
        Boolean isP1Turn = true;
        Player p1 = new Player("R");
        Player p2 = new Player("Y");
        Scanner sc= new Scanner(System.in);
        ConnectFour game = new ConnectFour(p1, p2);
        game.PrintBoard();
        while(true){
            System.out.print("Enter column to push your tocken:");
            int a = sc.nextInt();
            if(isP1Turn) {
                isWin = game.AddToken(a, p1);
                isP1Turn = false;
                if(isWin){
                    System.out.print("Player1 has won!");
                    p1.AddWin();
                    break;
                }
            }

            else{
                isWin = game.AddToken(a, p2);
                isP1Turn = true;
                if(isWin){
                    System.out.print("Player2 has won!");
                    p2.AddWin();
                    break;
                }
            }
        }
    }
}