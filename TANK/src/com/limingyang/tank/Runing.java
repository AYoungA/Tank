package com.limingyang.tank;


public class Runing {
    public static void main(String[] args) throws InterruptedException {

        TankFrame tankFrame = new TankFrame();  
        
        //每50ms，窗口重画
        while (true){
            Thread.sleep(50);
            tankFrame.repaint();
            
        }
    }
}