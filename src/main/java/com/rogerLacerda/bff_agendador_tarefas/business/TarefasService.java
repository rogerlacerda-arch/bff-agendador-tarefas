package com.rogerLacerda.bff_agendador_tarefas.business;


import com.rogerLacerda.bff_agendador_tarefas.business.dto.TarefasDTO;
import com.rogerLacerda.bff_agendador_tarefas.business.enums.StatusNotificacaoEnum;
import com.rogerLacerda.bff_agendador_tarefas.infrastructure.client.TarefasClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasClient tarefasClient;

    public TarefasDTO gravarTarefa(String token, TarefasDTO dto) {
        return tarefasClient.gravarTarefa(dto, token);
    }

    public List<TarefasDTO> buscaTarefasAgendadasPorPeriodo(LocalDateTime dataInicial,
                                                            LocalDateTime dataFinal,
                                                            String token) {
        return tarefasClient.buscaListaDeTarefasPorPeriodo(dataInicial, dataFinal, token);
    }

    public List<TarefasDTO> buscaTarefaPorEmail(String token) {
        return tarefasClient.buscaTarefasPorEmail(token);
    }

    public void deletaTarefasPorId(String id, String token) {
       tarefasClient.deletaTarefasPorId(id, token);
    }

    public TarefasDTO alteraStatus(StatusNotificacaoEnum status, String id, String token) {
        return tarefasClient.alteraStatusNotificacao(status, id, token);
    }

    public TarefasDTO updateTarefas(TarefasDTO dto, String id, String token) {
        return tarefasClient.updateTarefas(dto, id, token);
    }
}
