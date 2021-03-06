package com.limingyang.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {
    private static final int SPEED = 10;
    private int x,y;
    private Dir dir;

    public Bullet(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.red);
        g.fillOval(x, y, 10, 10);  
        g.setColor(c);
        move();
	}

    private void move() {
        switch(dir){
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
            }
    }
    
    
}