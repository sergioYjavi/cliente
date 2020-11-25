package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;


class Centro extends JPanel 
{
    private JLabel jltmedio,jltitulo,jltitulografica;
    private JTextArea textarea;
    private JScrollPane jsptextarea;
    
    public Centro()
    {
        jltmedio = new JLabel("Tiempo medio total taxi: ");

        textarea = new JTextArea(5, 100);
        textarea.setEnabled(false);
        jsptextarea = new JScrollPane(textarea);
        
        
        jltitulo = new JLabel("TAXI");
        jltitulo.setFont(new Font("Serif", Font.BOLD, 30)); jltitulo.setForeground(Color.RED); 

        jltitulografica = new JLabel("GRÁFICA");
        jltitulo.setFont(new Font("Serif", Font.BOLD, 30)); jltitulo.setForeground(Color.BLUE); 

        
        add(jltmedio);
        add(jsptextarea);
        add(jltitulo);        
        add(jltitulografica);        
        
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
