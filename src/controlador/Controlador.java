package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Modelo;
import vista.Vista;

public class Controlador implements ActionListener {
    private final Vista view;
    private final Modelo model;

    public Controlador(Vista view, Modelo model) {
        this.view = view;
        this.model = model;
        
        // Registra todos los botones
        this.view.btnMultiplicar.addActionListener(this);
        this.view.btnSumar.addActionListener(this);
        this.view.btnRestar.addActionListener(this);
        this.view.btnDividir.addActionListener(this);
    }

    public void iniciar() {
        view.setTitle("Calculadora MVC de Erik");
        view.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Cargar los números en el modelo
            model.setNumeroUno(Integer.parseInt(view.txtNumeroUno.getText()));
            model.setNumeroDos(Integer.parseInt(view.txtNumeroDos.getText()));

            // Identifica que botón se pulsó
            if (e.getSource() == view.btnMultiplicar) {
                model.multiplicar();
            } else if (e.getSource() == view.btnSumar) {
                model.sumar();
            } else if (e.getSource() == view.btnRestar) {
                model.restar();
            } else if (e.getSource() == view.btnDividir) {
                
                // Valida la división entre cero
                if (model.getNumeroDos() == 0) {
                    JOptionPane.showMessageDialog(view, "NO SE PUEDE DIVIDIR ENTRE 0, PARA");
                    return; // Detiene la ejecución
                }
                model.dividir();
            }

            // Muestra resultado
            view.txtResultado.setText(String.valueOf(model.getResultado()));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "LO HAS INGRESADO MAL, AGREGA NÚMERO VÁLIDOS");
        }
    }
}
