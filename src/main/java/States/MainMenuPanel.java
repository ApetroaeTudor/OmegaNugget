package States;

import Buttons.LevelButton;
import LoadSave.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

import static Phases.Constants.*;

public class MainMenuPanel {
    private BufferedImage Sprite;
    private int tick;
    private int Scroll_Speed=6;
    private BufferedImage Current_Sprite;
    private BufferedImage Menu_panel;

    private Main.Panel game_panel;

    private BufferedImage PlayButtonNeutral;
    private BufferedImage PlayButtonHovered;


    private LevelButton PlayButton;

    private int currentX_inScroll=0;

    public MainMenuPanel(Main.Panel PANEL) {
        game_panel=PANEL;
        PlayButtonNeutral=LoadSave.load_IMG(LoadSave.PLAY_BUTTON_NEUTRAL);
        PlayButtonHovered=LoadSave.load_IMG(LoadSave.PLAY_BUTTON_HOVERED);
        PlayButton=new LevelButton(LoadSave.PLAY_BUTTON_NEUTRAL,LoadSave.PLAY_BUTTON_HOVERED,LoadSave.PLAY_BUTTON_HOVERED,game_panel,(int)(WINDOW_REAL_WIDTH*0.43f),(int)(WINDOW_REAL_HEIGHT*0.5f),PLAY_BUTTON_REAL_WIDTH,PLAY_BUTTON_REAL_HEIGHT,PLAY_BUTTON_ID);
        Sprite=LoadSave.load_IMG(LoadSave.MAIN_MENU_BG);
        Current_Sprite=Sprite.getSubimage(0,0,MAIN_MENU_IMG_TILE_WIDTH,MAIN_MENU_IMG_HEIGHT);
        Menu_panel=LoadSave.load_IMG(LoadSave.MENU_PANEL);

    }

    public void update_Menu() {
        tick++;
        if(tick>= Scroll_Speed) {
            tick=0;
            currentX_inScroll+=2;
            if(currentX_inScroll>=MAIN_MENU_IMG_WIDTH-MAIN_MENU_IMG_TILE_WIDTH) {
                currentX_inScroll=0;
            }
            Current_Sprite=Sprite.getSubimage(currentX_inScroll,0,MAIN_MENU_IMG_TILE_WIDTH,MAIN_MENU_IMG_HEIGHT);
        }
    }

    public void paint_Menu(Graphics g) {
        g.drawImage(Current_Sprite,0,0,WINDOW_REAL_WIDTH,WINDOW_REAL_HEIGHT,null);
        g.drawImage(Menu_panel,(int)(WINDOW_REAL_WIDTH*0.29f),(int)(WINDOW_HEIGHT*0.04f),MENU_PANEL_REAL_WIDTH,MENU_PANEL_REAL_HEIGHT,null );
        getPlayButton().paint_Button(g);

    }

    public LevelButton getPlayButton() {
        return PlayButton;
    }
    public Main.Panel getGame_panel() {
        return game_panel;
    }


}
