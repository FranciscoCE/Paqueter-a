
package Paquetera;


public class Sucursal {
    private int numeroSucursal;
    private String direccion;
    private String ciudad;

    
    public Sucursal(int numeroSucursal, String direccion, String ciudad){
        this.numeroSucursal = numeroSucursal;
        this.direccion = direccion;
        this.ciudad = ciudad;
    }
    
    public int getNumeroSucursal(){
        return numeroSucursal;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCiudad() {
        return ciudad;
    }
    
    
    public String mostrarDatosSucursal(){
        return "Número de sucursal: "+numeroSucursal+"\nDirección: "+direccion+"\nCiudad: "+ciudad;           
    }
    
    public double calcularPrecioPaquete(Paquete paquete){
        double precio;
        precio = paquete.getPeso();
       
        if(paquete.getPrioridad()==1){
            precio+=10;
        }
        if(paquete.getPrioridad()==2){
            precio+=20;
        }
        return precio;
    }
    
    
}
