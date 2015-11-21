package models;

import models.configuracoesDeTimeLine.IOrganizadorDeTimeLine;
import models.dao.GenericDAOImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by axius on 20/11/15.
 */
public class TimeLine {
    IOrganizadorDeTimeLine organizador;
    GenericDAOImpl dao;
    public TimeLine(GenericDAOImpl dao, IOrganizadorDeTimeLine organizador){
       this.organizador = organizador;
       this.dao = dao;
    }

    public List<Dica> getTimeline(){
        List<Dica> dicas = organizador.pegarDicas(dao);
        for (Dica dica : dicas) {
            dica.checaTipoDica();
        }
        return dicas;
    }
}
