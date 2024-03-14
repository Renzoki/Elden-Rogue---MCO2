public class PlayerManager {

    public void addRunes(Player P, int runes){
        P.setRunes(P.getRunes() + runes);
    }

    public void buyWeapon(Player P, Weapon W, int runeCost){
        P.setRunes(P.getRunes() - runeCost);
        P.addToInventory(W);
    }

    public void equipWeapon(Player P, String weaponName){

        //Unequip weapon if player has one equipped
        if(P.getEquippedWeapon() != null){
            unequipWeapon(P);
        }

        for(Weapon i : P.getInventory()){
            if(weaponName.equals(i.getWeaponName())){
                P.setEquippedWeapon(i);
                P.setHealth(P.getHealth() + P.getEquippedWeapon().getWeapon_HP());
                P.setIntelligence(P.getIntelligence() + P.getEquippedWeapon().getWeapon_INT());
                P.setEndurance(P.getEndurance() + P.getEquippedWeapon().getWeapon_END());
                P.setStrength(P.getStrength() + P.getEquippedWeapon().getWeapon_STR());
                P.setFaith(P.getFaith() + P.getEquippedWeapon().getWeapon_FTH());
            }
        }
    }

    private void unequipWeapon(Player P){
        //Remove weapon stats from player stats
        P.setHealth(P.getHealth() - P.getEquippedWeapon().getWeapon_HP());
        P.setIntelligence(P.getIntelligence() - P.getEquippedWeapon().getWeapon_INT());
        P.setEndurance(P.getEndurance() - P.getEquippedWeapon().getWeapon_END());
        P.setStrength(P.getStrength() - P.getEquippedWeapon().getWeapon_STR());
        P.setFaith(P.getFaith() - P.getEquippedWeapon().getWeapon_FTH());
    }

    public void levelUp(Player P, String attribute){
        int runeCost = (P.getLevel() * 100) / 2;

        P.setLevel(P.getLevel() + 1);
        P.setRunes(P.getRunes() - runeCost);

        switch (attribute) {
            case "HP" -> levelUpHealth(P);
            case "DEX" -> levelUpDexterity(P);
            case "INT" -> levelUpIntelligence(P);
            case "END" -> levelUpEndurance(P);
            case "STR" -> levelUpStrength(P);
            case "FTH" -> levelUpFaith(P);
        }
    }

    private void levelUpHealth(Player P) {
        P.setHealth(P.getHealth() + 1);
    }

    private void levelUpDexterity(Player P) {
        P.setDexterity(P.getDexterity() + 1);
    }

    private void levelUpIntelligence(Player P) {
        P.setIntelligence(P.getIntelligence() + 1);
    }

    private void levelUpEndurance(Player P) {
        P.setEndurance(P.getEndurance() + 1);
    }

    private void levelUpStrength(Player P) {
        P.setStrength(P.getStrength() + 1);
    }

    private void levelUpFaith(Player P) {
        P.setFaith(P.getFaith() + 1);
    }


   //Battle

    //Set at the very first instance of a battle in an area
    public void setBattleHealth(Player P){
        P.setBattleHealth(100 * (P.getHealth() + P.getEquippedWeapon().getWeapon_HP()) / 2);
    }

    //Method for attacking both enemies and bosses
    //Both classes extend the Game_Entity class
    public void attack(Player P, Hostile_Entity G, String atkType){

        //Initialized to 0 in case the player does not have an equipped weapon
        int weapon_STR = 0;
        int weapon_INT = 0;
        int weapon_FTH = 0;

        if(P.getEquippedWeapon() != null){
            weapon_STR = P.getEquippedWeapon().getWeapon_STR();
            weapon_INT = P.getEquippedWeapon().getWeapon_INT();
            weapon_FTH = P.getEquippedWeapon().getWeapon_FTH();
        }

        switch (atkType) {
            case "PHYSICAL" -> G.takeDamage((int)((P.getStrength() + weapon_STR) * G.getPhysicalDefense()));
            case "SORCERY" -> G.takeDamage((int)((P.getIntelligence() + weapon_INT) * G.getSorceryDefense()));
            case "INCANTATION" -> G.takeDamage((int)((P.getFaith() + weapon_FTH) * G.getIncantationDefense()));
        }
    }

    public void takeDamage(Player P, int damage){
        P.setBattleHealth(P.getBattleHealth() - damage);
    }

    public int getDodgeChance(Player P){
        return 20 + (P.getEndurance() + P.getEquippedWeapon().getWeapon_END() / 2) / 100;
    }
}
