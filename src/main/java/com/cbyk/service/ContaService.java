package com.cbyk.service;

import com.cbyk.model.Conta;
import com.cbyk.model.enums.Situacao;
import com.cbyk.repository.ContaRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.webjars.NotFoundException;

import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ContaService {

    private final ContaRepository contaRepository;

    DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

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

    public void carregarCsvContas(MultipartFile file) {

            List<Conta> contas = new ArrayList<>();

        try (
                Reader reader = Files.newBufferedReader(Paths.get("C:\\Users\\Bob\\Documents\\teste\\teste.csv.txt"));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        ) {
            for (CSVRecord csvRecord : csvParser) {

                String[] array = csvRecord.get(0).split(";");

                String dtVencimento = array[0];
                String dtPagamento  = array[1];
                String valor        = array[2];
                String descricao    = array[3];
                String situacao     = array[4];

                LocalDate  dtVencimentoEntity = LocalDate.parse(dtVencimento, DATEFORMATTER);
                LocalDate  dtPagamentoEntity = LocalDate.parse(dtPagamento, DATEFORMATTER);
                BigDecimal valorEntity = new BigDecimal(valor);
                Situacao situacaoEnum = Situacao.valueOf(situacao);

                contas.add(Conta.builder()
                                .dataVencimento(dtVencimentoEntity)
                                .dataPagamento(dtPagamentoEntity)
                                .descricao(descricao)
                                .valor(valorEntity)
                                .situacao(situacaoEnum).build());

            }

            this.contaRepository.saveAll(contas);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}
