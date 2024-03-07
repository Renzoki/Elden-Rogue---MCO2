public class Player {

    //Player display attributes
    final private String playerName;
    final private String playerJob;

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
    *
    *                      Getter Methods (Display)
    *
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

    /*=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    *
    *                    Increment Methods for attributes
    *
    =-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

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

}


