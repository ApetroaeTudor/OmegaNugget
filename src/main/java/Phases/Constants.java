package Phases;

public abstract class Constants {

    public static final int WINDOW_WIDTH=1920;
    public static final int WINDOW_HEIGHT=1080;
    public static final float SCALE=0.7f;
    public static final int WINDOW_REAL_WIDTH=(int)(WINDOW_WIDTH*SCALE);
    public static final int WINDOW_REAL_HEIGHT=(int)(WINDOW_HEIGHT*SCALE);

    public static final int DUST_WIDTH_IMG=994;
    public static final int DUST_HEIGHT_IMG=513;
    public static final float DUST_SCALE=SCALE*0.15f;
    public static final int DUST_REAL_WIDTH=(int)(DUST_WIDTH_IMG*DUST_SCALE);
    public static final int DUST_REAL_HEIGHT=(int)(DUST_HEIGHT_IMG*DUST_SCALE);

    public static final int JUMP_SPRITE_WIDTH_IMG=300;
    public static final int JUMP_SPRITE_HEIGHT_IMG=300;

    public static final int PLAYER_WIDTH_IMG=140;
    public static final int PLAYER_HEIGHT_IMG=230;
    public static final float PLAYER_SCALE=SCALE*0.6f;
    public static final int PLAYER_REAL_WIDTH=(int)(PLAYER_WIDTH_IMG*PLAYER_SCALE);
    public static final int PLAYER_REAL_HEIGHT=(int)(PLAYER_HEIGHT_IMG*PLAYER_SCALE);

    public static final int MUSHROOM_HEAD_IMG_WIDTH=84;
    public static final int MUSHROOM_HEAD_IMG_HEIGHT=11;
    public static final float MUSHROOM_SCALE=SCALE*6.1f;
    public static final int MUSHROOM_HEAD_REAL_WIDTH=(int)(MUSHROOM_HEAD_IMG_WIDTH*MUSHROOM_SCALE);
    public static final int MUSHROOM_HEAD_REAL_HEIGHT=(int)(MUSHROOM_HEAD_IMG_HEIGHT*MUSHROOM_SCALE);

    public static final int MUSHROOM_COL_IMG_HEIGHT=84;
    public static final int MUSHROOM_COL_IMG_WIDTH=21;
    public static final int MUSHROOM_COL_REAL_HEIGHT=(int)(MUSHROOM_COL_IMG_HEIGHT*MUSHROOM_SCALE);
    public static final int MUSHROOM_COL_REAL_WIDTH=(int)(MUSHROOM_COL_IMG_WIDTH*MUSHROOM_SCALE);

    public static final int DEATH_IMG_HEIGHT=1080;
    public static final int DEATH_IMG_WIDTH=1920;

    public static final int STARRY_SKY_IMG_HEIGHT=1920;
    public static final int STARRY_SKY_IMG_WIDTH=1920;

    //BUTTON IDS

    public static final int SHOW_HITBOXES_BUTTON_ID=-1;
    public static final int SET_NAME_BUTTON_ID=-2;
    public static final int ALPHANUM_BUTTON_ID=-3;
    public static final int GO_BACK_BUTTON_ID=-4;
    public static final int BACKSPACE_BUTTON_ID=-5;
    public static final int DONE_BUTTON_ID=-6;
    public static final int PLAY_BUTTON_ID=-7;
    //

    public static final int ALPHANUM_BUTTON_IMG_WIDTH=300;
    public static final int ALPHANUM_BUTTON_IMG_HEIGHT=300;
    public static final int ALPHANUM_BUTTON_REAL_WIDTH=(int)(ALPHANUM_BUTTON_IMG_WIDTH*0.15f);
    public static final int ALPHANUM_BUTTON_REAL_HEIGHT=(int)(ALPHANUM_BUTTON_IMG_HEIGHT*0.15f);
    public static final int ALPHANUM_BUTTON_OFFSET=(int)(ALPHANUM_BUTTON_REAL_WIDTH*0.5f);

    public static final int SHOW_HITBOXES_REAL_WIDTH=(int)(WINDOW_REAL_WIDTH*0.1f);
    public static final int SHOW_HITBOXES_REAL_HEIGHT=(int)(WINDOW_REAL_HEIGHT*0.027f);
    public static final int SET_NAME_REAL_WIDTH=(int)(SHOW_HITBOXES_REAL_WIDTH*0.7f);

    public static final int GO_BACK_BUTTON_IMG_WIDTH=437;
    public static final int GO_BACK_BUTTON_IMG_HEIGHT=106;
    public static final int GO_BACK_BUTTON_REAL_WIDTH=(int)(GO_BACK_BUTTON_IMG_WIDTH*0.5f);
    public static final int GO_BACK_BUTTON_REAL_HEIGHT=(int)(GO_BACK_BUTTON_IMG_HEIGHT*0.5f);

    public static final int BACKSPACE_BUTTON_IMG_WIDTH=230;
    public static final int BACKSPACE_BUTTON_IMG_HEIGHT=100;
    public static final int BACKSPACE_BUTTON_REAL_WIDTH=(int)(BACKSPACE_BUTTON_IMG_WIDTH*0.55f);
    public static final int BACKSPACE_BUTTON_REAL_HEIGHT=(int)(BACKSPACE_BUTTON_IMG_HEIGHT*0.5f);

    public static final int BORDER_IMG_WIDTH=370;
    public static final int BORDER_IMG_HEIGHT=196;
    public static final int BORDER_REAL_WIDTH=(int)(BORDER_IMG_WIDTH*1.8f);
    public static final int BORDER_REAL_HEIGHT=(int)(BORDER_IMG_HEIGHT*1.8f);

