public class Player extends Player_Entity{

    PlayerManager PlayerManager = new PlayerManager();

    /** Constructor Method for the Player class.
     * Upon creation, a player is given a name, a job, and a job index.
     * setStatistics() is called to set the player's initial attribute values.
     */
    public Player(String name, String job, int jobIndex){
        this.playerName = name;
        this.playerJob = job;
 
        new JobStats(this, jobIndex - 1);//Set the player's HP, DEX, INT, END, STR, FTH
    }

    //Action Methods
    public void addRunes(int runes){
        PlayerManager.addRunes(this, runes);
    }

    public void buyWeapon(Weapon W, int runeCost){
        PlayerManager.buyWeapon(this, W, runeCost);
    }

    public void equipWeapon(String weaponName){
        PlayerManager.equipWeapon(this, weaponName);
    }

    public void levelUp(String attribute){
        PlayerManager.levelUp(this, attribute);
    }

    public void setBattleHealth(){
        PlayerManager.setBattleHealth(this);
    }

    public void attack(Hostile_Entity G, String atkType){
        PlayerManager.attack(this, G, atkType);
    }

    public void takeDamage(int damage){
        PlayerManager.takeDamage(this, damage);
    }

    public int getDodgeChance(){
        return PlayerManager.getDodgeChance(this);
    }
}


