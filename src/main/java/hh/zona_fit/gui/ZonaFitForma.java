package hh.zona_fit.gui;

import hh.zona_fit.modelo.Cliente;
import hh.zona_fit.servicio.IClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Component
public class ZonaFitForma extends JFrame{
    private JPanel panelPrincipal;
    private JTable clientesTabla;
    private JScrollPane scrollPane1;
    private JTextField textNombre;
    private JTextField textApellido;
    private JTextField textMembresia;
    private JButton guardarButton;
    private JButton limpiarButton;
    private JButton eliminarButton;
    private DefaultTableModel tableModelClientes;
    IClienteServicio iClienteServicio;
    private Integer idCliente;


    @Autowired
    public ZonaFitForma(IClienteServicio iClienteServicio){//Inyeccion de dependencia
        this.iClienteServicio=iClienteServicio;
        iniciarForma();
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarClientes();
            }
        });

        clientesTabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                seleccionarCliente();

            }
        });
        eliminarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                borrarCliente();
            }
        });
        limpiarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                limpiarDatos();
            }
        });
    }



    private void seleccionarCliente() {
        var renglon= clientesTabla.getSelectedRow();
        if(renglon!=-1){
            var id = clientesTabla.getModel().getValueAt(renglon,0).toString();
            this.idCliente=Integer.parseInt(id);
            this.textNombre.setText(clientesTabla.getModel().getValueAt(renglon,1).toString());
            this.textApellido.setText(clientesTabla.getModel().getValueAt(renglon,2).toString());
            this.textMembresia.setText(clientesTabla.getModel().getValueAt(renglon,3).toString());
        }
    }

    private void borrarCliente() {
       try{
           Cliente cliente = new Cliente();
           cliente.setIdcliente(idCliente);
           iClienteServicio.eliminarCliente(cliente);
           showMessage("Cliente Eliminado Con Exito");
           listarClientes();
           limpiarDatos();
       }catch (Exception e){
           showMessage("Cliente no encontrado");
       }
    }


    private void agregarClientes() {

        if(this.textNombre.getText().equals("")){
            showMessage("Ingrese el Nombre");
            textNombre.requestFocusInWindow();
            return;
        }
        if (this.textApellido.getText().equals("")) {
            showMessage("Ingrese el Apellido");
            textApellido.requestFocusInWindow();
            return;
        }
        if (this.textMembresia.getText().equals("")) {
            showMessage("Ingrese la Membresia");
            textMembresia.requestFocusInWindow();
            return;
        }
        try {
            Cliente cliente = new Cliente();

            cliente.setIdcliente(idCliente);
            cliente.setNombre(this.textNombre.getText());
            cliente.setApellido(this.textApellido.getText());
            cliente.setMembrensia(Integer.parseInt(this.textMembresia.getText()));
            iClienteServicio.guardarCliente(cliente);
            if(idCliente!=null){
                showMessage("Cliente Actualizado Correctamente");}
            else{
                showMessage("Cliente Agregado Correctamente");
            }
            limpiarDatos();
            listarClientes();
        }
        catch (Exception e){
            showMessage("A ocurrido un error al Agregar un Cliente");
        }
    }

    private void limpiarDatos() {
        idCliente=null;
        this.textNombre.setText("");
        this.textApellido.setText("");
        this.textMembresia.setText("");
    }

    public void showMessage(String mensaje){
        JOptionPane.showMessageDialog(this,mensaje);

    }

    private void iniciarForma() {
        setContentPane(panelPrincipal);//inicializa el panel principal
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //termina de ejecutar la aplicacion al cerrarla
        setSize(650,600);//Tamaño de la ventana
        setLocationRelativeTo(null);//centramos la ventana
    }

    private void createUIComponents() {
        this.tableModelClientes= new DefaultTableModel(0,4);
        String[] cabeceros={"ID","Nombre","Apellido","Membresia"};
        this.tableModelClientes.setColumnIdentifiers(cabeceros);
        this.clientesTabla= new JTable(tableModelClientes);
        listarClientes();
    }

    private void listarClientes() {
        this.tableModelClientes.setRowCount(0);
        var clientes= this.iClienteServicio.listarClientes();
        clientes.forEach(cliente ->
        {
            Object[] renglonCliente={
                    cliente.getIdcliente(),
                    cliente.getNombre(),
                    cliente.getApellido(),
                    cliente.getMembrensia()
            };
            this.tableModelClientes.addRow(renglonCliente);
        });
    }
}
