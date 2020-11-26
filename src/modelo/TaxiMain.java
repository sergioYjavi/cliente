package modelo;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class TaxiMain
{
    private int iteracion = 0;
    private int taxiAcabado = 0;
    private long [] tiempoMedio;
    private static boolean noAcabar = true;
    private static int PORT;
    private static int MAX_TAXI;
    private static int MAX_TAXI_GRUPO;
    private static int ITERACIONES;
    private static String IP;
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
           pool.execute(new TaxiThread(this, PORT , MAX_TAXI , 
                   MAX_TAXI_GRUPO, ITERACIONES, IP));
        }
    }

    protected synchronized void escribir(String msg, DataOutputStream out) 
            throws IOException 
    {
        out.writeUTF(msg);
        out.flush();
    }

    protected synchronized long enviaCoordenadas(String msg, 
            DataOutputStream out) throws IOException
    {
        out.writeUTF(msg);
        out.flush();
        return System.currentTimeMillis();
    }
    
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

    
    protected boolean comprobarIteracion() 
    {
        return iteracion < ITERACIONES;
    }
    public String getTiemposMedios()
    {
        String ret = "";
        
        for(int i = 0; i < tiempoMedio.length; i++)
        {
            ret += "Taxi " + i + " : " + (tiempoMedio[i]/ITERACIONES) + " milisegundos.\n";
        }
        
        return ret;
    }

    public boolean getNoAcabar() 
    {
        return noAcabar;
    }
}
