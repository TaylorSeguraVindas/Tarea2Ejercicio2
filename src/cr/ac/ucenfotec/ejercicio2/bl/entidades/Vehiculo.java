package cr.ac.ucenfotec.ejercicio2.bl.entidades;

import java.util.Objects;

public class Vehiculo {
    private String mnumSerie;
    private String mmarca;
    private Motor mmotor;

    public String getNumSerie() {
        return mnumSerie;
    }
    public void setNumSerie(String mnumSerie) {
        this.mnumSerie = mnumSerie;
    }

    public String getMarca() {
        return mmarca;
    }
    public void setMarca(String mmarca) {
        this.mmarca = mmarca;
    }

    public Motor getMotor() {
        return mmotor;
    }
    public void setMotor(Motor mmotor) {
        this.mmotor = mmotor;
    }

    /**
     * Metodo constructor para la clase Vehiculo
     * @param pNumSerie String que contiene el numero de serie de este vehiculo
     * @param pMarca String que contiene la marca de este vehiculo
     */
    public Vehiculo(String pNumSerie, String pMarca) {
        this.mnumSerie = pNumSerie;
        this.mmarca = pMarca;
        this.mmotor = new Motor(pNumSerie, 4); //Este constructor tiene que crear el motor
    }
    /**
     * Metodo constructor para la clase Vehiculo
     * @param pNumSerie String que contiene el numero de serie de este vehiculo
     * @param pMarca String que contiene la marca de este vehiculo
     * @param pMotor objeto de la clase Motor que define el motor de este vehiculo
     * @see Motor
     */
    public Vehiculo(String pNumSerie, String pMarca, Motor pMotor) {
        this.mnumSerie = pNumSerie;
        this.mmarca = pMarca;
        this.mmotor = pMotor;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "mnumSerie='" + mnumSerie + '\'' +
                ", mmarca='" + mmarca + '\'' +
                ", mmotor=" + mmotor +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return Objects.equals(mnumSerie, vehiculo.mnumSerie) &&
                Objects.equals(mmarca, vehiculo.mmarca) &&
                Objects.equals(mmotor, vehiculo.mmotor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mnumSerie, mmarca, mmotor);
    }
}
