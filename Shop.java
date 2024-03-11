import java.util.HashMap;

public class Shop {
    private HashMap<String, Weapon> Weapons;

    /**
     * Upon instantiation, the Shop's list of weapons is defined
     */
    public Shop(){
        new WeaponGenerator(this);
    }

    /**
     * Sets the Shop's weapon list
     */
    public void setShopItems(HashMap<String, Weapon> Weapons){
        this.Weapons = Weapons;
    }

    /**
     * This method allows the player to buy if they have
     * enough runes. It then places the runes in their inventory
     * and reduces their runes by the weapon runecost.
     */
    public void buyWeapon(Player P, String weaponName){
        Weapon W = Weapons.get(weaponName);
        if(hasEnoughRunes(P, W)){
            P.buyWeapon(W, W.getWeaponCost());
        }
    }

    /**
     * This method checks if the player has enough runes to buy
     * the weapon that they want to buy
     */
    private boolean hasEnoughRunes(Player P, Weapon W){
        return P.getRunes() > W.getWeaponCost();
    }

    /**
     * Getter Method for all weapons (For Display)
     */
    public HashMap<String, Weapon> Weapons(){
        return Weapons;
    }
}
