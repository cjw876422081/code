package HomeWork;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int random = (int )(1 + Math.random()* 10000 );
        Scanner sc = new Scanner(System.in) ;
        int sum = 0 ;
        do {
            int num = sc.nextInt() ;
            sum ++ ;
            if( num  > random ){
                System.out.println("大了");
            }else if (num < random){
                System.out.println("小了");
            }else if (num == random){
                System.out.println("猜对了" + sum );
            }
        }while(true);
    }
}
