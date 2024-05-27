package it.marconi.biblioteca_lotti.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import it.marconi.biblioteca_lotti.domanis.AddForm;
import it.marconi.biblioteca_lotti.services.LibroService;

@Controller
@RequestMapping("/")
public class LibroController {
    @Autowired
    LibroService libroService;

    @GetMapping
    public ModelAndView viewHomePage() {

        return new ModelAndView("elenco");
    }

    //Inserimento nuovo libro
    @PostMapping("/libri/nuovo")
    public ModelAndView handlerNewUser(@ModelAttribute AddForm libroForm) {


        // salvo l'utente nel finto database
        LibroService.addLibro(libroForm);  
}

// prendere un libro tramite il codice isbn
@GetMapping("/libri/{isbn}")
    public  ModelAndView userDetail(@PathVariable("isbn") String isbn) {


        Optional<AddForm> libro = LibroService.getLibroByIsbn(isbn);


        // se il libro esiste, mostro la pagina delle informazioni
        if (libro.isPresent())
            return new ModelAndView("libro-detail").addObject("libro", libro.get());
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Utente non trovato!");

}

