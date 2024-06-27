package ar.edu.davinci.parcial.Service;

import ar.edu.davinci.parcial.Model.Entrenador;
import ar.edu.davinci.parcial.Model.Pokemon;
import ar.edu.davinci.parcial.Repository.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrenadorService {

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    public Entrenador crearEntrenador(Entrenador entrenador) {
        return entrenadorRepository.save(entrenador);
    }

    public Entrenador recuperarEntrenadorPorId(Long id) {
        return entrenadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrenador no encontrado con ID: " + id));
    }

    public Entrenador recuperarEntrenadorPorNombre(String nombre) {
        return entrenadorRepository.findByNombreIgnoreCase(nombre);
    }

    public List<Entrenador> buscarEntrenadoresPorNombre(String nombre) {
    }

    public void capturarPokemon(Long entrenadorId, Pokemon pokemon) {
        Entrenador entrenador = recuperarEntrenadorPorId(entrenadorId);
        entrenador.capturarPokemon(pokemon);
        entrenadorRepository.save(entrenador);
    }

    public void enfrentarEntrenadores(Long entrenadorId1, Long entrenadorId2) {
        Entrenador entrenador1 = recuperarEntrenadorPorId(entrenadorId1);
        Entrenador entrenador2 = recuperarEntrenadorPorId(entrenadorId2);
        entrenador1.enfrentarseA(entrenador2);
        entrenadorRepository.save(entrenador1);
        entrenadorRepository.save(entrenador2);
    }
}