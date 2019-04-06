import java.util.*;

public class BackJoon6549 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        List<Long> areaArray = new ArrayList<>();           // test case마다 Max Area 를 담기 위한 Long 타입 배열
        int N;

        do{
            N =sc.nextInt();                                // 직사각형의 개수!
            Stack<Rectangular> stack = new Stack<>();       // 스택
            long maxArea = 0, nextHeight;

            for (int i = 0; i < N; i++) {
                nextHeight = sc.nextInt();
                if (stack.isEmpty() || stack.peek().height <= nextHeight){
                    stack.add(new Rectangular(nextHeight,i));
                }

                else if(stack.peek().height > nextHeight){
                    Rectangular temp = null;
                    while(!stack.isEmpty() && stack.peek().height > nextHeight){
                        temp = stack.pop();
                        if (maxArea < temp.height * (i-temp.index)){
                            maxArea = temp.height * (i-temp.index);
                        }
                    }
                    if (stack.isEmpty() || stack.peek().height != nextHeight)
                    stack.add(new Rectangular(nextHeight, temp.index));
                }
            }

            while(!stack.isEmpty()){
                Rectangular temp = stack.pop();
                if (maxArea < temp.height * (N-temp.index)){
                    maxArea = temp.height * (N-temp.index);
                }
            }
            areaArray.add(maxArea);
        }while(N != 0);

        for (int index = 0; index < areaArray.size()-1; index++) { // -1은 마지막 0 을 출력하기에 0 출력을 없애기 위해 해주었다.)
            System.out.println(areaArray.get(index));
        }
    }
}

class Rectangular{                                                  //직사각형 클래스
    long height;
    int index;

    public Rectangular(long height, int index) {
        this.height = height;
        this.index = index;
    }
}