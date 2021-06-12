package br.com.serratec.livraria.controller;

import br.com.serratec.livraria.dtos.UploadFileDTO;
import br.com.serratec.livraria.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.core.io.Resource;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
public class UploadArquivoController {

    @Autowired
    private StorageService service;

    @PostMapping("/upload")
    public UploadFileDTO upload(@RequestParam("arquivo") MultipartFile arquivo) throws Exception {
        String nomeDoArquivo = service.armazenar(arquivo);

        String uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(nomeDoArquivo)
                .toUriString();

        return new UploadFileDTO(nomeDoArquivo, uri,
                arquivo.getContentType(), arquivo.getSize());
    }

    @GetMapping("/download/{arquivo:.+}")
    public ResponseEntity<Resource> download(@PathVariable String arquivo, HttpServletRequest request) throws Exception {

        Resource resource = service.carregarArquivo(arquivo);

        String contentType =  request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "anexo; nomeDoArquivo=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

}
