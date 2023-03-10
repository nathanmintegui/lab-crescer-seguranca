package br.com.cwi.api.controller;

import br.com.cwi.api.service.MensagemPrivadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exemplos")
public class ExemploController {

    @Autowired
    private MensagemPrivadaService mensagemPrivadaService;

    @GetMapping
    public String privado() {
        return mensagemPrivadaService.gerarMensagem();
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/admin")
    public String admin() {
        return "Rota privada, exclusiva para usuários ADMIN";
    }

    @GetMapping("/publico")
    public String publico() {
        return "Rota pública";
    }
}
