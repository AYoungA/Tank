package com.limingyang.tank;

import java.awt.Graphics;


public class Tank {
    //坦克初始位置
    public int x, y;
    //坦克移动方向枚举类
    public Dir dir = Dir.DOWN;  
    //坦克移动速度
    private static final int SPEED = 10;
    //移动静止标识
    private boolean moving = false;

    public Tank(int x,int y,Dir dir){
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
	}
    public Dir Dir(){
        return dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    //坦克的移动交给坦克自己处理。
	public void paint(Graphics g) {
        g.fillRect(x, y, 50, 50);
        move();
	}

	private void move() {
        if(!moving) return;
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