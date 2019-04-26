import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {//1063 king
    private StringTokenizer _st;
    private BufferedReader _br;

    private String readLine() {
        try {
            return this._br.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    private String next() {
        while (!this._st.hasMoreTokens()) {
            this._st = new StringTokenizer(this.readLine());
        }
        return this._st.nextToken();
    }

    private int nextInt() {
        return Integer.parseInt(this.next());
    }

    private void init() {
        this._st = new StringTokenizer("");
        this._br = new BufferedReader(new InputStreamReader(System.in));
    }

    private void solve() {
        this.init();
        StringBuilder sb = new StringBuilder();
        sb.append(this.doTimes());
        System.out.println(sb.toString());
    }

    private String doTimes() {
        String kingPoint = this.next();
        char[] kingPointChar = kingPoint.toCharArray();
        String stonePoint = this.next();
        char[] stonePointChar = stonePoint.toCharArray();
        int numberOfChangeSpace = this.nextInt();

        for (int indexOfInputChangeSpace = 0; indexOfInputChangeSpace < numberOfChangeSpace; ++indexOfInputChangeSpace) {
            char[] tempKingPointChar = kingPointChar.clone();
            char[] tempStonePointChar = stonePointChar.clone();
            String inputData = this.next();
            Point changePointOfKing = this.changePoint(kingPointChar[0] - 0x41, kingPointChar[1] - 0x31, inputData);
            kingPointChar[0] = (char) (changePointOfKing.getY() + 0x41);
            kingPointChar[1] = (char) (changePointOfKing.getX() + 0x31);

            if (stonePointChar[0] == kingPointChar[0] && stonePointChar[1] == kingPointChar[1]) {
                Point changePointOfStone = this.changePoint(stonePointChar[0] - 0x41, stonePointChar[1] - 0x31, inputData);
                stonePointChar[0] = (char) (changePointOfStone.getY() + 0x41);
                stonePointChar[1] = (char) (changePointOfStone.getX() + 0x31);
                if (tempStonePointChar[0] == stonePointChar[0] && tempStonePointChar[1] == stonePointChar[1]) {
                    kingPointChar = tempKingPointChar;
                    stonePointChar = tempStonePointChar;
                }
            }//stone위치 변환
        }
        return new String(kingPointChar) + "\n" + new String(stonePointChar);
    }

    private Point changePoint(int nowCol, int nowRow, String inputData) {
        int changeRow;
        int changeCol;
        if ("R".equals(inputData)) {
            changeRow = nowRow;
            changeCol = nowCol + 1;
        } else if ("L".equals(inputData)) {
            changeRow = nowRow;
            changeCol = nowCol - 1;
        } else if ("B".equals(inputData)) {
            changeRow = nowRow - 1;
            changeCol = nowCol;
        } else if ("T".equals(inputData)) {
            changeRow = nowRow + 1;
            changeCol = nowCol;
        } else if ("RT".equals(inputData)) {
            changeRow = nowRow + 1;
            changeCol = nowCol + 1;
        } else if ("LT".equals(inputData)) {
            changeRow = nowRow + 1;
            changeCol = nowCol - 1;
        } else if ("RB".equals(inputData)) {
            changeRow = nowRow - 1;
            changeCol = nowCol + 1;
        } else {
            changeRow = nowRow - 1;
            changeCol = nowCol - 1;
        }
        if (0 <= changeRow && changeRow < 8 && 0 <= changeCol && changeCol < 8) {
            return new Point(changeRow, changeCol);
        }
        return new Point(nowRow, nowCol);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.solve();
    }
}