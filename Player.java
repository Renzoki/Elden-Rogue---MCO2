import java.util.List;

public class Player {

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

    /** Constructor Method for the Player class.
     * Upon creation, a player is given a name, a job, and a job index.
     * setStatistics() is called to set the player's initial attribute values.
     */
    public Player(String name, String job, int jobIndex){
        this.playerName = name;
        this.playerJob = job;

        new JobStats(this, jobIndex);//Set the player's HP, DEX, INT, END, STR, FTH
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

    /*=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    *                                                                    *
    *                           Setter Methods                           *
    *                                                                    *
    =-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setFaith(int faith) {
        this.faith = faith;
    }

    /*=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    *                                                                    *
    *                   Buy, Level-Up, and Equip Methods                 *
    *                                                                    *
    =-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

    public void addRunes(int runes){
        this.runes += runes;
    }

    public void buyWeapon(Weapon W, int runeCost){
        this.inventory.add(W);
        this.runes -= runeCost;
    }

    public void equipWeapon(String weaponName){
        for(Weapon i : inventory){
            if(weaponName.equals(i.getWeaponName())){
                this.equippedWeapon = i;
            }
        }
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

    //Method for attacking both enemies and bosses
    //Both classes extend the Game_Entity class
    public void attack(Hostile_Entity G, String atkType){

        //Initialized to 0 in case the player does not have an equipped weapon
        int weapon_STR = 0;
        int weapon_INT = 0;
        int weapon_FTH = 0;

        if(equippedWeapon != null){
            weapon_STR = equippedWeapon.getWeapon_STR();
            weapon_INT = equippedWeapon.getWeapon_INT();
            weapon_FTH = equippedWeapon.getWeapon_FTH();
        }

        switch (atkType) {
            case "PHYSICAL" -> G.takeDamage((int)((strength + weapon_STR) * G.getPhysicalDefense()));
            case "SORCERY" -> G.takeDamage((int)((intelligence + weapon_INT) * G.getSorceryDefense()));
            case "INCANTATION" -> G.takeDamage((int)((faith + weapon_FTH) * G.getIncantationDefense()));
        }
    }

    public void takeDamage(int damage){
        this.battleHealth -= damage;
    }

    public int getDodgeChance(){
        return 20 + (endurance + equippedWeapon.getWeapon_END() / 2) / 100;
    }

}


