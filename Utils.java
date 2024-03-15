package Project.Puzzle_15;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {
    private static final Scanner scanNum=new Scanner(System.in);
    private static final Scanner scanStr=new Scanner(System.in);
    private static List<Puz> list=new ArrayList<>();
    private static Puz[][] puzzles={
            {new Puz("1\uFE0F⃣",1),new Puz("2\uFE0F⃣",2),new Puz("1\uFE0F⃣",3),new Puz("2\uFE0F⃣",4)},
            {new Puz("5\uFE0F⃣",5),new Puz("6\uFE0F⃣",6),new Puz("7\uFE0F⃣",7),new Puz("8\uFE0F⃣",8)},
            {new Puz("9\uFE0F⃣",9),new Puz("\uD83D\uDD1F",10),new Puz("11",11),new Puz("12",12)},
            {new Puz("13",13),new Puz("14",14),new Puz("15",15),new Puz("   ",16)}
    };
    private static final Puz[][] test={
            {new Puz("1\uFE0F⃣",1),new Puz("2\uFE0F⃣",2),new Puz("1\uFE0F⃣",3),new Puz("2\uFE0F⃣",4)},
            {new Puz("5\uFE0F⃣",5),new Puz("6\uFE0F⃣",6),new Puz("7\uFE0F⃣",7),new Puz("8\uFE0F⃣",8)},
            {new Puz("9\uFE0F⃣",9),new Puz("\uD83D\uDD1F",10),new Puz("11",11),new Puz("12",12)},
            {new Puz("13",13),new Puz("14",14),new Puz("15",15),new Puz("   ",16)}
    };
    public void HomePack(){
        int n;
        while (!isWin()){
            showPuzzle();
            n=getInt("choose -> ");
            if (n==7007){
                puzzles=test;
                System.out.println("you win");
            } else if (n > 0 && n < 15) {
                shift(n);
            }
        }
    }

    private void showPuzzle() {
        for (Puz[] puzzle : puzzles) {
            for (Puz puz : puzzle) {
                System.out.print(puz + "    ");
            }
            System.out.println();
        }
    }

    private void shift(int toWalk){
        int colm;
        int row;
        int[] colmRow = colmRow(toWalk);
        row=colmRow[0];
        colm=colmRow[1];

        if (colm!=0 && puzzles[row][colm-1].getBack()==16){
            swap(puzzles[row][colm-1],puzzles[row][colm]);
        } else if (colm != 3 && puzzles[row][colm+1].getBack()==16) {
            swap(puzzles[row][colm+1],puzzles[row][colm]);
        }

    }

    private void swap(Puz puz1, Puz puz2) {
        Puz puz;
        puz=puz1;
        puz1=puz2;
        puz2=puz;
    }

    private static int[] colmRow(int toWalk) {
        int row;
        int colm;
        for (int i = 0; i < puzzles.length; i++) {
            for (int j = 0; j < puzzles[i].length; j++) {
                if (puzzles[i][j].getBack()== toWalk){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }

    private boolean isWin(){
        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < test[i].length; j++) {
                if (!test[i][j].equals(puzzles[i][j])){
                    return false;
                }
            }
        }
        return true;
    }
    private static int getInt(String massage){
        System.out.print(massage);
        return scanNum.nextInt();
    }
}
