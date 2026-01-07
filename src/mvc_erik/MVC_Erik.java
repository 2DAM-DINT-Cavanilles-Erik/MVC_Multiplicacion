package mvc_erik;

import controlador.Controlador;
import modelo.Modelo;
import vista.Vista;

public class MVC_Erik {
    public static void main(String[] args) {
        // Instancia de los objetos
        Modelo mod = new Modelo();
        Vista view = new Vista();
        
        // Se crea el controlador con los parámetros anteriores
        Controlador ctrl = new Controlador(view, mod);
        
        // Se inicia y se hace visible el formulario
        ctrl.iniciar();
        view.setVisible(true);
    }
}