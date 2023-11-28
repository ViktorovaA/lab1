import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Canvas{
    private JFrame frame;
    figure.Circle circle;
    figure.Rectangle rectangle;
    private JPanel layout;
    private JPanel btnLayout;
    private JButton btnCreateRectangle, btnCreateCircle, btnDelete, btnMoveToRectangle, btnMoveToCircle,
            btnSetRectangleWidth, btnSetRectangleHeight, btnSetCircleRadius;

    public Canvas() {

        layout = new JPanel();
        layout.setLayout(new BorderLayout());

        btnLayout = new JPanel();
        btnLayout.setLayout(new FlowLayout());

        // создание кнопок
        btnCreateRectangle = new JButton("Создать прямоугольник");
        btnCreateCircle = new JButton("Создать круг");
        btnMoveToRectangle = new JButton("Move to rectangle");
        btnMoveToCircle = new JButton("Move to circle");
        btnDelete = new JButton("Delete");
        btnSetRectangleWidth = new JButton("Set width");
        btnSetRectangleHeight = new JButton("Set height");
        btnSetCircleRadius = new JButton("Set radius");

        //listener
        btnCreateRectangle.addActionListener(new BListener(this));
        btnCreateCircle.addActionListener(new BListener(this));
        btnMoveToRectangle.addActionListener(new BListener(this));
        btnMoveToCircle.addActionListener(new BListener(this));
        btnDelete.addActionListener(new BListener(this));
        btnSetRectangleWidth.addActionListener(new BListener(this));
        btnSetRectangleHeight.addActionListener(new BListener(this));
        btnSetCircleRadius.addActionListener(new BListener(this));

        //add
        btnLayout.add(btnCreateRectangle);
        btnLayout.add(btnCreateCircle);
        btnLayout.add(btnMoveToRectangle);
        btnLayout.add(btnMoveToCircle);
        btnLayout.add(btnSetRectangleWidth);
        btnLayout.add(btnSetRectangleHeight);
        btnLayout.add(btnSetCircleRadius);

        int width = 1000;
        int height = 500;

        frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.add(btnLayout, BorderLayout.NORTH);
        frame.add(layout, BorderLayout.CENTER);
        frame.setSize(width, height);
        frame.setLocation(300, 100);
        frame.setTitle("Drawing of figure");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        circle = null;
        rectangle = null;
    }

    class BListener implements ActionListener {
        Canvas canvas;
        public BListener(Canvas canvas){
            this.canvas = canvas;
        }
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnCreateRectangle) {
                if(rectangle != null) return;

                rectangle = new figure.Rectangle(400, 200, 100,50);
                canvas.layout.add(rectangle);
                canvas.layout.revalidate();
                canvas.layout.repaint();
            }
            if (e.getSource() == btnCreateCircle) {
                if(circle != null) return;

                circle = new figure.Circle(400, 250, 50);
                canvas.layout.add(circle);
                canvas.layout.revalidate();
                canvas.layout.repaint();
            }
            if (e.getSource() == btnMoveToRectangle) {
                if(rectangle == null) return;

                rectangle.moveTo((int) (Math.random() * 100) - 50, (int) (Math.random() * 100) - 50);
                canvas.layout.revalidate();
                canvas.layout.repaint();
            }
            if (e.getSource() == btnMoveToCircle) {
                if(circle == null) return;

                circle.moveTo((int) (Math.random() * 100) - 50, (int) (Math.random() * 100) - 50);
                canvas.layout.revalidate();
                canvas.layout.repaint();
            }
            if (e.getSource() == btnSetRectangleWidth) {
                if(rectangle == null) return;
                
                rectangle.setWidth((int) (Math.random() * 200));
                canvas.layout.revalidate();
                canvas.layout.repaint();
            }
            if (e.getSource() == btnSetRectangleHeight) {
                if(rectangle == null) return;

                rectangle.setHeight((int) (Math.random() * 200));
                canvas.layout.revalidate();
                canvas.layout.repaint();
            }
            if (e.getSource() == btnSetCircleRadius) {
                if(circle == null) return;

                circle.setRadius((int) (Math.random() * 100));
                canvas.layout.revalidate();
                canvas.layout.repaint();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Canvas::new);
    }
}