package br.com.spring.controller;

import br.com.spring.bo.ClienteBO;
import br.com.spring.model.Cliente;
import org.hibernate.annotations.common.reflection.XMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteBO bo;
    @RequestMapping(value = "/novo", method = RequestMethod.GET)
    public ModelAndView novo(ModelMap model){
        model.addAttribute("cliente", new Cliente());
        return new ModelAndView("/cliente/formulario",model);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String salva(@ModelAttribute("cliente") Cliente cliente){
        if(cliente.getId()==null){
            bo.insere(cliente);
        }else{
            bo.atualiza(cliente);
        }
        return "redirect:/clientes/novo";
//        return ("/cliente/formulario");
    }

    //Método para listar
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView lista(ModelMap model){
        model.addAttribute("clientes", bo.listaTodos());
        return new ModelAndView("/cliente/lista",model);
    }

    //Método para editar
    @RequestMapping(value = "/edita/{id}", method = RequestMethod.GET)
    public ModelAndView edita(@PathVariable("id") Long id, ModelMap model){
        try{
            model.addAttribute("cliente", bo.pesquisaPeloId(id));
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ModelAndView("/cliente/formulario",model);
    }
    @RequestMapping(value = "/inativa/{id}", method = RequestMethod.GET)
    public String inativa(@PathVariable("id") Long id){

        try{
            Cliente cliente = bo.pesquisaPeloId(id);
            bo.inativa(cliente);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/clientes";
    }

    @RequestMapping(value = "/ativa/{id}", method = RequestMethod.GET)
    public String ativa(@PathVariable("id") Long id){

        try{
            Cliente cliente = bo.pesquisaPeloId(id);
            bo.ativa(cliente);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/clientes";
    }

}
