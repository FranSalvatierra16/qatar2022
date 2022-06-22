package apuestas_qatar22;

import java.util.ArrayList;
import java.util.Objects;

public class Equipo {
    private String nombre;
    private Integer ranking_fifa; //usado como dato y como id
    private int calificacion; //entre 0 y 100
    private ArrayList<String> plantilla_jugadores;
    private String director_tecnico;
    private Boolean como_clasifico; //true directo, false repechaje
    private Boolean estado; //true sigue en competencia, false quedó afuera
    private String grupo; //A, B, C, etc
    private int puntos;
    private int como_termino;

    public Equipo(String nombre, Integer ranking_fifa, int calificacion, ArrayList<String> plantilla_jugadores, String director_tecnico ,Boolean como_clasifico, String grupo) {
        this.nombre = nombre;
        this.ranking_fifa = ranking_fifa;
        this.calificacion = calificacion;
        this.plantilla_jugadores = plantilla_jugadores;
        this.como_clasifico = como_clasifico;
        this.director_tecnico=director_tecnico;
        this.estado = true;
        this.grupo = grupo;
        this.puntos=0;
        this.como_termino=0;
    }

    public String getDirector_tecnico() {
        return this.director_tecnico;
    }

    public void setDirector_tecnico(String director_tecnico) {
        this.director_tecnico = director_tecnico;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Integer getRanking_fifa() {
        return this.ranking_fifa;
    }

    public int getCalificacion() {
        return this.calificacion;
    }

    public ArrayList<String> getPlantilla_jugadores() {
        return this.plantilla_jugadores;
    }

    public Boolean getComo_clasifico() {
        return this.como_clasifico;
    }

    public Boolean getEstado() {
        return this.estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getGrupo() {
        return this.grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Equipo)) {
            return false;
        }
        Equipo equipo = (Equipo) o;
        return Objects.equals(nombre, equipo.nombre) && Objects.equals(ranking_fifa, equipo.ranking_fifa) && Objects.equals(calificacion, equipo.calificacion) && Objects.equals(plantilla_jugadores, equipo.plantilla_jugadores) && Objects.equals(como_clasifico, equipo.como_clasifico) && Objects.equals(estado, equipo.estado) && Objects.equals(grupo, equipo.grupo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, ranking_fifa, calificacion, plantilla_jugadores, como_clasifico, estado, grupo);
    }

    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", ranking_fifa='" + getRanking_fifa() + "'" +
            ", calificacion='" + getCalificacion() + "'" +
            ", plantilla_jugadores='" + getPlantilla_jugadores() + "'" +
            ", como_clasifico='" + getComo_clasifico() + "'" +
            ", estado='" + getEstado() + "'" +
            ", grupo='" + getGrupo() + "'" +
            ", puntos='" + getPuntos() + "'" +
            "}";
    }

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int resultado) {
		this.puntos = this.puntos + resultado;
	}

	public int getComo_termino() {
		return como_termino;
	}

	public void setComo_termino(int como_termino) {
		this.como_termino = this.como_termino+ como_termino;
	}


    
}
