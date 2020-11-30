package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import modelo.TaxiThread;
import modelo.Valores;


class Centro extends JPanel 
{
    private JLabel jltmedio,jltitulo,jltitulografica;
    private JTextArea textarea, textarea2,textarea3;
    private JScrollPane jsptextarea,jsptextarea2,jsptextarea3;
    
    private JPanel norte;
    private JPanel sur;
        
    
    public Centro()
 
    {
        norte = new JPanel();
        sur = new JPanel();
        
        jltmedio = new JLabel("Tiempo medio total taxi: ");

        textarea = new JTextArea(10, 20);
        textarea.setEnabled(false);
        jsptextarea = new JScrollPane(textarea);
        
        
        textarea2 = new JTextArea(10, 30);
        textarea2.setEnabled(false);
        jsptextarea2 = new JScrollPane(textarea2);
        
        
        textarea3 = new JTextArea(10, 30);
        textarea3.setEnabled(false);
        jsptextarea3 = new JScrollPane(textarea3);
        
        
        jltitulo = new JLabel("TAXI");
        jltitulo.setFont(new Font("Serif", Font.BOLD, 30)); 

        norte.setLayout(new BoxLayout(norte,BoxLayout.Y_AXIS));
        
        norte.add(jltitulo);        
 
        norte.add(jltmedio);
        sur.add(jsptextarea);
        sur.add(jsptextarea2);
        sur.add(jsptextarea3);
        
            
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
    public void setCoordenadas(String coordenadas) 
    {
        textarea2.setText(coordenadas);
    }
    
    
    public void setTaxiLibre(String libre) 
    {
        textarea3.setText(libre);
    }
    
    
    
    public int getCoordenada()
    {
        return 0;
    }

    

}
