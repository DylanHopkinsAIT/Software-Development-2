import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;

public class MoveCircle extends JFrame {

    //Create Canvas Panel to add to JFrame
    private final CanvasPanel canvas = new CanvasPanel();

    public MoveCircle() {
        this.setTitle("Move Circle");
        this.setSize(600, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void init() {
        this.setLayout(null);

        //Set canvas bounds to that of JFrame
        canvas.setBounds(0, 0, getSize().width, getSize().height);

        //Add Border to canvas because I like how it looks
        canvas.setBorder(BorderFactory.createLineBorder(Color.RED));

        //Add canvas to JFrame
        this.add(canvas);

        this.setVisible(true);

    }

}

class CanvasPanel extends JPanel implements ActionListener, KeyListener {
    Timer t = new Timer(5, this); //Create a timer to refresh every 5ms
    double x = 0, y = 0, velX = 0, velY = 0;


    public CanvasPanel() {
        //Start timer
        t.start();

        //Add Key listener
        addKeyListener(this);

        //Allow window to be focused, as key listener requires this
        this.setFocusable(true);

        //Disable key combinations or function keys
        setFocusTraversalKeysEnabled(false);
    }

    /**
     * Method to Move Circle Up
     */
    public void up() {
        velY = -1.5;
        velX = 0;
    }

    /**
     * Method to Move Circle Down
     */
    public void down() {
        velY = 1.5;
        velX = 0;
    }

    /**
     * Method to Move Circle Left
     */
    public void left() {
        velX = -1.5;
        velY = 0;
    }

    /**
     * Method to Move Circle Right
     */
    public void right() {
        velX = 1.5;
        velY = 0;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        //Make graphics pink
        g2d.setColor(Color.PINK);

        //Fill graphics with circle
        g2d.fill(new Ellipse2D.Double(x, y, 40, 40));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Refresh Canvas
        repaint();

        //Set Circle direction to that decided by methods
        x += velX;
        y += velY;
    }

    @Override
    public void keyPressed(KeyEvent e) {

        //Store Key Code in variable to avoid repeated access
        int keyCode = e.getKeyCode();

        //If W is pressed
        if (keyCode == KeyEvent.VK_W) {
            up();
            System.out.println("UP");
        }

        //If S is pressed
        if (keyCode == KeyEvent.VK_S) {
            down();
            System.out.println("DOWN");
        }

        //If A is pressed
        if (keyCode == KeyEvent.VK_A) {
            left();
            System.out.println("LEFT");
        }

        //If D is pressed
        if (keyCode == KeyEvent.VK_D) {
            right();
            System.out.println("RIGHT");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public static void main(String[] args) {
        new MoveCircle().init();
    }
}
