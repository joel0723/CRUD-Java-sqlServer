
package javaapplication3;



public class Cliente {
    private String ID;
    private String Nombre;
    private String Apellido;
    private String Compañia;
    private String Posicion;
    private String Email;
    private String Telefono;
    private String Notas;
    

    public Cliente() {
        
    }

    public Cliente(String ID,  String Nombre, String Apellido, String Compañia, String Posicion, String Email, String Telefono, String Notas) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Compañia = Compañia;
        this.Posicion = Posicion;
        this.Email = Email;
        this.Telefono = Telefono;
        this.Notas = Notas;
    }

    public Cliente(String Nombre, String Apellido, String Compañia, String Posicion, String Email, String Telefono, String Notas) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Compañia = Compañia;
        this.Posicion = Posicion;
        this.Email = Email;
        this.Telefono = Telefono;
        this.Notas = Notas;
    }

  

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getCompañia() {
        return Compañia;
    }

    public void setCompañia(String Compañia) {
        this.Compañia = Compañia;
    }

    public String getPosicion() {
        return Posicion;
    }

    public void setPosicion(String Posicion) {
        this.Posicion = Posicion;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getNotas() {
        return Notas;
    }

    public void setNotas(String Notas) {
        this.Notas = Notas;
    }


       
    
}
   