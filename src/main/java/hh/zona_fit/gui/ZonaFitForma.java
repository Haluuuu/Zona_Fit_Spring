package hh.zona_fit.gui;


import com.formdev.flatlaf.FlatDarculaLaf;
import hh.zona_fit.servicio.IClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
@Component
public class ZonaFitForma extends JFrame{
    private JPanel panelPrincipal;

    IClienteServicio iClienteServicio;

    @Autowired
    public ZonaFitForma(IClienteServicio iClienteServicio){//Inyeccion de dependencia
        this.iClienteServicio=iClienteServicio;
        iniciarForma();
    }

    private void iniciarForma() {
        setContentPane(panelPrincipal);//inicializa el panel principal
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //termina de ejecutar la aplicacion al cerrarla
        setSize(600,400);//Tamaño de la ventana
        setLocationRelativeTo(null);//centramos la ventana
    }

}
