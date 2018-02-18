package LeagueInvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Alien extends GameObject{
	int speed;
	Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = new Random().nextInt(11);
		if(speed == 0) {
			speed = 1;
		}
	}
	void update() {
		super.update();
		y+=speed;
	}
	void draw(Graphics g) {
		g.drawImage(GamePanel.alienImg, x, y, width, height, null);
	}
}
