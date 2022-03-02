import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class DropRandomShapes extends JFrame {

    private final CanvasPanel canvas = new CanvasPanel();

    public DropRandomShapes()
    {
        this.setSize(400, 400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void init()
    {
        this.add(canvas);
        canvas.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setVisible(true);
    }

    class CanvasPanel extends JPanel implements MouseListener
    {
        //private final Rectangle2D rectangle = new Rectangle2D.Double(100,100,50,50);
        //private final Rectangle2D square = new Rectangle2D.Double(100,100,100,100);
        //private final Ellipse2D circle = new Ellipse2D.Double(100,100,50,50);
        //private final Ellipse2D ellipse = new Ellipse2D.Double(100,100,50,25);

        private int ranColorNum, ranShapeNum;

        private final Color [] colors = {Color.BLUE, Color.RED, Color.GREEN};
        Random random = new Random();



        public CanvasPanel(){
            this.addMouseListener(this);
        }

        @Override
        public void paintComponent(Graphics g) {
            switch (ranShapeNum){
                case 0:
                    g.setColor(colors[ranColorNum]);
                    g.fillRect(100,100,50,50);
                    g.drawRect(100,100,50,50);
                    break;
                case 1:
                    g.setColor(colors[ranColorNum]);
                    g.fillRect(100,100,100,100);
                    g.drawRect(100,100,100,100);
                    break;
                case 2:
                    g.setColor(colors[ranColorNum]);
                    g.fillOval(100,100,50,50);
                    g.drawOval(100,100,50,50);
                    break;
                default:
                    g.setColor(colors[ranColorNum]);
                    g.fillOval(100,100,50,25);
                    g.drawOval(100,100,50,25);
                    break;
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {}

        @Override
        public void mousePressed(MouseEvent e) {
            ranColorNum = random.nextInt(3);
            ranShapeNum = random.nextInt(4);

            System.out.println(ranColorNum);
            System.out.println(ranShapeNum);

            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}

    }

    public static void main(String[] args) {
        new DropRandomShapes().init();
    }
}