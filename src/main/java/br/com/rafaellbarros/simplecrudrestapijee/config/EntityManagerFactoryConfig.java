package br.com.rafaellbarros.simplecrudrestapijee.config;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * created by:
 *
 * @author rafael barros for DevDusCorre <rafaelbarros.softwareengineer@gmail.com> on 21/07/2022
 */

public class EntityManagerFactoryConfig {

  @PersistenceContext(name = "mysql_dev_PU")
  EntityManager entityManager;

  @Produces
  @RequestScoped
  public EntityManager createEntityManager() {
    return entityManager;
  }

}
