package com.example.Shelfish.controller;

import com.example.Shelfish.models.Autor;
import com.example.Shelfish.models.Editora;
import com.example.Shelfish.service.ShelfishEditoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ShelfishEditoraController {
    @Autowired
    ShelfishEditoraService shelfishEditoraService;

    @RequestMapping(value = "/editora/{editoraCod}", method = RequestMethod.GET)
    //Ele trata o view e o Model juntos
    public ModelAndView getEditorabyCod(@PathVariable(value = "editoraCod") int editoraCodUrl) {
        ModelAndView modelAndView = new ModelAndView("editora");
        Editora editoraPesquisada = shelfishEditoraService.findEditoraByEditoraCod(editoraCodUrl);
        modelAndView.addObject("editoraPesquisada", editoraPesquisada);
        return modelAndView;
    }


    @RequestMapping(value = "/cadastrareditora", method = RequestMethod.GET)
    public String getCadastrarEditora(){
        return "cadastrareditora";
    }

    @RequestMapping(value = "/cadastrareditora", method = RequestMethod.POST)
    public String postCadastrareditora(@ModelAttribute Editora editora, RedirectAttributes att, Model model){
        model.addAttribute("editora", new Editora());
        shelfishEditoraService.save(editora);
        return "redirect:/";
    }


    @RequestMapping(value = "/deletareditora/{editoraCod}", method = RequestMethod.POST)
    public String deletarEditorabyCod(@PathVariable(value = "editoraCod") int editoraCodurl, RedirectAttributes att) {
        Editora editoraDeletada = shelfishEditoraService.findEditoraByEditoraCod(editoraCodurl);
        shelfishEditoraService.delete(editoraDeletada);
        return "redirect:/";
    }

    @RequestMapping(value = "/atualizareditora/{editoraCod}", method = RequestMethod.POST)
    public ModelAndView atualizarAutorbyCod(@PathVariable(value = "editoraCod") int editoraCodnurl, RedirectAttributes att) {
        ModelAndView modelAndView = new ModelAndView("editareditora");
        Editora editoraPesquisada = shelfishEditoraService.findEditoraByEditoraCod(editoraCodnurl);
        modelAndView.addObject("editoraPesquisada", editoraPesquisada);
        return modelAndView;
    }

    @RequestMapping(value = "/atualizareditora", method = RequestMethod.POST)
    public String postAtualizareditora(@ModelAttribute Editora editora, RedirectAttributes att, Model model){
        model.addAttribute("editora", new Editora());
        shelfishEditoraService.save(editora);
        String redirect = "redirect:/editora/" + editora.getEditoraCod();
        return redirect;
    }

}
