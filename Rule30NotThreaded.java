import java.util.Scanner;

/**
 * Created by Allyssa Albores on 07/12/2016.
 */

public class Rule30NotThreaded {
    public static void main(String args[] ) throws Exception {
        Scanner variable = new Scanner(System.in);
        int x;
        int i;
        long time = System.currentTimeMillis();
        System.out.print("Enter length: ");
        x = variable.nextInt();

        variable.close();
        int[] array = new int[x];
        int[] java = new int[x];

        for(i = 0; i < x; i++) {
            array[i] = 0;
        }

        array[x/2] = 1;

        for(i = 0; i < x; i++) {
            java[i] = array[i];
            System.out.print(array[i]);
        }

        System.out.println();

        for(int k = 0; k < x - 1; k++)
        {
            if(java[0] == 1 && java[1] == 1) {
                array[0] = 1;
                System.out.print("1");
            } else if(java[0] == 1 && java[1] == 0) {
                array[0] = 1;
                System.out.print("1");
            } else if(java[0] == 0 && java[1] == 1) {
                array[0] = 1;
                System.out.print("1");
            } else {
                array[0] = 0;
                System.out.print("0");
            }

            for(i = 1; i < x - 1; i++) {
                if((java[i-1] == 1 && java[i] == 0 && java[i+1] == 0) ||
                        (java[i-1] == 0 && java[i] == 1 && java[i+1] == 1) ||
                        (java[i-1] == 0 && java[i] == 1 && java[i+1] == 0) ||
                        (java[i-1] == 0 && java[i] == 0 && java[i+1] == 1)) {
                    array[i] = 1;
                    System.out.print("1");
                }
                else {
                    array[i] = 0;
                    System.out.print("0");
                }

            }

            if(java[i] == 1 && java[i-1] == 0) {
                array[i] = 1;
                System.out.print("1");
            } else if(java[i] == 0 && java[i-1] == 1) {
                array[i] = 1;
                System.out.print("1");
            } else {
                array[i] = 0;
                System.out.print("0");
            }

            System.out.println(); //new line

            for(i = 0; i < x; i++)
            {
                java[i] = array[i];
            }
        }

        System.out.println("Time: " + (System.currentTimeMillis() - time));
    }
}
