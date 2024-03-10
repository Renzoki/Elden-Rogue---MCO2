import java.util.HashMap;
import java.util.List;

public class Player {

    //Player display attributes
    final private String playerName;
    final private String playerJob;

    //Player health and dodge chance
    private int battleHealth;
    private int dodgeChance;

    //Player stats
    private int level = 1;
    private int health;
    private int dexterity;
    private int intelligence;
    private int endurance;
    private int strength;
    private int faith;

    //Player runes
    private int runes = 0;

    //Player Inventory and Current weapon
    private List<Weapon> inventory;
    private Weapon equippedWeapon;

    /** Constructor Method for the Player class.
     * Upon creation, a player is given a name, a job, and a job index.
     * setStatistics() is called to set the player's initial attribute values.
     */
    public Player(String name, String job, int jobIndex){
        this.playerName = name;
        this.playerJob = job;

        setStatistics(jobIndex); //Set the player's HP, DEX, INT, END, STR, FTH
    }

    /**
     * This method sets the player's attributes based on their chosen job class.
     */
     private void setStatistics(int jobIndex) {
        int[] HP = new int[]{15, 12, 11, 14, 9, 10};
        int[] DEX = new int[]{13, 15, 16, 9, 12, 10};
        int[] INT = new int[]{9, 9, 10, 7, 16, 7};
        int[] END = new int[]{11, 13, 11, 12, 9, 8};
        int[] STR = new int[]{14, 12, 10, 16, 8, 11};
        int[] FTH = new int[]{9, 8, 8, 8, 7, 16};

        this.health = HP[jobIndex];
        this.dexterity = DEX[jobIndex];
        this.intelligence = INT[jobIndex];
        this.endurance = END[jobIndex];
        this.strength = STR[jobIndex];
        this.faith = FTH[jobIndex];
    }

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

    public int getDodgeChance(){
        return dodgeChance;
    }

    /*=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    *                                                                    *
    *                       Buy and Level-Up Methods                     *
    *                                                                    *
    =-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

    public void buyWeapon(Weapon W, int runeCost){
        this.inventory.add(W);
        this.runes -= runeCost;
    }

    public void levelUp(int runeCost){
        this.level++;
        this.runes -= runeCost;
    }

    public void levelUpHealth() {
        this.health++;
    }

    public void levelUpDexterity() {
        this.dexterity++;
    }

    public void levelUpIntelligence() {
        this.intelligence++;
    }

    public void levelUpEndurance() {
        this.endurance++;
    }

    public void levelUpStrength() {
        this.strength++;
    }

    public void levelUpFaith() {
        this.faith++;
    }

    /*=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    *                                                                    *
    *                         Battle Methods                             *
    *                                                                    *
    =-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

    //Set at the very first instance of a battle in an area
    public void setBattleHealth(){
        this.battleHealth = 100 * (health + equippedWeapon.getWeapon_HP()) / 2;
    }

    public void attackEnemy(Enemy E, String atkType){
        switch (atkType) {
            case "PHYSICAL" -> E.takeDamage((int)((strength + equippedWeapon.getWeapon_STR()) * E.getPhysicalDefense()));
            case "SORCERY" -> E.takeDamage((int)((intelligence + equippedWeapon.getWeapon_INT()) * E.getSorceryDefense()));
            case "INCANTATION" -> E.takeDamage((int)((faith + equippedWeapon.getWeapon_FTH()) * E.getIncantationDefense()));
        }
    }

    public void takeDamage(int damage){
        this.battleHealth -= damage;
    }

    public void setDodgeChance(){
        this.dodgeChance =  20 + (endurance + equippedWeapon.getWeapon_END() / 2) / 100;
    }

}


