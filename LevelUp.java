public class LevelUp {

    //The cost for leveling up;
    private int runeCost = 0;

    /**
     * Method for leveling up the Player given a Player object
     * and Attribute
     */
    public void levelUp(Player P, String attribute){
        runeCost = (P.getLevel() * 100) / 2;
        if(hasEnoughRunes(P)) {
            P.levelUp(attribute);
        }
    }

    /**
     * Method for getting the runeCost for Displaying
     */
    public int getRuneCost(){
        return runeCost;
    }

    /**
     * This method checks if the player has enough runes to level up
     */
    private boolean hasEnoughRunes(Player P){
        return P.getRunes() > runeCost;
    }
}
