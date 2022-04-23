import javax.swing.*;
import java.awt.event.*;  
import java.awt.*;
import java.io.*;

public class choiceFrame extends main{

    JFrame choice = new JFrame();
    JPanel top = new JPanel(new BorderLayout());
    JPanel options = new JPanel(new FlowLayout());

    JButton exp = new JButton("Gain 40 EXP");
    JButton heal = new JButton("Heal to full");
    JButton save = new JButton("Save/Exit");

    JLabel level = new JLabel("Health: " + getPlayer().getHealth() + "/" + getPlayer().getMaxHealth() + "   Level: " + getPlayer().getLevel() + " EXP: " + getPlayer().getExp() + "/100"  );
    JLabel title = new JLabel("You defeated the enemy!\n Choose a reward!");
    
    choiceFrame(){ //COnstructor forms frame which shown after each stage, gives player an option before progressing stage

        level.setHorizontalAlignment(JLabel.CENTER);
        
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));

        top.add(title,BorderLayout.NORTH);
        top.add(level,BorderLayout.SOUTH);
        top.setBorder(BorderFactory.createEmptyBorder(70, 0, 0, 0));

        options.add(exp);
        options.add(heal);
        options.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));

        save.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                choice.dispose();
                new menuFrame();
                save();
            }
        });

        exp.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                EXP();
            }
        });

        heal.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                HEAL();
            }
        });

        options.setBackground(new Color(0,0,0));
        level.setForeground(new Color(255,255,255));
        title.setForeground(new Color(255,255,255));
        top.setBackground(new Color(0,0,0));
        
        exp.setForeground(new Color(255,255,255));
        exp.setBackground(new Color(59, 61, 64));

        heal.setForeground(new Color(255,255,255));
        heal.setBackground(new Color(59, 61, 64));

        save.setForeground(new Color(255,255,255));
        save.setBackground(new Color(59, 61, 64));

        choice.setLayout(new BorderLayout());
        choice.add(top,BorderLayout.NORTH);
        choice.add(options,BorderLayout.CENTER);
        choice.add(save,BorderLayout.SOUTH);

        CreateWindow(choice);
    }

    public void EXP(){ //Method called when "Gain EXP" button is pressed, increases player exp and moves game onto next stage.
        getPlayer().gainEXP(40);

        getPlayer().setStage((Player.getStage())+1);
        setCurrentEnemy(List.pickEnemy(getPlayer().getStage()));
        choice.dispose();
        new gameFrame();
    }

    public void HEAL(){ //Method called when "heal" button is pressed, heals player to max HP and moves game onto next stage.
        getPlayer().setHealth(getPlayer().getMaxHealth());
        getPlayer().setStage(getPlayer().getStage()+1);
        setCurrentEnemy(List.pickEnemy(getPlayer().getStage()));
        choice.dispose();
        new gameFrame();
    }

    public void save(){
        
        try{ 
            
            FileOutputStream saveGame = new FileOutputStream("./saves/saveGame");
            ObjectOutputStream savedPlayer = new ObjectOutputStream(saveGame);
            savedPlayer.writeObject(getPlayer());
            savedPlayer.close();

        }
        catch (Exception e) {
            
            e.printStackTrace();
        
        }
    }
    
}

