package br.com.serratec.livraria.dtos;

public class UploadFileDTO {

    private String nomeDoArquivo;
    private String uri;
    private String extensao;
    private long tamanho;

    public UploadFileDTO(String nomeDoArquivo, String uri, String extensao, long tamanho) {
        this.nomeDoArquivo = nomeDoArquivo;
        this.uri = uri;
        this.extensao = extensao;
        this.tamanho = tamanho;
    }

    public String getNomeDoArquivo() {
        return nomeDoArquivo;
    }

    public void setNomeDoArquivo(String nomeDoArquivo) {
        this.nomeDoArquivo = nomeDoArquivo;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getExtensao() {
        return extensao;
    }

    public void setExtensao(String extensao) {
        this.extensao = extensao;
    }

    public long getTamanho() {
        return tamanho;
    }

    public void setTamanho(long tamanho) {
        this.tamanho = tamanho;
    }
}
