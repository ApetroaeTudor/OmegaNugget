package Inputs;

import Entities.Player;
import Main.Game;
import Main.Panel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static Phases.Constants.*;

public class KeyboardInputs implements KeyListener {

    private Panel game_panel;
    private Player game_player;

    public KeyboardInputs(Panel panel, Player player) {

        this.game_panel=panel;
        this.game_player=player;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_A:
                    game_player.set_MovingLeft(true);
                    game_player.set_lastDiretion(-1);
                break;
            case KeyEvent.VK_D:
                    game_player.set_MovingRight(true);
                    game_player.set_lastDiretion(1);
                break;
            case KeyEvent.VK_SPACE:
                System.out.println("jump!");
                if(game_player.check_IfCanJump()) {
                    game_player.getJump().get_Dust().set_X(game_player.get_X());
                    game_player.getJump().get_Dust().set_Y(game_player.get_RelY()-PLAYER_REAL_HEIGHT/3);
                    game_player.getJump().set_IsJumping(true);
                    game_player.getJump().set_JumpInitTime(System.currentTimeMillis());
                }
                break;
            case KeyEvent.VK_ESCAPE:
                if(Game.getGameState()==PLAYING) {
                    Game.setGameState(MAIN_MENU);
                }
                if(Game.getGameState()==CHOOSE_NAME) {
                    Game.setGameState(PLAYING);
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_A:
                game_player.set_MovingLeft(false);
                break;
            case KeyEvent.VK_D:
                game_player.set_MovingRight(false);
                break;
            case KeyEvent.VK_SPACE:
                game_player.getJump().set_IsJumping(false);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
