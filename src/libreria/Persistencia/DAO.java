
package libreria.Persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAO<T> {
    // CREAMOS UN ENTITY MANAGER
    protected final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("libreriaPU");
    protected EntityManager em = EMF.createEntityManager();
    
    //CONSTRUCTOR VACIO
   
    
    protected void conectar() {
        if (!em.isOpen()) {
            em = EMF.createEntityManager();
            //System.out.println("Conexion");
        }
    }

    protected void desconectar() {
        if (em.isOpen()) {
            em.close();
        }
    }
    
   
    protected void guardar(T objeto){
        try {
            conectar();
            em.getTransaction().begin();
            em.persist(objeto);
            em.getTransaction().commit();
        } catch (Exception e) {
 
            e.printStackTrace();
            throw e;
        } finally {
            desconectar();
 
        }
        
        
        
//        conectar();
//        em.getTransaction().begin();
//        em.persist(objeto);
//        em.getTransaction().commit();
//        desconectar();
    }
    
    protected void editar(T objeto){
        conectar();
        em.getTransaction().begin();
        em.merge(objeto);
        em.getTransaction().commit();
        desconectar();
    }
    
    protected void eliminar(T objeto){
        conectar();
        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
        desconectar();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    // METODO PARA CONECTAR BASE
//    protected void conectar() throws Exception {
//        try{
//            if (!em.isOpen()) {
//            em = EMF.createEntityManager(); // ENTITY MANAGER ENCARGADO DE GESTIONAR INSTANCIAS
//            }
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//            throw new Exception("ERROR EN LA CONEXIÓN");
//        }
//    }
//
//    //METODO PARA DESCONECTAR BASE
//    protected void desconectar() throws Exception {
//        try{
//            if (em.isOpen()) {
//            em.close();
//            }
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//            throw new Exception("ERROR EN LA CONEXIÓN");
//        }
//        
//    }
//    
//    // METODO PARA GUARDAR UN DETERMINADO OBJETO EN LA BASE
//    protected void guardar(T objeto)throws Exception{
//        try{
//            conectar();
//            em.getTransaction().begin(); // INICIAMOS UNA TRANSACCIÓN A LA BASE DE DATOS
//            // PERSISTIMOS EL OBJETO, MANTENEMOS LA INFORMACIÓN DEL MISMO
//            em.persist(objeto);
//            // FINALIZAMOS LA TRANSACCIÓN CON UN COMMIT(CONFIRMAR CAMBIOS)
//            em.getTransaction().commit();
//        }catch(Exception ex){
//            System.out.println(ex.getMessage());
//            throw new Exception("ERROR AL GUARDAR EL OBJETO");
//        }finally{
//            desconectar();
//        }
//    }
//    
//    
//    // METODO PARA EDITAR INFORMACIÓN PASANDOLE EL OBJETO A MODIFICAR
//    protected void editar(T objeto)throws Exception{
//        try{
//            conectar();
//            em.getTransaction().begin();//INICIAMOS LA TRANSACCIÓN
//
//            // METODO QUE FUNCIONA COMO PERSIST PERO ES PARA ACTUALIZAR INFORMACIÓN
//            em.merge(objeto);
//
//
//            // FINALIZAMOS LA TRANSACCIÓN
//            em.getTransaction().commit();
//        }catch(Exception ex){
//            System.out.println(ex.getMessage());
//            throw new Exception("ERROR AL EDITAR EL OBJETO");
//        }finally{
//            desconectar();
//        }
//            
//       
//    }
//    
//    // METODO PARA ELIMAR UN OBJETO DE LA TABLA 
//    protected void eliminar(T objeto) throws Exception{
//        try{
//            conectar();
//            // INICIA LA TRANSACCIÓN
//            em.getTransaction().begin();
//            em.remove(objeto);// ELIMINA EL OBJETO
//            em.getTransaction().commit();// FINALIZAMOS LA TRANSACCIÓN
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//            throw new Exception("ERROR AL ELIMINAR EL OBJETO");
//        }finally{
//            desconectar();
//        }
//        
//    }

    
}
