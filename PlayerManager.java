public class PlayerManager {
     //LevelUp

    public void addRunes(Player P, int runes){
        P.setRunes(P.getRunes() + runes);
    }

    public void buyWeapon(Player P, Weapon W, int runeCost){
        P.setRunes(P.getRunes() - runeCost);
        P.addToInventory(W);
    }

    public void equipWeapon(Player P, String weaponName){
        for(Weapon i : P.getInventory()){
            if(weaponName.equals(i.getWeaponName())){
                P.setEquippedWeapon(i);
            }
        }
    }

    public void levelUp(Player P, int runeCost){
        P.setLevel(P.getLevel() + 1);
        P.setRunes(P.getRunes() - runeCost);
    }

    public void levelUpHealth(Player P) {
        P.setHealth(P.getHealth() + 1);
    }

    public void levelUpDexterity(Player P) {
        P.setDexterity(P.getDexterity() + 1);
    }

    public void levelUpIntelligence(Player P) {
        P.setIntelligence(P.getIntelligence() + 1);
    }

    public void levelUpEndurance(Player P) {
        P.setEndurance(P.getEndurance() + 1);
    }

    public void levelUpStrength(Player P) {
        P.setStrength(P.getStrength() + 1);
    }

    public void levelUpFaith(Player P) {
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
