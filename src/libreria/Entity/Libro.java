
package libreria.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity 
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long isbn;
    @Column
    private String nombre;
    private Integer anio;
    private Integer ejemplares;
    private Integer emplaresPrestados;
    private Integer ejemplaresRestantes;
    private boolean alta;
    
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="id_autor")

    private Autor autor;
    
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="id_editorial")
    private Editorial editorial;

    public Libro() {
    }
// CONSTRUCTOR LIBRO SIN ID

    public Libro(String nombre, Integer anio, Integer ejemplares, Integer emplaresPrestados, Integer ejemplaresRestantes, boolean alta, Autor autor, Editorial editorial) {
        this.nombre = nombre;
        this.anio = anio;
        this.ejemplares = ejemplares;
        this.emplaresPrestados = emplaresPrestados;
        this.ejemplaresRestantes = ejemplaresRestantes;
        this.alta = alta;
        this.autor = autor;
        this.editorial = editorial;
    }
  

    
    public Libro(long isbn, String nombre, Integer anio, Integer ejemplares, Integer emplaresPrestados, Integer ejemplaresRestantes, boolean alta, Autor autor, Editorial editorial) {
        this.isbn = isbn;
        this.nombre = nombre;
        this.anio = anio;
        this.ejemplares = ejemplares;
        this.emplaresPrestados = emplaresPrestados;
        this.ejemplaresRestantes = ejemplaresRestantes;
        this.alta = alta;
        this.autor = autor;
        this.editorial = editorial;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(Integer ejemplares) {
        this.ejemplares = ejemplares;
    }

    public Integer getEmplaresPrestados() {
        return emplaresPrestados;
    }

    public void setEmplaresPrestados(Integer emplaresPrestados) {
        this.emplaresPrestados = emplaresPrestados;
    }

    public Integer getEjemplaresRestantes() {
        return ejemplaresRestantes;
    }

    public void setEjemplaresRestantes(Integer ejemplaresRestantes) {
        this.ejemplaresRestantes = ejemplaresRestantes;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        return "Libro{" + "isbn=" + isbn + ", nombre=" + nombre + ", anio=" + anio + ", ejemplares=" + ejemplares + ", emplaresPrestados=" + emplaresPrestados + ", ejemplaresRestantes=" + ejemplaresRestantes + ", alta=" + alta + ", autor=" + autor.getId() + ", editorial=" + editorial.getId() + '}';
    }
    
}
