public class Gremlin extends Enemy{
    Gremlin(int level){
        setName("GREMLIN");
        setDamage(getDamage() + Math.round((getDamage()*(level-1)) * 100.0) / 100.0);
        setHealth(getMaxHealth() + Math.round((level*0.8) * 100.0) / 100.0);
        setMaxHealth(getHealth());
    }
    
    public void Attack(Player a){ //Method applies damage to player, Gremlin does a bit more damage than orc, but is affected more by block
        dealtDMG = Math.round(getDamage() * 102.0) / 100.0;

        if(block == true){
            dealtDMG = Math.round((dealtDMG * 0.6) * 100.0) / 100.0;
            block = false;
        }
        
        a.setHealth(Math.round((a.getHealth() - dealtDMG) * 100.0) / 100.0);
    }
}