    public static final int CHOOSE_NAME_IMG_WIDTH=454;
    public static final int CHOOSE_NAME_IMG_HEIGHT=36;
    public static final int CHOOSE_NAME_REAL_WIDTH=(int)(CHOOSE_NAME_IMG_WIDTH*1.2f);
    public static final int CHOOSE_NAME_REAL_HEIGHT=(int)(CHOOSE_NAME_IMG_HEIGHT*1.2f);

    public static final int DONE_IMG_WIDTH=252;
    public static final int DONE_IMG_HEIGHT=90;
    public static final int DONE_REAL_WIDTH=(int)(DONE_IMG_WIDTH*0.4);
    public static final int DONE_REAL_HEIGHT=(int)(DONE_IMG_HEIGHT*0.4f);

    public static final int NAME_LINE_IMG_WIDTH=312;
    public static final int NAME_LINE_IMG_HEIGHT=25;
    public static final int NAME_LINE_REAL_WIDTH=(int)(NAME_LINE_IMG_WIDTH*1.3f);
    public static final int NAME_LINE_REAL_HEIGHT=(int)(NAME_LINE_IMG_HEIGHT*1.5f);

    public static final int MAIN_MENU_IMG_WIDTH=3900;
    public static final int MAIN_MENU_IMG_HEIGHT=390;
    public static final int MAIN_MENU_IMG_TILE_WIDTH=780;

    public static final int MENU_PANEL_IMG_WIDTH=266;
    public static final int MENU_PANEL_IMG_HEIGHT=287;
    public static final int MENU_PANEL_REAL_WIDTH=(int)(MENU_PANEL_IMG_WIDTH*2.2f);
    public static final int MENU_PANEL_REAL_HEIGHT=(int)(MENU_PANEL_IMG_HEIGHT*2.2f);

    public static final int PLAY_BUTTON_IMG_HEIGHT=216;
    public static final int PLAY_BUTTON_IMG_WIDTH=216;
    public static final int PLAY_BUTTON_REAL_HEIGHT=(int)(PLAY_BUTTON_IMG_HEIGHT*1f);
    public static final int PLAY_BUTTON_REAL_WIDTH=(int)(PLAY_BUTTON_IMG_WIDTH*1f);

    public static final int SWORD_SWING_IMG_WIDTH=35;
    public static final int SWORD_SWING_IMG_HEIGHT=35;
    public static final int SWORD_SWING_REAL_WIDTH=(int)(SWORD_SWING_IMG_WIDTH*3f);
    public static final int SWORD_SWING_REAL_HEIGHT=(int)(SWORD_SWING_IMG_HEIGHT*3f);

    public static final int ENEMY_IMG_WIDTH=679;
    public static final int ENEMY_IMG_HEIGHT=1160;
    public static final int ENEMY_REAL_WIDTH=(int)(ENEMY_IMG_WIDTH*0.07f);
    public static final int ENEMY_REAL_HEIGHT=(int)(ENEMY_IMG_HEIGHT*0.07f);

    public static final int ENEMY_SHEET_INDIVIDUAL_IMG_WIDTH=1632;
    public static final int ENEMY_SHEET_INDIVIDUAL_IMG_HEIGHT=1526;
    public static final int ENEMY_DEATH_REAL_WIDTH=(int)(ENEMY_SHEET_INDIVIDUAL_IMG_WIDTH*0.08f);
    public static final int ENEMY_DEATH_REAL_HEIGHT=(int)(ENEMY_SHEET_INDIVIDUAL_IMG_HEIGHT*0.08f);

    public static final int EXPLOSION_IMG_WIDTH=70;
    public static final int EXPLOSION_IMG_HEIGHT=85;
    public static final int EXPLOSION_REAL_WIDTH=(int)(EXPLOSION_IMG_WIDTH*3f);
    public static final int EXPLOSION_REAL_HEIGHT=(int)(EXPLOSION_IMG_HEIGHT*3f);

    public static final int PLAYING=10;
    public static final int PAUSED=11;
    public static final int CHOOSE_NAME=12;
    public static final int MAIN_MENU=13;

    public static final int BG_SHEET_WIDTH=1440;
    public static final int BG_SHEET_HEIGHT=216;
    public static final int BG_SHEET_TILE_WIDTH=480;
    public static final int BG_REAL_WIDTH=WINDOW_REAL_WIDTH;
    public static final int BG_REAL_HEIGHT=WINDOW_REAL_HEIGHT;

    public static final int DONUT_IMG_WIDTH=82;
    public static final int DONUT_IMG_HEIGHT=64;
    public static final int DONUT_REAL_WIDTH=(int)(DONUT_IMG_WIDTH*1f);
    public static final int DONUT_REAL_HEIGHT=(int)(DONUT_IMG_HEIGHT*1f);

    public static final int YOU_WIN_IMG_WIDTH=1920;
    public static final int YOU_WIN_IMG_HEIGHT=1080;


    public static final int BASE=0;
    public static final int JUMP=1;
    public static final int ATTACK_SWORD=2;
    public static final int ANGER=3;
    public static final int FALLING=4;
    public static final int JUMPING=5;
    public static final int DEAD=6;
    public static final int WON=7;

    public static int get_nrFrames(int state) {
        switch(state) {
            case BASE:
                return 38;
            case JUMP:
                return 10;
            case ATTACK_SWORD:
                return 5;
            case ANGER:
                return 38;
            case FALLING:
                return 38;
            case JUMPING:
                return 31;
            case DEAD:
                return 31;
            default:
                return 0;
        }
    }
}
