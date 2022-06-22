package apuestas_qatar22;

public class Apuesta{
    private Float monto; //U$$
    private Float ganancia; //0 ó positiva(+)
    private Integer que_aposto; ////0 gana A, 1 gana B, 2 empate
    private Integer id_partido; //identificamos a qué partido apostó    
    private Boolean estado; //false-> apuesta perdida, true-> apuesta ganada

    public Apuesta (Float monto, Integer que_aposto, Integer id_partido) {
        this.monto = monto;
        this.que_aposto = que_aposto;
        this.id_partido = id_partido;
    }

    public Float getMonto() {
        return this.monto;
    }

    public Float getGanancia() {
        return this.ganancia;
    }

    public void setGanancia(Float ganancia) {
        this.ganancia = ganancia;
    }
    
    /*public Float calculo_ganancia() {
        if (estado==false) {
            this.ganancia = 0f;
            
        } else {
            this.ganancia = monto *  
        }
         return this.ganancia;
    }*/

    public Integer getQue_aposto() {
        return this.que_aposto;
    }

    public Integer getId_partido() {
        return this.id_partido;
    }

    public Boolean getEstado() {
        return this.estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }




    
}
