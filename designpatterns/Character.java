package designpatterns;

/**
 * Created by Allyssa Albores on 24/11/2016.
 */
public abstract class Character {
    private WeaponBehavior weapon;

    public void setWeapon(WeaponBehavior w) {
        this.weapon = w;
    }

    public void fight() {
        weapon.useWeapon();
    }
}
