package algorithms.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon_1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int L = Integer.parseInt(in[0]);
        int[] list = new int[N];

        in = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            list[i] = Integer.parseInt(in[i]);
        }
        Arrays.sort(list);

        int solution=1;
        int left=list[0];
        for(int i=1; i<N; i++) {
            if(list[i] > left+L-1) {
                left = list[i];
                ++solution;
            }
        }
        System.out.println(solution);
    }
}
