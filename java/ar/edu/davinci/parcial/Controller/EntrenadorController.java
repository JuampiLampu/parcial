package ar.edu.davinci.parcial.Controller;

import ar.edu.davinci.parcial.model.Entrenador;
import ar.edu.davinci.parcial.repository.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entrenadores")
public class EntrenadorController {

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    @GetMapping("/{id}")
    public Entrenador getEntrenadorById(@PathVariable Long id) {
        return entrenadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrenador no encontrado con id: " + id));
    }

    @PostMapping("/crear")
    public Entrenador crearEntrenador(@RequestBody Entrenador entrenador) {
        return entrenadorRepository.save(entrenador);
    }

    @GetMapping("/buscar")
    public Entrenador buscarEntrenadorPorNombre(@RequestParam String nombre) {
        return entrenadorRepository.findByNombreIgnoreCase(nombre);
    }

    @GetMapping("/todos")
    public List<Entrenador> getAllEntrenadores() {
        return entrenadorRepository.findAll();
    }

}