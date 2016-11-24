package designpatterns;

/**
 * Created by Allyssa Albores on 24/11/2016.
 */
public class CharacterTest {
    public static void main(String[] args) {
        Character c1 = new King();
        Character c2 = new Queen();
        Character c3 = new Knight();
        Character c4 = new Troll();

        Character c5 = new Queen();
        Character c6 = new Knight();

        c1.setWeapon(new KnifeBehavior());
        c2.setWeapon(new BowAndArrowBehavior());
        c3.setWeapon(new SwordBehavior());
        c4.setWeapon(new AxeBehavior());

        c5.setWeapon(new AxeBehavior());
        c6.setWeapon(new KnifeBehavior());

        c1.fight();
        c2.fight();
        c3.fight();
        c4.fight();

        c5.fight();
        c6.fight();
    }
}
