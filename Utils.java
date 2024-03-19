package Project.Puzzle_15;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class Utils {
    private final String url="D:/Project in java/Modullar/Lesson_4/src/Project/Puzzle_15>";
    private  final LocalDate date;
    private static final Scanner scanNum = new Scanner(System.in);
    private static final Scanner scanStr = new Scanner(System.in);
    private static List<Puz> list = new ArrayList<>();

    {
        for (Puz[] puz : test) {
            list.addAll(Arrays.asList(puz));
        }
        date= LocalDate.now();
    }

    private static   Puz[][] puzzles = {
            {new Puz("1", 1), new Puz("2", 2), new Puz("3", 3), new Puz("4", 4)},
            {new Puz("5", 5), new Puz("6", 6), new Puz("7", 7), new Puz("8", 8)},
            {new Puz("9", 9), new Puz("10", 10), new Puz("11", 11), new Puz("12", 12)},
            {new Puz("13", 13), new Puz("14", 14), new Puz("15", 15), new Puz("   ", 16)}
    };
    /*private static Puz[][] puzzles = {
            {new Puz("1\uFE0F⃣", 1), new Puz("2\uFE0F⃣", 2), new Puz("3\uFE0F⃣", 3), new Puz("4\uFE0F⃣", 4)},
            {new Puz("5\uFE0F⃣", 5), new Puz("6\uFE0F⃣", 6), new Puz("7\uFE0F⃣", 7), new Puz("8\uFE0F⃣", 8)},
            {new Puz("9\uFE0F⃣", 9), new Puz("\uD83D\uDD1F", 10), new Puz("11", 11), new Puz("12", 12)},
            {new Puz("13", 13), new Puz("14", 14), new Puz("15", 15), new Puz("   ", 16)}
    };*/
    private static final Puz[][] test = {
            {new Puz("1\uFE0F⃣", 1), new Puz("2\uFE0F⃣", 2), new Puz("3\uFE0F⃣", 3), new Puz("4\uFE0F⃣", 4)},
            {new Puz("5\uFE0F⃣", 5), new Puz("6\uFE0F⃣", 6), new Puz("7\uFE0F⃣", 7), new Puz("8\uFE0F⃣", 8)},
            {new Puz("9\uFE0F⃣", 9), new Puz("\uD83D\uDD1F", 10), new Puz("11", 11), new Puz("12", 12)},
            {new Puz("13", 13), new Puz("14", 14), new Puz("15", 15), new Puz("   ", 16)}
    };

    public void HomePack() {
        String str;
        int n;
        int count = 0;
        restart();
        while (!isWin()) {
            showPuzzle();
            str = getStr();
            if (str.equals("//end")) {
                puzzles = test;
                System.out.println("you win");
            } else if (str.equals("//res")) {
                restart();
                count = 0;
            } else if (Integer.parseInt(str) > 0 && Integer.parseInt(str) < 16) {
                n = Integer.parseInt(str);
                shift(n);
            }
        }
        registration();
    }

    private void registration() {
    }

    private void restart() {
        int count = 0;
        Collections.shuffle(list);
        for (int i = 0; i < puzzles.length; i++) {
            for (int j = 0; j < puzzles[i].length; j++) {
                puzzles[i][j] = list.get(count++);
            }
        }
    }

    private void showPuzzle() {
        for (int i = 0; i < puzzles.length; i++) {
            for (int j = 0; j < puzzles[i].length; j++) {
                System.out.print(puzzles[i][j]+"  ");
            }
            System.out.println();
        }
    }

    private void shift(int toWalk) {
        int colm;
        int row;
        int[] colmRow = colmRow(toWalk);
        row = colmRow[0];//1
        colm = colmRow[1];//0

        if (colm != 0 && puzzles[row][colm - 1].getBack() == 16) {
            swap(row, colm - 1, row, colm);
        } else if (colm != 3 && puzzles[row][colm + 1].getBack() == 16) {
            swap(row, colm + 1, row, colm);
        } else if (row != 0 && puzzles[row - 1][colm].getBack() == 16) {
            swap(row-1, colm , row, colm);
        } else if (row != 3 && puzzles[row + 1][colm].getBack() == 16) {
            swap(row+1, colm, row, colm);
        }

    }

    private void swap(int row1, int colm1, int row2, int colm2) {
        Puz puz;
        puz = puzzles[row1][colm1];
        puzzles[row1][colm1] = puzzles[row2][colm2];
        puzzles[row2][colm2] = puz;
    }

    private  int[] colmRow(int toWalk) {
        for (int i = 0; i < puzzles.length; i++) {
            for (int j = 0; j < puzzles[i].length; j++) {
                if (puzzles[i][j].getBack() == toWalk) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    private boolean isWin() {
        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < test[i].length; j++) {
                if (!(test[i][j].getBack()==puzzles[i][j].getBack())) {
                    return false;
                }
            }
        }
        return true;
    }


    private static int getInt(String massage) {
        System.out.print(massage);
        return scanNum.nextInt();
    }

    private static String getStr() {
        System.out.print("choose -> ");
        return scanNum.nextLine();
    }
}
