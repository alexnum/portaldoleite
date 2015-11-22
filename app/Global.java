import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import models.Disciplina;
import models.*;
import models.dao.GenericDAOImpl;
import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.db.jpa.JPA;


public class Global extends GlobalSettings {

	private static GenericDAOImpl dao = new GenericDAOImpl();
	private List<Disciplina> disciplinas = new ArrayList<>();
	
	@Override
	public void onStart(Application app) {
		Logger.info("Aplicação inicializada...");

		JPA.withTransaction(new play.libs.F.Callback0() {
			@Override
			public void invoke() throws Throwable {
				if(dao.findAllByClassName(Disciplina.class.getName()).size() == 0){
					criaDisciplinaTemas();
                    adicionarDicas();
				}

                if(dao.findAllByClassName(User.class.getName()).size() == 0) {
                    criaUsuarios();
                }
			}
		});
	}
	
	@Override
	public void onStop(Application app){
	    JPA.withTransaction(new play.libs.F.Callback0() {
	    @Override
	    public void invoke() throws Throwable {
	        Logger.info("Aplicação finalizando...");
	        disciplinas = dao.findAllByClassName("Disciplina");

	        for (Disciplina disciplina: disciplinas) {
	        dao.removeById(Disciplina.class, disciplina.getId());
	       } 
	    }}); 
	}
	
	private void criaDisciplinaTemas(){
		Disciplina si1 = new Disciplina("Sistemas de Informação 1");
		si1.addTema(new Tema("Análise x Design"));
		si1.addTema(new Tema("Orientação a objetos"));
		si1.addTema(new Tema("GRASP"));
		si1.addTema(new Tema("GoF"));
		si1.addTema(new Tema("Arquitetura"));
		si1.addTema(new Tema("Play"));
		si1.addTema(new Tema("JavaScript"));
		si1.addTema(new  Tema("HTML / CSS / Bootstrap"));
		si1.addTema(new Tema("Heroku"));
		si1.addTema(new Tema("Labs"));
		si1.addTema(new Tema("Minitestes"));
		si1.addTema(new Tema("Projeto"));
        for(Tema t: si1.getTemas()){
            t.setDisciplina(si1);
        }
                 //Disciplina: Lógica Matemática
                Disciplina calc = new Disciplina("Cálculo Diferencial e Integral I");
                calc.addTema(new Tema("Limites e Continuidade"));
                calc.addTema(new Tema("Introdução ao conceito de limite"));
                calc.addTema(new Tema("Definição de limite"));
                calc.addTema(new Tema("Técnicas para a determinação de limites"));
                calc.addTema(new Tema("Limites que envolvem infinito"));
                calc.addTema(new Tema("Assíntotas horizontais e assíntotas verticais"));
                calc.addTema(new Tema("Funções contínuas"));
                calc.addTema(new Tema("Retas tangentes e taxas de variação"));
                calc.addTema(new Tema("Definição de derivada"));
                calc.addTema(new Tema("Técnicas de diferenciação"));
                calc.addTema(new Tema("Derivadas de funções trigonométricas"));
                calc.addTema(new Tema("Incrementos e diferenciais"));
                calc.addTema(new Tema("A Regra da Cadeia"));
                calc.addTema(new Tema("Diferenciação implícita"));
                calc.addTema(new Tema("Taxas relacionadas"));
                calc.addTema(new Tema("Extremos de funções"));
                calc.addTema(new Tema("Os teoremas de Rolle e do Valor Médio"));
                calc.addTema(new Tema("O teste da derivada primeira"));
                calc.addTema(new Tema("Concavidade e o teste da derivada segunda"));
                calc.addTema(new Tema("Resumo dos métodos gráficos"));
                calc.addTema(new Tema("Problemas de Otimização"));
                calc.addTema(new Tema("Antiderivada e integração indefinida"));
                calc.addTema(new Tema("Mudança de variáveis em integrais indefinidas"));
                calc.addTema(new Tema("Notação de somação e área"));
                calc.addTema(new Tema("Somas de Riemann e a integral definida"));
                calc.addTema(new Tema("Propriedades da integral definida"));
                calc.addTema(new Tema("A integral como área"));
                calc.addTema(new Tema("O Teorema Fundamental do Cálculo"));
                calc.addTema(new Tema("Funções Exponenciais e Logarítmicas"));
                calc.addTema(new Tema("Funções inversas"));
                calc.addTema(new Tema("A função logarítmica natural"));
                calc.addTema(new Tema("A função exponencial natural"));
                calc.addTema(new Tema("Funções Exponenciais e Logarítmicas Gerais"));
                calc.addTema(new Tema("Derivação e Integração"));
                calc.addTema(new Tema("Derivação logarítimica"));
                calc.addTema(new Tema("Funções Trigonométricas Inversas"));
                calc.addTema(new Tema("Derivadas e integrais"));
                calc.addTema(new Tema("Técnicas de integração"));
                calc.addTema(new Tema("Integração por partes"));
                calc.addTema(new Tema("Integrais trigonométricas"));
                calc.addTema(new Tema("Substituições trigonométricas"));
                calc.addTema(new Tema("Integrais de funções racionais"));
                calc.addTema(new Tema("Integrais que envolvem expressões quadrática"));
                calc.addTema(new Tema("Formas Indeterminadas"));





        for(Tema t: calc.getTemas()){
                        t.setDisciplina(calc);
                    }
        //Disciplina: Programação 2
        Disciplina p2 = new Disciplina("Programação 2");
        p2.addTema(new Tema("Introdução a Linguagem Java"));
        p2.addTema(new Tema("Criação de Classes I: Usando Objetos e Introdução a OO"));
        p2.addTema(new Tema("Criação de Classes I: Testes de Unidades"));
        p2.addTema(new Tema("Tratamento de Exceções, Escopo e Visibilidade"));
        p2.addTema(new Tema("Introdução a Coleções"));
        p2.addTema(new Tema("Reuso, Composição e Herança"));
        p2.addTema(new Tema("herança e Polimorfismo"));
        p2.addTema(new Tema("Interfaces e Polimorfismo"));
        p2.addTema(new Tema("Tratamento de Erros com Exceções + Enumerações"));
        p2.addTema(new Tema("Coleções em Java"));
        p2.addTema(new Tema("Arquivos"));
        p2.addTema(new Tema("Refatoramento e Regras de Design II"));
        p2.addTema(new Tema("Recursividade"));
        p2.addTema(new Tema("Design Patterns"));

        for(Tema t: p2.getTemas()){
            t.setDisciplina(p2);
        }
              dao.persist(si1);
               dao.persist(calc);
               dao.persist(p2);


                dao.flush();

    }

