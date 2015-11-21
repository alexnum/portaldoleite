package models.configuracoesDeTimeLine;

import models.dao.GenericDAO;
import models.dao.GenericDAOImpl;
import models.Dica;

import java.util.List;

/**
 * Created by axius on 21/11/15.
 */
public interface IOrganizadorDeTimeLine {
    public List<Dica> pegarDicas(GenericDAOImpl dao);
}
