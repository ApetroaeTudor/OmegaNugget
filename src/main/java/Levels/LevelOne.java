package Levels;

import Buttons.Button;
import Buttons.LevelButton;
import Entities.*;
import Hitboxes.Hitbox;
import java.awt.*;
import java.util.ArrayList;
import Main.Panel;
import static LoadSave.LoadSave.*;
import static Phases.Constants.*;

public class LevelOne {

    public LevelOne(Panel PANEL) {
        game_panel=PANEL;
        bg=new Background(0,0);
        wm=new WhiteMushroom(wm_X,wm_Y);
        rm=new RedMushroom(rm_X,rm_Y);

        DONUT=new Donut(DONUT_X,DONUT_Y,DONUT_REAL_WIDTH,DONUT_REAL_HEIGHT,game_panel);



        BUTTONS=new ArrayList<Button>();
        int button_HitboxesX=(int)(WINDOW_REAL_WIDTH*0.87f);
        int button_HitboxesY=(int)(WINDOW_HEIGHT*0.05f);

        hitbox_Button=new LevelButton(SHOW_HITBOXES_PASSIVE,SHOW_HITBOXES_HOVER,SHOW_HITBOXES_CLICKED,getGame_panel(),button_HitboxesX,button_HitboxesY,SHOW_HITBOXES_REAL_WIDTH,SHOW_HITBOXES_REAL_HEIGHT,SHOW_HITBOXES_BUTTON_ID);
        BUTTONS.add(hitbox_Button);

        setname_Button=new LevelButton(SET_NAME_PASSIVE,SET_NAME_HOVER,SET_NAME_CLICKED,getGame_panel(),button_HitboxesX,(int)(button_HitboxesY*1.55f),SET_NAME_REAL_WIDTH,SHOW_HITBOXES_REAL_HEIGHT,SET_NAME_BUTTON_ID);
        BUTTONS.add(setname_Button);

        make_HitboxesArrList();
    }

    private Panel game_panel;
    private Background bg;
    private WhiteMushroom wm;
    private RedMushroom rm;

    private Donut DONUT;

    private int rm_X=(int)(WINDOW_REAL_WIDTH*0.4f);
    private int rm_Y=(int)(WINDOW_REAL_HEIGHT*0.6f );

    private int wm_X=(int)(WINDOW_REAL_WIDTH*0.05f);
    private int wm_Y=(int)(WINDOW_REAL_HEIGHT*0.5f);

    private int DONUT_X=(int)(WINDOW_REAL_WIDTH*0.74f);
    private int DONUT_Y=(int)(WINDOW_REAL_HEIGHT*0.4f);

    private LevelButton hitbox_Button;
    private LevelButton setname_Button;


    private ArrayList<Hitbox> HITBOXES;
    private ArrayList<Button> BUTTONS;

    public void paint_Level(Graphics g) {
        bg.paint_BG(g);
        wm.print_Mush(g);
        rm.print_Mush(g);
        DONUT.print_Donut(g);

        for(Button b:getBUTTONS()) {
            b.paint_Button(g);
        }

    }

    public void make_HitboxesArrList() {
        HITBOXES=new ArrayList<Hitbox>();
        add_toHitboxArrList(HITBOXES,wm,MUSHROOM_HEAD_REAL_WIDTH,MUSHROOM_HEAD_REAL_HEIGHT);
        add_toHitboxArrList(HITBOXES,rm,MUSHROOM_HEAD_REAL_WIDTH,MUSHROOM_HEAD_REAL_HEIGHT);
        HITBOXES.add(hitbox_Button.get_PersonalHitbox());
        HITBOXES.add(setname_Button.get_PersonalHitbox());
    }

    public void add_toHitboxArrList(ArrayList<Hitbox> hitboxes, Entity obj, int len, int hei) {
        Hitbox temp=new Hitbox(obj.get_X(),obj.get_Y(),len,hei);
        hitboxes.add(temp);
    }

    public ArrayList<Hitbox> get_HitboxArr() {
        return HITBOXES;
    }
    public Panel getGame_panel() {
        return game_panel;
    }
    public ArrayList<Button> getBUTTONS() {
        return BUTTONS;
    }

    public Background getBg() {
        return bg;
    }

    public Donut getDONUT() {
        return DONUT;
    }

}
