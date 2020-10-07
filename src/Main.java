import javax.swing.*;
import java.awt.*;

public class Main {

    public static int k = 0;

    public static void main(String[] args) {
        JFrame window = new JFrame();
        JPanel canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D)g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                super.paintComponent(g2);
                for (double x = -25; x < 25; x += 0.1) {
                    double y = k * x * x / 200;
                    g2.drawOval((int)x + 250, (int)y + 125, 1, 1);
                }
                g2.drawLine(0, 125, 500, 125);
                g2.drawLine(250, 500, 250, 0);
            }
        };
        canvas.setBounds(0, 0, 400, 400);
        JSlider slider = new JSlider(SwingConstants.HORIZONTAL, -100, 100, 0);
        slider.addChangeListener(changeEvent -> {
            k = slider.getValue();
            canvas.repaint();
        });
        window.add(canvas);
        window.add(slider);
        window.setLayout(new GridLayout(2, 1));
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setBounds(0, 0, 500, 500);
        window.setVisible(true);
    }
}