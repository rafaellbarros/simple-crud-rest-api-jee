package br.com.rafaellbarros.simplecrudrestapijee.service;

import br.com.rafaellbarros.simplecrudrestapijee.model.entity.Todo;
import br.com.rafaellbarros.simplecrudrestapijee.repository.TodoRepository;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.text.MessageFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * created by:
 *
 * @author rafael barros for DevDusCorre <rafaelbarros.softwareengineer@gmail.com> on 19/07/2022
 */


public class TodoService {

    private static final Logger logger = Logger.getLogger(TodoService.class.getName());

    @Produces
    @Dependent
    @PersistenceContext(unitName = "mysql_dev_PU")
    private EntityManager em;
    private TodoRepository repository;

    @PostConstruct
    private void init() {
        RepositoryFactorySupport factory = new JpaRepositoryFactory(em);
        this.repository = factory.getRepository(TodoRepository.class);
    }

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
