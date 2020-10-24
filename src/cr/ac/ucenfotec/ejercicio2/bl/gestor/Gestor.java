package cr.ac.ucenfotec.ejercicio2.bl.gestor;

import cr.ac.ucenfotec.ejercicio2.bl.entidades.Motor;
import cr.ac.ucenfotec.ejercicio2.bl.entidades.Vehiculo;

import java.util.ArrayList;

/**
 * La clase Gestor se encarga de toda la lógica base de la aplicación
 * es donde se interactúa directamente con los objetos que se almacenan
 *
 * @author Taylor Segura Vindas
 * @version 1.0
 * @since 2020-10-24
 */
public class Gestor {
    private ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
    private ArrayList<Motor> motores = new ArrayList<Motor>();

    /**
     * Este método se usa para registrar un nuevo vehiculo
     * @param  numSerie  un String que hace referencia al numero de serie de este vehiculo
     * @param  marca  un String que hace referencia al nombre de la marca del vehiculo
     * @param  motor  una referencia al motor que posee el vehiculo
     * @return true si se realiza el registro correctamente, false si el vehiculo ya existe
     * @see Vehiculo
     * @see Motor
     */
    public boolean registrarVehiculo(String numSerie, String marca, Motor motor){
        Vehiculo nuevoVehiculo;
        if(motor == null){
            nuevoVehiculo = new Vehiculo(numSerie, marca);
        } else {
            nuevoVehiculo = new Vehiculo(numSerie, marca, motor);
        }

        if(!vehiculos.contains(nuevoVehiculo)){
            vehiculos.add(nuevoVehiculo);
            return true;
        }

        return false;
    }
    /**
     * Este método se usa para obtener la lista de vehiculos almacenada
     * @return un arrayList que contiene los vehiculos que se han creado
     * @see Vehiculo
     * @see ArrayList
     */
    public ArrayList<Vehiculo> listarVehiculos(){
        return this.vehiculos;
    }
    /**
     * Este método se usa para buscar y obtener un motor basado en su serie
     * @return un objeto de la clase Motor que posee la misma serie que se envió como parámetro
     * @see Vehiculo
     */
    public Vehiculo buscarVehiculo(String pSerie){
        for (Vehiculo objVehiculo: vehiculos) {
            if(objVehiculo.getNumSerie().equals(pSerie)){
                return objVehiculo;
            }
        }

        return null;
    }


    /**
     * Este método se usa para registrar un nuevo motor
     * @param  serie  un String que hace referencia a la serie del motor
     * @param  cilindros  un entero que hace referencia a la cantidad de cilindros que posee el motor
     * @return true si se realiza el registro correctamente, false si el motor ya existe
     * @see Motor
     */
    public boolean registrarMotor(String serie, int cilindros){
        Motor nuevoMotor = new Motor(serie, cilindros);
        if(!motores.contains(nuevoMotor)){
            motores.add(nuevoMotor);
            return true;
        }

        return false;
    }
    /**
     * Este método se usa para obtener la lista de vehiculos almacenada
     * @return un arrayList que contiene los vehiculos que se han creado
     * @see Motor
     * @see ArrayList
     */
    public ArrayList<Motor> listarMotores(){
        return this.motores;
    }
    /**
     * Este método se usa para buscar y obtener un motor basado en su serie
     * @return un objeto de la clase Motor que posee la misma serie que se envió como parámetro
     * @see Motor
     */
    public Motor buscarMotor(String pSerie){
        for (Motor objMotor: motores) {
            if(objMotor.getSerie().equals(pSerie)){
                return objMotor;
            }
        }

        return null;
    }
}
