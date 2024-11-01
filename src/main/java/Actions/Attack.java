package Actions;

import Entities.Entity;
import Hitboxes.Hitbox;
import LoadSave.LoadSave;
import Phases.Constants;

import java.awt.*;
import java.awt.image.BufferedImage;

import static Phases.Constants.*;

public class Attack {

    private int x,y,relx,rely;
    private int wid,hei;
    private BufferedImage SpriteSheet;
    private int tick=0;
    private int animation_Phase=0;
    private BufferedImage[] attack_Animation;
    private Hitbox current_PersonalHitbox;
    private int animation_Speed=20;

    private boolean is_Finished=false;
    private Entity assigned_Entity;

    public Attack(int X, int Y, int WID, int HEI, Entity Character,int code, String att_type,int img_wid,int img_hei) {
        x=X;
        y=Y;
        wid=WID;
        hei=HEI;
        assigned_Entity=Character;
        relx=x+wid;
        rely=y+hei;
        SpriteSheet=LoadSave.load_IMG(att_type);
        make_Animation(code,img_wid,img_hei);

    }

    private void make_Animation(int code, int img_wid,int img_hei) {
        attack_Animation=new BufferedImage[Constants.get_nrFrames(code)];
        for(int i=0;i<Constants.get_nrFrames(code);i++) {
            attack_Animation[i]=SpriteSheet.getSubimage(i*img_wid,0,img_wid,img_hei);
        }
    }

    public void update_Animation() {
        if(!get_IsFinished()) {
            tick++;
            if (tick >= animation_Speed) {
                tick = 0;
                animation_Phase++;
                if (animation_Phase >= Constants.get_nrFrames(Constants.ATTACK_SWORD)) {
                    set_IsFinished(true);
                }
            }
        }

    }

    public void Attack_Update() {
        update_Animation();
        update_CurrentPersonalHitbox(get_CurrentPhase());
    }

    public void print_Animation(Graphics g) {
        if(!get_IsFinished()) {
            g.drawImage(attack_Animation[animation_Phase],assigned_Entity.get_X() + (int)(WINDOW_REAL_WIDTH*0.024f),(int)(assigned_Entity.get_Y()*0.93f),SWORD_SWING_REAL_WIDTH,SWORD_SWING_REAL_HEIGHT,null );
        }
    }

    public void print_Hitbox(Graphics g) {
        if(!get_IsFinished() && current_PersonalHitbox!=null) {
          current_PersonalHitbox.print_Hitbox(g);
        }
    }

    public void update_CurrentPersonalHitbox(int phase) {
        current_PersonalHitbox=new Hitbox(assigned_Entity.get_X()+50,(int)(assigned_Entity.get_Y()*1.2f-phase*assigned_Entity.get_Y()*0.08f),(int)(SWORD_SWING_REAL_WIDTH*0.8f),(int)(SWORD_SWING_REAL_HEIGHT*phase*0.18f));
    }


    public Hitbox getCurrent_PersonalHitbox() {
        return current_PersonalHitbox;
    }
    public boolean get_IsFinished() {
        return is_Finished;
    }
    public void set_IsFinished(boolean val) {
        is_Finished=val;
    }
    public void setX(int val) {
        x=val;
        relx=x+wid;
    }
    public int getX() {
        return x;
    }
    public void setY(int val) {
        y=val;
        rely=y+hei;
    }
    public int get_RelX() {
        return relx;
    }
    public int get_RelY() {
        return rely;
    }
    public Entity getAssigned_Entity() {
        return assigned_Entity;
    }
    public void setAssigned_Entity(Entity Character) {
        assigned_Entity=Character;
    }
    public int get_CurrentPhase() {
        return animation_Phase;
    }

}
