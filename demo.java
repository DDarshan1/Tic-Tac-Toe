package TicTacToeGame;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class demo extends JFrame{
	
	static JButton b1,b2,b3;
	static JFrame f;
	public static void main(String[] args)
	{
		
		
		f=new JFrame();
		f.setVisible(true);
		f.setSize(300, 300);
		f.setLayout(new FlowLayout());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton b[]= {b1,b2,b3};
		
		for(JButton i:b)
		{
			i=new JButton();
			i.setSize(150,50);
			f.add(i);
		}
	}
}
