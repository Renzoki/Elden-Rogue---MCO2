public class LevelUp {

    //The cost for leveling up;
    private int runeCost = 0;

    /**
     * Upon instantiation, the object levels up the given
     * player in the parameter based on the given attribute in the parameter.
     */
    public LevelUp(Player P, String attribute){
        runeCost = (P.getLevel() * 100) / 2;
        P.levelUp(runeCost);

        switch (attribute) {
            case "HP" -> P.levelUpHealth();
            case "DEX" -> P.levelUpDexterity();
            case "INT" -> P.levelUpIntelligence();
            case "END" -> P.levelUpEndurance();
            case "STR" -> P.levelUpStrength();
            case "FTH" -> P.levelUpFaith();
        }
    }

    /**
     * Method for getting the runeCost for Displaying
     */
    public int getRuneCost(){
        return runeCost;
    }
}
