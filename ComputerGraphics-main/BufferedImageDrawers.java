import java.awt.*;
import java.awt.image.*;

public class BufferedImageDrawers extends Frame {
    public BufferedImage bi;
    public Graphics2D g2dbi;
    public Graphics2D g2d;

    public BufferedImageDrawers(BufferedImage buffIm, int width, int height) {
        bi = buffIm;
        g2dbi = bi.createGraphics();
        addWindowListener(new MyFinishWindow());
        this.setTitle("Double-Buffering");
        this.setSize(width, height);
        this.setVisible(true);
    }

    public void paint(Graphics g) {
        update(g);
    }

    public void update(Graphics g) {
        g2d = (Graphics2D) g;
        g2d.drawImage(bi, 0, 0, this);
    }

    public static void main(String[] args) {
        int width = 400;
        int height = 300;
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        BufferedImageDrawers bd = new BufferedImageDrawers(bi, width, height);
        bd.g2dbi.setPaint(Color.white);
        bd.g2dbi.fillRect(0, 0, width, height);
        bd.g2dbi.setPaint(Color.red);
        bd.g2dbi.drawLine(0, 0, width, height);
        bd.g2dbi.drawLine(0, height, width, 0);
        bd.repaint();
    }
}