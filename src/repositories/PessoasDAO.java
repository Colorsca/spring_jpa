package repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import entities.tbPessoas;

@Component
public class PessoasDAO {

    @PersistenceContext private EntityManager em;
    
    @Transactional
    public void persist(tbPessoas guest) {
        em.persist(guest);
    }
 
    public List<tbPessoas> getAll() {
        TypedQuery<tbPessoas> query = em.createQuery("SELECT g FROM tbPessoas g ORDER BY g.id", tbPessoas.class);
        List<tbPessoas> lista = query.getResultList();
        return lista;
    }
 
}