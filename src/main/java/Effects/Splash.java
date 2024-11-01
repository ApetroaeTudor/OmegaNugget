package Effects;

import Entities.Entity;
import Entities.Player;
import LoadSave.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

import static Phases.Constants.*;

public class Splash extends Entity {

    public Splash(int _x, int _y, Player Character) {
        super();
        this.set_X(_x);
        this.set_Y(_y);
        splash_Xrel=x+splash_width;
        splash_Yrel=y+splash_height;
        animation=new BufferedImage[7];
        load_IMG();
        make_Animation();
        character=Character;
    }

    private int splash_width=(int)(WINDOW_REAL_WIDTH*0.1f);
    private int splash_height=(int)(WINDOW_REAL_HEIGHT*0.2f);

    private int splash_Xrel;
    private int splash_Yrel;
    private BufferedImage SplashL1;
    private BufferedImage SplashL2;
    private BufferedImage[] animation;
    private int nr_framesL1=4;
    private int nr_framesL2=3;
    private Player character;

    private boolean fin=false;

    private int animation_Speed=25;
    private int tick=0;
    private int animation_Phase=0;

    public void set_Fin(boolean val) {
        fin=val;
    }

    public boolean get_Fin() {
        return fin;
    }

    public void update_Animation() {
        tick++;
        if(tick>=animation_Speed) {
            tick=0;
            animation_Phase++;
            System.out.println("ani phase: "+animation_Phase);
            if(animation_Phase>=nr_framesL1+nr_framesL2) {
                fin=true;
                System.out.println("STOP");
            }
        }
    }
    private void load_IMG() {
        SplashL1=LoadSave.load_IMG(LoadSave.SPLASH1);
        SplashL2=LoadSave.load_IMG(LoadSave.SPLASH2);
    }
    private void make_Animation() {
        for(int i=0;i<nr_framesL1+nr_framesL2;i++) {
            if(i<nr_framesL1) {
                animation[i] = SplashL1.getSubimage(i * 61, 0, 61, 32);
            }
            if(i>=nr_framesL1) {
                animation[i]=SplashL2.getSubimage((i-nr_framesL1)*61,0,61,32);
            }
        }

    }
    public void setSplash_width(int wid) {
        splash_width=wid;
        splash_Xrel=x+splash_width;
    }
    public void setSplash_height(int hei) {
        splash_height=hei;
        splash_Yrel=y+splash_height;
    }
    public void set_X(int _x) {
        x=_x;
        splash_Xrel=x+splash_width;
    }
    public void set_Y(int _y) {
        y=_y;
        splash_Yrel=y+splash_height;
    }


    public int getSplash_width() {
        return splash_width;
    }
    public int getSplash_height() {
        return splash_height;
    }
    public int getSplash_Xrel() {
        return splash_Xrel;
    }
    public int getSplash_Yrel() {
        return splash_Yrel;
    }

    public void paint_Animation(Graphics g) {
        if(!fin) {
            System.out.println("paint");
            System.out.println("ani Phase: " +animation_Phase);
            g.drawImage(animation[animation_Phase],x-PLAYER_REAL_WIDTH,y-(int)(WINDOW_REAL_HEIGHT*0.15f),splash_width,splash_height,null);
        }
    }
}
