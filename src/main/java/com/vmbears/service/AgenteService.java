package com.vmbears.service;

import com.vmbears.api.dto.Agentes;
import com.vmbears.converter.AgenteXmlConverter;
import com.vmbears.model.Agente;
import com.vmbears.repository.AgenteRepository;
import com.vmbears.repository.RegiaoRepository;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AgenteService {

    private final AgenteRepository agenteRepository;

    private final RegiaoRepository regiaoRepository;

    private final AgenteXmlConverter xmlConverter;

    @Transactional
    public Agentes processarArquivos(MultipartFile arquivoXml) throws IOException, JAXBException {

        File file = new File("D:\\Teste\\exemplo_01.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Agentes.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Agentes agentes = (Agentes) jaxbUnmarshaller.unmarshal(file);

        // Printar o código de todos os agentes via console
        agentes.getAgente().stream().forEach( e -> System.out.println("Agente Código: " + e.getCodigo()));

        // converter esses objetos xml para model e salvar na base de dados
        List<Agente> agenteList = agentes.getAgente().stream().map(from -> xmlConverter.convertXmlToModel(from)).collect(Collectors.toList());

        agenteRepository.saveAll(agenteList);

        return new Agentes();

    }
}
