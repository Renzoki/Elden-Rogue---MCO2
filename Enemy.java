import java.util.Random;  //We are using a randomizer

public class Enemy extends Hostile_Entity {
    private final int areaIndex; //From where the enemy is from
    private final int enemyType; //Type 1, 2, or 3

    public Enemy(int areaIndex){
        Random R = new Random();
        this.areaIndex = areaIndex;
        this.enemyType = R.nextInt(3);

        new EnemyGenerator(this, areaIndex, enemyType);
        this.runeDrop = health * 2;
    }

    //Set Enemy Damage
    public int calculateDamage(){
        int[][] ENEMY_ATK_VALUES ={{70, 80}, {110, 120}, {120, 130}};

        Random R = new Random();
        setDamage(ENEMY_ATK_VALUES[enemyType][R.nextInt(2)] * areaIndex);
        return ENEMY_ATK_VALUES[enemyType][R.nextInt(2)] * areaIndex;
    }}
