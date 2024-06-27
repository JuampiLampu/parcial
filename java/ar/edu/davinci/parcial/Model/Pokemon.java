package ar.edu.davinci.parcial.Model;

import javax.persistence.*;

@Entity
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private String especie;
    private float vida;
    private int poder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entrenador_id")
    private Entrenador entrenador;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public float getVida() {
        return vida;
    }

    public void setVida(float vida) {
        this.vida = vida;
    }

    public int getPoder() {
        return poder;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void atacar(Pokemon otroPokemon) {
        float poderAtaque = this.getPoder(); // Podrías agregar lógica más compleja aquí
        otroPokemon.restarVida(poderAtaque);
    }

    public void restarVida(float cantidad) {
        this.vida -= cantidad;
        if (this.vida < 0) {
            this.vida = 0;
        }
    }

    public void aumentarVida(float cantidad) {
        this.vida += cantidad;
    }

    public void setEntrenador(Entrenador entrenador) {
    }
}
}
