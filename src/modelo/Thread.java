package modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Random;

public class Thread implements Runnable
{
    private TaxiMain tm;
    //Nº taxis por grupo
    private static int MAX_TAXI_GRUPO;
    private static int ITERACIONES;
    private static int PORT;
    // Nº DE Taxis a conectar
    private static int MAX_TAXI;
    //IP Servidor
    private static String IP;
    //Constructor
    Thread(TaxiMain tm, int PORT, int MAX_TAXI, 
            int MAX_TAXI_GRUPO, int ITERACIONES, String IP) 
    {
        this.tm = tm;
        this.PORT = PORT;
        this.MAX_TAXI = MAX_TAXI;
        this.MAX_TAXI_GRUPO = MAX_TAXI_GRUPO;
        this.ITERACIONES = ITERACIONES;
        this.IP = IP;
    }

     // generar una coordenada aleatoria.
    public static String getCoordenadaAleatoria()
    {
        Random random = new Random();
        int ptox, ptoy, ptoz;
        ptox = random.nextInt(102)%(101);
        ptoy = random.nextInt(102)%(101);
        ptoz = random.nextInt(102)%(101);
        String coordenada = "(" + ptox +", " + ptoy + ", " + ptoz + ") ";
        return coordenada;
    }

    public void run() 
    {
        try 
        {
            Socket socket = new Socket(IP, PORT);
            String msg = "ACK1;" + getCoordenadaAleatoria();
            int cuentaTaxi = 0, cuentaCoordenadas = 0;
            boolean noAcabar = true;
            String[] s;
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            
            long startTime = tm.enviaCoordenadas(msg, out);
            ++cuentaCoordenadas;
            while(noAcabar)
            {
                do
                {
                    if(cuentaTaxi == MAX_TAXI - 1 && (cuentaCoordenadas < ITERACIONES))
                    {
                        cuentaTaxi = 0;
                        startTime = tm.enviaCoordenadas("ACK1;" + getCoordenadaAleatoria(), out);
                        ++cuentaCoordenadas;
                    }
                    msg = in.readUTF();
                }
                while(!msg.substring(0,3).equals("ACK") || !noAcabar);
                
                s = msg.split(";");
                switch(s[0])
                {
                     case "ACK1":
                        msg = "ACK2;OK;" + s[3] + ";" + s[2];
                        tm.escribir(msg, out);
                        
                     break;
                     case "ACK2":
                            ++cuentaTaxi;

                            if(cuentaTaxi == (MAX_TAXI/MAX_TAXI_GRUPO) - 1)
                            {
                               long end = System.currentTimeMillis();
                               long num = (end - startTime);
                               out.writeUTF("ACK;" + num);
                           
                               noAcabar = tm.sumaIteracion(num);
                            }
                    break;
                }
            }
        }
        catch (Exception e) 
        {
            System.out.println("Excepcion : " + e);
        } 
        catch (Throwable ex) 
        {
            System.out.println("Excepcion : " + ex);
        }
    }
   }
