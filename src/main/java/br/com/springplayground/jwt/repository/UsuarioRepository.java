package br.com.springplayground.jwt.repository;

import br.com.springplayground.jwt.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT u FROM Usuario u WHERE u.userName =:userName")
    Usuario findByLogin(@Param("userName") String userName);

}
