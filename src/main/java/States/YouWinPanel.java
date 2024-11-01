package States;

import LoadSave.LoadSave;
import Main.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

import static Phases.Constants.*;

public class YouWinPanel {
    private BufferedImage Sprite_Sheet;
    private BufferedImage[] Animation;
    private int tick=0;
    private int animation_Phase=0;
    private int animation_Speed=30;
    private Main.Panel game_panel;

    public YouWinPanel(Main.Panel PANEL) {
        game_panel=PANEL;
        Sprite_Sheet=LoadSave.load_IMG(LoadSave.YOU_WIN);
        make_Animation();
    }
    private void make_Animation() {
        Animation=new BufferedImage[4];
        for(int i=0;i<4;i++) {
            Animation[i]=Sprite_Sheet.getSubimage(i*YOU_WIN_IMG_WIDTH,0,YOU_WIN_IMG_WIDTH,YOU_WIN_IMG_HEIGHT);
        }
    }
    public void update_Animation() {
        tick++;
        if(tick>=animation_Speed) {
            tick=0;
            animation_Phase++;
            if(animation_Phase>=4) {
                animation_Phase=0;
                Game.set_isRunning(false);
            }
        }
    }
    public void print_YouWin(Graphics g) {
        g.drawImage(Animation[animation_Phase],0,0,WINDOW_REAL_WIDTH,WINDOW_REAL_HEIGHT,null);
    }
}
