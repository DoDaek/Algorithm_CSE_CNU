package algorithms.divde_conquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class baekjoon_6549 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        while(N!=0) {
            long[] histogram = new long[N];
            for(int i=0; i<N; i++)
                histogram[i] = Long.parseLong(in[i+1]);

            long solution = divide(histogram, 0, N-1);
            sb.append(solution+"\n");

            in = br.readLine().split(" ");
            N = Integer.parseInt(in[0]);
        }
        System.out.print(sb);
    }

    static long divide(long[] histogram, int left, int right) {
        if(left==right)
            return histogram[left];

        int mid = (left+right)/2;
        long leftMax = divide(histogram, left, mid); // 왼쪽구간 최댓값
        long rightMax = divide(histogram, mid+1, right); // 오른쪽구간 최대값

        // 중간구간 최대값 구하기
        long middleMax=0;
        {
            // 중간 2개 붙인거부터 시작.
            int leftP = mid;
            int rightP = mid+1;

            long minHeight = Math.min(histogram[leftP], histogram[rightP]);
            middleMax = minHeight*2;
            long numBlock = 2;

            // 높은쪽으로 하나씩 확장.
            while(leftP!=left || rightP!=right) {
                ++numBlock;
                if(leftP > left && (rightP==right || histogram[leftP-1]>histogram[rightP+1])) {
                    // 왼쪽으로 확장
                    --leftP;
                    minHeight = Math.min(minHeight, histogram[leftP]);
                } else {
                    // 오른쪽 확장
                    ++rightP;
                    minHeight = Math.min(minHeight, histogram[rightP]);
                }
                middleMax = Math.max(middleMax, minHeight*numBlock);
            }
        }
        return Math.max(Math.max(leftMax, rightMax), middleMax);
    }
}
