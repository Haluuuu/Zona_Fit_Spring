package hh.zona_fit.repositorio;

import hh.zona_fit.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IClienteRepositorio extends JpaRepository<Cliente,Integer> { }
