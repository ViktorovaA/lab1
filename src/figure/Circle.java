package figure;

import javax.swing.*;
import java.awt.*;

public class Circle extends JPanel {
    public int x, y, radius;
    public Color color;

    public Circle() {
        this.x = 0;
        this.y = 0;
        this.radius = 0;
        this.color = Color.BLACK;
    }
    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = Color.BLACK;
    }
    public void show() {
        this.repaint();
    }
    public void moveTo(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
    public void setRadius(int newRadius) {
        this.radius = newRadius;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.drawOval(x - radius, y - radius, radius * 2, radius * 2);
    }
}
