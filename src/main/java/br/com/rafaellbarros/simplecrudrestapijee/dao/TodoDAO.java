package br.com.rafaellbarros.simplecrudrestapijee.dao;

import br.com.rafaellbarros.simplecrudrestapijee.model.entity.Todo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * created by:
 *
 * @author rafael barros for DevDusCorre <rafaelbarros.softwareengineer@gmail.com> on 19/07/2022
 */

@Stateless
public class TodoDAO {

    @PersistenceContext(unitName = "mysql_dev_PU")
    private EntityManager em;

    public List getAll() {
        return em.createNamedQuery("Todo.findAll", Todo.class).getResultList();
    }

    public Todo findById(Long id) {
        return em.find(Todo.class, id);
    }

    public void update(Todo todo) {
        em.merge(todo);
    }

    public void create(Todo todo) {
        em.persist(todo);
    }

    public void delete(Todo todo) {
        if (!em.contains(todo)) {
            todo = em.merge(todo);
        }

        em.remove(todo);
    }
}
