package com.rogerLacerda.bff_agendador_tarefas.infrastructure.client;

import com.rogerLacerda.bff_agendador_tarefas.business.dto.EnderecoDTOResponse;
import com.rogerLacerda.bff_agendador_tarefas.business.dto.TelefoneDTOResponse;
import com.rogerLacerda.bff_agendador_tarefas.business.dto.UsuarioDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping
    UsuarioDTOResponse buscaUsuarioPorEmail(@RequestParam("email") String email,
                                            @RequestHeader("Authorization") String token);
    @PostMapping
    UsuarioDTOResponse salvaUsuario(@RequestBody UsuarioDTOResponse usuarioDTOResponse);


    @PostMapping ("/login")
    String login(@RequestBody UsuarioDTOResponse usuarioDTOResponse);

    @DeleteMapping("/{email}")
    void deletaUsuarioPorEmail(@PathVariable String email,
                               @RequestHeader ("Authorization") String token);


    @PutMapping
    UsuarioDTOResponse atualizaDadosUsuario(@RequestBody UsuarioDTOResponse dto,
                                            @RequestHeader ("Authorization") String token);

    @PutMapping("/endereco")
    EnderecoDTOResponse atualizaEndereco(@RequestBody EnderecoDTOResponse dto,
                                         @RequestParam ("id") Long id,
                                         @RequestHeader ("Authorization") String token);

    @PutMapping("/telefone")
    TelefoneDTOResponse atualizaTelefone(@RequestBody TelefoneDTOResponse dto,
                                         @RequestParam ("id") Long id,
                                         @RequestHeader ("Authorization") String token);


    @PostMapping("/endereco")
    EnderecoDTOResponse cadastraEndereco(@RequestBody EnderecoDTOResponse dto,
                                         @RequestHeader ("Authorization") String token);

    @PostMapping("/telefone")
    TelefoneDTOResponse cadastraTelefone(@RequestBody TelefoneDTOResponse dto,
                                         @RequestHeader ("Authorization") String token);
}
