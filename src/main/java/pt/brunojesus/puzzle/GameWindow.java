package pt.brunojesus.puzzle;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicBorders;

/**
 * The GameWindow that lets users play the game.
 * Requires a system capable of rendering a Java swing window.
 * <br>
 * Check {@link IBoard} for more information about the game implementation.
 *
 * @author Bruno Jesus
 * @since 1.0
 * @version 1.0
 */
public class GameWindow {

    JFrame frame = new JFrame();
    JButton[][] buttons;
    IBoard board;

    /**
     * Instantiates a new game window.
     *
     * @param title the window title
     * @param board the board implementation
     */
    public GameWindow(String title, IBoard board) {
        this.board = board;
        this.buttons = new JButton[board.getSize()][board.getSize()];
        this.initWindow(title);
    }

    private void initWindow(String title) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setTitle(title);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.addKeyListener(new GameWindowKeyListener(frame, board, () -> {
            for (int x = 0; x < this.board.getSize(); x++) {
                for (int y = 0; y < this.board.getSize(); y++) {
                    buttons[x][y].setText(this.board.getItemInPosition(x,y));
                }
            }
        }));

        JPanel titlePanel = new JPanel();
        JPanel btnPanel = new JPanel();

        JLabel titleLabel = new JLabel();
        titleLabel.setFont(new Font("Arial", Font.BOLD, 60));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setOpaque(true);
        titleLabel.setText(title);
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 400, 100);
        btnPanel.setLayout(new GridLayout(3, 3));// setting layout of bt_pannel as gridlayout
        for (int x = 0; x < this.board.getSize(); x++) {
            for (int y = 0; y < this.board.getSize(); y++) {
                JButton btn = createButton(btnPanel);
                btn.setText(this.board.getItemInPosition(x,y));
                buttons[x][y] = btn;
            }
        }

        titlePanel.add(titleLabel);
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(btnPanel);
    }

    private JButton createButton(JPanel panel) {
        JButton btn = new JButton();
        panel.add(btn);
        btn.setBackground(Color.WHITE);
        btn.setBorder(BasicBorders.getInternalFrameBorder());
        btn.setFont(new Font("Arial", Font.BOLD, 80));
        btn.setFocusable(false);
        return btn;
    }
}
