package apuestas_qatar22;
import java.util.Objects;

public class Partido {
    private Equipo equipoA;
    private Equipo equipoB;
    private Integer golesA;
    private Integer golesB;
    private Integer id;
    private Integer resultado; // 0 ganó equipoA, 1 ganó equipoB, 2 empate
    public static Integer cont = 0;

    public Partido(Equipo equipoA, Equipo equipoB) {
        this.equipoA = equipoA;
        this.equipoB = equipoB;
        this.golesA = 0;
        this.golesB = 0;
        this.id = cont + 1;
        cont++;
        this.resultado = -1;
    }

    public Integer setResultado() {
        // Probabilidades de ganar en formate 0.x
        int suma_calificaciones = equipoA.getCalificacion() + equipoB.getCalificacion();
        int probabilidades_ganarA = (equipoA.getCalificacion()) / suma_calificaciones;
        int probabilidades_ganarB = (equipoB.getCalificacion()) / suma_calificaciones;

        // Intervalos de 0-1000 para posible calculo
        Integer intervalo_eA = (int) (1000 * probabilidades_ganarA);
        Integer intervalo_eB = intervalo_eA + 1;

        // 0 ganó equipoA, 1 ganó equipoB, 2 empate
        int resultado = -1;
        int golesPartido = (int) (Math.random() * 5 - 0);
        //System.out.println("Goles partido:" + golesPartido);

        if (golesPartido != 0) {

            for (int i = 0; i < golesPartido; i++) {

                int n = (int) (Math.random() * 1000 + 1);

                if (n <= intervalo_eA && intervalo_eA > 0) {
                    setGolesA();
                } else {
                    setGolesB();
                }
            }
            
        } else {
            resultado = 2;
        }

        resultado = quien_gano();

        return this.resultado = resultado;
        

    }

    public Integer quien_gano() {
        Integer rta = -1;

        if (getGolesA() == getGolesB()) {
            rta = 2; // 2 es empate
            getEquipoA().setPuntos(1);
            getEquipoB().setPuntos(1);
        } else if (getGolesA() > getGolesB()) {
            rta = 0;
            // 0 es gana equipoA
            getEquipoA().setPuntos(3);
        } else {
            rta = 1; // 1 es gana equipoB
            getEquipoB().setPuntos(3);
        }

        return rta;
    }

    public Integer getResultado() {
        return this.resultado;
    }

    public String getGanadorString() {
        String ganador = "";
        if (getResultado() == 2) {
            ganador = "Empate";
        } else if (getResultado() == 1) {
            ganador = getEquipoB().getNombre();
        } else {
            ganador = getEquipoA().getNombre();
        }
        return ganador;
    }

    public Equipo getEquipoA() {
        return this.equipoA;
    }

    public void setEquipoA(Equipo equipoA) {
        this.equipoA = equipoA;
    }

    public Equipo getEquipoB() {
        return this.equipoB;
    }

    public void setEquipoB(Equipo equipoB) {
        this.equipoB = equipoB;
    }

    public Integer getGolesA() {
        return this.golesA;
    }

    public void setGolesA() {
        this.golesA = golesA + 1;
    }

    public void calcularProbabilidadesGanar(Equipo equipoA, Equipo equipoB) {
        // Probabilidades de ganar en formate 0.x
        int suma_calificaciones = equipoA.getCalificacion() + equipoB.getCalificacion();
        int probabilidades_ganarA = (equipoA.getCalificacion()) / suma_calificaciones;
        int probabilidades_ganarB = (equipoA.getCalificacion()) / suma_calificaciones;

        // Intervalos de 0-1000 para posible calculo
        Integer intervalo_eA = (int) (1- probabilidades_ganarA);
        Integer intervalo_eB =  1 - probabilidades_ganarB ;
    }

    public Integer getGolesB() {
        return this.golesB;
    }

    public void setGolesB() {
        this.golesB = golesB + 1;
    }

    public Integer getId() {
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Partido)) {
            return false;
        }
        Partido partido = (Partido) o;
        return Objects.equals(equipoA, partido.equipoA) && Objects.equals(equipoB, partido.equipoB)
                && Objects.equals(golesA, partido.golesA) && Objects.equals(golesB, partido.golesB)
                && Objects.equals(id, partido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(equipoA, equipoB, golesA, golesB, id);
    }

    @Override
    public String toString() {
        return getEquipoA().getNombre() + " - " + getEquipoB().getNombre();
    }

    public String toStringResultado() {
        return "=>" + getEquipoA().getNombre()+ " "+ getGolesA() + "-" + getGolesB()+ " " + getEquipoB().getNombre() +
                "\nGanador: " + getGanadorString();
    }

    

}
