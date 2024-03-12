import java.util.List;

public class Player extends Player_Entity{

    PlayerManager PL = new PlayerManager();

    /** Constructor Method for the Player class.
     * Upon creation, a player is given a name, a job, and a job index.
     * setStatistics() is called to set the player's initial attribute values.
     */
    public Player(String name, String job, int jobIndex){
        this.playerName = name;
        this.playerJob = job;

        new JobStats(this, jobIndex);//Set the player's HP, DEX, INT, END, STR, FTH
    }

    //Action Methods
    public void addRunes(int runes){
        PL.addRunes(this, runes);
    }

    public void buyWeapon(Weapon W, int runeCost){
        PL.buyWeapon(this, W, runeCost);
    }

    public void equipWeapon(String weaponName){
        PL.equipWeapon(this, weaponName);
    }

    public void levelUp(int runeCost){
        PL.levelUp(this, runeCost);
    }

    public void levelUpHealth() {
        PL.levelUpHealth(this);
    }

    public void levelUpDexterity() {
        PL.levelUpDexterity(this);
    }

    public void levelUpIntelligence() {
        PL.levelUpIntelligence(this);
    }

    public void levelUpEndurance() {
        PL.levelUpEndurance(this);
    }

    public void levelUpStrength() {
        PL.levelUpStrength(this);
    }

    public void levelUpFaith() {
        PL.levelUpFaith(this);
    }

    public void setBattleHealth(){
        PL.setBattleHealth(this);
    }

    public void attack(Hostile_Entity G, String atkType){
        PL.attack(this, G, atkType);
    }

    public void takeDamage(int damage){
        PL.takeDamage(this, damage);
    }

    public int getDodgeChance(){
        return PL.getDodgeChance(this);
    }
}


