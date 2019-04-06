import java.util.Scanner;

public class BackJoon1449 {
    public static void main(String args[]){
        Scanner sc =new Scanner(System.in);
        int number, length, count =0;
        boolean[] array = new boolean[1001];

        number = sc.nextInt();
        length = sc.nextInt();

        for (int i = 0; i < number; i++) {
            array[sc.nextInt()] = true;
        }

        for (int i=0; i < array.length; i++){
            if (array[i]) {
                count++;
                i += length-1;
            }
        }
        System.out.println(count);
    }
}
