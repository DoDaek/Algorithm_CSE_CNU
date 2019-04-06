import java.util.Scanner;
public class BackJoon1074 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n, r, c, square = 1, index = 0;

        n = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();

        for (int i=0; i < n-1; i++){
            square *= 2;
        }

        for (;square != 1; square /= 2){
            if (r >= square){
                r -= square;
                index += square*square*2;
            }
            if (c >= square){
                c -= square;
                index += square*square;
            }
        }

        if (r == 0 && c ==0) System.out.println(index);
        if (r == 0 && c ==1) System.out.println(index+1);
        if (r == 1 && c ==0) System.out.println(index+2);
        if (r == 1 && c ==1) System.out.println(index+3);
    }
}
