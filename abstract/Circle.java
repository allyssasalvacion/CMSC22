/**
 * Created by Albores, Allyssa; Serato, Jay Vince; Sotto, Wina Gen on 10/3/2016.
 */
import java.lang.*;

public class Circle extends Shape{
    protected double radius = 1.0;

    public Circle() {
        this(1.0);
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public String toString() {
        return "A Circle with radius = " + radius + " which is a subclass of " + super.toString();
    }
}
