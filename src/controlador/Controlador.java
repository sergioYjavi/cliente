package controlador;

import modelo.TaxiMain;
import vista.Vista;
import java.awt.event.*;
import javax.swing.JOptionPane;

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
                    vista.getMax_Taxi_Grupo(), 
                    vista.getMax_Taxi(),
                    vista.getIteraciones(),
                    vista.getIp());
                    vista.setTiempoMedio(taxiMain.getTiemposMedios());
                    
                break;
                case "salir":
                    System.exit(0);
                break;
                default:
                    System.out.println("Comando ’" + 
                        command + "’ no reconocido.");
                break;
            }
        }
    }
}