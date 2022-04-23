import javax.swing.*;
import java.awt.event.*;  
import java.awt.*;

public class gameFrame extends main{
    
    JFrame Game = new JFrame();
        
    JPanel enemyBar = new JPanel(new BorderLayout());
    JPanel playerBar = new JPanel(new BorderLayout());
    JPanel options = new JPanel(new FlowLayout());

    JButton block = new JButton("Block");
    JButton attack = new JButton("Attack");
        
    JLabel EnemyName = new JLabel("===Stage " + getPlayer().getStage() + ": "+ getCurrentEnemy().getName() + "===");
    JLabel PHealth = new JLabel("Your HP: " + getPlayer().getHealth() + "/" + getPlayer().getMaxHealth() + " Level: " + getPlayer().getLevel());
    JLabel EHealth = new JLabel(getCurrentEnemy().getHealth() + "/" + getCurrentEnemy().getMaxHealth());
    JTextArea info = new JTextArea("\t===Battle start===\n                     What would you like to do?");
    
    gameFrame(){ //Constructor used to create fran holding the main game.
        
        info.setEditable(false);
        info.setBorder(BorderFactory.createEmptyBorder(80, 150, 20, 20));
        
        options.add(attack);
        options.add(block);
        playerBar.add(PHealth,BorderLayout.CENTER);
        PHealth.setHorizontalAlignment(JLabel.CENTER);
        playerBar.add(options,BorderLayout.SOUTH);
        playerBar.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        enemyBar.add(EnemyName,BorderLayout.CENTER);
        enemyBar.add(EHealth,BorderLayout.SOUTH);
        EHealth.setHorizontalAlignment(JLabel.CENTER);
        EnemyName.setHorizontalAlignment(JLabel.CENTER);
        enemyBar.setBorder(BorderFactory.createEmptyBorder(40, 0, 10, 0));

        attack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                attackSequence();
        }});

        block.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                blockSequence();
            }
        });
        
        info.setBackground(new Color(59, 61, 64));
        info.setForeground(new Color(255,255,255));

        EHealth.setForeground(new Color(255,255,255));
        EnemyName.setForeground(new Color(255,255,255));

        PHealth.setForeground(new Color(255,255,255));
        playerBar.setBackground(new Color(0,0,0));

        options.setBackground(new Color(0,0,0));

        attack.setForeground(new Color(255,255,255));
        attack.setBackground(new Color(59, 61, 64));

        block.setForeground(new Color(255,255,255));
        block.setBackground(new Color(59, 61, 64));

        enemyBar.setBackground(new Color(0,0,0));

        Game.setLayout(new BorderLayout());
        Game.add(playerBar,BorderLayout.SOUTH);
        Game.add(enemyBar,BorderLayout.NORTH);
        Game.add(info,BorderLayout.CENTER);

        CreateWindow(Game);
    }

    public void blockSequence(){ //Method called when block button is pressed, causes the block sequence to commence.

        getPlayer().Block(getCurrentEnemy());
        getCurrentEnemy().Attack(getPlayer());
        PHealth.setText("Your HP: " + getPlayer().getHealth() + "/" + getPlayer().getMaxHealth());
        EHealth.setText(getCurrentEnemy().getHealth() + "/" + getCurrentEnemy().getMaxHealth());

        if(getPlayer().doubleDMG == true){
            info.setText("\tYou blocked this attack! \nYour block left the enemy stumbling, deal a critical hit next turn!" + "\n\t" + getCurrentEnemy().getName() + " attacked you for " + getCurrentEnemy().getDealtDMG());
        }
        else{
             info.setText("\tYou blocked this attack! " + "\n\t" + getCurrentEnemy().getName() + " attacked you for " + getCurrentEnemy().getDealtDMG());
        }

        if(getPlayer().health <= 0){
            Game.dispose();
            new retryFrame();
        }
     }

     public void attackSequence(){ //Method called when attack button is pressed, causes attack sequence to commence.
        
        getPlayer().Attack(getCurrentEnemy());
        
        if(getCurrentEnemy().getHealth() <=0.0){
            Game.dispose();
            getPlayer().gainEXP(30);
            new choiceFrame();
        }
        else if(getPlayer().getHealth() > 0){
            getCurrentEnemy().Attack(getPlayer());
            PHealth.setText("Your HP: " +getPlayer().getHealth() + "/" + getPlayer().getMaxHealth() + " Level: " + getPlayer().getLevel());
            EHealth.setText(getCurrentEnemy().getHealth() + "/" + getCurrentEnemy().getMaxHealth());
        }
        if(getPlayer().getHealth() <= 0){
            Game.dispose();
            new retryFrame();
        }
        
        info.setText("\tYou attacked " + getCurrentEnemy().getName() + " for " + getPlayer().getDealtDMG() + "\n\t" + getCurrentEnemy().getName() + " attacked you for " + getCurrentEnemy().getDealtDMG());
    }

}   


