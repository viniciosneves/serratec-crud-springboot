package br.com.serratec.livraria.repositories;

import br.com.serratec.livraria.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
