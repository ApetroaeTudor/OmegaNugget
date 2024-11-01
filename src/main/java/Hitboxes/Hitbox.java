package Hitboxes;

import java.awt.*;
import Main.Game;

public class Hitbox {

    private int x,y,rel_x,rel_y,wid,hei;

    public Hitbox(int _x,int _y, int _wid, int _hei) {
        x=_x;
        y=_y;
        wid=_wid;
        hei=_hei;
        rel_x=x+wid;
        rel_y=y+hei;
    }

    public void update_Hitbox(int poswid,int poshei,int posx,int posy) {
        if(poswid!=0 && poshei!=0) {
            set_Wid(poswid);
            set_Hei(poshei);
        }
        set_x(get_x()+posx);
        set_y(get_y()+posy);
    }


    public void print_Hitbox(Graphics g) {
        if(Game.get_PrintFlag()) {
            g.setColor(Color.red);
            g.drawRect(x,y,wid,hei);
        }
    }

    public static boolean check_HitboxCollision(Hitbox H, int x, int y) {
        if(x>=H.get_x() && x<=H.get_relX() && y>=H.get_y() && y<=H.get_relY()) {
            return true;
        }
        return false;
    }

    public static boolean check_Collision2Hitboxes(Hitbox A, Hitbox B) {
        if(A.get_relX()>=B.get_x() && ( (A.get_y()>=B.get_y() && A.get_y()<= B.get_relY()) || (B.get_y()>=A.get_y() && B.get_y()<=A.get_relY()) )){
            if(A.get_x()>B.get_relX()) {
                return false;
            }
            return true;
        }

        return false;
    }


    public void set_x(int _x) {
        x=_x;
        rel_x=x+wid;
    }
    public void set_y(int _y) {
        y=_y;
        rel_y=y+hei;
    }
    public int get_x() {
        return x;
    }
    public int get_y() {
        return y;
    }
    public int get_relX() {
        return rel_x;
    }
    public int get_relY() {
        return rel_y;
    }
    public void set_Wid(int _wid) {
        wid=_wid;
        rel_x=x+wid;
    }
    public void set_Hei(int _hei) {
        hei=_hei;
        rel_y=y+hei;
    }
    public int get_Wid() {
        return wid;
    }
    public int get_Hei() {
        return hei;
    }


}
