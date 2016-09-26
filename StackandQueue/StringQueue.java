import java.util.Arrays;

/**
 * Created by Albores, Allyssa; Serato, Jay Vince; Sotto, Wina Gen on 9/26/2016.
 */
public class StringQueue {
    private String[] elements;
    private int count;
    public static final int DEFAULT_SIZE = 10;

    public StringQueue() {
        elements = new String[DEFAULT_SIZE];
    }

    public int size() {
        return count;
    }

    public void queue(String item){
        if (count + 1 >= elements.length){
            extend();
        }
        elements[count++] = item;
    }

    public void extend(){
        String[] temp = Arrays.copyOf(elements, elements.length * 2);
        elements = temp;
    }

    public String dequeue() {
        String str = elements[0];
        for(int i = 1; i < count; i++) {
            elements[i - 1] = elements[i];
        }
        count--;
        return str;
    }

    public String peek() {
        if (count == 0) {
            throw new ArrayIndexOutOfBoundsException("There's no one in the line!");
        }
        return elements[0];
    }

    public String toString() {
        if (count == 0){
            return "EMPTY";
        }
        String ret = "";
        for (int i = 0; i < count - 1; i++){
            ret += elements[i] + ", ";
        }
        return ret + elements[size() - 1];
    }

    public void singit(int position, String x) {
        if (position > count || position <= 0) {
            throw new ArrayIndexOutOfBoundsException("Position not valid!");
        }
        count++;
        for (int i = count - 1; i >= position - 1; i--) {
            elements[i + 1] = elements[i];
        }

        elements[position - 1] = x;
    }

    public static void main(String[] args) {
        StringQueue line = new StringQueue();
        line.queue("Wina");
        line.queue("Vince");
        line.queue("Allyssa");
        System.out.println(line);
        System.out.println(line.size());

        String item1 = line.dequeue();
        String item2 = line.dequeue();
        String item3 = line.dequeue();

        System.out.println(item1);
        System.out.println(item2);
        System.out.println(item3);
        System.out.println(line);
        System.out.println(line.size());

        line.queue("Wina");
        line.queue("Vince");
        line.queue("Allyssa");
        System.out.println(line);
        line.singit(2, "Danielle");
        System.out.println(line);
    }
}
