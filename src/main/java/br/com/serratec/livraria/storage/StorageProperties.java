package br.com.serratec.livraria.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "file")
public class StorageProperties {
    private String diretorioParaUpload;

    public String getDiretorioParaUpload() {
        return diretorioParaUpload;
    }

    public void setDiretorioParaUpload(String diretorioParaUpload) {
        this.diretorioParaUpload = diretorioParaUpload;
    }
}
