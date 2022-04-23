import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PopUp{

    JButton submit = new JButton("Got it!");
    JFrame menu = new JFrame();
	final JTextArea Tut = new JTextArea("This is an adventure game. The goal is to get the highest stage you can! \nEach stage will have a new enemy which you need to combat to progress through the game.\nEach combat you have the option of attacking or blocking (blocking will decrease damage taken)\nOnce a stage is completed you have the option of healing, or gaining exp"); 
	JPanel panel = new JPanel(new BorderLayout());
    
	PopUp(){	//Constructor has a opens a pop up window displaying how to play the game.
		
		panel.add(Tut, BorderLayout.CENTER);
		panel.add(submit, BorderLayout.SOUTH);
		Tut.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		Tut.setBackground(new Color(0,0,0));
		Tut.setForeground(new Color(255,255,255));
		submit.setBackground(new Color(59, 61, 64));
		submit.setForeground(new Color(255,255,255));
		
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.dispose();  
			}
			});

		menu.add(panel);
		menu.setSize(500,500);
		menu.setResizable(false);
		menu.pack();
		menu.setLocationRelativeTo(null);
		menu.setVisible(true);
	
    }

}
