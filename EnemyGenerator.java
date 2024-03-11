import java.util.Random;

public class EnemyGenerator {
    private final int areaIndex;
    private final int enemyType;

    public EnemyGenerator(Enemy E, int areaIndex){
        Random R = new Random();

        this.areaIndex = areaIndex;
        this.enemyType = R.nextInt(3);

        setName(E);
        setDefense(E);
        setHealth(E);
    }

    //Set Enemy Name
    private void setName(Enemy E){

        //Row 1 is Stormveil, Row 2 is Ray Lucaria, Columns are the enemy types
        String[][] ENEMY_NAMES = {{"Godrick Soldier", "Godrick Archer", "Godrick Knight"},
                {"Living Jar", "Glintstone Sorcerer", "Battle Mage"}};

        //Area index is either 1 or 2
        E.setName(ENEMY_NAMES[areaIndex - 1][enemyType]);
    }

    //Set Enemy Health
    private void setHealth(Enemy E){

        //Row is Enemy type, Column is High/Low
        int[][] ENEMY_HP_VALUES = {{20, 30}, {25, 35}, {70, 80}};

        Random R = new Random();

        E.setHealth(ENEMY_HP_VALUES[enemyType][R.nextInt(2)] * areaIndex);
    }

    //Set Enemy Defense
    private void setDefense(Enemy E){

        //Row is Enemy type, and the values in the columns are
        //Physical, Sorcery, and Incantation defense respectively.
        double[][] ENEMY_DEFENSE = {{0.20, 0.15, 0.10}, {0.50, 0.15, 0.20}, {0.25, 0.25, 0.20}};

        E.setPhyDef(ENEMY_DEFENSE[enemyType][0] * areaIndex);
        E.setSorDef(ENEMY_DEFENSE[enemyType][1] * areaIndex);
        E.setIncDef(ENEMY_DEFENSE[enemyType][2] * areaIndex);
    }
}
