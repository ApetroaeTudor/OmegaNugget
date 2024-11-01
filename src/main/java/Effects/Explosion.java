package Effects;

import LoadSave.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

import static Phases.Constants.*;

public class Explosion {
    private BufferedImage Animation_Sprite;
    private BufferedImage[] Animation;
    private int tick=0;
    private int animation_Phase=0;
    private int animation_Speed=20;
    private Main.Panel game_panel;

    private boolean did_Explode=true;
    private boolean started=false;

    private int x,y,relx,rely,wid,hei;

    public Explosion(int X,int Y,int WID,int HEI,Main.Panel PANEL) {
        x=X;
        y=Y;
        wid=WID;
        hei=HEI;
        relx=x+wid;
        rely=y+hei;
        game_panel=PANEL;
        Animation_Sprite=LoadSave.load_IMG(LoadSave.EXPLOSION);
        make_Animation();
    }

    private void make_Animation() {
        Animation=new BufferedImage[17];
        for(int i=0;i<17;i++) {
            Animation[i]=Animation_Sprite.getSubimage(i*EXPLOSION_IMG_WIDTH,0,EXPLOSION_IMG_WIDTH,EXPLOSION_IMG_HEIGHT);
        }
    }

    public void initialize_Explosion() {
        did_Explode=false;
    }

    public void update_ExplosionAnimation() {
        tick++;
        if(tick>=animation_Speed) {
            tick=0;
            animation_Phase++;
            if(animation_Phase>=17) {
                animation_Phase=0;
                did_Explode=true;
            }
        }
    }

    public void print_Explosion(Graphics g) {
        if(!did_Explode) {
            g.drawImage(Animation[animation_Phase],getx(),gety(),EXPLOSION_REAL_WIDTH,EXPLOSION_REAL_HEIGHT,null);
            if(animation_Phase==17) {
                did_Explode=true;
            }
        }
    }

    public void setStarted(boolean val) {
        started=val;
    }
    public boolean getStarted() {
        return started;
    }
    public void setx(int val) {
        x=val;
        relx=x+wid;
    }
    public int getx(){
        return x;
    }
    public void sety(int val) {
        y=val;
        rely=y+hei;
    }
    public int gety() {
        return y;
    }
    public void setWid(int val) {
        wid=val;
        relx=x+wid;
    }
    public int getWid() {
        return wid;
    }
    public void setHei(int val) {
        hei=val;
        rely=y+hei;
    }
    public Main.Panel getGame_panel() {
        return game_panel;
    }
    public boolean get_didExplode() {
        return did_Explode;
    }
}
