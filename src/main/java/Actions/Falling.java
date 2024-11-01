package Actions;

import Entities.Player;
import LoadSave.LoadSave;
import Phases.Constants;

import java.awt.*;
import java.awt.image.BufferedImage;

import static Phases.Constants.*;

public class Falling extends Action{

    private BufferedImage Sprite;
    private BufferedImage[] animation;
    private int tick=0;
    private int animation_Phase=-1;
    private int animation_Speed=15;


    private boolean is_Falling=false;

    public Falling(Player PLAYER) {
        super(PLAYER);
        load_IMG();
        load_Animation();
    }

    public void check_Falling() {
        if(!player.can_Move()) {
            set_isFalling(true);
        }
        else {
            set_isFalling(false);
        }
    }

    public void update_Position() {
        check_Falling();
        if(get_isFalling()) {
            player.set_Y(player.get_Y()+2);
            player.getPersonal_Hitbox().update_Hitbox(0,0,0,2);
        }
    }

    public void update_Animation() {
        if(animation_Phase<0) {
            animation_Phase=0;
        }
        tick++;
        if(tick>=animation_Speed) {
            tick=0;
            animation_Phase++;
            if(animation_Phase>= Constants.get_nrFrames(JUMPING)) {
                animation_Phase=0;
            }
        }
    }

    private void load_IMG() {
        Sprite=LoadSave.load_IMG(LoadSave.JUMPING);
    }
    private void load_Animation() {
        animation=new BufferedImage[31];
        for(int i=0;i<31;i++) {
            animation[i]=Sprite.getSubimage(i*JUMP_SPRITE_WIDTH_IMG,0,JUMP_SPRITE_WIDTH_IMG,JUMP_SPRITE_HEIGHT_IMG);
        }
    }


    public void paint_Animation(Graphics g) {
            g.drawImage(animation[animation_Phase],player.get_X(), player.get_Y(),(int)(PLAYER_REAL_WIDTH*0.8f), (int)(PLAYER_REAL_HEIGHT*0.8f), null);
    }

    public boolean get_isFalling() {
        return is_Falling;
    }
    public void set_isFalling(boolean val) {
        is_Falling=val;
    }

    public int get_AnimationPhase() {
        return animation_Phase;
    }
    public void set_AnimationPhase(int val) {
        animation_Phase=val;
    }


}

