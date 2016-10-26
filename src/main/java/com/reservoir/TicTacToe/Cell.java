package com.reservoir.TicTacToe;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Cell extends JPanel{

	//token of this cell
	private char token = ' ';

	public Cell(){

		setBorder(new LineBorder(Color.black, 1));
		//addMouseListener(new MyMouseListener());
	}
	
	public char getToken(){
		return token;
	}
	
	public void setToken(char c){
	
		token = c;
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		if(token == 'X'){
			g.drawLine(10, 10, getWidth() - 10, getHeight() - 10);
			g.drawLine(getWidth() - 10, 10, 10, getHeight() - 10);
		}
		else if(token == 'O'){
			g.drawOval(10, 10, getWidth() - 20, getHeight() - 20);
		}
	}
	
	/*private class MouseListener extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e){
		
			if(token == ' ' && whoseT)
		}
	
	}*/
}
