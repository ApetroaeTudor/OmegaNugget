package Entities;

import LoadSave.LoadSave;
import java.awt.*;
import java.awt.image.BufferedImage;
import static Phases.Constants.*;

public class Background extends Entity{


    private BufferedImage bg;
    private BufferedImage temp;
    private int tick=0;
    private int Scroll_Speed=13;

    private int currentX_inScoll=0;

    public Background(int _x, int _y) {
        super();
        this.set_X(_x);
        this.set_Y(_y);
        bg=LoadSave.load_IMG(LoadSave.BGSHEET);
        temp=bg.getSubimage(0,0,BG_SHEET_TILE_WIDTH,BG_SHEET_HEIGHT);
    }

    public void update_bg() {
        tick++;
        if(tick>=Scroll_Speed) {
            tick=0;
            currentX_inScoll+=1;
            if(currentX_inScoll>=BG_SHEET_WIDTH-BG_SHEET_TILE_WIDTH) {
                currentX_inScoll=0;
            }
            temp=bg.getSubimage(currentX_inScoll,0,BG_SHEET_TILE_WIDTH,BG_SHEET_HEIGHT);
        }
    }

    public void paint_BG(Graphics g) {
        g.drawImage(temp,0,0,WINDOW_REAL_WIDTH,WINDOW_REAL_HEIGHT,null);
    }
}
