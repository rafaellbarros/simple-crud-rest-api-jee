package br.com.rafaellbarros.simplecrudrestapijee.service;

import br.com.rafaellbarros.simplecrudrestapijee.model.entity.Todo;
import br.com.rafaellbarros.simplecrudrestapijee.repository.TodoRepository;
import org.springframework.beans.BeanUtils;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * created by:
 *
 * @author rafael barros for DevDusCorre <rafaelbarros.softwareengineer@gmail.com> on 19/07/2022
 */

@ApplicationScoped
public class TodoService {

    private static final Logger logger = Logger.getLogger(TodoService.class.getName());

    @Inject
    private TodoRepository repository;

    public Todo findById(final Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Todo não encontrado: "+ id));
    }

    public List<Todo> getAll() {
        logger.log(Level.INFO,"getAll()");
        return repository.findAll();
    }

    @Transactional
    public Todo create(final Todo todo) {
        logger.log(Level.INFO, "create() {0}", todo);
        return repository.save(todo);
    }

    @Transactional
    public Todo update(final Long id, final Todo todoUpdate) {
        logger.log(Level.INFO, "update() {0}", id);
        logger.log(Level.INFO, "update() {0}",todoUpdate);
        final Todo todo = findById(id);
        BeanUtils.copyProperties(todoUpdate, todo);
        return repository.save(todo);
    }

    @Transactional
    public void delete(final Long id) {
        logger.log(Level.INFO, "delete() {0}", id);
        final Todo todo = findById(id);
        repository.delete(todo);
    }


}
