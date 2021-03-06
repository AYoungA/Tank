package com.limingyang.tank;
import java.awt.*;
import java.awt.event.*;


public class TankFrame extends Frame{

    /**
     * 类的序列号
     */
    private static final long serialVersionUID = 1L;

    Tank myTank = new Tank(200,200,Dir.DOWN);

    Bullet myBullet = new Bullet(300,300,Dir.DOWN);

    public TankFrame (){
        setTitle("tank war");
        setSize(800,600);
        setResizable(false);
        setVisible(true);
        
        //添加监听器
        addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
            
        });
        this.addKeyListener(new MyKeyListener());
    }

    @Override
    public void paint(Graphics g) {
        myTank.paint(g); 
        myBullet.paint(g);
        
    }

    //就键盘监听器
    class MyKeyListener extends KeyAdapter {

        boolean bL = false;
        boolean bR = false;
        boolean bU = false;
        boolean bD = false;
        @Override
        public void keyReleased(KeyEvent e) {
            // System.out.println("keyreleased");
            int key = e.getKeyCode();
            /**
             * 1.0 不做处理
             * 2.0 每次按键抬起，将方向状态值设为默认false
             */
            switch(key){
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                default:
                    break;
            }
            setMainTankDir();

        }
        @Override
        public void keyPressed(KeyEvent e) {
            // System.out.println("keypress");
            int key = e.getKeyCode();
            /**
             * 处理上下左右键
             * 1.0 按那个键往那个方向移动
             * 2.0 组合键，增加四个布尔值，根据每个键的状态判断移动方向，实现可以斜着走。
             * 
             */
            switch(key){
                case KeyEvent.VK_LEFT:
                    bL = true; 
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }
        private void setMainTankDir() {
            
            if (!bL && !bR && !bU && !bD ) myTank.setMoving(false);
            else{
                myTank.setMoving(true);
                if(bL) myTank.setDir(Dir.LEFT);
                if(bR) myTank.setDir(Dir.RIGHT);
                if(bU) myTank.setDir(Dir.UP);
                if(bD) myTank.setDir(Dir.DOWN);
            }
                
            
            }
        }
    }