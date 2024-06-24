package com.cbyk.api.controller.doc;

import com.cbyk.api.dto.request.ContaRequest;
import com.cbyk.api.dto.response.ContaResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Tag(name = "Api de Contas")
public interface IContaController {

    @Operation(summary = "Realiza o cadastro de uma conta",
            description = "Realiza o cadastro de uma conta")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Caso a conta seja cadastradas com sucesso."
            )
    })
    @PostMapping(value = "",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ContaResponse> cadastrar(@RequestBody ContaRequest contaRequest);

    @Operation(summary = "Buscar uma conta por id.")
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
    @GetMapping(value = "/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ContaResponse> buscarPorId(@PathVariable(name = "id") UUID id);

    @Operation(summary = "Lista as contas por filtro de data de vencimento e descrição.")
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
    @GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<ContaResponse>> listarPorFiltro(@RequestParam(name = "filtroDataInicial") LocalDate filtroDataIncial,
                                                              @RequestParam(name = "filtroDataFinal") LocalDate filtroDataFinal,
                                                              @RequestParam(name = "descricao") String descricao,
                                                              Pageable pageable);

    @Operation(summary = "Realiza a atualizacao da conta",
            description = "Realiza a atualizacao da conta")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Caso a conta seja atualizada com sucesso."
            )
    })
    @PutMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE , consumes=MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ContaResponse> atualizar(@PathVariable(name = "id") UUID id,@RequestBody ContaRequest contaRequest);

    @Operation(summary = "Buscar uma conta por id.")
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
    @GetMapping(value = "/total", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BigDecimal> valorTotalPorPeriodo(@RequestParam(name = "periodoInicial") LocalDate periodoInicial,
                                                    @RequestParam(name = "periodoFinal") LocalDate periodoFinal );
}
