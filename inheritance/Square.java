/**
 * Created by User on 10/3/2016.
 */
public class Square extends Rectangle {
    public Square() {
        super(1.0, 1.0);
    }

    public Square(double side){
        super(side, side);
    }

    public Square(double side, String color, boolean filled){
        super(side, side, color, filled);
    }

    public double getSide(){
        return super.getLength();
    }

    public void setSide(double side){
        setLength(side);
        setWidth(side);
    }

    @Override
    public void setLength(double size) {
        super.setLength(size);
    }

    @Override
    public void setWidth(double size) {
        super.setWidth(size);
    }

    public String toString(){
        return "A Square with side=" + getSide() + ", which is a subclass of " + super.toString();
    }
}
