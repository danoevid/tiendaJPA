/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.Persistencia;

import java.util.List;
import libreria.Entity.Autor;

/**
 *
 * @author user
 */
public class AutorDAO extends DAO<Autor>{
 
    public AutorDAO() {
        super();
    }
    
    // METODO PARA GUARDAR AUTOR PASANDO POR PARAMETRO UN AUTOR
    @Override
    public void guardar(Autor autor)  {
        
           super.guardar(autor);
          
    }

    // METODO ELIMINAR AUTOR, PASANDO POR PARAMETRO EL ID. NO UTILIZAMOS METODO DE DAO PADRE
    // GENERAMOS UNA TRANSACCION AQUI
    public void eliminar(String id) throws Exception {
      em.getTransaction().begin();
     Autor autor = em.find(Autor.class, id);
      if (autor!= null) {
         em.remove(autor);
          System.out.println("SE ELIMINO CON ÉXITO");
      }else{
          System.out.println("EL AUTOR NO FUE ENCONTRADO");
      }
      em.getTransaction().commit();
      desconectar();
   }
        

   // METODO BUSCAR AUTOR POR ID
    public Autor buscarPorId(String id) throws Exception {
        try{
            this.conectar();
            Autor autor = em.find(Autor.class, id);
            if(autor==null){
                System.out.println("EL AUTOR SOLICITADO NO SE ENCUENTRA");
            }
                
            return autor;
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw e;
        }finally{
            this.desconectar();
        }
    }
    
    // METODO PARA LISTAR TODOS LOS AUTORES DE LA BASE DE DATOS
    public List<Autor> listarTodos() throws Exception {
       try{
            conectar();
        List<Autor> ListaAutores = em.createQuery("SELECT d FROM Autor d")
                .getResultList();
        
        return ListaAutores;
       }catch(Exception e){
           System.out.println(e.getMessage());
           throw e;
       }finally{
           this.desconectar();
       }
           
    }
    
    // METODO EDITAR AUTOR, PASANDO UN AUTOR POR PARAMETRO
     public void editarAutor(Autor autor) throws Exception{
        try{
            if(autor!=null){
                this.editar(autor);
                System.out.println("MODIFICACIÓN EXITOSA");
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
    }
     
     
     // METODO BUSCAR AUTOR POR NOMBRE PASADO POR PARAMETRO
     public List<Autor> buscarPorNombreAutor(String nombre){
         try{
            this.conectar();
            
            List<Autor> lista =em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE :nombre").setParameter("nombre",nombre)
                    .getResultList();
            if(lista==null){
                System.out.println("EL AUTOR SOLICITADO NO SE ENCUENTRA");
            }
               
            return lista;
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw e;
        }finally{
            this.desconectar();
        }
     }
     
     // METODO PARA VERIFICAR SI EXISTE AUTOR
     public Autor verificarExistencia(String id) throws Exception{
         try{
             
             Autor autor  = em.find(Autor.class, id);
             List<Autor>listaAuotores = listarTodos();
             for (Autor aut : listaAuotores) {
                 if(aut.equals(autor)){
                     return aut; 
                    
                 }
             }
             return autor;
         }catch(Exception e){
             System.out.println(e.getMessage());
             return null;
         }
     }
}
