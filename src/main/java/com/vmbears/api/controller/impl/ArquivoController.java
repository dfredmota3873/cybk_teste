package com.vmbears.api.controller.impl;

import com.vmbears.api.dto.Agente;
import com.vmbears.api.dto.Agentes;
import com.vmbears.service.AgenteService;
import jakarta.xml.bind.JAXBException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/file")
@AllArgsConstructor
@CrossOrigin("*")
public class ArquivoController {

    private final AgenteService agenteService;

    @PostMapping(
            path = "",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Agentes> saveFile(@RequestParam("file") MultipartFile file) throws IOException, JAXBException {
        return new ResponseEntity<>(agenteService.processarArquivos(file), HttpStatus.OK);
    }
}
