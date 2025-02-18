package hh.zona_fit.servicio;

import hh.zona_fit.modelo.Cliente;
import hh.zona_fit.repositorio.IClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //para agregar a la fabrica de spring
public class ClienteServicio implements IClienteServicio{

    @Autowired //se auto inyecta
    private IClienteRepositorio iclienteRepositorio;

    @Override
    public List<Cliente> listarClientes() {
        List<Cliente> clientes= iclienteRepositorio.findAll();
        return clientes;
    }

    @Override
    public Cliente buscarClientePorId(Integer idCliente) {
        Cliente cliente=iclienteRepositorio.findById(idCliente).orElse(null);
        return cliente;
    }

    @Override
    public void guardarCliente(Cliente cliente) {
        iclienteRepositorio.save(cliente);
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        iclienteRepositorio.delete(cliente);
    }
}
