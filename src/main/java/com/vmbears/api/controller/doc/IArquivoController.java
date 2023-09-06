package com.vmbears.api.controller.doc;

import com.vmbears.api.dto.AgenteResponse;
import com.vmbears.model.Agente;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Tag(name = "Api de Arquivos")
public interface IArquivoController {

    @Operation(summary = "Recebe e processa um arquivo xml", description = "Recebe e processa um arquivo xml")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Caso o processamento do arquivo seja concluído com sucesso."
            )
    })
    @PostMapping(value = "")
    ResponseEntity<List<Agente>> processarXml(@RequestParam("file") MultipartFile file);


    @Operation(summary = "Lista os agentes por uma região especifíca.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Caso a consulta seja efetuada com sucesso."
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Caso o ID enviado na URL não seja de nenhum agente."
            ),
    })
    @GetMapping(value = "/buscarAgentesPorRegiao", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<AgenteResponse>> buscarAgentesPorRegiao(@RequestParam(name = "regiao") String regiao);

}
