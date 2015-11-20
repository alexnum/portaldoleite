package models;

import models.dao.GenericDAOImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by axius on 20/11/15.
 */
public class TimeLine {
    List<Dica> dicas = new ArrayList<Dica>();

    public TimeLine(GenericDAOImpl dao, String query){
       this.dicas = dao.createQuery(query).setMaxResults(10).getResultList();
    }

    public List<Dica> getTimeline(){
        for (Dica dica : dicas) {
            dica.checaTipoDica();
        }
        return dicas;
    }
}
