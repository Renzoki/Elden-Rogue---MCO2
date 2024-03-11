public class JobStats {

    ///This method sets the player's attributes based on their chosen job class.
    public JobStats(Player P, int jobIndex) {
        int[] HP = new int[]{15, 12, 11, 14, 9, 10};
        int[] DEX = new int[]{13, 15, 16, 9, 12, 10};
        int[] INT = new int[]{9, 9, 10, 7, 16, 7};
        int[] END = new int[]{11, 13, 11, 12, 9, 8};
        int[] STR = new int[]{14, 12, 10, 16, 8, 11};
        int[] FTH = new int[]{9, 8, 8, 8, 7, 16};

        P.setHealth(HP[jobIndex]);
        P.setDexterity(DEX[jobIndex]);
        P.setIntelligence(INT[jobIndex]);
        P.setEndurance(END[jobIndex]);
        P.setStrength(STR[jobIndex]);
        P.setFaith(FTH[jobIndex]);
    }

}
