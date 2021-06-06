package com.example.Shelfish.controller;

import com.example.Shelfish.models.Autor;
import com.example.Shelfish.models.Livro;
import com.example.Shelfish.service.ShelfishAutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Locale;

@Controller
public class ShelfishAutorController {

    @Autowired
    ShelfishAutorService shelfishAutorService;

    @RequestMapping(value = "/autor/{autorCod}", method = RequestMethod.GET)
    //Ele trata o view e o Model juntos
    public ModelAndView getAutorbyName(@PathVariable(value = "autorCod") int autorCodurl) {
        ModelAndView modelAndView = new ModelAndView("autor");
        Autor autorPesquisado = shelfishAutorService.findbyAutorCod(autorCodurl);
        modelAndView.addObject("autorPesquisado", autorPesquisado);
        return modelAndView;
    }

    @RequestMapping(value = "/cadastrarautor", method = RequestMethod.GET)
    public String getCadastrarAutor(){
        return "cadastrarautor";
    }

    @RequestMapping(value = "/cadastrarautor", method = RequestMethod.POST)
    public String postCadastrarautor(@ModelAttribute Autor autor, RedirectAttributes att, Model model){
        model.addAttribute("autor", new Autor());
        shelfishAutorService.save(autor);
        return "redirect:/";
    }

    @RequestMapping(value = "/deletarautor/{autorCod}", method = RequestMethod.POST)
    public String deleteAutorbyid(@PathVariable(value = "autorCod") int autorCodurl, RedirectAttributes att) {
        Autor autordeletado = shelfishAutorService.findbyAutorCod(autorCodurl);
        shelfishAutorService.delete(autordeletado);
        return "redirect:/";
    }


    @RequestMapping(value = "/atualizarautor/{autorCod}", method = RequestMethod.POST)
    public ModelAndView atualizarAutorbyCod(@PathVariable(value = "autorCod") int autorCodnurl, RedirectAttributes att) {
        ModelAndView modelAndView = new ModelAndView("editarautor");
        Autor autorPesquisado = shelfishAutorService.findbyAutorCod(autorCodnurl);
        modelAndView.addObject("autorPesquisado", autorPesquisado);
        return modelAndView;
    }

    @RequestMapping(value = "/atualizarautor", method = RequestMethod.POST)
    public String postAtualizarautor(@ModelAttribute Autor autor, RedirectAttributes att, Model model){
        model.addAttribute("autor", new Autor());
        shelfishAutorService.save(autor);
        String redirect = "redirect:/autor/" + autor.getAutorCod();
        return redirect;
    }

}
