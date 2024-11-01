package Entities;

import Effects.Explosion;
import Hitboxes.Hitbox;
import LoadSave.LoadSave;
import Main.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

import static Phases.Constants.*;

public class Enemy extends Entity{
    private BufferedImage Sprite;
    private BufferedImage Death_Sprite;
    private BufferedImage[] Death_Animation;
    private Hitbox private_Hitbox;
    private int wid,hei;
    private int relx,rely;
    private int tick=0;
    private int animation_Phase=0;
    private int animation_Speed=10;
    private boolean is_Dead=false;
    private Main.Panel game_panel;
    private int direction=-1;
    private boolean finished_animation=false;
    private boolean checked_ifDead=false;

    private Explosion explosion;

    public Enemy(int X,int Y,int WID,int HEI, Main.Panel PANEL) {
        super();
        game_panel=PANEL;
        this.x=X;
        this.y=Y;
        this.wid=WID;
        this.hei=HEI;
        this.relx=x+wid;
        this.rely=y+hei;
        Sprite=LoadSave.load_IMG(LoadSave.ENEMY_SPRITE);
        Death_Sprite=LoadSave.load_IMG(LoadSave.ENEMY_SPRITE_SHEET);
        explosion=new Explosion(getx(),gety(),EXPLOSION_REAL_WIDTH,EXPLOSION_REAL_HEIGHT,game_panel);
        make_DeathAnimation();
    }

    private void check_IsDeadByAttack() {
        if(game_panel.getPlayer().getSword_Attack()!=null && !checked_ifDead) {
            if (game_panel.getPlayer().getSword_Attack().getCurrent_PersonalHitbox() != null){
                if (Hitbox.check_Collision2Hitboxes(private_Hitbox, game_panel.getPlayer().getSword_Attack().getCurrent_PersonalHitbox())) {
                    explosion.initialize_Explosion();
                    is_Dead = true;
                    checked_ifDead=true;
                }
        }
        }
    }

    private void make_DeathAnimation() {
        Death_Animation=new BufferedImage[8];
        for(int i=0;i<8;i++) {
            Death_Animation[i]=Death_Sprite.getSubimage(i*ENEMY_SHEET_INDIVIDUAL_IMG_WIDTH,0,ENEMY_SHEET_INDIVIDUAL_IMG_WIDTH,ENEMY_SHEET_INDIVIDUAL_IMG_HEIGHT);
        }
    }

    private void update_RoamingPosition() {
        if(!game_panel.getPlayer().is_Dead()) {
            for (Hitbox i : getGame_panel().getLevel().get_HitboxArr()) {
                if ((getx() >= i.get_x() && get_relX() <= i.get_relX()) && (get_relY() == i.get_y() + (int) ((i.get_relY() - i.get_y()) / 2f))) {
                    setx(get_X() + direction);
                } else if (get_relY() < i.get_y() + (int) ((i.get_relY() - i.get_y()) / 2f)) {
                    sety(get_Y() + 1);
                }
                if (getx() == i.get_x()) {
                    direction *= (-1);
                }
                if (get_relX() == i.get_relX()) {
                    direction *= (-1);
                }
            }
        }
    }

    private void update_CatDeathAnimation() {
        if(is_Dead) {
            tick++;
            if (tick >= animation_Speed) {
                tick = 0;
                animation_Phase++;
                if (animation_Phase >= 8) {
                    animation_Phase = 0;
                }
            }
        }
    }

    public void update_Enemy() {
        check_IsDeadByAttack();
        update_RoamingPosition();
        make_privateHitbox();
        update_CatDeathAnimation();
        if(is_Dead) {
            explosion.update_ExplosionAnimation();
        }

    }

    public void draw_Enemy(Graphics g) {
        if(!is_Dead && !is_OutsideWindow()) {
            g.drawImage(Sprite, getx(), gety(), get_Width(), get_Height(), null);
        }
        else if(!is_OutsideWindow()) {
            g.drawImage(Death_Animation[animation_Phase],getx(),gety(),ENEMY_DEATH_REAL_WIDTH,ENEMY_DEATH_REAL_HEIGHT,null );

            if(!explosion.getStarted()) {
                explosion.setx(getx());
                explosion.sety(gety()-(int)(ENEMY_REAL_HEIGHT*0.2f));
                explosion.setStarted(true);
            }
            explosion.print_Explosion(g);

            setx(getx()+(int)(animation_Phase*0.05f*ENEMY_DEATH_REAL_WIDTH));
            sety(gety()-(int)(animation_Phase*0.03f*ENEMY_DEATH_REAL_HEIGHT));
            if(explosion.get_didExplode()) {
                explosion.setStarted(false);
            }
        }
        else {
            explosion.setStarted(false);
            set_IsDead(false);
            setx(-100);
            sety(-100);
        }

    }

    public boolean is_OutsideWindow() {
        if(getx()-wid<=0 || getx()>=WINDOW_REAL_WIDTH) {
            return true;
        }
        if(gety()>=WINDOW_REAL_HEIGHT || gety()-hei<=0) {
            return true;
        }
        return false;
    }

    private void make_privateHitbox() {
        private_Hitbox=new Hitbox(getx(),(int)(gety()*1.05f),get_Width(),(int)(get_Height()*0.9f) );
    }

    public void print_privateHitbox(Graphics g) {
        if(Game.get_PrintFlag() && !is_Dead && !is_OutsideWindow()) {
            g.setColor(Color.red);
            g.drawRect(getPrivate_Hitbox().get_x(),getPrivate_Hitbox().get_y(),get_Width(),(int)(get_Height()*0.9f) );
        }
    }


    public boolean get_IsDead(){
        return is_Dead;
    }
    public void set_IsDead(boolean val) {
        is_Dead=val;
    }

    public Hitbox getPrivate_Hitbox() {
        return private_Hitbox;
    }

    public Main.Panel getGame_panel() {
        return game_panel;
    }
    public int get_relX() {
        return relx;
    }
    public int get_relY() {
        return rely;
    }
    public void setx(int val) {
        this.x=val;
        this.relx=x+wid;
    }
    public int getx() {
        return x;
    }
    public void sety(int val) {
        this.y=val;
        this.rely=y+hei;
    }
    public int gety() {
        return y;
    }
    public void set_Width(int val) {
        this.wid=val;
        this.relx=x+wid;
    }
    public int get_Width() {
        return this.wid;
    }
    public void set_Height(int val) {
        this.hei=val;
        this.rely = y+val;
    }
    public int get_Height() {
        return this.hei;
    }



}
