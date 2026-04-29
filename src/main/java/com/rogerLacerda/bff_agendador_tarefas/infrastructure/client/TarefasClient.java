package com.rogerLacerda.bff_agendador_tarefas.infrastructure.client;

import com.rogerLacerda.bff_agendador_tarefas.business.dto.TarefasDTO;
import com.rogerLacerda.bff_agendador_tarefas.business.enums.StatusNotificacaoEnum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@FeignClient(name = "agendador-tarefas", url = "${agendador-tarefas.url}")
public interface TarefasClient {

    @PostMapping
    TarefasDTO gravarTarefa(@RequestBody TarefasDTO dto,
                            @RequestHeader("Authorization") String token);



    @GetMapping("/eventos")
 List<TarefasDTO> buscaListaDeTarefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
            @RequestHeader("Authorization") String token);

    @GetMapping
    List<TarefasDTO> buscaTarefasPorEmail(@RequestHeader("Authorization") String token);


    @DeleteMapping
    void deletaTarefasPorId(@RequestParam("id") String id,
                            @RequestHeader("Authorization") String token);

    @PatchMapping
    TarefasDTO alteraStatusNotificacao (@RequestParam ("status") StatusNotificacaoEnum status,
                                                               @RequestParam ("id")String id,
                                        @RequestHeader("Authorization") String token);

    @PutMapping
    TarefasDTO updateTarefas (@RequestBody TarefasDTO dto,
                              @RequestParam("id") String id,
                              @RequestHeader("Authorization") String token);
    }
