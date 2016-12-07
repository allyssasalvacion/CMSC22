import javafx.scene.transform.Shear;

/**
 * Created by Albores, Allyssa; Serato, Jay Vince; Sotto, Wina Gen on 10/3/2016.
 */
public class Shape {
    private String color = "red";
    private boolean filled= true;

    public Shape(){
        this.color = "green";
        this.filled = true;
    }

    public Shape(String color, boolean filled){
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public String toString(){
        String s = "A shape with color of " + color + " and ";
        if (filled){
            return s + "filled.";
        }
        return s + "not filled.";
    }
}
