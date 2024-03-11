import java.util.Random;  //We are using a randomizer

public class Enemy extends NPC {
    private final int areaIndex; //From where the enemy is from
    private final int enemyType; //Type 1, 2, or 3

    //Enemy Stats

    public Enemy(int areaIndex){
        Random R = new Random();

        this.areaIndex = areaIndex;
        this.enemyType = R.nextInt(3);

        setName();
        setHealth();
        setDefense();
        setDamage();
        this.runeDrop = health * 2;
    }

    /*=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    *                                                                    *
    *                          Setter Methods                            *
    *                                                                    *
    =-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

    //Set Enemy Name
    protected void setName(){

        //Row 1 is Stormveil, Row 2 is Ray Lucaria, Columns are the enemy types
        String[][] ENEMY_NAMES = {{"Godrick Soldier", "Godrick Archer", "Godrick Knight"},
                {"Living Jar", "Glintstone Sorcerer", "Battle Mage"}};

        //Area index is either 1 or 2
        this.name = ENEMY_NAMES[areaIndex - 1][enemyType];
    }

    //Set Enemy Health
    protected void setHealth(){

        //Row is Enemy type, Column is High/Low
        int[][] ENEMY_HP_VALUES = {{20, 30}, {25, 35}, {70, 80}};

        Random R = new Random();

        this.health = ENEMY_HP_VALUES[enemyType][R.nextInt(2)] * areaIndex;
    }

    //Set Enemy Defense
    protected void setDefense(){

        //Row is Enemy type, and the values in the columns are
        //Physical, Sorcery, and Incantation defense respectively.
        double[][] ENEMY_DEFENSE = {{0.20, 0.15, 0.10}, {0.50, 0.15, 0.20}, {0.25, 0.25, 0.20}};

        this.phyDef = ENEMY_DEFENSE[enemyType][0] * areaIndex;
        this.sorDef = ENEMY_DEFENSE[enemyType][1] * areaIndex;
        this.incDef = ENEMY_DEFENSE[enemyType][2] * areaIndex;
    }

    //Set Enemy Damage
    protected void setDamage(){

        //Row is Enemy Type, Column is High/Low
        int[][] ENEMY_ATK_VALUES ={{70, 80}, {110, 120}, {120, 130}};

        Random R = new Random();

        this.damage = (ENEMY_ATK_VALUES[enemyType][R.nextInt(2)]) * areaIndex;
    }
}
