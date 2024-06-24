package com.cbyk.service;

import com.cbyk.model.Conta;
import com.cbyk.repository.ContaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ContaService {

    private final ContaRepository contaRepository;

    @Transactional
    public Conta cadastrar(Conta conta) {
        return contaRepository.save(conta);
    }

    public List<Conta> listarPorFiltro(LocalDate dataInicial, LocalDate dataFinal, String descricao, Pageable pageable) {

        List<Conta> lista = contaRepository.listar(descricao, dataInicial, dataFinal);

        return lista;
    }

    public Conta buscarPorId(UUID id){
        return contaRepository.findById(id).orElseThrow(() -> new NotFoundException("Não existe conta com o id : " + id));
    }

    @Transactional
    public Conta atualizar(UUID id, Conta conta) {

        var contaDB = contaRepository.findById(id).orElseThrow(() -> new NotFoundException("Não existe conta com o id : " + id));

        contaDB.setDescricao(conta.getDescricao());
        contaDB.setValor(conta.getValor());
        contaDB.setSituacao(conta.getSituacao());
        contaDB.setDataVencimento(conta.getDataVencimento());
        contaDB.setDataPagamento(conta.getDataPagamento());

        return contaRepository.save(contaDB);
    }

    public BigDecimal valorTotalPorPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
        return contaRepository.valorTotalPorPeriodo(dataInicial, dataFinal);
    }


}
