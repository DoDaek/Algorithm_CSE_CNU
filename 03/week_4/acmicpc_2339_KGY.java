import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int size = scanner.nextInt();
    static int[][] slate = new int[size][size];
    static List<Dirty> dirtyList = new ArrayList<>();

    public static void main(String[] args) {

        // input slate
        for (int i=0; i<size; i++) { // 행
            for (int j=0; j<size; j++) { //열
                slate[i][j] = scanner.nextInt();

                if (slate[i][j] == 1) {
                    dirtyList.add(new Dirty(i, j));
                }
            }
        }

        int total = cutSlate(0, size-1, 0, size-1);
        if (total == 0) {
            total = -1;
        }

        System.out.println(total);
    }

    public static int cutSlate(int startY, int endY, int startX, int endX) {
        int horizontalCutting = cutHorizontally(startY, endY, startX, endX);
        int verticalCutting   = cutVertically(startY, endY, startX, endX);

        return horizontalCutting + verticalCutting;
    }

    public static int cutHorizontally(int startY, int endY, int startX, int endX) {
        int horizontalCutting = 0;

        if (isEmptySlate(startY, endY, startX, endX)) {
            return 1;
        }

        if (hasNoDiamond(startY, endY, startX, endX)) {
            return 0;
        }

        if (completeCutting(startY, endY, startX, endX)) {
            return 1;
        }

        List<Dirty> dirties = getDirtyList(startY, endY, startX, endX);
        for (Dirty dirtyItem : dirties) {
            if (!canCutHorizontally(startY, endY, startX, endX, dirtyItem)) {
                continue;
            }

            int slate_1 = cutVertically(startY, dirtyItem.row-1, startX, endX);
            int slate_2 = cutVertically(dirtyItem.row+1, endY, startX, endX);
            horizontalCutting += slate_1 * slate_2;
        }


        return horizontalCutting;
    }

    public static int cutVertically(int startY, int endY, int startX, int endX) {
        int verticalCutting = 0;

        if (isEmptySlate(startY, endY, startX, endX)) {
            return 1;
        }

        if (hasNoDiamond(startY, endY, startX, endX)) {
            return 0;
        }

        if (completeCutting(startY, endY, startX, endX)) {
            return 1;
        }

        List<Dirty> dirties = getDirtyList(startY, endY, startX, endX);
        for (Dirty dirtyItem : dirties) {
            if (!canCutVertically(startY, endY, startX, endX, dirtyItem)) {
                continue;
            }

            int slate_1 = cutHorizontally(startY, endY, startX, dirtyItem.col-1);
            int slate_2 = cutHorizontally(startY, endY, dirtyItem.col+1, endX);
            verticalCutting += slate_1 * slate_2;
        }

        return verticalCutting;
    }

    private static boolean isEmptySlate(int startY, int endY, int startX, int endX) {
        return (startX > endX) || (startY > endY);
    }

    public static boolean hasNoDiamond(int startY, int endY, int startX, int endX) {
        int diamond = 0;

        for (int i=startY; i<=endY; i++) {
            for (int j=startX; j<=endX; j++) {
                if (slate[i][j] == 2) {
                    diamond++;
                }
            }
        }

        return (diamond == 0);
    }

    public static boolean completeCutting(int startY, int endY, int startX, int endX) {
        int numOfDirty   = 0;
        int numOfDiamond = 0;

        for (int i=startY; i<=endY; i++) {
            for (int j=startX; j<=endX; j++) {
                if (slate[i][j] == 1) {
                    numOfDirty++;
                }
                else if (slate[i][j] == 2) {
                    numOfDiamond++;
                }
            }
        }

        return (numOfDirty == 0 && numOfDiamond == 1);
    }

    public static List<Dirty> getDirtyList(int startY, int endY, int startX, int endX) {
        List<Dirty> list = new ArrayList<>();

        for (Dirty dirtyItem : dirtyList) {
            if (dirtyItem.row >= startY && dirtyItem.row <= endY
             && dirtyItem.col >= startX && dirtyItem.col <= endX) {
                list.add(dirtyItem);
            }
        }

        return list;
    }

    public static boolean canCutHorizontally(int startY, int endY, int startX, int endX, Dirty dirty) {
        for (int i=startX; i<=endX; i++) {
            if (slate[dirty.row][i] == 2) {
                return false;
            }
        }

        return true;
    }

    public static boolean canCutVertically(int startY, int endY, int startX, int endX, Dirty dirty) {
        for (int i=startY; i<=endY; i++) {
            if (slate[i][dirty.col] == 2) {
                return false;
            }
        }

        return true;
    }

    static class Dirty {
        int row;
        int col;

        public Dirty(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
