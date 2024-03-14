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
    public String getName(){
        return playerName;
    }

    public String getJob(){
        return playerJob;
    }

    public int getRunes(){
        return runes;
    }

    //Player stats
    public int getLevel(){
        return level;
    }

    public int getHealth() {
        return health;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getEndurance() {
        return endurance;
    }

    public int getStrength() {
        return strength;
    }

    public int getFaith() {
        return faith;
    }

    //Player Battle Values
    public int getBattleHealth(){
        return battleHealth;
    }

    public Weapon getEquippedWeapon(){
        return equippedWeapon;
    }

    public List<Weapon> getInventory(){
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
