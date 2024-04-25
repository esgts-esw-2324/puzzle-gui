package pt.brunojesus.puzzle;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Listens to KeyPresses in the window.
 * <br>
 * Reacts to W, A, S, D and calls the action to refresh the {@link GameWindow}
 *
 * @author Bruno Jesus
 * @version 1.0
 * @since 1.0
 */
public class GameWindowKeyListener extends KeyAdapter {

    private final JFrame parentFrame;
    private final IBoard board;
    private final Runnable refreshCallback;

    /**
     * The {@link GameWindowKeyListener} constructor
     * <br>
     *
     * @param parentFrame     the {@link GameWindow}
     * @param board           the {@link IBoard}
     * @param refreshCallback the action to refresh the {@link GameWindow}
     */
    public GameWindowKeyListener(JFrame parentFrame, IBoard board, Runnable refreshCallback) {
        this.parentFrame = parentFrame;
        this.board = board;
        this.refreshCallback = refreshCallback;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        final PlayDirection direction;
        switch (e.getKeyChar()) {
            case 'w' -> direction = PlayDirection.UP;
            case 's' -> direction = PlayDirection.DOWN;
            case 'a' -> direction = PlayDirection.LEFT;
            case 'd' -> direction = PlayDirection.RIGHT;
            default -> direction = null;
        }

        if (direction == null) {
            JOptionPane.showMessageDialog(parentFrame, "Please use W,A,S,D keys.");
        } else {
            try {
                this.board.play(direction);
                this.refreshCallback.run();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(parentFrame, ex.getMessage());
            }
        }
    }
}
