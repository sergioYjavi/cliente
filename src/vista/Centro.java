package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;


class Centro extends JPanel 
{
    private JLabel jltmedio,jltitulo,jltitulografica;
    private JTextArea textarea;
    private JScrollPane jsptextarea;
    
    private JPanel norte;
    private JPanel sur;
    
    public Centro()
 
    {
        norte = new JPanel();
        sur = new JPanel();
        
        jltmedio = new JLabel("Tiempo medio total taxi: ");

        textarea = new JTextArea(10, 50);
        textarea.setEnabled(false);
        jsptextarea = new JScrollPane(textarea);
        
        
        jltitulo = new JLabel("TAXI");
        jltitulo.setFont(new Font("Serif", Font.BOLD, 30)); 

        norte.setLayout(new BoxLayout(norte,BoxLayout.Y_AXIS));
        
        norte.add(jltitulo);        
 
        norte.add(jltmedio);
        sur.add(jsptextarea);
            
        add(norte);
        add(sur);
        
        this.setVisible(true);
    }
     
    /**
     * Asignar el tiempo medio de totextareal 
     * @param tiempoMedioTotextareal 
     */
    public void setTiempoMedio(String tiempoMedioTotextareal) 
    {
        textarea.setText(tiempoMedioTotextareal);
    }
}
