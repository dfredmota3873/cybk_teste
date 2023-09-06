package com.vmbears.api.controller.impl;

import com.vmbears.api.controller.doc.IArquivoController;
import com.vmbears.api.dto.AgenteResponse;
import com.vmbears.converter.AgentesConverter;
import com.vmbears.model.Agente;
import com.vmbears.service.AgenteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v1/file")
@AllArgsConstructor
@CrossOrigin("*")
public class ArquivoController implements IArquivoController {

    private final AgenteService agenteService;

    private final AgentesConverter converter;

    @PostMapping(
            path = "",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Agente>> processarXml(@RequestParam("file") MultipartFile file) {
        return new ResponseEntity<>(agenteService.processarArquivos(file), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<AgenteResponse>> buscarAgentesPorRegiao(String regiao) {
        List<Agente> listModel = agenteService.retornaAgentesPorRegiao(regiao);
        return new ResponseEntity<>(converter.convertListModelToResponse(listModel), HttpStatus.OK);
    }

}
