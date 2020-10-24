package cr.ac.ucenfotec.ejercicio2.bl.entidades;

import java.util.Objects;

public class Motor {
    private String mserie;
    private int mnumCilindros;

    public String getSerie() {
        return mserie;
    }
    public void setSerie(String mserie) {
        this.mserie = mserie;
    }

    public int getNumCilindros() {
        return mnumCilindros;
    }
    public void setNumCilindros(int mnumCilindros) {
        this.mnumCilindros = mnumCilindros;
    }

    public Motor(){}
    public Motor(String pSerie, int pNumCilindros) {
        this.mserie = pSerie;
        this.mnumCilindros = pNumCilindros;
    }

    @Override
    public String toString() {
        return "Motor{" +
                "mserie='" + mserie + '\'' +
                ", mnumCilindros=" + mnumCilindros +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Motor motor = (Motor) o;
        return mnumCilindros == motor.mnumCilindros &&
                Objects.equals(mserie, motor.mserie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mserie, mnumCilindros);
    }
}
