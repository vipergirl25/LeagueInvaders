package LeagueInvaders;

import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	final int width = 500;
	final int height = 800;
	GamePanel gamepanel;
	LeagueInvaders(){
		frame = new JFrame();
		gamepanel = new GamePanel();
	}
	void setup() {
		frame.add(gamepanel);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setPreferredSize(new Dimension(width, height));
		frame.pack();
		frame.addKeyListener(gamepanel);
		gamepanel.startGame();
	}
	public static void main(String[] args) {
		LeagueInvaders leagueinvaders = new LeagueInvaders();
		leagueinvaders.setup();
	}
}
