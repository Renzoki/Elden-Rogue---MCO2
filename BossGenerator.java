import java.util.Random;

public class BossGenerator {
    private final int areaIndex;

    public BossGenerator(Boss B, int areaIndex){
        this.areaIndex = areaIndex;

        setName(B);
        setDefense(B);
        setHealth(B);
    }

    //Set Boss Name
    private void setName(Boss B){

        String[] BOSS_NAMES = {"Godrick the Grafted", "Rennala, Queen of the Full Moon", "The Elden Beast"};

        B.setName(BOSS_NAMES[areaIndex - 1]);
    }

    //Set Boss Health
    private void setHealth(Boss B){

        int[] BOSS_HP_VALUES = {200, 400, 800};

        B.setHealth(BOSS_HP_VALUES[areaIndex - 1]);
    }

    //Set Boss Defense
    private void setDefense(Boss B){

        double[][] BOSS_DEFENSE = {{0.35, 0.20, 0.15}, {0.15, 0.35, 0.25}, {0.25, 0.50, 0.40}};

        B.setPhyDef(BOSS_DEFENSE[areaIndex - 1][0]);
        B.setPhyDef(BOSS_DEFENSE[areaIndex - 1][1]);
        B.setSorDef(BOSS_DEFENSE[areaIndex - 1][2]);
    }
}
