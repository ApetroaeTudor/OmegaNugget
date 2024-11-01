package Inputs;

import Actions.ButtonBehaviors.ButtonBehaviors;
import Entities.Player;
import Main.Game;
import Main.Panel;

import javax.swing.event.MouseInputListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import static Phases.Constants.*;

public class MouseInputs implements MouseInputListener, MouseMotionListener {

    private Panel game_panel;
    private Player game_player;

    public MouseInputs(Panel PANEL, Player PLAYER) {
        game_panel=PANEL;
        game_player=PLAYER;
    }

    @Override
    public void mousePressed(MouseEvent e) {

        switch(Game.getGameState()) {
            case PLAYING:
                ButtonBehaviors.OnPress_PLAYINGSTATEButtons_Behavior(game_panel);
                ButtonBehaviors.OnPress_Attack(game_panel);
                break;
            case CHOOSE_NAME:
                ButtonBehaviors.OnPress_CHOOSENAMESTATEButtons_Behavior(game_panel);
                break;
            case MAIN_MENU:
                ButtonBehaviors.OnPress_PlayButton_Behavior(game_panel.getMain_MenuPanel().getPlayButton(),game_panel);
                break;
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        switch (Game.getGameState()) {
            case PLAYING:
                ButtonBehaviors.ReleasePress_PLAYINGSTATEButtons_Behavior(game_panel);
                //ButtonBehaviors.ReleasePress_Attack(game_panel);
                break;
            case CHOOSE_NAME:
                ButtonBehaviors.ReleasePress_CHOOSENAMESTATEButtons_Behavior(game_panel);
                break;
            case MAIN_MENU:
                ButtonBehaviors.ReleasePress_PlayGameButton_Behavior(game_panel.getMain_MenuPanel().getPlayButton());
                break;
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {

        switch (Game.getGameState()) {
            case PLAYING:
                ButtonBehaviors.MouseMoved_PLAYINGSTATEButtons_Behavior(game_panel);
                break;
            case CHOOSE_NAME:
                ButtonBehaviors.MouseMoved_CHOOSENAMESTATEButtons_Behavior(game_panel);
                break;
            case MAIN_MENU:
                ButtonBehaviors.MouseMoved_PlayGameButton_Behavior(game_panel.getMain_MenuPanel().getPlayButton());
                break;
        }

        }

    @Override
    public void mouseClicked(MouseEvent e) {

    }
    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseExited(MouseEvent e) {

    }
    @Override
    public void mouseDragged(MouseEvent e) {

    }
    }

