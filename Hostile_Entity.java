import java.util.Random;

public class Hostile_Entity {
    protected String name; //Enemy name
    protected int runeDrop; //Enemy drops
    protected int health; //Enemy health points
    protected int damage; //Enemy damage
    protected double phyDef; //Physical defense
    protected double sorDef; //Sorcery defense
    protected double incDef; //Incantation defense

    protected void setName(String name){
        this.name = name;
    }
    protected void setHealth(int health){
        this.health = health;
    }
    protected void setPhyDef(double phyDef){
        this.phyDef = phyDef;
    }
    protected void setSorDef(double sorDef){
        this.sorDef = sorDef;
    }
    protected void setIncDef(double incDef){
        this.incDef = incDef;
    }
    protected void setDamage(int damage){
        this.damage = damage;
    }

    /*=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    *                                                                    *
    *                           Getter Methods                           *
    *                                                                    *
    =-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

    public String getName(){
        return name;
    }

    public int getHealth(){
        return health;
    }

    public int getDamage(){
        return damage;
    }

    public double getPhysicalDefense(){
        return phyDef;
    }

    public double getSorceryDefense(){
        return sorDef;
    }

    public double getIncantationDefense(){
        return incDef;
    }

    public int getDroppedRunes(){
        return runeDrop;
    }

    /*=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    *                                                                    *
    *                         Battle Methods                             *
    *                                                                    *
    =-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

    //Attacks the player
    protected void attackPlayer(Player P){
        P.takeDamage(damage);
    }

    public void takeDamage(int damage){
        this.health -= damage;
    }

    //Returns true if the player cannot dodge
    public boolean canPlayerDodge(Player P){
        Random R = new Random();
        return R.nextInt(101) < P.getDodgeChance();
    }

    //Gives the player runes upon defeating an enemy
    public boolean isDefeated(Player P){
        if(this.health <= 0){
            P.addRunes(runeDrop);
            return true;
        }

        return false;
    }
}