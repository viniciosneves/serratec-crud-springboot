package br.com.serratec.livraria.repositories;

import br.com.serratec.livraria.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
