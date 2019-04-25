package com.tictactoe.ui;

import java.awt.Color;
import java.awt.Panel;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class GameDesign {
	
	public static void main(String args[])
	{
		System.gc();
		
		Design obj=new Design();
		
		obj.startGame();
		
	}

}

final class Design{
	static int count=0;
	
	private JFrame frame;
	private Panel panel;
	
	private JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
	
	private JRadioButton first,second;
	
	private JLabel p1,p2;
	
	private JLabel result=new JLabel();
	
	Design()
	{
		frame=new JFrame("Tic Tac Toe");
		frame.setVisible(true);
		frame.setSize(450, 360);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		panel=new Panel();
		panel.setBackground(Color.BLACK);
		panel.setLayout(null);
		frame.add(panel);
	}
	
	void startGame()
	{
		addButtons();
		addRadioButtons();
		selectPlayer();
		buttonFunction();
	}
	private void disableButtons()
	{
		b1.setEnabled(false);
		b2.setEnabled(false);
		b3.setEnabled(false);
		b4.setEnabled(false);
		b5.setEnabled(false);
		b6.setEnabled(false);
		b7.setEnabled(false);
		b8.setEnabled(false);
		b9.setEnabled(false);
	}
	
	private void addButtons()
	{
		b1=new JButton();
		b2=new JButton();
		b3=new JButton();
		b4=new JButton();
		b5=new JButton();
		b6=new JButton();
		b7=new JButton();
		b8=new JButton();
		b9=new JButton();
		
		b1.setForeground(Color.MAGENTA);
		b2.setForeground(Color.MAGENTA);
		b3.setForeground(Color.MAGENTA);
		b4.setForeground(Color.MAGENTA);
		b5.setForeground(Color.MAGENTA);
		b6.setForeground(Color.MAGENTA);
		b7.setForeground(Color.MAGENTA);
		b8.setForeground(Color.MAGENTA);
		b9.setForeground(Color.MAGENTA);
		
		disableButtons();
		
		b1.setBounds(10, 10, 100, 100);
		b2.setBounds(120, 10, 100, 100);
		b3.setBounds(230, 10, 100, 100);
		
		b4.setBounds(10, 120, 100, 100);
		b5.setBounds(120, 120, 100, 100);
		b6.setBounds(230, 120, 100, 100);
		
		b7.setBounds(10, 230, 100, 100);
		b8.setBounds(120, 230, 100, 100);
		b9.setBounds(230, 230, 100, 100);
		
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		
		panel.add(b4);
		panel.add(b5);
		panel.add(b6);
		
		panel.add(b7);
		panel.add(b8);
		panel.add(b9);
	}
	
	private void addRadioButtons()
	{
		first =new JRadioButton("O");
		second=new JRadioButton("X");
		
		ButtonGroup rb =new ButtonGroup();
		rb.add(first);
		rb.add(second);
		
		first.setBounds(350, 50, 50, 50);
		first.setBackground(Color.WHITE);
		first.setForeground(Color.WHITE);
		first.setVisible(true);
		panel.add(first);
		
		
		second.setBounds(400, 50, 50, 50);
		second.setBackground(Color.WHITE);
		second.setForeground(Color.WHITE);
		second.setVisible(true);
		panel.add(second);
		
		p1=new JLabel("Player1");
		p2=new JLabel("Player2");
		
		p1.setBounds(350, 130, 100, 50);
		p1.setForeground(Color.WHITE);
		panel.add(p1);
		
		p2.setBounds(350, 200, 100, 50);
		p2.setForeground(Color.WHITE);
		panel.add(p2);
	}
	
	private void selectPlayer()
	{
		first.addActionListener(ae->{radiobuttonFunctioning();});
		second.addActionListener(ae->{radiobuttonFunctioning();});
	}
	
	private void radiobuttonFunctioning()
	{
		clear();
		
		b1.setEnabled(true);
		b2.setEnabled(true);
		b3.setEnabled(true);
		b4.setEnabled(true);
		b5.setEnabled(true);
		b6.setEnabled(true);
		b7.setEnabled(true);
		b8.setEnabled(true);
		b9.setEnabled(true);
		
		if(first.isSelected())
		{
			p1.setText("Player1: "+": "+first.getText());
			p2.setText("Player2: "+": "+second.getText());
		}
		else if(second.isSelected())
		{
			p1.setText("Player1: "+": "+second.getText());
			p2.setText("Player2: "+": "+first.getText());
		}
	}

