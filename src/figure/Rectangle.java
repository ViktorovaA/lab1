package figure;

import java.awt.*;
import javax.swing.*;

/* прямоугольник */
public class Rectangle extends JPanel{
    public int x, y, width, height;
    public Color color;

    public Rectangle() {
        this.x = 0;
        this.y = 0;
        this.width = 0;
        this.height = 0;
        this.color = Color.BLUE;
    }
    public Rectangle(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.color = Color.BLUE;
    }
    public void show() {
        this.repaint();
    }
    public void moveTo(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
    public void setWidth(int newWidth) {
        this.width = newWidth;
    }
    public void setHeight(int newHeight) {
        this.height = newHeight;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.drawRect(x, y, width, height);
    }
}
