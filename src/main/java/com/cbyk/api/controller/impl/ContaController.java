package com.cbyk.api.controller.impl;

import com.cbyk.api.controller.doc.IContaController;
import com.cbyk.api.dto.request.ContaRequest;
import com.cbyk.api.dto.response.ContaResponse;
import com.cbyk.converter.ContaConverter;
import com.cbyk.service.ContaService;
import lombok.AllArgsConstructor;
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
public class ContaController implements IContaController {

    private final ContaService contaService;

    private final ContaConverter converter;


    @Override
    public ResponseEntity<ContaResponse> cadastrar(ContaRequest contaRequest) {
        var conta = contaService.cadastrar(converter.toModel(contaRequest));
        return ResponseEntity.ok(converter.toResponse(conta));
    }

    @Override
    public ResponseEntity<ContaResponse> buscarPorId(UUID id) {
        var conta = contaService.buscarPorId(id);
        return ResponseEntity.ok(converter.toResponse(conta));
    }

    @Override
    public ResponseEntity<List<ContaResponse>> listarPorFiltro(LocalDate filtroDataInicial, LocalDate filtroDataFinal,
                                                               String descricao, Pageable pageable) {
        var lista = contaService.listarPorFiltro(filtroDataInicial,filtroDataFinal,descricao,pageable);
        return ResponseEntity.ok(converter.ToListResponse(lista));

    }

    @Override
    public ResponseEntity<ContaResponse> atualizar(UUID id,ContaRequest contaRequest) {
        var conta = contaService.atualizar(id, converter.toModelUpdate(contaRequest));
        return ResponseEntity.ok(converter.toResponse(conta));
    }

    @Override
    public ResponseEntity<BigDecimal> valorTotalPorPeriodo(LocalDate periodoInicial, LocalDate periodoFinal) {
        return ResponseEntity.ok(contaService.valorTotalPorPeriodo(periodoInicial,periodoFinal));
    }

    @Override
    public ResponseEntity<Void> carregarCsv(MultipartFile file) {
         contaService.carregarCsvContas(file);
        return ResponseEntity.ok().build();
    }

}
