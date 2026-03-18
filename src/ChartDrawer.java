import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ChartDrawer extends JPanel {
    private List<Double> accuracies;

    public ChartDrawer(List<Double> accuracies) {
        this.accuracies = accuracies;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Włączenie wygładzania krawędzi (antyaliasing), żeby wykres wyglądał ładnie
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int padding = 50;
        int width = getWidth() - 2 * padding;
        int height = getHeight() - 2 * padding;

        // Rysowanie osi X i Y
        g2d.setColor(Color.BLACK);
        g2d.drawLine(padding, getHeight() - padding, padding, padding); // Oś Y
        g2d.drawLine(padding, getHeight() - padding, getWidth() - padding, getHeight() - padding); // Oś X

        if (accuracies == null || accuracies.isEmpty()) return;

        // Rysowanie punktów i linii
        g2d.setColor(Color.BLUE);
        int pointSpacing = width / (accuracies.size() - 1 > 0 ? accuracies.size() - 1 : 1);

        for (int i = 0; i < accuracies.size(); i++) {
            int x1 = padding + i * pointSpacing;
            // Skalujemy celność (0.0 - 1.0) do wysokości okna
            int y1 = getHeight() - padding - (int) (accuracies.get(i) * height);

            // Rysowanie punktu (kropki)
            g2d.fillOval(x1 - 4, y1 - 4, 8, 8);

            // Podpis pod osią X (K=1, K=2 itd.)
            g2d.setColor(Color.BLACK);
            g2d.drawString(String.valueOf(i + 1), x1 - 5, getHeight() - padding + 20);

            // Podpis punktu (wartość %) nad kropką
            String accText = String.format("%.1f%%", accuracies.get(i) * 100);
            g2d.drawString(accText, x1 - 15, y1 - 10);
            g2d.setColor(Color.BLUE);

            // Rysowanie linii łączącej z poprzednim punktem
            if (i > 0) {
                int x0 = padding + (i - 1) * pointSpacing;
                int y0 = getHeight() - padding - (int) (accuracies.get(i - 1) * height);
                g2d.drawLine(x0, y0, x1, y1);
            }
        }
    }

    // Metoda pomocnicza do wywołania okienka
    public static void showChart(List<Double> accuracies) {
        JFrame frame = new JFrame("Zależność celności od K");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Zamyka tylko okno, nie cały program
        frame.setSize(800, 400);
        frame.add(new ChartDrawer(accuracies));
        frame.setVisible(true);
    }
}