import java.awt.*;

public class strokeExample extends Frame {
    strokeExample() {
        addWindowListener(new MyFinishWindow());
    }

    public void paint() {
        Graphics2D g = (Graphics2D) g;

        BasicStroke MyThickLine = new BasicStroke(3.0f);
        g.setStroke(MyThickLine);
        g.drawLine(30, 50, 30, 250);

        float[] dashPattern = new float[] { 20, 10 };
        int thickness 

        BasicStroke Dash = new BasicStroke(thickness, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 2.0f, dashPattern,
                dashPhase);
        

    }

    public static void main(String[] args) {
        strokeExample f = new strokeExample();
        f.setTitle("null");
        f.setSize(400, 300);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }
}
