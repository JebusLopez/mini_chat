import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class Cliente implements Runnable{

    private String host;
    private int puerto;
    private String mensaje;

    public Cliente(String host,int puerto, String mensaje) {
        this.host = host;
        this.puerto = puerto;
        this.mensaje = mensaje;
    }
    
    @Override
    public void run() {
        DataOutputStream out;
        try {
            
            Socket sc = new Socket(host,puerto);
            out = new DataOutputStream(sc.getOutputStream());
            
            out.writeUTF(mensaje);
            
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
