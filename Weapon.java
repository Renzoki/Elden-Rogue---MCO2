public class Weapon {

    //Weapon Display attributes
    private int weaponIndex;
    private String weaponName;

    //Weapon Usage/Buy info
    final private int weaponCost;
    final private int DEX_Requirement; //Requirement to be used

    //Weapon Statistics
    final private int weapon_HP;
    final private int weapon_END;
    final private int weapon_STR;
    final private int weapon_INT;
    final private int weapon_FTH;

    //Flag for weapon equipment
    private boolean isEquipped = false;

    /** Constructor Method for the Weapon class.
     * Upon creation, a weapon is given a name, a cost, and a dexterity requirement.
     * The rest of the weapon's statistics are also set and cannot be changed later.
     */
    public Weapon(String name, int DexReuirement, int cost, int HP, int END, int STR, int INT, int FTH){
        this.weaponName = name;
        this.weaponCost = cost;
        this.DEX_Requirement = DexReuirement;
        this.weapon_HP = HP;
        this.weapon_END = END;
        this.weapon_STR = STR;
        this.weapon_INT = INT;
        this.weapon_FTH = FTH;
    }

    /*=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    *                                                                    *
    *                         Getter Methods                             *
    *                                                                    *
    =-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

    public int getDEX_Requirement() {
        return DEX_Requirement;
    }

    public int getWeaponCost() {
        return weaponCost;
    }

    public int getWeapon_HP() {
        return weapon_HP;
    }

    public int getWeapon_END() {
        return weapon_END;
    }

    public int getWeapon_STR() {
        return weapon_STR;
    }

    public int getWeapon_INT() {
        return weapon_INT;
    }

    public int getWeapon_FTH() {
        return weapon_FTH;
    }
}

