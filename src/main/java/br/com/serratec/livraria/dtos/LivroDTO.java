package br.com.serratec.livraria.dtos;

import br.com.serratec.livraria.models.Autor;
import br.com.serratec.livraria.models.Categoria;
import br.com.serratec.livraria.models.Livro;

import java.util.List;
import java.util.stream.Collectors;

public class LivroDTO {
    private String nome;
    private String codigo;
    private Categoria categoria;
    private List<Autor> autores;

    public LivroDTO () {

    }

    public LivroDTO(Livro livro) {

        this.nome = livro.getNome();
        this.codigo = livro.getCodigo();
        this.categoria = livro.getCategoria();
        this.autores = livro.getAutores();
    }

    public static List<LivroDTO> converter(List<Livro> livros) {
        return livros
                .stream()
                .map(LivroDTO::new)
                .collect(Collectors.toList());
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public Livro toModel() {
        Livro livro = new Livro();
        livro.setAutores(this.autores);
        livro.setCategoria(this.categoria);
        livro.setCodigo(this.codigo);
        livro.setNome(this.nome);
        return livro;
    }
}
