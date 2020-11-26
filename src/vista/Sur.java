package vista;

import java.awt.event.ActionListener;
import javax.swing.*;


class Sur extends JPanel 
{
    private JButton inicio, salir,act;
    
    /**
     * Constructor
     */
    public Sur()
    {
        inicio = new JButton("Empezar");
        inicio.setActionCommand("inicio");
        salir = new JButton("Cerrar");
        salir.setActionCommand("salir");
        act = new JButton("Actualizar");
        act.setActionCommand("act");
        
        add(inicio);
        add(act);
        add(salir);
        this.setVisible(true);
    }

    /**
     * Asignar actionListener a los botones 
     * @param actionListener actionListener 
     */
    public void setActionListener(ActionListener actionListener) 
    {
        inicio.addActionListener(actionListener);
        salir.addActionListener(actionListener);
        act.addActionListener(actionListener);
       
    }
}
