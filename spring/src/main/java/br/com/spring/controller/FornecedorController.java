package br.com.spring.controller;

import br.com.spring.bo.FornecedorBO;
import br.com.spring.model.Fornecedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/fornecedores")
public class FornecedorController {
    @Autowired
    private FornecedorBO bo;

    @RequestMapping(value = "/novo", method = RequestMethod.GET)
    public ModelAndView novo (ModelMap model){
        model.addAttribute("fornecedor", new Fornecedor());
        return new ModelAndView("/fornecedor/formulario",model);
    }
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String salva(@Valid @ModelAttribute("fornecedor")Fornecedor fornecedor,
                        BindingResult result,
                        RedirectAttributes redirect){
        if(result.hasErrors()){
            return "fornecedor/formulario";
        }
        if(fornecedor.getId()==null){
            bo.insere(fornecedor);
            redirect.addFlashAttribute("feedback", "O Fornecedor foi cadastrado com sucesso!");
        }else{
            bo.atualiza(fornecedor);
            redirect.addFlashAttribute("feedback", "O Fornecedor foi atualizado com sucesso");
        }
        return "redirect:/fornecedores/";
    }
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView lista(ModelMap model){
        model.addAttribute("fornecedores", bo.listaTodos());
        return new ModelAndView("/fornecedor/lista", model);
    }

    //Método para editar
    @RequestMapping(value = "/edita/{id}", method = RequestMethod.GET)
    public ModelAndView edita(@PathVariable("id") Long id, ModelMap model){
        try{
            model.addAttribute("fornecedor", bo.pesquisaPeloId(id));
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ModelAndView("/fornecedor/formulario",model);
    }
    @RequestMapping(value = "/inativa/{id}", method = RequestMethod.GET)
    public String inativa(@PathVariable("id") Long id, RedirectAttributes attr){

        try{
            Fornecedor fornecedor = bo.pesquisaPeloId(id);
            bo.inativa(fornecedor);
            attr.addFlashAttribute("feedback", "O fornecedor foi inativado com sucesso!");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/fornecedores";
    }

    @RequestMapping(value = "/ativa/{id}", method = RequestMethod.GET)
    public String ativa(@PathVariable("id") Long id,RedirectAttributes attr){
        try{
            Fornecedor fornecedor = bo.pesquisaPeloId(id);
            bo.ativa(fornecedor);
            attr.addFlashAttribute("feedback", "O fornecedor foi ativado com sucesso!");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/fornecedores";
    }

}
