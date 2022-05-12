
package libreria.Service;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.Entity.Editorial;
import libreria.Persistencia.EditorialDAO;


public class EditorialService {
    private final Scanner sc;
    EditorialDAO dao = new EditorialDAO();
    public EditorialService(){
        this.sc = new Scanner(System.in);
    }
    
    
    // METODO DONDE VAMOS A CREAR UNA EDITORIAL
    public Editorial crearEdiorial(String nombre, boolean alta){
        try{
            Editorial editorial = new Editorial();
            editorial.setNombre(nombre);
            editorial.setAlta(alta);
            return editorial;
        }catch(Exception e){
            throw e;
        }
    }
    public void guardarEditorial(Editorial editorial) throws Exception{
        try{
            if(editorial!=null){
            dao.guardar(editorial);
            System.out.println("EDITORIAL GUARDADA CON EXITO.");
            }else{
                throw new Exception("ERROR AL GUARDAR EDITORIAL");
            }
        }catch(Exception e){
            throw e;
        }
    }
    
    public void elimarEditorial(Integer id) throws Exception{
        try{
            dao.eliminar(id);
            System.out.println("Se elimino con exito");
        }catch(Exception e){
            throw e;
        }
      
     
   }
    
    public Editorial buscarEditorialId(Integer id) throws Exception{
        try{
            Editorial editorial = dao.buscarPorId(id);
            return editorial;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            throw ex;
        }
    }
    
    
    // METODO PARA VER SI EXISTE EL AUTOR
      public Editorial verificarExistenciaEditorial(Integer id) throws Exception{
         try{
             boolean t = false;
             Editorial editorial = dao.verificarExistencia(id);
             List<Editorial>listaEditoriales = dao.listarTodos();
             if(editorial!=null){
                 return editorial;
             }
             return editorial;
         }catch(Exception e){
             System.out.println(e.getMessage());
             return null;
         }
     }
      
      public List<Editorial>listarEditorial() throws Exception{
          return dao.listarTodos();
      }
    
}