	private void buttonFunction()
	{
		b1.addActionListener(ae->{enterSymbolONButton(b1);});
		b2.addActionListener(ae->{enterSymbolONButton(b2);});
		b3.addActionListener(ae->{enterSymbolONButton(b3);});
		b4.addActionListener(ae->{enterSymbolONButton(b4);});
		b5.addActionListener(ae->{enterSymbolONButton(b5);});
		b6.addActionListener(ae->{enterSymbolONButton(b6);});
		b7.addActionListener(ae->{enterSymbolONButton(b7);});
		b8.addActionListener(ae->{enterSymbolONButton(b8);});
		b9.addActionListener(ae->{enterSymbolONButton(b9);});
	}
	
	private void enterSymbolONButton(JButton b)
	{
		count++;
		
		if(b.getText()=="")
		{
			if(first.isSelected())
			{
				if(count%2==1)
				{
					b.setText(first.getText());
				}
				else
				{
					b.setText(second.getText());
				}
			}
			else
			{
				if(count%2==1)
				{
					b.setText(second.getText());
				}
				else
				{
					b.setText(first.getText());
				}
			}
			
			
		}
			
		if(getResult())
		{
			frame.setEnabled(false);
			resultFrame();
		}
		
	}
	
	private void resultFrame()
	{
		JFrame f=new JFrame("Result");
		f.setVisible(true);
		f.setSize(450, 200);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setAlwaysOnTop(true);
		
		Panel p=new Panel();
		p.setLayout(null);
		f.add(p);
		
		JButton yes=new JButton("Yes");
		JButton no=new JButton("No");
		
		JLabel replay=new JLabel("Would like to play again?");
		
		
		
		yes.setBounds(150,125,50,25);
		no.setBounds(250, 125, 50, 25);
		
		p.add(yes);
		p.add(no);
		
		getResult();
		
		result.setForeground(Color.RED);
		result.setBorder(null);
		result.setBounds(150, 50, 150, 20);
		
		replay.setBounds(125, 80, 200, 20);
		
		p.add(result);
		p.add(replay);
		
		
		
		yes.addActionListener(ae->{frame.setEnabled(true);
									clear();
									f.dispose();});
		no.addActionListener(ae->{frame.dispose();
									f.dispose();});
	}
	
	private boolean getResult()
	{
		String s[]=new String[9];
		s[0]=b1.getText();
		s[1]=b2.getText();
		s[2]=b3.getText();
		s[3]=b4.getText();
		s[4]=b5.getText();
		s[5]=b6.getText();
		s[6]=b7.getText();
		s[7]=b8.getText();
		s[8]=b9.getText();
		
		for(int i=0;i<9;i+=3)
		{
			if(s[i]==s[i+1]&&s[i]==s[i+2]&&s[i]!="")
			{
				return checkWinner(s[i]);
			}
		}
		for(int i=0;i<3;i++)
		{
			if(s[i]==s[i+3]&&s[i]==s[i+6]&&s[i]!="")return checkWinner(s[i]);
			
			if(i==0)if(s[i]==s[i+4]&&s[i]==s[i+8]&&s[i]!="")return checkWinner(s[i]);
			
			if(i==2)if(s[i]==s[i+2]&&s[i]==s[i+4]&&s[i]!="")return checkWinner(s[i]);
		}
		
		if(count==9) {result.setText("Match Drawn");return true;}
		
		return false;
	}
	
	private void clear()
	{
		count=0;
		b1.setText("");
		b2.setText("");
		b3.setText("");
		b4.setText("");
		b5.setText("");
		b6.setText("");
		b7.setText("");
		b8.setText("");
		b9.setText("");
		
		disableButtons();
	}

	private boolean checkWinner(String s)
	{
		if(first.isSelected())
		{
			if(s.equalsIgnoreCase(first.getText()))
			{
				result.setText("Player1 wins");
				return true;
			}
			else
			{
				result.setText("Player2 wins");
				return true;
			}
		}
		
		if(second.isSelected())
		{
			if(s.equalsIgnoreCase(second.getText()))
			{
				result.setText("Player1 wins");
				return true;
			}
			else
			{
				result.setText("Player2 wins");
				return true;
			}
		}
		
		return false;
	}
}
