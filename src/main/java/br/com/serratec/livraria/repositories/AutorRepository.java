package br.com.serratec.livraria.repositories;

import br.com.serratec.livraria.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
