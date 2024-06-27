package ar.edu.davinci.parcial.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Entrenador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String fechaNacimiento;
    private String nacionalidad;
    private String genero;
    private int edad;

    @OneToMany(mappedBy = "entrenador", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Pokemon> pokemons = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Set<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(Set<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public void capturarPokemon(Pokemon pokemon) {
        if (pokemons.size() < 5) {
            pokemons.add(pokemon);
            pokemon.setEntrenador(this);
        } else {
            throw new RuntimeException("El entrenador ya tiene 5 pokemons, no puede capturar más.");
        }
    }

    public void enfrentarseA(Entrenador otroEntrenador) {
        for (Pokemon miPokemon : pokemons) {
            for (Pokemon pokemonEnemigo : otroEntrenador.getPokemons()) {
                miPokemon.atacar(pokemonEnemigo);
            }
        }
    }

}