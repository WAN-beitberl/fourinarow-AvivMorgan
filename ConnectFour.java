import java.util.*;

public class ConnectFour {
    private String board[][];
    private int emptyHeadIndex[];
    private Player player1;
    private Player player2;

    public ConnectFour(Player player1, Player player2) {
        this.board = new String[6][7];
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 7; j++)
                this.board[i][j] = "-";
        }
        this.emptyHeadIndex= new int[7];
        for(int i = 0; i < 7; i++)
            this.emptyHeadIndex[i] = 5;
        this.player1 = player1;
        this.player2 = player2;
    }

    public Boolean AddToken(int colIndex, Player p){
        if(this.emptyHeadIndex[colIndex - 1] < 6 && colIndex <=7 && colIndex >= 1){
            int row = this.emptyHeadIndex[colIndex - 1];
            this.board[row][colIndex - 1] = p.GetColor();
            this.emptyHeadIndex[colIndex - 1]--;
            PrintBoard();
            return CheckWin(this.emptyHeadIndex[colIndex - 1], colIndex - 1, p.GetColor());
        }
        return false;
    }

    public Boolean CheckWin(int row, int col, String wantedColor){
        if(CheckRow(row, col, wantedColor)){
            System.out.print("row check\n");
            return true;
        }
        if(CheckCol(row, col, wantedColor)){
            System.out.print("col check\n");
            return true;
        }
        if(CheckMainDiagonal(row, col, wantedColor)) {
            System.out.print("main diagonal check\n");
            return true;
        }
        if(CheckSeconderyDiagonal(row, col, wantedColor)){
            System.out.print("row check\n");
            return true;
        }
        return false;
    }

    private Boolean CheckRow(int row, int col, String wantedColor) {
        int count = 1;
        for (int i = 1; i < 4; i++){
            if((col + i) < 7 && row >= 0 && this.board[row][col + i] == wantedColor && this.board[row][col + i] != "-")
                count++;
            else
                break;
        }
        if(count == 4)
            return true;
        count = 1;
        for (int i = 1; i < 4; i++){
            if((col - i) >= 0 && row >= 0  && this.board[row][col - i] == wantedColor && this.board[row][col - i] != "-")
                count++;
            else
                break;
        }
        return (count == 4);
    }

    private Boolean CheckCol(int row, int col, String wantedColor) {
        int count = 1;
        for (int i = 0; i < 4; i++){
            if ((row + i) < 6 && row >= 0 && this.board[row + i][col] == wantedColor && this.board[row + i][col] != "-")
                count++;
            else
                break;
        }
        if(count == 4)
            return true;
        count = 1;
        for (int i = 0; i < 4; i++){
            if ((row - i) >= 0 && this.board[row - i][col] == wantedColor && this.board[row - i][col] != "-")
            count++;
            else
                break;
        }
        return (count == 4);
    }

    private Boolean CheckMainDiagonal(int row, int col, String wantedColor) {
        int count = 1;
        for (int i = 1; i < 4; i++){
            if((row + i) < 6 && (col + i) < 7 && this.board[row + i][col + i] == wantedColor && this.board[row + i][col + i] != "-")
                count++;
            else
                break;
        }
        if(count == 4)
            return true;
        count = 1;
        for (int i = 1; i < 4; i++){
            if((row - i) >= 0 && (col - i) >= 0 && this.board[row - i][col - i] == wantedColor && this.board[row - i][col - i] != "-")
                count++;
            else
                break;
        }
        return (count == 4);
    }

    private Boolean CheckSeconderyDiagonal(int row, int col, String wantedColor) {
        int count = 1;
        for (int i = 1; i < 4; i++){
            if((row + i) < 6 && (col - i) >= 0 && (this.board[row + i][col - i] == wantedColor) && (this.board[row + i][col - i] != "-"))
                count++;
            else
                break;
        }
        if(count == 4)
            return true;
        count = 1;
        for(int i = 1; i < 4; i++){
            if((row - i) >= 0 && (col + i) < 7 && (this.board[row - i][col + i] == wantedColor) && (this.board[row - i][col + i] != "-"))
                count++;
            else
                break;
        }
        return (count == 4);
    }

    public void PrintBoard() {
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 7; j++)
                System.out.print(this.board[i][j] + " ");
            System.out.print("\n");
        }
        for (int i = 1; i <= 7; i++)
            System.out.print(i + " ");
        System.out.print("\n");
    }
}
