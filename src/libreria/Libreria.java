/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package libreria;

import java.util.List;
import java.util.Scanner;
import libreria.Entity.Autor;
import libreria.Entity.Editorial;
import libreria.Entity.Libro;
import libreria.Persistencia.AutorDAO;
import libreria.Persistencia.EditorialDAO;
import libreria.Persistencia.LibroDAO;
import libreria.Service.AutorService;
import libreria.Service.EditorialService;
import libreria.Service.LibroService;


public class Libreria {

    public static void main(String[] args) throws Exception {
       Scanner sc = new Scanner(System.in);
         LibroService serviLibro = new LibroService();
         AutorService serviAutor = new AutorService();
         EditorialService serviEditorial = new EditorialService();
         
         
         
        Autor autor = serviAutor.verificarExistenciaAutor("17");
        System.out.println(autor);
         Editorial editorial = serviEditorial.verificarExistenciaEditorial(29);
         if(editorial==null){
             System.out.println("No existe editorial");
             System.out.println("Crear nueva");
             editorial = serviEditorial.crearEdiorial("Editorial Obelisco", Boolean.TRUE);
             List<Editorial>lista = serviEditorial.listarEditorial();
             for (Editorial edito : lista) {
                 if(edito.getNombre().equals(editorial.getNombre()))
                     editorial = edito;
             }
             System.out.println(editorial.getId());
             System.out.println(editorial.getNombre());
         }
         
        Libro libro = serviLibro.crearLibro("EL perdido", 2010, 12, 0, 0, Boolean.TRUE,autor,editorial);
        
        //System.out.println(libro);
          
    }
    
}
