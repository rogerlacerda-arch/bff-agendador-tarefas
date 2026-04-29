package com.rogerLacerda.bff_agendador_tarefas.business;


import com.rogerLacerda.bff_agendador_tarefas.business.dto.TarefasDTOResponse;
import com.rogerLacerda.bff_agendador_tarefas.business.enums.StatusNotificacaoEnum;
import com.rogerLacerda.bff_agendador_tarefas.infrastructure.client.EmailClient;
import com.rogerLacerda.bff_agendador_tarefas.infrastructure.client.TarefasClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailClient emailClient;

    public void enviaEmail(TarefasDTOResponse dto) {
        emailClient.enviarEmail(dto);
    }
}
