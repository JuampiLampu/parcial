package ar.edu.davinci.parcial.Repository;

import ar.edu.davinci.parcial.Model.Entrenador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrenadorRepository extends JpaRepository<Entrenador, Long> {
    Entrenador findByNombreIgnoreCase(String nombre);
}