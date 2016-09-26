import java.util.Arrays;

/**
 * Created by Albores, Allyssa; Serato, Jay Vince; Sotto, Wina Gen on 9/26/2016.
 */
public class StringStack {
    private String[] elements;
    private int count;
    public static final int DEFAULT_SIZE = 10;

    public void push(String item){
        if (count + 1 >= elements.length){
            extend();
        }
        elements[count++] = item;
    }

    public void extend(){
        String[] temp = Arrays.copyOf(elements, elements.length * 2);
        elements = temp;
    }

    public String pop(){
        if (count == 0){
            throw new ArrayIndexOutOfBoundsException("There is nothing to pop!");
        }
        return elements[--count];
    }

    public int size(){
        return count;
    }

    public StringStack(){
        this(DEFAULT_SIZE);
    }

    public StringStack(int size){
        if (size <= 0){
            throw new IllegalArgumentException("Invalid size!");
        }
        elements = new String[size];
    }

    public String toString(){
        if (count == 0){
            return "EMPTY";
        }
        String ret = "";
        for (int i = 0; i < count - 1; i++){
            ret += elements[i] + ", ";
        }
        return ret + elements[size() - 1];
    }

    public static void main(String[] args){
        StringStack stack = new StringStack();
        stack.push("paper");
        stack.push("plastic");
        stack.push("tissue");
        System.out.println(stack);
        System.out.println(stack.size());

        String item1 = stack.pop();
        String item2 = stack.pop();
        String item3 = stack.pop();

        System.out.println(item1);
        System.out.println(item2);
        System.out.println(item3);
        System.out.println(stack);
        System.out.println(stack.size());
    }
}
