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
import libreria.Persistencia.AutorDAO;

/**
 *
 * @author user
 */
public class AutorService {
    private final Scanner sc; 
    AutorDAO dao = new AutorDAO();
    
   
    
    public AutorService(){
        this.sc = new Scanner(System.in).useDelimiter("\n");
    }
    
    //METODO DONDE VAMOS A CREAR UN AUTOR
    public Autor crearAutor(String nombre, boolean alta) throws Exception{
        try{
            Autor autor = new Autor();
            autor.setNombre(nombre);
            autor.setAlta(alta);
            return autor;
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
        
    }
    
    public void eliminarAutor(String id) throws Exception{
        try{
            
            dao.eliminar(id);
            
        }catch(Exception e){
            throw e;
        }
    }
    
    
    public void guardarAutor(Autor autor) throws Exception{
        try{
            if(autor.getNombre().isEmpty()){
                throw new Exception("EL AUTOR NO PUEDE TENER UN NOMBRE VACIO");
            }
            if(autor.isAlta()==false){
                throw new Exception("EL AUTOR TIENE QUE ESTAR HABILIDADO");
            }
            dao.guardar(autor);
            System.out.println("AUTOR GUARDADO CON ÉXITO");
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw new Exception("ERROR AL GUARDAR AUTOR");
        }
    }
    
    
   public void editarAutor(String id) throws Exception{
       try{
           Autor autor = dao.buscarPorId(id);
           System.out.println("1-MODIFICAR NOMBRE 2-DARLO DE BAJA");
           var op = sc.nextInt();
           if(op==1){
               System.out.println("Ingrese nombre: ");
               var nombre = sc.next();
               autor.setNombre(nombre);
           }else if(op==2){
               autor.setAlta(Boolean.FALSE);
           }
           dao.editarAutor(autor);
       }catch(Exception e){
           throw e;
       }
       
   }
   
   //METODO PARA BUSCAR AUTOR POR NOMBRE, EXTRAIDO DE autorDAO
   public List<Autor> buscarAutorPorNombre() throws Exception{
       try{
           System.out.println("Ingrese el nombre que desea buscar");
           String nombre = sc.next();
           if(nombre.isEmpty()){
               throw new Exception("EL NOMBRE DEL AUTOR NO PUEDE ESTAR VACIO");
           }
           
           List<Autor>lista = dao.buscarPorNombreAutor(nombre);
           
           return lista;
       }catch(Exception e){
           throw e;
       }
   }
   
   public Autor buscarAutorId(String id) throws Exception{
       try{
           Autor autor = dao.buscarPorId(id);
           if(autor==null){
               throw new Exception("ERROR AL BUSCAR AUTOR");
           }
           return autor;
       }catch(Exception e){
           throw e;
       }
   }
   
   // METODO PARA VER SI EXISTE EL AUTOR
      public Autor verificarExistenciaAutor(String id) throws Exception{
         try{
             boolean t = false;
             Autor autor = dao.verificarExistencia(id);
             List<Autor>listaAuotores = dao.listarTodos();
             for (Autor aut : listaAuotores) {
                 if(aut.equals(autor)){
                    return autor; 
                     
                 }
             }
             return autor;
         }catch(Exception e){
             System.out.println(e.getMessage());
             return null;
         }
     }
}
