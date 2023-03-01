
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
/**
 * This class makes use of "Actionlistener" which is responsible
 * for handling all of the keys presses that the user press such as using
 * one of the in-game components.
 */
public class TheGame implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent arg0) {
        try {
            if (input.isKeyDown(KeyEvent.VK_W)) {
                GameActions.moveEevee(0, -1); //Up
                GameActions.getEevee().setDirection(Direction.Forward);
            } else if (input.isKeyDown(KeyEvent.VK_A)) {
                GameActions.moveEevee(-1, 0); //Left
                GameActions.getEevee().setDirection(Direction.Left);
            } else if (input.isKeyDown(KeyEvent.VK_S)) {
                GameActions.moveEevee(0, 1); //Down
                GameActions.getEevee().setDirection(Direction.Back);
            } else if (input.isKeyDown(KeyEvent.VK_D)) {
                GameActions.moveEevee(1, 0); //Right
                GameActions.getEevee().setDirection(Direction.Right);
            } else if (input.isKeyDown(KeyEvent.VK_H)) {
                GameActions.getEevee().usePotion();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }

    }


}
