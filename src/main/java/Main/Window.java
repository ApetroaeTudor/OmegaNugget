package Main;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class Window extends JFrame {

    private Panel game_panel;
    private JFrame jframe;

    public void add_Panel(Panel PANEL) {
        this.jframe.setResizable(false);
        this.jframe.remove(game_panel);
        this.game_panel=PANEL;
        this.jframe.add(game_panel);
        jframe.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {

            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                System.out.println("hi");
                game_panel.getPlayer().set_MovingLeft(false);
                game_panel.getPlayer().set_MovingRight(false);
            }
        });
        this.jframe.pack();

        this.jframe.setVisible(true);
    }

    public Window(Panel panel) {

        this.game_panel=panel;
        this.jframe=new JFrame();
        this.jframe.setResizable(false);
        jframe.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {

            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                System.out.println("hi");
                game_panel.getPlayer().set_MovingLeft(false);
                game_panel.getPlayer().set_MovingRight(false);
            }
        });

        this.jframe.add(this.game_panel);
        this.jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.jframe.pack();
        this.jframe.setLocationRelativeTo(null);

        this.jframe.setVisible(true);
    }
}