    public void adicionarDicas(){
        disciplinas = dao.findAllByClassName("Disciplina");;
        Disciplina d1 = disciplinas.get(0);
        Disciplina d2 = disciplinas.get(1);
        Disciplina d3 = disciplinas.get(2);
        DicaConselho dica = new DicaConselho();
        dica.setTema(d1.getTemaByNome("Análise x Design"));
        dica.setConselho("Procure sempre fazer uma avaliação");
        dica.setUser("usuario0");
        d1.getTemaByNome("Análise x Design").addDica(dica);

        DicaConselho dica1 = new DicaConselho();
        dica1.setTema(d1.getTemaByNome("Orientação a objetos"));
        dica1.setConselho("Faça uma revisão no seu material de P2.");
        dica1.setUser("usuario1");
        d1.getTemaByNome("Orientação a objetos").addDica(dica1);

        DicaAssunto dica2 = new DicaAssunto();
        dica2.setTema(d1.getTemaByNome("Play"));
        dica2.setAssunto("Não importa o que faça ou quanto estude, você vai sofrer aqui. " +
                "Não existem muitos materiais para aprender o Play, mas comece com a documentação");
        dica2.setUser("usuario2");
        d1.getTemaByNome("Play").addDica(dica2);

        DicaConselho dica3 = new DicaConselho();
        dica3.setTema(d1.getTemaByNome("Labs"));
        dica3.setConselho("Faça o máximo que puder aqui, envie tudo, mesmo que você ache que não irá valer nada.");
        dica3.setUser("usuario3");
        d1.getTemaByNome("Labs").addDica(dica3);

        DicaMaterial dica4 = new DicaMaterial();
        dica4.setTema(d1.getTemaByNome("GoF"));
        dica4.setUrl("http://www.tutorialspoint.com/design_pattern/index.htm");
        dica4.setUser("usuario5");
        d1.getTemaByNome("GoF").addDica(dica4);

        DicaConselho dica5 = new DicaConselho();
        dica5.setTema(d2.getTemaByNome("Definição de limite"));
        dica5.setConselho("Há vários tutoriais de limites, visto que é o mais fácil de entender!");
        dica5.setUser("usuario4");
        d2.getTemaByNome("Definição de limite").addDica(dica5);

        DicaConselho dica6 = new DicaConselho();
        dica6.setTema(d3.getTemaByNome("Interfaces e Polimorfismo"));
        dica6.setConselho("Dois assuntos importantíssimos para utilizar o padrão de projeto Strategy deixando o código menos acoplado, aberto para extensões e" +
                "fechado para modificações. Há videos no youtube que ensinam bem!");
        dica6.setUser("usuario4");
        d3.getTemaByNome("Interfaces e Polimorfismo").addDica(dica6);

        dao.persist(d1);
        dao.persist(d2);
        dao.persist(d3);
        dao.flush();
    }

    private void criaUsuarios() {

        for (int i = 1; i <= 10; i++) {
            String nome = "Usuario " + i;
            String email = "usuario" + i + "@ccc.ufcg.edu.br";
            String nick = "usuario" + i;
            String pass = "12345";

            User usuario = new User(email, pass, nick);
            usuario.setNome(nome);
            dao.persist(usuario);
        }

        dao.flush();
    }
}
