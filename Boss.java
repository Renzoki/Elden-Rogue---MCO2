import java.util.Random;

public class Boss extends Hostile_Entity {
    private final int areaIndex; //From where the Boss is from

    public Boss(int areaIndex){
        new BossGenerator(this, areaIndex);
        this.areaIndex = areaIndex;
        this.runeDrop = health * 5;
    }

    //Set Boss Damage
    public int calculateDamage(){
        int[][] BOSS_ATK_VALUES ={{150, 300}, {200, 300}, {250, 500}};

        Random R = new Random();
        setDamage(BOSS_ATK_VALUES[areaIndex - 1][R.nextInt(2)]);
        return BOSS_ATK_VALUES[areaIndex - 1][R.nextInt(2)];
    }
}
