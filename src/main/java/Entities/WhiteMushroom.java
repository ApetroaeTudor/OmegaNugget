package Entities;

import LoadSave.LoadSave;
import java.awt.*;
import java.awt.image.BufferedImage;
import static Phases.Constants.*;

public class WhiteMushroom extends Entity {

    private BufferedImage c1;
    private BufferedImage mushroom_Head;


    public WhiteMushroom(int _x, int _y) {
        super();
        this.set_X(_x);
        this.set_Y(_y);
        Load_Column();
        Load_Head();
    }

    public void print_Mush(Graphics g) {
        g.drawImage(mushroom_Head,x,y,MUSHROOM_HEAD_REAL_WIDTH,MUSHROOM_HEAD_REAL_HEIGHT,null);
        g.drawImage(c1,(int)(get_X()+MUSHROOM_HEAD_REAL_WIDTH*0.4f),get_Y()+MUSHROOM_HEAD_REAL_HEIGHT,MUSHROOM_COL_REAL_WIDTH,MUSHROOM_COL_REAL_HEIGHT,null);
    }

    private void Load_Head() {
        mushroom_Head=LoadSave.load_IMG(LoadSave.WHITE_MUSH_HEAD);
    }

    private void Load_Column() {
        this.c1=LoadSave.load_IMG(LoadSave.MUSH_C1);
    }
}
