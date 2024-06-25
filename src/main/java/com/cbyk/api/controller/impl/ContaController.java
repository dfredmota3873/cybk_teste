package com.cbyk.api.controller.impl;

import com.cbyk.api.controller.doc.IContaController;
import com.cbyk.api.dto.request.ContaRequest;
import com.cbyk.api.dto.response.ContaResponse;
import com.cbyk.converter.ContaConverter;
import com.cbyk.service.ContaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/conta")
@AllArgsConstructor
@CrossOrigin("*")
@Slf4j
public class ContaController implements IContaController {

    private final ContaService contaService;

    private final ContaConverter converter;


    @Override
    public ResponseEntity<ContaResponse> cadastrar(ContaRequest contaRequest) {
        log.info("Iniciando cadastro de uma conta com payload: {}", contaRequest);
        var conta = contaService.cadastrar(converter.toModel(contaRequest));
        log.info("Cadastro da conta realizada com sucesso id: {}", conta.getId());
        return ResponseEntity.ok(converter.toResponse(conta));
    }

    @Override
    public ResponseEntity<ContaResponse> buscarPorId(UUID id) {
        log.info("Iniciando busca de uma conta com id: {}", id);
        var conta = contaService.buscarPorId(id);
        log.info("Busca de uma conta com sucesso id: {}", id);
        return ResponseEntity.ok(converter.toResponse(conta));
    }

    @Override
    public ResponseEntity<List<ContaResponse>> listarPorFiltro(LocalDate filtroDataInicial, LocalDate filtroDataFinal,
                                                               String descricao, Pageable pageable) {
        log.info("Realizando uma busca de contas por filtro");
        var lista = contaService.listarPorFiltro(filtroDataInicial, filtroDataFinal, descricao, pageable);
        return ResponseEntity.ok(converter.ToListResponse(lista));

    }

    @Override
    public ResponseEntity<ContaResponse> atualizar(UUID id, ContaRequest contaRequest) {
        log.info("Atualizando dados da conta com id: {}", id);
        var conta = contaService.atualizar(id, converter.toModelUpdate(contaRequest));
        log.info("Dados atualizados com sucesso id: {}", id);
        return ResponseEntity.ok(converter.toResponse(conta));
    }

    @Override
    public ResponseEntity<BigDecimal> valorTotalPorPeriodo(LocalDate periodoInicial, LocalDate periodoFinal) {
        log.info("Iniciando o valor total por periodo");
        return ResponseEntity.ok(contaService.valorTotalPorPeriodo(periodoInicial, periodoFinal));
    }

    @Override
    public ResponseEntity<Void> carregarCsv(MultipartFile file) {
        log.info("Iniciando a carda arquivo CSV");
        contaService.carregarCsvContas(file);
        log.info("Carregado com sucesso");
        return ResponseEntity.ok().build();
    }

}
