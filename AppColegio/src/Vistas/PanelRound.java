package Vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;

public class PanelRound extends JPanel {
    private int topLeftRadius;
    private int topRightRadius;
    private int bottomLeftRadius;
    private int bottomRightRadius;

    public PanelRound(int topLeftRadius, int topRightRadius, int bottomLeftRadius, int bottomRightRadius) {
        super();
        this.topLeftRadius = topLeftRadius;
        this.topRightRadius = topRightRadius;
        this.bottomLeftRadius = bottomLeftRadius;
        this.bottomRightRadius = bottomRightRadius;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Crea el camino para el borde redondeado.
        Path2D.Float path = new Path2D.Float();
        path.moveTo(topLeftRadius, 0);
        path.lineTo(getWidth() - topRightRadius, 0);
        path.quadTo(getWidth(), 0, getWidth(), topRightRadius);
        path.lineTo(getWidth(), getHeight() - bottomRightRadius);
        path.quadTo(getWidth(), getHeight(), getWidth() - bottomRightRadius, getHeight());
        path.lineTo(bottomLeftRadius, getHeight());
        path.quadTo(0, getHeight(), 0, getHeight() - bottomLeftRadius);
        path.lineTo(0, topLeftRadius);
        path.quadTo(0, 0, topLeftRadius, 0);
        path.closePath();

        g2d.setColor(getBackground());
        g2d.fill(path);
        g2d.dispose();
    }

    // Getters y setters para cada radio de esquina.
    public int getTopLeftRadius() { return topLeftRadius; }
    public void setTopLeftRadius(int topLeftRadius) { this.topLeftRadius = topLeftRadius; repaint(); }
    public int getTopRightRadius() { return topRightRadius; }
    public void setTopRightRadius(int topRightRadius) { this.topRightRadius = topRightRadius; repaint(); }
    public int getBottomLeftRadius() { return bottomLeftRadius; }
    public void setBottomLeftRadius(int bottomLeftRadius) { this.bottomLeftRadius = bottomLeftRadius; repaint(); }
    public int getBottomRightRadius() { return bottomRightRadius; }
    public void setBottomRightRadius(int bottomRightRadius) { this.bottomRightRadius = bottomRightRadius; repaint(); }

     
}
