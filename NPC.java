import java.util.Random;

public class NPC {
    protected String name; //Enemy name
    protected int runeDrop; //Enemy drops
    protected int health; //Enemy health points
    protected int damage; //Enemy damage
    protected double phyDef; //Physical defense
    protected double sorDef; //Sorcery defense
    protected double incDef; //Incantation defense

    protected void setName(){}
    protected void setHealth(){}
    protected void setDefense(){}
    protected void setDamage(){}

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

    //Damage is randomly set every turn (low/high)
    public void attackPlayer(Player P){
        setDamage();
        P.takeDamage(damage);
    }

    public void takeDamage(int damage){
        this.health -= damage;
    }

    //Returns true if the player cannot dodge
    public boolean checkDodgeChance(Player P){
        Random R = new Random();
        return R.nextInt(101) > P.getDodgeChance();
    }
}