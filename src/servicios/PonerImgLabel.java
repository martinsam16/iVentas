/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author martin
 */

public class PonerImgLabel extends Thread{

    public PonerImgLabel(String nombreHilo) {
        super(nombreHilo);
    }
    
    public String link = null;
    public JLabel lbl = null;

    @Override
    public void run() {
        try {
            Image img = null;
            URL url = new URL(link);
            ImageIcon imgIcon = new ImageIcon(ImageIO.read(url));
            Icon icono = new ImageIcon(imgIcon.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT));
            lbl.setIcon(icono);
            lbl.repaint();
        } catch (IOException e) {
            System.out.println("[ERROR] "+e.getMessage());
        }
    }
    
}
