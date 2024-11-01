package Entities;

import Hitboxes.Hitbox;
import LoadSave.LoadSave;
import Main.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Donut extends Entity{
    private int x,y,relx,rely,wid,hei;
    private boolean is_Collected=false;
    private BufferedImage Sprite;
    private Main.Panel game_panel;
    private Hitbox personal_Hitbox;
    private int tick=0;
    private int moving_tick=0;

    private int moving_Dir=1;

    public Donut(int X,int Y, int WID, int HEI,Main.Panel PANEL) {
        x=X;
        y=Y;
        wid=WID;
        hei=HEI;
        relx=x+wid;
        rely=y+hei;
        game_panel=PANEL;
        Sprite=LoadSave.load_IMG(LoadSave.DONUT);
        personal_Hitbox=new Hitbox(x,y,wid,hei);
    }


    public void update_Donut() {

        update_PersonalHitbox();
    }

    private void update_PersonalHitbox() {
        personal_Hitbox=new Hitbox((int)(getx()*1.01f),(int)(gety()*1.01f),(int)(getWid()*0.8f),(int)(getHei()*0.8f) );
    }



    public void print_Donut(Graphics g) {
        if(!is_Collected) {
            tick++;
            moving_tick++;
            g.drawImage(Sprite, getx(), gety(), getWid(), getHei(), null);
            if (moving_tick >= 3) {
                moving_tick = 0;
                sety(gety() + moving_Dir);
            }
            if (tick >= 20) {
                tick = 0;
                moving_Dir *= (-1);
            }
            if (Game.get_PrintFlag()) {
                g.setColor(Color.red);
                g.drawRect(getPersonal_Hitbox().get_x(), getPersonal_Hitbox().get_y(), getPersonal_Hitbox().get_Wid(), getPersonal_Hitbox().get_Hei());
            }
        }
    }


    public Hitbox getPersonal_Hitbox() {
        return personal_Hitbox;
    }
    public boolean getIsCollected() {
        return is_Collected;
    }
    public void setIsCollected(boolean val) {
        is_Collected=val;
    }

    public void setx(int val) {
        x=val;
        relx=x+wid;
    }
    public int getx() {
        return x;
    }
    public void sety(int val) {
        y=val;
        rely=y+hei;
    }
    public int gety() {
        return y;
    }
    public int getWid() {
        return wid;
    }
    public int getHei() {
        return hei;
    }
    public Main.Panel getGame_panel() {
        return game_panel;
    }

}
