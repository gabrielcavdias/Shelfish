package com.example.Shelfish.controller;

import com.example.Shelfish.models.Livro;
import com.example.Shelfish.service.ShelfishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ShelfishController {
    @Autowired
    ShelfishService shelfishService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    //Ele trata o view e o Model juntos
    public ModelAndView getLivros() {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Livro> livros = shelfishService.findAll();
        modelAndView.addObject("livros", livros);
        return modelAndView;
    }

    @RequestMapping(value = "/livro/{isbn}", method = RequestMethod.GET)
    //Ele trata o view e o Model juntos
    public ModelAndView getLivrobyISBN(@PathVariable(value = "isbn") String isbnUrl) {
        ModelAndView modelAndView = new ModelAndView("livro");
        Livro livroPesquisado = shelfishService.findbyISBN(isbnUrl);
        modelAndView.addObject("livroPesquisado", livroPesquisado);
        return modelAndView;
    }

    @RequestMapping(value = "/cadastrarlivro", method = RequestMethod.GET)
    public String getCadastrarlivro(){
        return "cadastrarlivro";
    }

    //https://spring.io/guides/gs/handling-form-submission/
    @RequestMapping(value = "/cadastrarlivro", method = RequestMethod.POST)
    public String postCadastrarlivro(@ModelAttribute Livro livro, RedirectAttributes att, Model model){
        model.addAttribute("livro", new Livro());
        shelfishService.save(livro);
        return "redirect:/";
    }

    @RequestMapping(value = "/deletarlivro/{isbn}", method = RequestMethod.POST)
    public String deletarLivrobyid(@PathVariable(value = "isbn") String isbnurl, RedirectAttributes att){
        Livro livroDeletado = getLivroByISBN(isbnurl);
        shelfishService.delete(livroDeletado);
        return "redirect:/";
    }


    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String getErrorPage(){
        return "error";
    }

    private Livro getLivroByISBN(String isbn){
        return shelfishService.findbyISBN(isbn);
    }

    @RequestMapping(value = "atualizarivro/{isbn}", method = RequestMethod.POST)
    public ModelAndView atualizarLivrobyid(@PathVariable(value = "isbn") String isbnurl, RedirectAttributes att){
        ModelAndView modelAndView = new ModelAndView("editarlivro");
        Livro livroPesquisado = getLivroByISBN(isbnurl);
        modelAndView.addObject("livroPesquisado", livroPesquisado);
        return modelAndView;
    }

    @RequestMapping(value = "/atualizarlivro", method = RequestMethod.POST)
    public String postAtualizarlivro(@ModelAttribute Livro livro, RedirectAttributes att, Model model){
        model.addAttribute("livro", new Livro());
        shelfishService.save(livro);
        String redirect = "redirect:/livro/" + livro.getISBN();
        return redirect;
    }


}