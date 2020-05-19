import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;

public class Servidor extends Observable implements Runnable{
    private int puerto;
    
    public Servidor(int puerto){
        this.puerto = puerto;
    }

    @Override
    public void run() {
        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in = null;
        try {
            servidor = new ServerSocket(puerto);
            
            while(true){
                sc = servidor.accept();
                
                in = new DataInputStream(sc.getInputStream());
                String mensaje = in.readUTF();
                
                this.setChanged();
                this.notifyObservers(mensaje);
                this.clearChanged();
                
                sc.close();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
