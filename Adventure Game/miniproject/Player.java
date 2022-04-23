import java.io.Serializable;

public class  Player extends Character implements Serializable{
    
    
    public int exp = 0;
    public static int stage = 1;
    public static int level = 1;
    public static boolean doubleDMG = false;
    
    Player(String name){
        setName(name);

    }

    public void gainEXP(int EXP){ //Increases EXP my number in parameters, levels player up if they reach 100.
        exp = exp + EXP;
        if(exp >= 100){
            levelUp();
        }
    }

    public void levelUp(){ //Method increases damage of player
        
        setDamage(getDamage() + Math.round((getDamage() * 0.4) * 100.0) / 100.0);
        setMaxHealth(getMaxHealth() + Math.round((getMaxHealth() * 0.3) * 100.0) / 100.0);
        setHealth(getMaxHealth());
        setLevel(level+1);
        
        setExp(exp-100);
    }

    public void Attack(Enemy a){ //Method applies damage to enemy in parameters
        
        dealtDMG = Math.round((Roll() * getDamage()) * 100.0) / 100.0;
        
        if(doubleDMG == true){
            dealtDMG = Math.round((4 * getDamage()) * 100.0) / 100.0;
            doubleDMG = false;
        }
        
        a.setHealth(Math.round((a.getHealth() - dealtDMG) * 100.0) / 100.0);
    }
    
    public int Roll(){  //Method used to add Randomness to the attack, highest chance to do normal damage, then a bit higher chance to do double damage, and least chance to do triple damage.

        int Roll = (int)(Math.random()*10);
        
        if(Roll >= 1 && Roll <= 6){
            return 1;
        }
        else if(Roll > 6 && Roll <= 8){
            return 2;
        }

        return 3;
    }

    public void Block(Enemy a){ //Method allows the player to block, changes variables in Enemy class, rolls a dice for a random chance at double damage.
        
        int special = (int)(Math.random()*3);
        
        if(special == 1){
            setDoubleDMG(true);;
        }
        a.setBlock(true);

    }

    //Getter annd setter methods


    public int getExp() {
        return exp;
    }

    public static int getLevel() {
        return level;
    }

    public static int getStage() {
        return stage;
    }


    public void setExp(int exp) {
        this.exp = exp;
    }

    public static void setLevel(int level) {
        Player.level = level;
    }

    public static void setStage(int stage) {
        Player.stage = stage;
    }

    public static void setDoubleDMG(boolean doubleDMG) {
        Player.doubleDMG = doubleDMG;
    }
}
