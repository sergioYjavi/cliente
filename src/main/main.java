package main;

import vista.Vista;
import controlador.Controlador;

public class main 
{
  
    
    public static void main(String[] args) 
    {
        Vista vista = new Vista();
        Controlador controlador = new Controlador(vista);
        
        vista.setVisible(true);
    }
    
}
