package ifpi.tadsii;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class App {

    public static void main(String[] args) {
        JFrame janela = new JFrame("Urna Eletrônica");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Painel painel = new Painel();
        janela.getContentPane().add(painel);

        janela.pack();
        janela.setVisible(true);
    }
}

class Painel extends JPanel {
    public int x = 280;
    public int y = 150;

    public Painel() {
        setLayout(null);

        setBackground(Color.LIGHT_GRAY);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 600);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Display
        g.setColor(Color.WHITE);
        g.fillRect(150, 100, 300, 100);
        g.setColor(Color.BLACK);
        g.drawRect(150, 100, 300, 100);
        

        // Título
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString("Urna Eletrônica", 200, 50);

        // Números
        int startX = 200, startY = 300, width = 60, height = 60;
        for (int i = 1; i <= 9; i++) {
            int x = startX + ((i - 1) % 3) * (width + 10);
            int y = startY + ((i - 1) / 3) * (height + 10);
            g.setColor(Color.DARK_GRAY);
            g.fillRect(x, y, width, height);
            g.setColor(Color.WHITE);
            g.drawString(String.valueOf(i), x + 20, y + 35);
        }

        // Botão 0
        int x0 = startX + width + 10;
        int y0 = startY + 3 * (height + 10);
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x0, y0, width, height);
        g.setColor(Color.WHITE);
        g.drawString("0", x0 + 20, y0 + 35);
        
     // Botão Branco
        int brancoX = startX + 3 * (width + 10);
        int brancoY = startY + 4 * (height - 60);
        g.setColor(Color.WHITE);
        g.fillRect(brancoX, brancoY, 3 * width, height);
        g.setColor(Color.BLACK);
        g.drawString("BRANCO", brancoX + 40, brancoY + 35);
        
     // Botão Corrige
        int corrigeX = startX + 3 * (width + 10);
        int corrigeY = startY + 4 * (height - 40);
        g.setColor(Color.ORANGE);
        g.fillRect(corrigeX, corrigeY, 3 * width, height);
        g.setColor(Color.BLACK);
        g.drawString("CORRIGE", corrigeX + 30, corrigeY + 35);

        // Botão Confirma
        int confirmaX = startX + 3 * (width + 10);
        int confirmaY = startY + 4 * (height - 20);
        g.setColor(Color.GREEN);
        g.fillRect(confirmaX, confirmaY, 3 * width, 2 * height);
        g.setColor(Color.BLACK);
        g.drawString("CONFIRMA", confirmaX + 20, confirmaY + 35);
    }
}

