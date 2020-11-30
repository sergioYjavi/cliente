package controlador;

import modelo.TaxiMain;
import vista.Vista;
import java.awt.event.*;


public class Controlador 
{
    private TaxiMain taxiMain;
    
    private Vista vista;
    
    public Controlador(Vista vista)
    {
        this.vista = vista;
        vista.addWindowListener(new ControladorWindowListener());
        vista.setActionListener(new ControladorActionListener());
    }
    
    class ControladorWindowListener extends WindowAdapter 
    {
        @Override
        public void windowClosing(WindowEvent e) 
        {
            System.exit(0);
        }
    }
    
    
    class ControladorActionListener implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            String command = ae.getActionCommand();
            switch (command) 
            {
                case "inicio":
                    taxiMain = new TaxiMain(
                        vista.getPuerto(),
                        vista.getMax_Taxi(), 
                        vista.getMax_Taxi_Grupo(),
                        vista.getIteraciones(),
                        vista.getIp());
                break;
                case "salir":
                    System.exit(0);
                break;
                case "act":
                    vista.setTiempoMedio(taxiMain.getTiemposMedios());
                    vista.setCoordenadas(taxiMain.getCoordenadas());
                break;
                default:
                    System.out.println("Comando ’" + 
                        command + "’ no reconocido.");
                break;
            }
        }
    }
}