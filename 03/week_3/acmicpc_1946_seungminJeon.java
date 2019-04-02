package algorithms.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class baekjoon_1946 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        byte T = Byte.parseByte(br.readLine());
        StringBuilder sb= new StringBuilder();
        for(byte t=0; t<T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] candidate = new int[N+1];
            String[] input;
            for(int i=0; i<N; i++) {
                input = br.readLine().split(" ");
                candidate[Integer.parseInt(input[0])] = Integer.parseInt(input[1]);
            }

            int solution=1;
            int pivot = candidate[1];
            for(int i=2; i<=N; i++) {
                if(candidate[i]<pivot) {
                    pivot = candidate[i];
                    ++solution;
                }
            }

            /*
            int pivot = candidate[0][1];
            for(int i=1; i<N; i++) {
                if(candidate[i][1]<pivot) {
                    ++solution;
                    pivot = candidate[i][1];
                }
            }
            */
            sb.append(solution+"\n");

            /*
            for(int i=0; i<N; i++) {
                System.out.println(candidate[i][0]+" "+candidate[i][1]);
            }
            */
        }
        System.out.print(sb);
    }
}
