/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.Service;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.Entity.Autor;
import libreria.Entity.Editorial;
import libreria.Entity.Libro;
import libreria.Persistencia.LibroDAO;

/**
 *
 * @author user
 */
public class LibroService {
    private final Scanner sc;
    private AutorService serviceAutor;
    private EditorialService serviceEditorial;
    private final LibroDAO DAO;
  
    public LibroService() {
        this.sc = new Scanner(System.in);
        this.serviceEditorial = new EditorialService();
        this.serviceAutor = new AutorService();
        this.DAO = new LibroDAO();
        
    }
    
    

    //METODO PARA CREAR LIBRO
    public Libro crearLibro(String nombre, Integer anio, Integer ejemplares, 
            Integer ejemplaresPrestados, Integer ejemplaresRestantes, boolean alta,
            Autor autor, Editorial editorial)throws Exception{
        
        try{
            Libro libro = new Libro();
            libro.setNombre(nombre);
            libro.setAnio(anio);
            libro.setEjemplares(ejemplares);
            libro.setEmplaresPrestados(ejemplaresPrestados);
            libro.setEjemplaresRestantes(ejemplaresRestantes);
            libro.setAlta(alta);
            
                libro.setAutor(autor);
            
            
                libro.setEditorial(editorial);
            
            DAO.guardarLibro(libro);
            return libro;
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
    }
    
    
    
    // METODO PARA VERIFICAR SI EL LIBRO CREADO YA EXISTE
    public boolean VerificarExistencia(Libro libro) throws Exception{
        List<Libro>lista = DAO.listarTodos();
        for (Libro lib : lista) {
            if(lib.equals(libro)){
                System.out.println("EL LIBRO YA EXISTE");
                return false;
                
            } 
            if(lib.getNombre().equalsIgnoreCase(libro.getNombre())&&
                    (lib.getAutor().equals(libro.getAutor()))){
                System.out.println("El LIBRO YA EXISTE");
                return false;
                
            }
            
        }
        return true;
        
    }
    
     public List<Libro> listarLibros() {
        try {
            return DAO.listarTodos();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
     
     public Libro buscarPorId(long id) throws Exception{
         return DAO.buscarPorId(id);
     }
     
     public void eliminarLibro(long id) throws Exception{
         DAO.eliminarLibro(id);
     }
             
     
     //METODO PARA BUSCAR LIBRO POR TITULO
     public Libro buscarLibroPorTitulo() throws Exception{
         try{
             System.out.println("Ingrese el titulo a buscar");
             String nombre = sc.next();
             if(nombre.isEmpty()){
                 throw new Exception("DEBE INGRESAR UN TÍTULO");
             }
             Libro libro = DAO.buscarLibroTitulo(nombre);
             if(libro==null){
                 throw new Exception("NO SE ENCONTRO NINGÚN RESULTADO");
             }
             return libro;
         }catch(Exception e){
             System.out.println(e.getMessage());
             throw e;
         }
     }
     
     // METODO PARA BUSCAR LIBRO POR NOMBRE DEL AUTOR
     public List<Libro>listarLibrosAutor(String nombreAutor) throws Exception{
         try{
             if(nombreAutor.isEmpty()){
                 throw new Exception("EL NOMBRE DEL AUTOR NO PUEDE ESTAR VACIO");
                 
             }
             List<Libro> lista = DAO.buscarLibroPorAutor(nombreAutor);
             if(lista.isEmpty()){
                System.out.println("EL AUTOR NO ESTA ASIGNADO A NINGUN LIBRO");
            }
             if(lista==null){
                 throw new Exception("NO SE ENCONTRARON RESULTADOS");
             }
             return lista;
         }catch(Exception e){
         throw e;
        }
       
     }
     
     
     // METODO PARA BUSCAR LIBROS SEGUN EL NOMBRE DE LA  EDITORIAL 
     public List<Libro>listarLibrosEditorial(String nombreEditorial) throws Exception{
         try{
             if(nombreEditorial.isEmpty()){
                 throw new Exception("EL NOMBRE DE LA EDITORIAL NO PUEDE ESTAR VACIO");
                 
             }
             List<Libro> lista = DAO.buscarLibroPorEditorial(nombreEditorial);
             if(lista.isEmpty()){
                System.out.println("LA EDITORIAL NO ESTA ASIGNADO A NINGUN LIBRO");
            }
             if(lista==null){
                 throw new Exception("NO SE ENCONTRARON RESULTADOS");
             }
             return lista;
         }catch(Exception e){
         throw e;
        }
       
     }
     
     //METODO PARA VALIDAR EL NOMBRE 
     public String validarTitulo(String titulo) throws Exception{
         try{
             String nombre = DAO.ValidarNombre(titulo);
             if(nombre.equalsIgnoreCase(titulo)){
                 System.out.println("EL TÍTULO YA SE ENCUENTRA REGISTRADO");
                 
             }
             return nombre;
             
             
         }catch(Exception e){
             throw e;
         }
     }
}
