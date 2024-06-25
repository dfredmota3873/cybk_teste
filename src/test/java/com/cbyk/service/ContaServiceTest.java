package com.cbyk.service;

import com.cbyk.model.Conta;
import com.cbyk.model.enums.Situacao;
import com.cbyk.repository.ContaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ContaServiceTest {

    @InjectMocks
    ContaService contaService;

    @Mock(lenient = true)
    ContaRepository contaRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void buscarPorIdTest(){

        UUID id = UUID.randomUUID();
        Conta conta = getConta();

        when(contaRepository.findById(id)).thenReturn(Optional.of(conta));

        Conta contaBuscado = contaService.buscarPorId(id);

        assertEquals(conta, contaBuscado);
        verify(contaRepository, times(1)).findById(id);

    }

    @Test
    public void cadastrarTest(){

        Conta c1 = getConta();

        when(contaRepository.save(c1)).thenReturn(c1);

        Conta c2 = contaService.cadastrar(c1);

        assertEquals(c1, c2);

    }

    private Conta getConta(){
        return Conta.builder()
                .descricao("Teste")
                .situacao(Situacao.C)
                .valor(new BigDecimal(150))
                .dataPagamento(LocalDate.now())
                .dataVencimento(LocalDate.now().plusDays(3))
                .build();
    }
}
