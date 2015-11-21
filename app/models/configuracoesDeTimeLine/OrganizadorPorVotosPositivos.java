package models.configuracoesDeTimeLine;

import models.Dica;
import models.dao.GenericDAOImpl;

import java.util.List;

/**
 * Created by axius on 21/11/15.
 */
public class OrganizadorPorVotosPositivos implements IOrganizadorDeTimeLine{
    private static String QUERY_GET_DICAS = "FROM " + Dica.class.getName()  + " ORDER BY concordancias DESC";


    @Override
    public List<Dica> pegarDicas(GenericDAOImpl dao) {
        return dao.createQuery(QUERY_GET_DICAS).setMaxResults(10).getResultList();
    }

}