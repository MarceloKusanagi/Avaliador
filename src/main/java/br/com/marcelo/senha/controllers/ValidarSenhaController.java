package br.com.marcelo.senha.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.marcelo.senha.model.ValidarSenha;

@Controller
public class ValidarSenhaController {
	
    @GetMapping("/")
    public String calcularForm(Model model) {
        model.addAttribute("validarSenha", new ValidarSenha());
        return "index";
    }

    @PostMapping("/calcular")
    public String calcularSubmit(@ModelAttribute ValidarSenha validarSenha) {
    	validarSenha.calcularPontos(validarSenha.getSenha());
    	validarSenha.calcularComplexidade(validarSenha.getPontos());
        return "resultado";
    }
}
