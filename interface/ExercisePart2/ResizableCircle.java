/**
 * Created by Allyssa Albores on 11/10/2016.
 */
public class ResizableCircle extends Circle implements Resizable {
    public ResizableCircle(double radius) {
        super(radius);
    }

    @Override
    public double resize(int percent) {
        return radius *= (percent*0.01);
    }
}
