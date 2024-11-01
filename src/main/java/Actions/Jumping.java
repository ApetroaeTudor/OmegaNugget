package Actions;

import Effects.Dust;
import Entities.Player;
import LoadSave.LoadSave;
import Phases.Constants;
import java.awt.*;
import java.awt.image.BufferedImage;

import static Phases.Constants.*;

public class Jumping extends Action{

    private BufferedImage Sprite;
    private BufferedImage[] animation;
    private int tick=0;
    private int animation_Phase=0;
    private int animation_Speed=5;

    private boolean is_Jumping=false;
    private long jump_InitTime=0;
    private long jump_CurrentTime=0;

    private Dust dust;

    public Jumping(Player PLAYER) {
        super(PLAYER);
        dust=new Dust();
        load_IMG();
        load_Animation();
    }

    public void update_Position() {
        if(get_IsJumping()) {
            player.set_Y(player.get_Y()-2);
            player.getPersonal_Hitbox().update_Hitbox(0,0,0,-2);
            if (player.is_MovingLeft() && !player.is_MovingRight()) {
                player.set_X(player.get_X()-2);
                player.getPersonal_Hitbox().update_Hitbox(0,0,-2,0);
            } else if (player.is_MovingRight() && !player.is_MovingLeft()) {

                player.set_X(player.get_X()+2);
                player.getPersonal_Hitbox().update_Hitbox(0,0,2,0);
            }
        }

    }

    public boolean check_JumpCooldown() {
        long now=System.currentTimeMillis();
        if(now-get_JumpInitTime()>=500) {
            return true;
        }
        return false;
    }

    private void check_IfFinishedJump() {
        set_JumpCurrentTime(System.currentTimeMillis());
        if(get_JumpCurrentTime()-get_JumpInitTime()>=320) {
            set_IsJumping(false);
        }
    }

    public void update_Animation() {

        dust.update_Animation();


        check_IfFinishedJump();
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
        Sprite= LoadSave.load_IMG(LoadSave.JUMPING);
    }
    private void load_Animation() {
        animation=new BufferedImage[get_nrFrames(JUMPING)];
        for(int i=0;i<31;i++) {
            animation[i]=Sprite.getSubimage(i*JUMP_SPRITE_WIDTH_IMG,0,JUMP_SPRITE_WIDTH_IMG,JUMP_SPRITE_HEIGHT_IMG);
        }
    }

    public void paint_Animation(Graphics g) {
        dust.paint_Animation(g);
        g.drawImage(animation[animation_Phase], player.get_X(), player.get_Y(), PLAYER_REAL_WIDTH-(PLAYER_REAL_WIDTH*20)/100, PLAYER_REAL_HEIGHT -(PLAYER_REAL_HEIGHT*20)/100, null);
    }

    public boolean get_IsJumping() {
        return is_Jumping;
    }
    public void set_IsJumping(boolean val) {
        is_Jumping=val;
    }
    public long get_JumpInitTime() {
        return jump_InitTime;
    }
    public void set_JumpInitTime(long val) {
        jump_InitTime=val;
    }
    public long get_JumpCurrentTime() {
        return jump_CurrentTime;
    }
    public void set_JumpCurrentTime(long val) {
        jump_CurrentTime=val;
    }
    public Dust get_Dust() {
        return dust;
    }

}
