package ar.edu.davinci.parcial.Service;

import ar.edu.davinci.parcial.Model.Pokemon;
import ar.edu.davinci.parcial.Repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    public Pokemon crearPokemon(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    public Pokemon recuperarPokemonPorId(Long id) {
        return pokemonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pokemon no encontrado con ID: " + id));
    }

    public List<Pokemon> buscarPokemonsPorRangoDePoder(int minPoder, int maxPoder) {
        return pokemonRepository.findByPoderBetween(minPoder, maxPoder);
    }
}