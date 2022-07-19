package br.com.rafaellbarros.simplecrudrestapijee.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * created by:
 *
 * @author rafael barros for DevDusCorre <rafaelbarros.softwareengineer@gmail.com> on 19/07/2022
 */

@ToString
@Setter
@Getter
@Entity
@Table(name = "todos")
@NamedQueries({
        @NamedQuery(name = "Todo.findAll", query = "SELECT t FROM Todo t")
})
public class Todo implements Serializable {

 private static final long serialVersionUID = 1L;

 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Long id;
 private String task;
 private String description;

}
