public class Elf extends Enemy{
    Elf(int level){
        setName("ELF");
        setDamage(getDamage() +  Math.round(level * 1.5 * 100.0) / 100.0);
        setHealth(getMaxHealth()+ Math.round(level * 0.5 * 100.0) / 100.0);
        setMaxHealth(getHealth());
    }
    
    public void Attack(Player a){ //Method applies damage to player, Elf does the most damage but is most affected by block
        dealtDMG = Math.round(getDamage() * 103.0) / 100.0;

        if(block == true){
            dealtDMG = Math.round((dealtDMG * 0.2) * 100.0) / 100.0;
            block = false;
        }
        a.setHealth(Math.round((a.getHealth() - dealtDMG) * 100.0) / 100.0);
    }
}
