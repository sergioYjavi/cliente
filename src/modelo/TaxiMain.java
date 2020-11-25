
package modelo;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class TaxiMain
{
    //Iteración de los taxis.
    private int iteracion = 0;
    //taxis que han acabado la iteración.
     private int taxiAcabado = 0;
    //Tiempo medio de cada taxi.
    private long [] tiempoMedio;
    //Acabado todas las iteraciones.
    private static boolean noAcabar = true;
    //puerto de conexión.
    private static int PORT;
    //número de taxis que conectarán.
    private static int MAX_TAXI;
    //Nº Taxis por grupo
    private static int MAX_TAXI_GRUPO;
    //número de iteraciones.
    private static int ITERACIONES;
    //Ipservidor
    private static String IP;
    //Constructor
    public TaxiMain(int PORT, int MAX_TAXI, int MAX_TAXI_GRUPO
            , int ITERACIONES, String IP)
    {
        this.PORT = PORT;
        this.MAX_TAXI = MAX_TAXI;
        this.MAX_TAXI_GRUPO = MAX_TAXI_GRUPO;
        this.ITERACIONES = ITERACIONES;
        this.IP = IP;
        tiempoMedio = new long[MAX_TAXI];
        iniciar();
    }

    public void iniciar()
    {
        ExecutorService pool = Executors.newFixedThreadPool(MAX_TAXI);
        
        for(int i = 0; i < MAX_TAXI; i++)
        {
           tiempoMedio[i] = 0;
           pool.execute(new Thread(this, PORT , MAX_TAXI,MAX_TAXI_GRUPO, ITERACIONES, IP));
        }
    }

    //mensaje de conectado al taxi
 
    protected synchronized void escribir(String msg, DataOutputStream out) 
            throws IOException 
    {
        out.writeUTF(msg);
        out.flush();
        
    }

    // Envía las coordenadas(msg)
    protected synchronized long enviaCoordenadas(String msg, 
            DataOutputStream out) throws IOException
    {
        out.writeUTF(msg);
        out.flush();
        return System.currentTimeMillis();
    }
    
    //Iteracion actual
    protected synchronized int getIteracion() 
    {
        return iteracion;
    }
       
  
    protected synchronized boolean sumaIteracion(long tiempo) throws Throwable 
    {
        tiempoMedio[taxiAcabado] += tiempo;
        ++taxiAcabado;
        if(taxiAcabado == MAX_TAXI)
        {
            taxiAcabado = 0;
            ++iteracion;
        }
        
        if(iteracion == ITERACIONES)
        {
            noAcabar = false;
            return false;
        }
        return true;
    }
    
    //iteraciones acabadadas
    protected boolean comprobarIteracion() 
    {
        return iteracion < ITERACIONES;
    }
    
    //Tiempos médidos
    public String getTiemposMedios()
    {
        String ret = "";
        
        for(int i = 0; i < tiempoMedio.length; i++)
        {
            ret += "Taxi " + i + " : " + (tiempoMedio[i]/ITERACIONES) + " milisegundos.\n";
        }
        
        return ret;
    }

   //finalizado simulación
    public boolean getNoAcabar() 
    {
        return noAcabar;
    }
}
