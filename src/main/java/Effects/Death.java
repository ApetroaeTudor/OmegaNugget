package Effects;

import Entities.Entity;
import LoadSave.LoadSave;
import Main.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

import static Phases.Constants.*;

public class Death extends Entity {

    private BufferedImage Sprite;
    private BufferedImage[] animation;
    private Game game;
    private boolean fin=false;

    private int animation_Speed=10;
    private int tick=0;
    private int animation_Phase=-1;

    public Death(int _x, int _y, Game GAME) {
        super();
        this.set_X(_x);
        this.set_Y(_y);
        Load_IMG();
        animation=new BufferedImage[11];
        load_Animation();
        game=GAME;
    }

    public void update_Animation() {

            if(animation_Phase<0) {
                animation_Phase=0;
            }
            tick++;
            if (tick >= animation_Speed) {
                tick = 0;
                animation_Phase++;
                if (animation_Phase >= 11) {
                    fin = true;
                    game.set_isRunning(false);
                }
            }
    }



    private void Load_IMG() {
        Sprite=LoadSave.load_IMG(LoadSave.DEATH);
    }
    private void load_Animation() {
        for(int i=0;i<11;i++) {
            animation[i]=Sprite.getSubimage(i*DEATH_IMG_WIDTH,0,DEATH_IMG_WIDTH,DEATH_IMG_HEIGHT);
        }
    }

    public void paint_Animation(Graphics g) {

        if(!fin && animation_Phase>0) {
            g.drawImage(animation[animation_Phase],0,0,WINDOW_REAL_WIDTH,WINDOW_REAL_HEIGHT,null);
        }
    }
}
