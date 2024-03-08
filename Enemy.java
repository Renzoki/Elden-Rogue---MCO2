import java.util.Random;  //We are using a randomizer

public class Enemy {

    //Display
    private String enemyName; //Enemy name
    private int areaIndex; //From where the enemy is from
    private int enemyType; //From where the enemy is from

    //Enemy Stats
    private int health; //Enemy health points
    private int damage; //Enemy damage
    private int phyDef; //Physical defense
    private int sorDef; //Sorcery defense
    private int incDef; //Incantation defense

    public Enemy(int areaIndex){
        Random R = new Random();

        this.areaIndex = areaIndex;
        this.enemyType = R.nextInt(3);

        setName();
        setHealth();
        setDamage();
    }

    /*=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    *                                                                    *
    *                          Setter Methods                            *
    *                                                                    *
    =-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

    //Set Enemy Name
    private void setName(){

        //Row 1 is Stormveil, Row 2 is Ray Lucaria, Columns are the enemy types
        String[][] ENEMY_NAMES = {{"Godrick Soldier", "Godrick Archer", "Godrick Knight"},
                {"Living Jar", "Glintstone Sorcerer", "Battle Mage"}};

        //Area index is either 1 or 2
        this.enemyName = ENEMY_NAMES[areaIndex - 1][enemyType];
    }

    //Set Enemy Health
    private void setHealth(){

        //Row is Enemy type, Column is High/Low
        int[][] ENEMY_HP_VALUES = {{20, 30}, {25, 35}, {70, 80}};

        Random R = new Random();

        this.health = ENEMY_HP_VALUES[enemyType][R.nextInt(2)];
    }

    //Sets Enemy Damage
    private void setDamage(){

        //Row is Enemy Type, Column is High/Low
        int[][] ENEMY_ATK_VALUES ={{70, 80}, {110, 120}, {120, 130}};

        Random R = new Random();

        this.damage = (ENEMY_ATK_VALUES[enemyType][R.nextInt(2)]) * areaIndex;
    }

    /*=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    *                                                                    *
    *                      Getter Methods (Display)                      *
    *                                                                    *
    =-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

    public String getEnemyName(){
        return enemyName;
    }

    public int getEnemyHealth(){
        return health;
    }

    public int getDamage(){
        return damage;
    }

    /*=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    *                                                                    *
    *                         Battle Methods                             *
    *                                                                    *
    =-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

    public void attackPlayer(Player P){

    }

    public void takeDamage(int damage){
        this.health -= damage;
    }
}
