package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JFrame;


public class Vista extends JFrame 
{
    
    private norte panelnorte;
    private Sur panelsur;
    private Centro panelcentro;
    public Vista()
    {
        this.setLayout(new BorderLayout());
        panelnorte = new norte();
        panelsur = new Sur();
        panelcentro = new Centro();
        
        this.add(panelnorte,BorderLayout.NORTH);
        this.add(panelsur,BorderLayout.SOUTH);
        this.add(panelcentro,BorderLayout.CENTER);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.setVisible(true);
    }
    
    // Devuelve el numero maximo de taxis 
     
    public int getMax_Taxi()
    {
        return panelnorte.getMax_Taxi();
    }
    
    // Numero maximo de taxistas por grupo
    public int getMax_Taxi_Grupo()
    {
        return panelnorte.getMax_Taxi_Grupo();
    }
    
    
    /**
     * Devuelve el puerto 
     */
    
    public int getPuerto()
    {
        return panelnorte.getPuerto();
    }
    
    
    
    //Nº iteraciones
    public int getIteraciones()
    {
        return panelnorte.getIteraciones();
    }
    
    // Devuelve IP
    public String getIp()
    {
        return panelnorte.getIp();
    }
    
   
    
     // Listener al paner sur 
    public void setActionListener(ActionListener actionListener)
    {
        panelsur.setActionListener(actionListener);
    }


    //tiempo medio del total 
    
    public void setTiempoMedio(String tiempoMedioTotal)
    {
       panelcentro.setTiempoMedio(tiempoMedioTotal);
    }
    
    
}
