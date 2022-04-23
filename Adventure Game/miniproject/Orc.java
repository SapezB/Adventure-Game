public class Orc extends Enemy{
    Orc(int level){ 
        setName("ORC");
        setDamage(getDamage() + Math.round(level * 0.5 * 100.0) / 100.0);
        setHealth(getMaxHealth() + Math.round(level * 1.5 * 100.0) / 100.0);
        setMaxHealth(getHealth());
    }

    public void Attack(Player a){ //Method applies damage to player, Orc is less effected by block, but does the least damage
        setDealtDMG(getDamage());

        if(block == true){
            setDealtDMG(Math.round((getDealtDMG() * 0.8) * 100.0) / 100.0);
            block = false;
        }
        a.setHealth(Math.round((a.getHealth() - dealtDMG) * 100.0) / 100.0);
    }
    
}
