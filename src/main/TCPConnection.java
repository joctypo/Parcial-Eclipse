package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.gson.Gson;

public class TCPConnection extends Thread{

    private Main ref;

    public void run() {
        try {
        	
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Esperando cliente...");
            Socket socket = server.accept();
            System.out.println("Cliente esta conectado");

            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader breader = new BufferedReader(isr);

            
            while (true) {

                System.out.println("Esperando mensaje...");
                String mensajeRecibido = breader.readLine();
                
                System.out.println(mensajeRecibido);
                
                Gson gson = new Gson();
                Recordatorio rec = gson.fromJson(mensajeRecibido, Recordatorio.class);

                System.out.println(rec.getX());
                System.out.println(rec.getY());
                System.out.println(rec.getColor());
                System.out.println(rec.getTextor());
                
                if(rec.getBtn().contentEquals("1")) {
                	
                	ref.notificar(rec);
                }else if(rec.getBtn().contentEquals("2")) {
                	
                	ref.crear(rec);
                }

                //Notificar o avisar a MAIN
                

                

            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

	public void setMain(Main main) {
		this.ref = main;
		
	}
    }