import java.util.*;

public class BackJoon1946 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int[] testCase = new int[ sc.nextInt()];

        for (int testCaseIndex = 0; testCaseIndex < testCase.length; testCaseIndex++) {
            int employeeNumber = sc.nextInt();
            int[] scoreList = new int[employeeNumber+1];
            for (int scoreIndex = 0; scoreIndex < employeeNumber; scoreIndex++) {
                scoreList[sc.nextInt()] = sc.nextInt();
            }
            int min=scoreList[1], number = 1;
            for (int index = 2; index < scoreList.length; index++) {
                if (min > scoreList[index]){
                    min = scoreList[index];
                    number++;
                }
            }
            testCase[testCaseIndex] = number;
        }
        for (int testCaseIndex = 0; testCaseIndex < testCase.length; testCaseIndex++) {
            System.out.println(testCase[testCaseIndex]);
        }
    }
}
