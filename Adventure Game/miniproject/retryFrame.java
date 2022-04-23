import javax.swing.*;
import java.awt.event.*;  
import java.awt.*;

public class retryFrame extends main{ //Constructor used when players health reaches 0, gives player option of starting the game again or not (which closes the game)
    
    JFrame retry = new JFrame();
        
    JPanel buttons = new JPanel(new FlowLayout());
    JPanel panel = new JPanel(new BorderLayout());
    JPanel top = new JPanel();

    JButton yes = new JButton("Yes");
    JButton no = new JButton("No");
    
    JTextArea ta = new JTextArea();
    JLabel title = new JLabel("You died! You made it to stage: " + getPlayer().getStage() +"!");
    JLabel again = new JLabel("Would you like to play agian?");
    
    retryFrame(){
        
        ta.setText("Your stats from this run:\nName:" + getPlayer().getName() + "\nLevel:" + getPlayer().getLevel() + "\nMaxHealth:" + getPlayer().getMaxHealth() + "\nStage: " + getPlayer().getStage() );
        ta.setEditable(false);

        buttons.add(yes);
        buttons.add(no);
        
        title.setHorizontalAlignment(JLabel.CENTER);
        again.setHorizontalAlignment(JLabel.CENTER);

        top.add(title);

        panel.add(again,BorderLayout.CENTER);
        panel.add(buttons,BorderLayout.SOUTH);

        retry.setLayout(new BorderLayout());
        retry.add(top,BorderLayout.NORTH);
        retry.add(ta,BorderLayout.CENTER);
        retry.add(panel,BorderLayout.SOUTH);

        ta.setBorder(BorderFactory.createEmptyBorder(50, 200, 0, 0));
        title.setBorder(BorderFactory.createEmptyBorder(25, 0, 25, 0));
        buttons.setBorder(BorderFactory.createEmptyBorder(10, 0, 23, 0));
        again.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        yes.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                retry.dispose();
                reset();
            }
        });

        no.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

        buttons.setBackground(new Color(0,0,0));
        panel.setBackground(new Color(0,0,0));
        top.setBackground(new Color(0,0,0));

        title.setForeground(new Color(255,255,255));
    
        again.setForeground(new Color(255,255,255));

        ta.setBackground(new Color(59, 61, 64));
        ta.setForeground(new Color(255,255,255));
        
        yes.setBackground(new Color(59, 61, 64));
        yes.setForeground(new Color(255,255,255));
        
        no.setBackground(new Color(59, 61, 64));
        no.setForeground(new Color(255,255,255));
        
        CreateWindow(retry);
    }

    public void reset(){ //Method restarts all stats, returns player to main menu
        
        setPlayer(new Player(getPlayer().getName()));
        getPlayer().setStage(1);
        System.out.println(getPlayer().getStage());
        setCurrentEnemy(List.pickEnemy(getPlayer().getStage()));
        
        new menuFrame();
    }
}

