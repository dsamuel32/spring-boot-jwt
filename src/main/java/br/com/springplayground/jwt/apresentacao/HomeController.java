package br.com.springplayground.jwt.apresentacao;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "publico/v1/home", produces = MediaType.APPLICATION_JSON_VALUE)
public class HomeController {

    @GetMapping()
    public ResponseEntity<Map<String, String>> teste() {
        Map<String, String> resposta = new HashMap<>();
        resposta.put("pagina", "Página sem segurança!!!!");
        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

}
