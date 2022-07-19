package br.com.rafaellbarros.simplecrudrestapijee.repository;

import br.com.rafaellbarros.simplecrudrestapijee.model.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * created by:
 *
 * @author rafael barros for DevDusCorre <rafaelbarros.softwareengineer@gmail.com> on 19/07/2022
 */

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
