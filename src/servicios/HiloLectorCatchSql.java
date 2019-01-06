package servicios;

import java.io.InputStream;

public class HiloLectorCatchSql extends Thread {

    private final InputStream is;

    public HiloLectorCatchSql(InputStream is) {
        this.is = is;
    }

    @Override
    public void run() {
        try {
            byte[] buffer = new byte[1000];
            int leido = is.read(buffer);
            while (leido > 0) {
                System.out.print(new String(buffer, 0, leido));
                leido = is.read(buffer);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
}
