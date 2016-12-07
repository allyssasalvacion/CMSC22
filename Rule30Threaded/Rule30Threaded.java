import java.util.Scanner;

/**
 * Created by Allyssa Albores on 05/12/2016.
 */

public class Rule30Threaded extends Thread {
    private final static int THREAD_COUNT = 10;
    private static int ppt;
    private String row;
    private int start;
    private int end;
    private String result = "";

    public Rule30Threaded(String row, int start, int end) {
        this.row = row;
        this.start = start;
        this.end = end;
    }

    public void run() {
        for(int i = start; i <= end; i++){
            result += solution(i);
        }
    }

    public char solution(int i) {
        char num = '0';
            if(i == 0) {
                if(row.charAt(i) == '1' && row.charAt(i) == '1') {
                    num = '1';
                    //result = result + num;
                } else if(row.charAt(i) == '0' && row.charAt(i) == '1') {
                    num = '1';
                    //result = result + num;
                } else if(row.charAt(i) == '1' && row.charAt(i) == '0') {
                    num = '1';
                    //result = result + num;
                }
            } else if(i == row.length() - 1) {
                if(row.charAt(i - 1) == '0' && row.charAt(i) == '1') {
                    num = '1';
                    //result = result + num;
                } else if(row.charAt(i - 1) == '1' && row.charAt(i) == '0') {
                    num = '1';
                    //result = result + num;
                }
            } else {
                if(row.charAt(i - 1) == '0' && row.charAt(i) == '0' && row.charAt(i + 1) == '1') {
                    num = '1';
                    //result = result + num;
                } else if(row.charAt(i - 1) == '0' && row.charAt(i) == '1' && row.charAt(i + 1) == '0') {
                    num = '1';
                    //result = result + num;
                } else if(row.charAt(i - 1) == '0' && row.charAt(i) == '1' && row.charAt(i + 1) == '1') {
                    num = '1';
                    //result = result + num;
                } else if(row.charAt(i - 1) == '1' && row.charAt(i) == '0' && row.charAt(i + 1) == '0') {
                    num = '1';
                    //result = result + num;
                } else {
                    num = '0';
                }
            }
        return num;
    }

    public String getResult(){
        return result;
    }

    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length: ");
        int length = sc.nextInt();
        int num;
        int start = 0;
        int end;
        String first;
        String result = "";
        long time = System.currentTimeMillis();

        char[] array = new char[length];

        /** FIRST LINE **/
        for(int i = 0; i < length; i++) {
            array[i] = '0';
        }
        array[length/2] = '1';
        first = String.valueOf(array);
        System.out.println(first);
        /****************/

        if(length < THREAD_COUNT) {
            num = length;
        } else {
            num = THREAD_COUNT;
        }

        Rule30Threaded[] portion = new Rule30Threaded[num];
        ppt = length / num;
        end = ppt - 1;

        for(int i = 0; i < length - 1; i++){
            for(int j = 0; j < num; j++){
                if(j == num - 1){
                    end = length - 1;
                }

                portion[j] = new Rule30Threaded(first, start, end);

                start = end + 1;
                end = start + ppt - 1;

                portion[j].start();

                while (portion[j].isAlive()) {
                    try {
                        portion[j].join();
                    }catch (InterruptedException e) {
                        System.err.println("thread interrupted: " + e.getMessage());
                    }
                }

                result += portion[j].getResult();
            }

            System.out.println(result);
            first = result;
            start = 0;
            end = ppt - 1;
            result = "";
        }

        System.out.println("THREADED: " + (System.currentTimeMillis() - time));
    }

}