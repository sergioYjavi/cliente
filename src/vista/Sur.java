package vista;

import java.awt.event.ActionListener;
import javax.swing.*;


class Sur extends JPanel 
{
    private JButton inicio, salir;
    
    /**
     * Constructor
     */
    public Sur()
    {
        inicio = new JButton("Empezar");
        inicio.setActionCommand("inicio");
        salir = new JButton("Cerrar");
        salir.setActionCommand("salir");
        
        add(inicio);
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
    }
}
