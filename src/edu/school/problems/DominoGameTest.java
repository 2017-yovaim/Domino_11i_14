package edu.school.problems;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class DominoGameTest extends JFrame
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(50, 50, 900, 500);
		f.setLayout(new BorderLayout());
		DominoTable t = new DominoTable();
		t.addLeft(new DominoTile(1, 2));
		t.addLeft(new DominoTile(3, 1));
		t.addLeft(new DominoTile(4, 3));
		t.addLeft(new DominoTile(5, 4));
		t.addLeft(new DominoTile(6, 5));
		t.addLeft(new DominoTile(0, 6));
		t.addRight(new DominoTile(2, 4));
		
		Hand<DominoTile> hand1 = new Hand<>();
		hand1.add(new DominoTile(2, 2));
		hand1.add(new DominoTile(2, 4));
		hand1.add(new DominoTile(4, 3));
		hand1.add(new DominoTile(3, 6));
		hand1.add(new DominoTile(5, 6));
		
		DominoPlayer player1 = new DominoPlayer("Player 1", hand1, hand1.getSize(), t);
		
		//t.print();
		DominoTableView v = new DominoTableView(t);
		PlayerView pv = new PlayerView(player1);
		
		f.add(v, BorderLayout.CENTER);
		f.add(pv, BorderLayout.SOUTH);
		f.setVisible(true);
		
		
	}

}