import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

public class ConnectPoints extends JFrame {

    //Variables final as they will not be changed
    private final JButton draw = new JButton("Draw Line");  //Create new button called draw
    private final CanvasPanel canvas = new CanvasPanel();   //Create new Canvas Panel from CanvasPanel class

    public ConnectPoints() {
        this.setSize(400, 400); //Set size of main window
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);   //Set program to close when GUI closes
    }

    public void init() {
        this.setLayout(null);

        canvas.setBounds(0, 0, 400, 300);   //Set Canvas to only take a portion of window
        canvas.setBorder(BorderFactory.createLineBorder(Color.BLACK));  //Add border to canvas
        this.add(canvas);   //Add canvas to window

        draw.setBounds(90, 305, 200, 50);   //Position draw button in main window
        draw.addActionListener(e -> repaint()); //When button clicked, repaint canvas.
        this.add(draw); //Add draw button to window.

        this.setVisible(true);
    }

}

class CanvasPanel extends JPanel implements MouseListener {

    //Variables final as they will not be changed
    private final int[] firstClickCoords = new int[]{0, 0};    //Int array containing coordinates of the location of first click
    private final int[] secondClickCoords = new int[]{0, 0};   //Int array containing coordinates of the location of second click
    private int clickCounter = 0;   //Create counter for number of clicks

    public CanvasPanel() {
        this.addMouseListener(this);    //Add mouse listener to canvas
    }

    @Override
    public void paintComponent(Graphics g) {
        //Paint a line between coordinates of first and second clicks
        g.drawLine(firstClickCoords[0], firstClickCoords[1], secondClickCoords[0], secondClickCoords[1]);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //If first click
        if (clickCounter == 0) {

            //Get coordinates of first click
            firstClickCoords[0] = e.getX();
            firstClickCoords[1] = e.getY();

            //Increment click counter
            clickCounter++;
            System.out.println("First click coords: " + Arrays.toString(firstClickCoords));
        }
        //If second click
        else if (clickCounter == 1) {
            //Get coordinates of second click
            secondClickCoords[0] = e.getX();
            secondClickCoords[1] = e.getY();

            //Increment click counter
            clickCounter++;
            System.out.println("Second click coords: " + Arrays.toString(secondClickCoords));
        }
        //Else reset counter
        else clickCounter = 0;

    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public static void main(String[] args) {
        new ConnectPoints().init();
    }
}