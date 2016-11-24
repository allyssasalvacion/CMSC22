package designpatterns;

/**
 * Created by Allyssa Albores on 24/11/2016.
 */
public class BowAndArrowBehavior implements WeaponBehavior {
    @Override
    public void useWeapon() {
        System.out.println("Thwaack… Thud");
    }
}
