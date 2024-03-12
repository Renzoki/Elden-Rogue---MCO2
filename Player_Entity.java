import java.util.List;

public class Player_Entity {
    //Player display attributes
    protected String playerName;
    protected String playerJob;

    //Player battle health
    protected int battleHealth;

    //Player stats
    protected int level = 1;
    protected int health;
    protected int dexterity;
    protected int intelligence;
    protected int endurance;
    protected int strength;
    protected int faith;

    //Player runes
    protected int runes = 0;

    //Player Inventory and Current weapon
    protected List<Weapon> inventory;
    protected Weapon equippedWeapon;
    
    /*=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    *                                                                    *
    *                           Getter Methods                           *
    *                                                                    *
    =-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

    //Player attributes
    protected String getName(){
        return playerName;
    }

    protected String getJob(){
        return playerJob;
    }

    protected int getRunes(){
        return runes;
    }

    //Player stats
    protected int getLevel(){
        return level;
    }

    protected int getHealth() {
        return health;
    }

    protected int getDexterity() {
        return dexterity;
    }

    protected int getIntelligence() {
        return intelligence;
    }

    protected int getEndurance() {
        return endurance;
    }

    protected int getStrength() {
        return strength;
    }

    protected int getFaith() {
        return faith;
    }

    //Player Battle Values
    protected int getBattleHealth(){
        return battleHealth;
    }

    protected Weapon getEquippedWeapon(){
        return equippedWeapon;
    }

    protected List<Weapon> getInventory(){
        return inventory;
    }

    /*=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    *                                                                    *
    *                           Setter Methods                           *
    *                                                                    *
    =-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

    protected void setRunes(int runes){
        this.runes = runes;
    }

    protected void setLevel(int level){
        this.level = level;
    }

    protected void setHealth(int health) {
        this.health = health;
    }

    protected void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    protected void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    protected void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    protected void setStrength(int strength) {
        this.strength = strength;
    }

    protected void setFaith(int faith) {
        this.faith = faith;
    }

    protected void setEquippedWeapon(Weapon weapon){
        this.equippedWeapon = weapon;
    }

    protected void addToInventory(Weapon weapon){
        this.inventory.add(weapon);
    }

    protected void setBattleHealth(int Health){
        this.battleHealth = Health;
    }
}
