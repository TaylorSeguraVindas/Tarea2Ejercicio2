package cr.ac.ucenfotec.ejercicio2.controlador;

import cr.ac.ucenfotec.ejercicio2.bl.entidades.Motor;
import cr.ac.ucenfotec.ejercicio2.bl.entidades.Vehiculo;
import cr.ac.ucenfotec.ejercicio2.ui.UI;
import cr.ac.ucenfotec.ejercicio2.bl.gestor.Gestor;

import java.util.ArrayList;

/**
 * La clase Controlador se usa para realizar la comunicación entre
 * el UI y el Gestor
 *
 * @author Taylor Segura Vindas
 * @version 1.0
 * @since 2020-10-24
 */
public class Controlador {
    private UI ui = new UI();
    private Gestor gestor = new Gestor();

    /**
     * Este método se usa para iniciar el comportamiento del controlador
     */
    public void iniciarPrograma(){
        int opcion = 0;
       do {
           ui.imprimirLinea("Bienvenido, seleccione una opcion");
           ui.imprimirLinea("1. Registrar motor");
           ui.imprimirLinea("2. Listar motores");
           ui.imprimirLinea("3. Registrar vehiculo");
           ui.imprimirLinea("4. Listar vehiculos");
           ui.imprimirLinea("5. Salir");
           ui.imprimir("Su opcion: ");
           opcion = ui.leerEntero();
           procesarOpcion(opcion);
       } while (opcion != 5);
    }

    /**
     * Este método se usa para procesar la opción recibida por el usuario
     * y realizar una acción basada en esta
     * @param  opcion  el entero que el usuario ingresó
     */
    private void procesarOpcion(int opcion){
        switch (opcion){
            case 1:
                registrarMotor();
                break;
            case 2:
                listarMotores();
                break;
            case 3:
                registrarVehiculo();
                break;
            case 4:
                listarVehiculos();
                break;
            case 5:
                ui.imprimirLinea("Adios");
                break;
            default:
                ui.imprimirLinea("Opcion invalida");
                break;
        }
    }

    private Motor registrarMotor() {
        ui.imprimirLinea("Registro de motor");
        ui.imprimir("Serie: ");
        String serie = ui.leerLinea();
        ui.imprimir("Numero de cilindros: ");
        int cilindros = ui.leerEntero();

        boolean resultado = gestor.registrarMotor(serie, cilindros);

        if(resultado){
            ui.imprimirLinea("Registro realizado correctamente");
            return gestor.buscarMotor(serie);
        } else {
            ui.imprimirLinea("El motor ya existe :(");
        }

        return null;
    }
    private void listarMotores() {
        ui.imprimirLinea("Lista de motores");
        ArrayList<Motor> motores = gestor.listarMotores();

        for (Motor objMotor: motores) {
            ui.imprimirLinea(objMotor.toString());
        }
    }

    private Vehiculo registrarVehiculo(){
        ui.imprimirLinea("Registro de vehiculo");
        ui.imprimir("Numero de serie: ");
        String serie = ui.leerLinea();
        ui.imprimir("Marca: ");
        String marca = ui.leerLinea();

        ui.imprimir("Ingrese la serie del motor: ");
        String serieMotor = ui.leerLinea();

        Motor motor = gestor.buscarMotor(serieMotor);

        if(motor == null){
            ui.imprimirLinea("No se ha encontrado ningun motor con esa serie.");
            motor = registrarMotor();
        }

        boolean resultado = gestor.registrarVehiculo(serie, marca, motor);

        if(resultado){
            ui.imprimirLinea("Registro realizado correctamente");
            return gestor.buscarVehiculo(serie);
        } else {
            ui.imprimirLinea("El motor ya existe :(");
        }

        return null;
    }
    private void listarVehiculos(){
        ui.imprimirLinea("Lista de vehiculos");
        ArrayList<Vehiculo> vehiculos = gestor.listarVehiculos();

        for (Vehiculo objVehiculo: vehiculos) {
            ui.imprimirLinea(objVehiculo.toString());
        }
    }
}
