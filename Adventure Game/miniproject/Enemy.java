public class Enemy extends Character{

    boolean block = false;
    
    public void Attack(Player a){ //Method applies damage to player
        setDealtDMG(Math.round(getDamage() * 100.0) / 100.0);

        if(block == true){
            System.out.println("Attack blocked! " + getName() + " did reduced damage this turn!");
            setDealtDMG(dealtDMG*0.6);
            setBlock(false);
        }
        a.setHealth(Math.round((a.getHealth() - dealtDMG) * 100.0) / 100.0);
        System.out.println(getName() + " Attacked you for " + getDealtDMG() + ". You now have: " + a.getHealth() + " HP");
    }

    //setter method for variable block
    
    public void setBlock(boolean block) {
        this.block = block;
    }


}
