package Effects;

import LoadSave.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

import static Phases.Constants.*;

public class Dust {
    public Dust() {
        load_IMG();
        load_Animation();
    }

    private int x;
    private int y;
    private BufferedImage Sprite;
    private BufferedImage[] animation;
    private int animation_Phase=3;
    private int tick;
    private int animation_Speed=20;

    private boolean is_Finished=false;

    private void load_IMG() {
        Sprite=LoadSave.load_IMG(LoadSave.JUMP_EFF);
    }
    private void load_Animation() {
        animation=new BufferedImage[4];
        for(int i=0;i<4;i++) {
            animation[i]=Sprite.getSubimage(i*DUST_WIDTH_IMG,0,DUST_WIDTH_IMG,DUST_HEIGHT_IMG);
        }
    }

    public void update_Animation() {
        tick++;
        if(tick>=animation_Speed) {
            tick=0;
            animation_Phase--;
            if(animation_Phase<=0) {
                animation_Phase=3;
                set_IsFinished(true);
            }
        }
    }

    public void paint_Animation(Graphics g) {
        if(get_IsFinished()) {
            g.drawImage(animation[animation_Phase], get_X(), get_Y(), DUST_REAL_WIDTH, DUST_REAL_HEIGHT, null);
        }
    }

    public void set_IsFinished(boolean val) {
        this.is_Finished=val;
    }
    public boolean get_IsFinished() {
        return this.is_Finished;
    }

    public void set_X(int val) {
        this.x=val;
    }
    public int get_X() {
        return this.x;
    }

    public void set_Y(int val) {
        this.y=val;
    }
    public int get_Y() {
        return this.y;
    }
}
