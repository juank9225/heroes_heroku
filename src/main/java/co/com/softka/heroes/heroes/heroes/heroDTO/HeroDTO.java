package co.com.softka.heroes.heroes.heroes.heroDTO;

import java.util.List;

public class HeroDTO {

    private String id;
    private String nombre;
    private String raza;
    private List<String> habilidad;
    private Integer nivelDePoder;
    private String urlImagen;

    public HeroDTO() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public List<String> getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(List<String> habilidad) {
        this.habilidad = habilidad;
    }

    public Integer getNivelDePoder() {
        return nivelDePoder;
    }

    public void setNivelDePoder(Integer nivelDePoder) {
        this.nivelDePoder = nivelDePoder;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }
}
