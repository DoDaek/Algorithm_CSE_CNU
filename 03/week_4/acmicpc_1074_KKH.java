import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {//1074 Z
    private StringTokenizer _st;
    private BufferedReader _br;
    private int nowPointNumber;

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

    private int doTimes() {
        int numberOfRad = this.nextInt();
        int row = this.nextInt();
        int col = this.nextInt();
        numberOfRad = (int) Math.pow(2, numberOfRad);
        return this.fillTheSpace(new Point(0, 0), new Point(numberOfRad - 1, numberOfRad - 1), row, col);
    }

    private int fillTheSpace(Point leftPoint, Point rightPoint, int row, int col) {
        if ((leftPoint.x == rightPoint.x && leftPoint.y == rightPoint.y)) {
            if (leftPoint.x == row && leftPoint.y == col) {
                return this.nowPointNumber;//해당 위치일 경우 filed변수로 return
            }
            return -1; //해당 위치가 아닌 경우 예외 처리
        }
        int temp = -1;
        int changeRow = (rightPoint.x + leftPoint.x) / 2;
        int changeCol = (rightPoint.y + leftPoint.y) / 2;
        if (leftPoint.x <= row && row <= changeRow && leftPoint.y <= col && col <= changeCol) {
            temp = this.fillTheSpace(leftPoint, new Point(changeRow, changeCol), row, col);
        } else {
            this.nowPointNumber += Math.pow(changeRow - leftPoint.x + 1, 2);
        }

        changeRow = leftPoint.x;//row의 왼쪽 꼭지점
        changeCol = (leftPoint.y + rightPoint.y) / 2 + 1;//col의 왼쪽 꼭지점
        int otherRow = (leftPoint.x + rightPoint.x) / 2;//row의 오른쪽 아래 꼭지점
        int otherCol = rightPoint.y;//col의 오른쪽 아래 꼭지점
        if (changeRow <= row && row <= otherRow && changeCol <= col && col <= otherCol && temp < 0) {
            temp = this.fillTheSpace(new Point(changeRow, changeCol), new Point(otherRow, otherCol), row, col);
        } else {
            this.nowPointNumber += Math.pow(otherRow - changeRow + 1, 2);
        }

        changeRow = (rightPoint.x + leftPoint.x) / 2 + 1;
        changeCol = leftPoint.y;
        otherRow = rightPoint.x;
        otherCol = (rightPoint.y + leftPoint.y) / 2;
        if (changeRow <= row && row <= otherRow && changeCol <= col && col <= otherCol && temp < 0) {
            temp = this.fillTheSpace(new Point(changeRow, changeCol), new Point(otherRow, otherCol), row, col);
        } else {
            this.nowPointNumber += Math.pow(otherRow - changeRow + 1, 2);
        }

        changeRow = (rightPoint.x + leftPoint.x) / 2 + 1;
        changeCol = (leftPoint.y + rightPoint.y) / 2 + 1;
        otherRow = rightPoint.x;
        otherCol = rightPoint.y;
        if (changeRow <= row && row <= otherRow && changeCol <= col && col <= otherCol && temp < 0) {
            temp = this.fillTheSpace(new Point(changeRow, changeCol), rightPoint, row, col);
        } else {
            this.nowPointNumber += Math.pow(otherRow - changeRow + 1, 2);
        }
        return temp;
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.solve();
    }
}