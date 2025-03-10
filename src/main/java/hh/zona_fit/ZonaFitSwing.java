package hh.zona_fit;

import com.formdev.flatlaf.FlatDarculaLaf;
import hh.zona_fit.gui.ZonaFitForma;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import javax.swing.*;

@SpringBootApplication
public class ZonaFitSwing {

    public static void main(String[] args) {
        //Instaciar la fabrica de Spring
        ConfigurableApplicationContext contextoSpring=
                new SpringApplicationBuilder(ZonaFitSwing.class)
                        .headless(false)
                        .web(WebApplicationType.NONE)
                        .run(args);

        //Crear objeto de Swing
        SwingUtilities.invokeLater(()->{
            FlatDarculaLaf.setup();
          ZonaFitForma zonaFitForma  =contextoSpring.getBean(ZonaFitForma.class);
          zonaFitForma.setVisible(true);
        });
    }
}
