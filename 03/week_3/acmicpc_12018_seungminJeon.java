package algorithms.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon_12018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]); // 과목수
        int m = Integer.parseInt(in[1]); // 마일리지

        int[] list = new int[n]; // 과목당 필요 마일리지
        for(int i=0; i<n; i++) {
            in = br.readLine().split(" ");
            int P = Integer.parseInt(in[0]); // 신청한 사람
            int L = Integer.parseInt(in[1]); // 제한 인원

            in = br.readLine().split(" ");
            if(P<L) { // 어차피 자리 남음
                list[i]=1;
            } else {
                int[] pList = new int[P];
                for(int person=0; person<P; person++) {
                    pList[person] = Integer.parseInt(in[person]);
                }
                Arrays.sort(pList);
                list[i] = pList[P-L]; // L번째 순위랑 같게
            }
        }
        Arrays.sort(list);

        int solution=0;
        for(int i=0; i<n; i++) {
            if(m>=list[i]) {
                m-=list[i];
                ++solution;
            } else break;
        }
        System.out.println(solution);
    }
}
