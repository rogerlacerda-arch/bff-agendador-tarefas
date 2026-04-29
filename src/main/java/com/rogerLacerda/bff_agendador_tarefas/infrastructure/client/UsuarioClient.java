package com.rogerLacerda.bff_agendador_tarefas.infrastructure.client;

import com.rogerLacerda.bff_agendador_tarefas.business.dto.EnderecoDTO;
import com.rogerLacerda.bff_agendador_tarefas.business.dto.TelefoneDTO;
import com.rogerLacerda.bff_agendador_tarefas.business.dto.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping
    UsuarioDTO buscaUsuarioPorEmail(@RequestParam("email") String email,
                                    @RequestHeader("Authorization") String token);
    @PostMapping
    UsuarioDTO salvaUsuario(@RequestBody UsuarioDTO usuarioDTO);


    @PostMapping ("/login")
    String login(@RequestBody UsuarioDTO usuarioDTO);

    @DeleteMapping("/{email}")
    void deletaUsuarioPorEmail(@PathVariable String email,
                               @RequestHeader ("Authorization") String token);


    @PutMapping
    UsuarioDTO atualizaDadosUsuario(@RequestBody UsuarioDTO dto,
                                    @RequestHeader ("Authorization") String token);

    @PutMapping("/endereco")
    EnderecoDTO atualizaEndereco(@RequestBody EnderecoDTO dto,
                                @RequestParam ("id") Long id,
                                @RequestHeader ("Authorization") String token);

    @PutMapping("/telefone")
    TelefoneDTO atualizaTelefone(@RequestBody TelefoneDTO dto,
                                 @RequestParam ("id") Long id,
                                 @RequestHeader ("Authorization") String token);


    @PostMapping("/endereco")
   EnderecoDTO cadastraEndereco(@RequestBody EnderecoDTO dto,
                                @RequestHeader ("Authorization") String token);

    @PostMapping("/telefone")
   TelefoneDTO cadastraTelefone(@RequestBody TelefoneDTO dto,
                                @RequestHeader ("Authorization") String token);
}
