public class LevelUp {
    public LevelUp(Player P, String attribute){
        int runeCost = (P.getLevel() * 100) / 2;
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
}
