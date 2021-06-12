package br.com.serratec.livraria.controller;

import br.com.serratec.livraria.dtos.LivroDTO;
import br.com.serratec.livraria.dtos.LoginDto;
import br.com.serratec.livraria.dtos.TokenDto;
import br.com.serratec.livraria.dtos.UsuarioDTO;
import br.com.serratec.livraria.models.Usuario;
import br.com.serratec.livraria.repositories.UsuarioRepository;
import br.com.serratec.livraria.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    @RequestMapping("/registro")
    public ResponseEntity<UsuarioDTO> registrar (@RequestBody UsuarioDTO input) {

        Usuario usuario = input.toModel();
        repository.save(usuario);
        return  ResponseEntity.ok().build();
    }

    @PostMapping
    @RequestMapping("/login")
    public ResponseEntity<TokenDto> login (@RequestBody LoginDto input) {

        UsernamePasswordAuthenticationToken dadosLogin = input.converter();

        try {
            Authentication authentication = authManager.authenticate(dadosLogin);
            String token = tokenService.gerarToken(authentication);
            return ResponseEntity.ok(new TokenDto(token, "Bearer"));
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
