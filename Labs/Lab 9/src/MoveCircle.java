import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MoveCircle extends JFrame{

    private CanvasPanel canvas = new CanvasPanel();

    public MoveCircle(){
        this.setSize(600,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void init(){
        this.setLayout(null);

        canvas.setBounds(0,0,600,600);
        canvas.setBorder(BorderFactory.createLineBorder(Color.RED));
        this.add(canvas);

        this.setVisible(true);

    }

}

class CanvasPanel extends JPanel implements KeyListener {

    public CanvasPanel() {
        addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        new MoveCircle().init();
    }
}
