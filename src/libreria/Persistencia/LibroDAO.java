/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.Persistencia;

import java.util.List;
import javax.persistence.Query;
import libreria.Entity.Libro;


public class LibroDAO extends DAO<Libro>{

    public LibroDAO() {
        super();
    }
    
    /**
     *
     * @param libro
     */
    @Override
    public void guardar(Libro libro) {
        try{
           super.guardar(libro);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            throw ex;
        }
    }
    
    public void guardarLibro(Libro libro){
          try {
            conectar();
            em.getTransaction().begin();
            em.persist(libro);
            em.getTransaction().commit();
        } catch (Exception e) {
 
            e.printStackTrace();
            throw e;
        } finally {
            desconectar();
 
        }
    }

//    
//    public void eliminar(long id) throws Exception {
//        try{
//            Libro libro = buscarPorId(id);
//            if(libro==null){
//                System.out.println("EL LIBRO NO SE PUDO ELIMINAR, NO SE ENCUENTRA REGISTRADO");
//            }
//            this.eliminar(libro);
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//            throw e;
//        }
//    }

   // METODO BUSCAR LIBRO POR ISBN(ID)
    public Libro buscarPorId(long id) throws Exception {
        try{
            this.conectar();
            Libro libro = em.find(Libro.class, id);
            if(libro==null){
                System.out.println("EL LIBRO SOLICITADO NO SE ENCUENTRA");
            }
                
            return libro;
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw e;
        }finally{
            this.desconectar();
        }
    }

    public List<Libro> listarTodos() throws Exception {
       try{
            conectar();
        List<Libro> ListaLibros = em.createQuery("SELECT d FROM Libro d")
                .getResultList();
        
        return ListaLibros;
       }catch(Exception e){
           System.out.println(e.getMessage());
           throw e;
       }finally{
           this.desconectar();
       }
           
    }
    
    public void eliminarLibro(long id) throws Exception{
        conectar();
       em.getTransaction().begin();
      Libro libro = em.find(Libro.class, id);
      if (libro!= null) {
         em.remove(libro);
      }
      em.getTransaction().commit();
      desconectar();
     }
    
    // METODO BUSCAR LIBRO POR TITULO
    public Libro buscarLibroTitulo(String titulo){
        try{
            Libro libro = (Libro)em.createQuery("SELECT l FROM Libro l WHERE l.nombre LIKE :nombre").setParameter("nombre",titulo).getSingleResult();
            return libro;
        }catch(Exception e){
            throw e;
        }
    }
    
    //METODO PARA BUSCAR LIBRO CON NOMBRE DEL AUTOR
    public List<Libro> buscarLibroPorAutor(String autorNombre){
        try{
            List<Libro> lista = em.createQuery("SELECT a FROM Libro a WHERE a.autor.nombre LIKE :autorNombre")
                    .setParameter("autorNombre",autorNombre).getResultList();
            
            return lista;
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
    }
    
    public List<Libro> buscarLibroPorEditorial(String editorialNombre){
        try{
            List<Libro> lista = em.createQuery("SELECT a FROM Libro a WHERE a.editorial.nombre LIKE :editorialNombre")
                    .setParameter("editorialNombre",editorialNombre).getResultList();
            
            return lista;
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
    }
    
    
    //METODO PARA VER SI EL NOMBRE INGRESADO DEL NUEVO LIBRO YA SE ENCUENTRA O NO
     public String ValidarNombre(String nombre) throws Exception{
         try{
           String titulo = (String) em.createQuery("SELECT a.nombre FROM Libro a WHERE a.nombre LIKE :nombre")
                   .setParameter("nombre",nombre).getSingleResult();
                     
            return titulo; 
         }catch(Exception e){
             System.out.println(e.getMessage());
             throw new Exception("ERROR EN LA VALIDACIÓN");
                 
             
         }
     }
}
