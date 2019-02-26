package servicios;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Martín Alexis Samán Arata
 */
public class PonerImgLabel extends Thread {

    public PonerImgLabel(String nombreHilo) {
        super(nombreHilo);
    }

    public String link = null;
    public JLabel lbl = null;

    @Override
    public void run() {
        try {
            if (!link.isEmpty() || link != null || !"".equals(link)) {
                URL url = new URL(link);
                ImageIcon imgIcon = new ImageIcon(ImageIO.read(url));
                Icon icono = new ImageIcon(imgIcon.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT));
                lbl.setIcon(icono);
                lbl.repaint();
            }
        } catch (IOException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
