package ar.edu.davinci.parcial.Controller;

import ar.edu.davinci.parcial.model.Pokemon;
import ar.edu.davinci.parcial.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemones")
public class PokemonController {

    @Autowired
    private PokemonRepository pokemonRepository;

    @GetMapping("/{id}")
    public Pokemon getPokemonById(@PathVariable Long id) {
        return pokemonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pokemon no encontrado con id: " + id));
    }

    @PostMapping("/crear")
    public Pokemon crearPokemon(@RequestBody Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    @GetMapping("/tipo")
    public List<Pokemon> getPokemonesPorTipo(@RequestParam String tipo) {
        return pokemonRepository.findByTipoIgnoreCase(tipo);
    }

    @GetMapping("/poder")
    public List<Pokemon> getPokemonesPorRangoDePoder(@RequestParam int minPoder, @RequestParam int maxPoder) {
        return pokemonRepository.findByPoderBetween(minPoder, maxPoder);
    }

    @GetMapping("/todos")
    public List<Pokemon> getAllPokemones() {
        return pokemonRepository.findAll();
    }

}