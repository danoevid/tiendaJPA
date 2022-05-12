/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.Persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import libreria.Entity.Editorial;


public class EditorialDAO extends DAO<Editorial> {

    public EditorialDAO() {
        
        super();
    }
    
    @Override
    public void guardar(Editorial editorial) {
      super.guardar(editorial);
    }

    public void eliminar(Integer  id) throws Exception {
        
         em.getTransaction().begin();
      Editorial editorial = em.find(Editorial.class, id);
      if (editorial!= null) {
         em.remove(editorial);
      }
      em.getTransaction().commit();
      em.close();
//        try{
//            Editorial editorial = buscarPorId(id);
//            if(editorial==null){
//                System.out.println("LA EDITORIAL NO SE PUDO ELIMINAR, NO SE ENCUENTRA REGISTRADO.");
//            }
//            this.eliminar(editorial);
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//            throw e;
//        }
    }

   
    public Editorial buscarPorId(Integer id) throws Exception {
        try{
            this.conectar();
            Editorial editorial = em.find(Editorial.class, id);
            if(editorial==null){
                System.out.println("LA EDITORIAL SOLICITADO NO SE ENCUENTRA");
            }
                
            return editorial;
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw e;
        }finally{
            this.desconectar();
        }
    }

    public List<Editorial> listarTodos() throws Exception {
       try{
            conectar();
        List<Editorial> ListaEditoriales = em.createQuery("SELECT d FROM Editorial d")
                .getResultList();
        
        return ListaEditoriales;
       }catch(Exception e){
           System.out.println(e.getMessage());
           throw e;
       }finally{
           this.desconectar();
       }
           
    }
    
    
     public Editorial verificarExistencia(Integer id) throws Exception{
         try{
             
             Editorial editorial = em.find(Editorial.class, id);
             List<Editorial>listaAuotores = listarTodos();
             for (Editorial edit : listaAuotores) {
                 if(edit.equals(editorial)){
                     return edit; 
                     
                 }
             }
             return editorial;
         }catch(Exception e){
             System.out.println(e.getMessage());
             return null;
         }
     }
    
}
