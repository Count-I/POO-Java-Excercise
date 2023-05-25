import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Mascota> mascotas = new ArrayList<>();
        int n;
        String Icontinue = "si";
        do{
            switch (menuOptions()){
                case 1:
                    n = Integer.parseInt(requestData("¿Cuantas mascotas desea ingresar?"));
                    for(int i=0;i<n;i++){
                        mascotas.add(new Mascota(requestData("Ingrese el nombre"),
                                requestData("Ingrese la especie"),
                                Integer.parseInt(requestData("Ingrese la edad"))));
                    }
                    break;
                case 2:consultarMascota(mascotas,requestData("Ingrese el nombre de la mascota que desea buscar"));
                break;
                case 3:consultarListaMascotas(mascotas);menuOptions();
                case 4:actualizarMascota(mascotas,requestData("Ingrese el nombre de la mascota que desea actualizar"));
                case 5:System.out.println("Gracias por su visita");
                Icontinue="no";
                break;
                default:System.out.println("Error, codigo inexistente, vuelva a intentar");
                break;
            }
        }
        while(Icontinue.equalsIgnoreCase("si"));

}
    public static void init(){

    }
    public static String requestData(String message){
        return JOptionPane.showInputDialog(message);
    }

    public static void consultarMascota(ArrayList<Mascota> mascotas,String nombre){
        for(int i=0;i<mascotas.size();i++) {
            if (mascotas.get(i).getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Identificación: " + mascotas.get(i).getIdentificacion() +
                        "\nNombre: " + mascotas.get(i).getNombre() +
                        "\nEspecie: " + mascotas.get(i).getEspecie() +
                        "\nEdad: " + mascotas.get(i).getEdad());
            }
        }
    }

    public static void consultarListaMascotas(ArrayList<Mascota> mascotas){
        for(int i=0;i<mascotas.size();i++){
            System.out.println("Identificación: "+mascotas.get(i).getIdentificacion()+
                    "\nNombre: "+mascotas.get(i).getNombre()+
                    "\nEspecie: "+mascotas.get(i).getEspecie()+
                    "\nEdad: "+mascotas.get(i).getEdad());
        }
    }
    public static void actualizarMascota(ArrayList<Mascota> mascotas,String nombre){
        Mascota mascota = null;
        for(int i=0;i<mascotas.size();i++) {
            if (mascotas.get(i).getNombre().equalsIgnoreCase(nombre)) {
                mascota = mascotas.get(i);
            }
        }
        switch (updateMenuOptions()){
            case 1:mascota.setNombre(requestData("ingrese el nuevo nombre de su mascota"));
            case 2:mascota.setEspecie(requestData("ingrese la nueva especie de su mascota"));
            case 3:mascota.setEdad(Integer.parseInt(requestData("ingrese la nueva edad de su mascota")));
            case 4:menuOptions();
        }

    }
    public static int menuOptions(){
        String menu;
        menu="  Veterinaria \n\nDigite el número de la operación que desee realizar\n";
        menu+="1: Registrar mascotas \n";
        menu+="2: Buscar mascota por nombre \n";
        menu+="3: Imprimir lista de mascotas \n";
        menu+="4: Actualizar mascota \n";
        menu+="5: Salir \n";
        return Integer.parseInt(JOptionPane.showInputDialog(menu));
    }

    public static int updateMenuOptions(){
        String menu;
        menu="  Veterinaria \n\nDigite el número de la operación que desee realizar\n";
        menu+="1: Cambiar nombre \n";
        menu+="2: Cambiar especie \n";
        menu+="3: Cambiar edad \n";
        menu+="4: Salir \n";
        return Integer.parseInt(JOptionPane.showInputDialog(menu));
    }

}