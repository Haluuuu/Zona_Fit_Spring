package hh.zona_fit.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Objects;

//JPA
@Entity
@Data //genera los metodos de get y set automaticamente
@NoArgsConstructor//contructor vacio
@AllArgsConstructor//contructor lleno
@ToString//metodo to string
@EqualsAndHashCode
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcliente;
    private String nombre;
    private String apellido;
    private Integer membrensia;
}
