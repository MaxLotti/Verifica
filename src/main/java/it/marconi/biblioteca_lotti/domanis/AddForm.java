package it.marconi.biblioteca_lotti.domanis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddForm {

    private String isbn;
    private String titolo;
    private String autore; 
    private String genere; 
    private String annopubblicazione;

}
