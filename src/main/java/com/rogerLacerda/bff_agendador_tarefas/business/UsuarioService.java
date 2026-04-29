package com.rogerLacerda.bff_agendador_tarefas.business;

import com.rogerLacerda.bff_agendador_tarefas.business.dto.EnderecoDTOResponse;
import com.rogerLacerda.bff_agendador_tarefas.business.dto.TelefoneDTOResponse;
import com.rogerLacerda.bff_agendador_tarefas.business.dto.UsuarioDTOResponse;
import com.rogerLacerda.bff_agendador_tarefas.infrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient usuarioClient;

    public UsuarioDTOResponse salvaUsuario(UsuarioDTOResponse usuarioDTOResponse) {
       return usuarioClient.salvaUsuario(usuarioDTOResponse);
    }

   public String loginUsuario(UsuarioDTOResponse usuarioDTOResponse) {
       return usuarioClient.login(usuarioDTOResponse);
   }

    public UsuarioDTOResponse buscaUsuarioPorEmail(String email, String token) {
        return usuarioClient.buscaUsuarioPorEmail(email, token);
    }

    public void deletaUsuarioPorEmail(String email,  String token) {
        usuarioClient.deletaUsuarioPorEmail(email, token);
    }

    public UsuarioDTOResponse atulizaDadosUsuario(String token, UsuarioDTOResponse dto) {
      return usuarioClient.atualizaDadosUsuario(dto, token);
    }

    public EnderecoDTOResponse atualizaEndereco(Long idEndereco, EnderecoDTOResponse enderecoDTOResponse, String token) {
       return usuarioClient.atualizaEndereco(enderecoDTOResponse, idEndereco, token);
    }

    public TelefoneDTOResponse atualizaTelefone(Long idTelefone, TelefoneDTOResponse telefoneDTOResponse, String token) {
        return usuarioClient.atualizaTelefone(telefoneDTOResponse, idTelefone, token);
    }

    public EnderecoDTOResponse cadastraEndereco(String token, EnderecoDTOResponse dto) {
        return usuarioClient.cadastraEndereco(dto, token);
    }

    public TelefoneDTOResponse cadastraTelefone(String token, TelefoneDTOResponse dto) {
        return usuarioClient.cadastraTelefone(dto, token);
    }
}
