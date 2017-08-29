
package Paquetera;

import java.util.Scanner;


public class Main {
    public static int BuscarPaquete(Paquete paquete[], int numeroPaquete, int contadorPaquete){
        boolean encontrado = false;
        int indice=0;
            
            for(int i=0; i<contadorPaquete;i++){
                if(paquete[i].getNumeroPaquete()== numeroPaquete){
                    encontrado = true;
                    indice = 1;
                }
            }
            
            if(encontrado== false){
                indice = -1;
            }
        return indice;
    }
    
    
    
    public static int BuscarSucursal(Sucursal sucursal[], int numeroSucursal, int contadorSucursal){
        boolean encontrado = false;
        int indice=0;
            
            for(int i=0; i<contadorSucursal;i++){
                if(sucursal[i].getNumeroSucursal() == numeroSucursal){
                    encontrado = true;
                    indice = 1;
                }
            }
            
            if(encontrado== false){
                indice = -1;
            }
        return indice;
    }
    
    public static void main (String [] args){
    Scanner entrada = new Scanner(System.in);
    
    int numeroPaquete, prioridad, numeroSucursal, opcion, contadorSucursal=0, contadorPaquete=0;
    String dni, direccion, ciudad;
    double peso, precioPaquete;
    int indiceSucursal, indicePaquete;
    Paquete paquete [] = new Paquete[50];
    Sucursal sucursal[] = new Sucursal[100];
    
    
    
    
    do{
        System.out.println("\t\n...:::MENÚ:::...");
        System.out.println("1.-Agregar sucursal");
        System.out.println("2.-Enviar paquete");
        System.out.println("3.-Consultar sucursal");
        System.out.println("4.-Consultar paquete");
        System.out.println("5.-Mostrar todas las sucursales");
        System.out.println("6-.Mostrar todos los paquetes");
        System.out.println("7.-Salir");
        
        System.out.print("\nElige una opción: ");
        opcion = entrada.nextInt();
        
        switch(opcion){
            
            case 1:
                    System.out.print("\nIngresa el número de sucursal: ");
                    numeroSucursal = entrada.nextInt();
                    entrada.nextLine();
                    System.out.print("Ingresa dirección: ");
                    direccion = entrada.nextLine();
                    System.out.print("Ingresa ciudad: ");
                    ciudad = entrada.nextLine();
                    
                    sucursal [contadorSucursal] = new Sucursal(numeroSucursal, direccion, ciudad);
                
                    contadorSucursal++;
                break;
                
                
            case 2: 
                System.out.print("Ingresa númer de sucursal: ");
                numeroSucursal = entrada.nextInt();
                
                indiceSucursal = BuscarSucursal(sucursal, numeroSucursal, contadorSucursal);
                if(indiceSucursal==-1){
                    System.out.println("La sucursal no existe.");
                }
                else{
                    System.out.print("\nIngresa número del paquete: ");
                    numeroPaquete = entrada.nextInt();
                    entrada.nextLine();
                    System.out.print("Ingresa DNI: ");
                    dni = entrada.nextLine();
                    System.out.print("Ingresa el peso del paquete: ");
                    peso = entrada.nextDouble();
                    System.out.print("Ingresa laprioridad del paquete. 0.-Normal, 1.-Alta, 2.-Express. ");
                    prioridad = entrada.nextInt();
                    
                    paquete[contadorPaquete] = new Paquete(numeroPaquete, dni, peso, prioridad);
                    
                    precioPaquete = sucursal[indiceSucursal].calcularPrecioPaquete(paquete[contadorPaquete]);
                    System.out.println("El precio es: "+precioPaquete);
                    contadorPaquete++;  
                }
               break;
                
                
                
            case 3:
                System.out.print("\nIngrese número de sucursal: ");
                numeroSucursal = entrada.nextInt();
                
                indiceSucursal = BuscarSucursal(sucursal, numeroSucursal, contadorSucursal);
                
                if(indiceSucursal==-1){
                    System.out.println("La sucursal no existe.");
                }
                else{
                    System.out.println("\nLos datos de la sucursal son: ");
                    System.out.println(sucursal[indiceSucursal].mostrarDatosSucursal());
                }break;
                
            case 4:
                System.out.println("\nIngrese número de paquete: ");
                numeroPaquete = entrada.nextInt();
                
                indicePaquete = BuscarPaquete(paquete, numeroPaquete, contadorPaquete);
                if (indicePaquete==-1){
                    System.out.println("El paquete no existe.");
                }
                else{
                    System.out.println("\nLos datos del paquete son: ");
                    System.out.println(paquete[indicePaquete].mostrarDatosPaquete());
                }
                
                break;
                
            case 5:
                if(contadorSucursal ==0){
                    System.out.println("\nNo hay sucursales.");
                }
                else{
                    for(int i=0; i<contadorSucursal; i++){  
                        System.out.println("\n");
                        System.out.println(sucursal[i].mostrarDatosSucursal());
                        System.out.println("\n");
                    }
                }
                
                break;
                
                
            case 6:
                if(contadorPaquete == 0){
                    System.out.println("\nNo hay paquetes.");
                }
                else{
                    for (int i=0; i<contadorPaquete; i++){
                        System.out.println("\n");
                        System.out.println(paquete[i].mostrarDatosPaquete());
                        System.out.println("\n");
                    }
                }
                
                break;
                
            case 7:
                break;
                
            default:
                System.out.println("Opción inválida.");
                break;
                
        }
        
    
}while(opcion !=7);
        
    } 
}
