package it.marconi.biblioteca_lotti.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import it.marconi.biblioteca_lotti.domains.AddForm;

@Service
public class LibroService {
    
    //finto database
     private ArrayList<AddForm> libri = new ArrayList<>();

     //metodo per avere tutti i libri che si trovano all'interno del finto databese
     public ArrayList<AddForm> getLibro() {
         return libri;
     }

     //return Optional.empty();
 
    //Metodo per aggiungere un nuovo libro
     public void addLibro(AddForm newLibro) {
         libro.add(newLibro);
     }

     public Optional<AddForm> getUserByUsername(String username) {

        for(AddForm l : libri) {
            if(l.getIsbn().equals(isbn)) {
                return Optional.of(l);
            }
        }
        return Optional.empty();
    }
 
}
