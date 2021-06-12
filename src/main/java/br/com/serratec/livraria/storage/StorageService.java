package br.com.serratec.livraria.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class StorageService {

    private final Path diretorioBase;

    @Autowired
    public StorageService(StorageProperties fileStorageProperties) throws Exception {
        this.diretorioBase = Paths.get(fileStorageProperties.getDiretorioParaUpload())
                .toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.diretorioBase);
        } catch (Exception ex) {
            throw new Exception("Não foi possível criar o diretório base.", ex);
        }
    }

    public String armazenar(MultipartFile file) throws Exception {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            Path targetLocation = this.diretorioBase.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        } catch (IOException ex) {
            throw new Exception("O arquivo " + fileName + " não foi armazeado.", ex);
        }
    }

    public Resource carregarArquivo(String fileName) throws Exception {
        try {
            Path filePath = this.diretorioBase.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new Exception("Arquivo não encontrado: " + fileName);
            }
        } catch (Exception ex) {
            throw new Exception("Falha ao carregar o arquivo: " + fileName, ex);
        }
    }

}
