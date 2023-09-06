package com.vmbears.service;

import com.vmbears.api.dto.Agentes;
import com.vmbears.converter.AgenteXmlConverter;
import com.vmbears.exception.BusinessException;
import com.vmbears.model.Agente;
import com.vmbears.model.enums.TipoRegiao;
import com.vmbears.repository.AgenteRepository;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AgenteService {

    private final AgenteRepository agenteRepository;

    private final AgenteXmlConverter xmlConverter;

    @Transactional
    public List<Agente> processarArquivos(MultipartFile arquivoXml) {

        List<Agente> agenteList = null;

        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(Agentes.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Agentes agentes = (Agentes) jaxbUnmarshaller.unmarshal(arquivoXml.getInputStream());

            // Printar o código de todos os agentes via console
            agentes.getAgente().stream().forEach(e -> System.out.println("Agente Código: " + e.getCodigo()));

            // converter esses objetos xml para model e salvar na base de dados
            agenteList = agentes.getAgente().stream().map(from -> xmlConverter.convertXmlToModel(from)).collect(Collectors.toList());

            agenteRepository.saveAll(agenteList);

        } catch (IOException e) {
            throw new BusinessException("Erro ao processar os arquivos xml");
        } catch (JAXBException e) {
            throw new BusinessException("Erro ao processar os arquivos xml");
        }

        return agenteList;

    }

    public List<Agente> retornaAgentesPorRegiao(String regiao) {

        List<Agente> list = agenteRepository.buscarAgentesPorRegiao(TipoRegiao.valueOf(regiao));

        if(Objects.isNull(list) || list.isEmpty())
            throw  new BusinessException("Não existe nenhum agente para essa região.");

        return list;
    }
}
