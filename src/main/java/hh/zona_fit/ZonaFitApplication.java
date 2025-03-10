package hh.zona_fit;

import hh.zona_fit.modelo.Cliente;
import hh.zona_fit.servicio.IClienteServicio;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

//@SpringBootApplication
public class ZonaFitApplication implements CommandLineRunner {
	@Autowired
	private IClienteServicio clienteServicio;
	//se inyecta la dependencia de servicio

	//Para hacer imprensiones mas elaboradas
	private static final Logger logger=LoggerFactory.getLogger(ZonaFitApplication.class);

	public static void main(String[] args) {

		logger.info("Iniciando la Aplicacion");
		SpringApplication.run(ZonaFitApplication.class, args);
		logger.info("Finalizando la Aplicacion...");
	}

	@Override
	public void run(String... args) throws Exception {
		Cliente cliente = new Cliente();
		var scan=new Scanner(System.in);
		var ejecucion=true;
		logger.info("---------------------------");
		logger.info("***Aplicacion Zona Fit***");


			while (ejecucion){
				try {
					var opcion= mostrarMenu(scan);
					if(opcion==6){
						ejecucion=false;
					}
					else{
						ejecutarOpcion(opcion,scan,cliente);
					}
				}catch (Exception e){
					logger.info("Error en el sistema: "+e);
				}
			}

	}

	private int mostrarMenu(Scanner scan) {
		logger.info("""
				-----------------------
				Menu de Opciones
				-----------------------
				1.Mostrar Clientes
				2.Buscar Cliente por Id
				3.Agregar Cliente
				4.Actualizar Cliente
				5.Borrar Cliente
				6.Salir
				Opcion: """);

		var opcion= Integer.parseInt(scan.nextLine());
		return opcion;
	}
	private void ejecutarOpcion(Integer opcion,Scanner scan,Cliente cliente){
		switch (opcion){
			case 1->{
				logger.info("----Lista de Clientes----");
				var listaClientes=clienteServicio.listarClientes();
				for(Cliente client:listaClientes) logger.info(""+client);
			}
			case 2->{
				logger.info("----Busqueda Por Id---- \n Ingrese Su Id: ");
				var idcliente=Integer.parseInt(scan.nextLine());
				var busquedaCliente=clienteServicio.buscarClientePorId(idcliente);
				if(busquedaCliente!=null){
					logger.info("-----Cliente Encontrado-----\n"+busquedaCliente);
				}
				else{
					logger.info("********Cliente no Encontrado*******");
				}
			}
			case 3->{
				logger.info("----Agregar Nuevo Cliente---- \n Ingrese el Nombre: ");
				cliente.setNombre(scan.nextLine());
				logger.info("Ingrese el Apellido:");
				cliente.setApellido(scan.nextLine());
				logger.info("Ingrese la Menbresia:");
				cliente.setMembrensia(Integer.parseInt(scan.nextLine()));
				clienteServicio.guardarCliente(cliente);
				logger.info("Cliente Guardado con Exito");
			}
			case 4->{
				logger.info("----Actualizar Cliente---- \n Ingrese el Id: ");
				cliente.setIdcliente(Integer.parseInt(scan.nextLine()));
				logger.info("Ingrese el nombre");
				cliente.setNombre(scan.nextLine());
				logger.info("Ingrese el Apellido:");
				cliente.setApellido(scan.nextLine());
				logger.info("Ingrese la Menbresia:");
				cliente.setMembrensia(Integer.parseInt(scan.nextLine()));
				clienteServicio.guardarCliente(cliente);
				logger.info("Cliente Actualizado con Exito");
			}
			case 5->{
				logger.info("Elimar Cliente \n Ingrese el Id:");
				cliente.setIdcliente(Integer.parseInt(scan.nextLine()));
				var encontrado=clienteServicio.buscarClientePorId(cliente.getIdcliente());
				if(encontrado!=null){
					clienteServicio.eliminarCliente(cliente);
					logger.info("Cliente Eliminado con exito");
				}else{
					logger.info("Cliente No encontrado");
				}
			}
		}
	}
}
