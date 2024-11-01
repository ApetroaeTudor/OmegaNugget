package Buttons;

import Entities.Entity;
import Hitboxes.Hitbox;
import LoadSave.LoadSave;
import java.awt.*;
import java.awt.image.BufferedImage;
import Main.Panel;

public abstract class Button extends Entity {

    private int ID;
    private Panel game_panel;
    private BufferedImage ph1,ph2,ph3;
    private int x,y,relX,relY,wid,hei;
    private Hitbox personal_Hitbox=null;

    private boolean is_Hovered=false;
    private boolean is_Pressed=false;

    private BufferedImage CURRENT_IMG;

    public Button(String code1, String code2, String code3, Panel PANEL) {
        set_ph1(LoadSave.load_IMG(code1));
        set_ph2(LoadSave.load_IMG(code2));
        set_ph3(LoadSave.load_IMG(code3));
        game_panel=PANEL;

        setCURRENT_IMG(ph1);
    }

    public Button(BufferedImage P1, BufferedImage P2, BufferedImage P3, Panel PANEL) {
        game_panel=PANEL;
        set_ph1(P1);
        set_ph2(P2);
        set_ph3(P3);

        setCURRENT_IMG(ph1);
    }

    public boolean check_MouseHover() {
        if (Hitbox.check_HitboxCollision(get_PersonalHitbox(), (int)(game_panel.getP().getX()), (int)(game_panel.getP().getY()))) {
            setCURRENT_IMG(get_ph2());
            return true;
        } else {
            setCURRENT_IMG(get_ph1());
            return false;
        }
    }

    public void paint_Button(Graphics g) {
            g.drawImage(getCURRENT_IMG(), get_X(), get_Y(), get_Wid(), get_Hei(), null);
    }

    public BufferedImage getCURRENT_IMG() {
        return CURRENT_IMG;
    }
    public void setCURRENT_IMG( BufferedImage img) {
        CURRENT_IMG=img;
    }
    public int get_Hei() {
        return hei;
    }
    public int get_Wid() {
        return wid;
    }
    public int get_relX() {
        return relX;
    }
    public int get_relY() {
        return relY;
    }

    public void setIs_Hovered(boolean val) {
        is_Hovered=val;
    }
    public boolean getIs_Hovered() {
        return is_Hovered;
    }
    public void setIs_Pressed(boolean val) {
        is_Pressed=val;
    }
    public boolean getIs_Pressed() {
        return is_Pressed;
    }

    public void set_PersonalHitbox(Hitbox H) {
        personal_Hitbox=H;
    }
    public Hitbox get_PersonalHitbox() {
        return personal_Hitbox;
    }


    public void set_ph1(BufferedImage PH1) {
        ph1=PH1;
    }
    public void set_ph2(BufferedImage PH2) {
        ph2=PH2;
    }
    public void set_ph3(BufferedImage PH3) {
        ph3=PH3;
    }

    public BufferedImage get_ph1() {
        return ph1;
    }
    public BufferedImage get_ph2() {
        return ph2;
    }
    public BufferedImage get_ph3() {
        return ph3;
    }
    public int get_ID() {
        return ID;
    }
    public void set_ID(int id) {
        ID=id;
    }

    public void set_Wid(int _wid) {
        wid=_wid;
        relX=x+wid;
    }
    public void set_Hei(int _hei) {
        hei=_hei;
        relY=y+hei;
    }


}
