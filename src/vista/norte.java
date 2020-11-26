package vista;

import modelo.Valores;
import javax.swing.*;


class norte extends JPanel 
{
    private JTextField jttaxis, jtntaxisgrupo, jtiteraciones, jtpuertos, jtservidor;
    private JLabel jltaxis, jltaxisgrupo, jliteraciones, jlpuerto, jlipservidor, jltitulo;
    
    /**
     * Constructor
     */
    public norte()
    {
        jltaxis = new JLabel("Nº Taxis: ");
        jltaxisgrupo = new JLabel("Nº taxis por grupo: ");
        jliteraciones = new JLabel("Nº de \niteraciones: ");
        jlpuerto = new JLabel("Puerto: ");
        jlipservidor = new JLabel("Dirección Ip \ndel servidor: ");
        
        jttaxis = new JTextField(5);
        jttaxis.setText("500");
        jtntaxisgrupo = new JTextField(5);
        jtntaxisgrupo.setText("50");
        jtiteraciones = new JTextField(5);
        jtiteraciones.setText("10");
        jtpuertos = new JTextField(5);
        jtpuertos.setText("12345");
        jtservidor = new JTextField(15);
        jtservidor.setText("localhost");
        
        add(jltaxis);
        add(jttaxis);
        add(jltaxisgrupo);
        add(jtntaxisgrupo);
        add(jliteraciones);
        add(jtiteraciones);
        add(jlpuerto);
        add(jtpuertos);
        add(jlipservidor);
        add(jtservidor);
                
        this.setVisible(true);
    }
    
   
    // Numero maximo de taxis por grupo
    public int getMax_Taxi_Grupo()
    {
        try
        {
            return Integer.parseInt(jtntaxisgrupo.getText());
        }
        catch(NumberFormatException e)
        {
            return Valores.MAX_TAXI_GRUPO;
        }
    }

    
    
     // Numero maximo de taxis 
    
    public int getMax_Taxi()
    {
        try
        {
            return Integer.parseInt(jttaxis.getText());
        }
        catch(NumberFormatException e)
        {
            return Valores.MAX_TAXI;
        }
    }

    /**
     * Devuelve el numero de iteraciones 
     * @return numero de iteraciones 
     */
    public int getIteraciones()
    {
        try
        {
            return Integer.parseInt(jtiteraciones.getText());
        }
        catch(NumberFormatException e)
        {
            return Valores.ITERACIONES;
        }
    }
    
    // Número de puerto
    public int getPuerto()
    {
        try
        {
            return Integer.parseInt(jtpuertos.getText());
        }
        catch(NumberFormatException e)
        {
            return Valores.PORT;
        }
    }
    
    /**
     * Devuelve direccion ip
     * @return direccion ip
     */
    public String getIp()
    {
        try
        {
            
            return jtservidor.getText();
        }
        catch(Exception e)
        {
            return Valores.IP;
        }
    }
}
