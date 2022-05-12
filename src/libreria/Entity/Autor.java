
package libreria.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @Column(name="id_autor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
   
    private String nombre;
    private boolean alta;

    public Autor() {
    }

    //CONSTRUCTOR DONDE NO SE ENCUENTRA EL ID, PORQUE ES AUTOGENERADO PARA LA BASE DE DATOS
    public Autor(String nombre, boolean alta) {
        this.nombre = nombre;
        this.alta = alta;
    }

    public Autor(String id, String nombre, boolean alta) {
        this.id = id;
        this.nombre = nombre;
        this.alta = alta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

    @Override
    public String toString() {
        return "Autor{" + "id=" + id + ", nombre=" + nombre + ", alta=" + alta + '}';
    }
    
    
}
