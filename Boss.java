import java.util.Random;

public class Boss extends NPC {
    private final int areaIndex; //From where the Boss is from

    public Boss(int areaIndex){

        this.areaIndex = areaIndex;

        setName();
        setHealth();
        setDefense();
        setDamage();
        this.runeDrop = health * 5;
    }

    //Set Enemy Name
    protected void setName(){

        String[] BOSS_NAMES = {"Godrick the Grafted", "Rennala, Queen of the Full Moon", "The Elden Beast"};

        this.name = BOSS_NAMES[areaIndex - 1];
    }

    //Set Enemy Health
    protected void setHealth(){

        int[] BOSS_HP_VALUES = {200, 400, 800};

        this.health = BOSS_HP_VALUES[areaIndex - 1];

    }

    //Set Boss Defense
    protected void setDefense(){

        //Physical, Sorcery, and Incantation defense respectively.
        double[][] BOSS_DEFENSE = {{0.35, 0.20, 0.15}, {0.15, 0.35, 0.25}, {0.25, 0.50, 0.40}};

        this.phyDef = BOSS_DEFENSE[areaIndex - 1][0];
        this.sorDef = BOSS_DEFENSE[areaIndex - 1][1];
        this.incDef = BOSS_DEFENSE[areaIndex - 1][2];

    }

    //Set Boss Damage
    protected void setDamage(){

        int[][] BOSS_ATK_VALUES ={{150, 300}, {200, 300}, {250, 500}};

        Random R = new Random();

        this.damage = (BOSS_ATK_VALUES[areaIndex - 1][R.nextInt(2)]);
    }

}
