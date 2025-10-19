package br.com.fiap.dasa;

import br.com.fiap.dasa.bo.AnaliseService;
import br.com.fiap.dasa.config.DatabaseInitializer;
import br.com.fiap.dasa.dao.impl.ExameDAOImpl;
import br.com.fiap.dasa.dao.impl.MedicoDAOImpl;
import br.com.fiap.dasa.dao.impl.UsuarioDAOImpl;
import br.com.fiap.dasa.model.Exame;
import br.com.fiap.dasa.model.Medico;
import br.com.fiap.dasa.model.Usuario;


import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        DatabaseInitializer.init();


        var usuarioDAO = new UsuarioDAOImpl();
        var medicoDAO = new MedicoDAOImpl();
        var exameDAO = new ExameDAOImpl();
        var analiseService = new AnaliseService();


// 1) cadastrarMedico
        Long idMedico = medicoDAO.create(new Medico(null, "Dra. Ana", "ana@dasa.com", "123", "CRM123", "Patologia"));
        System.out.println("Medico cadastrado ID=" + idMedico);


// 2) cadastrarUsuario (paciente) só para exemplo
        Long idPaciente = usuarioDAO.create(new Usuario(null, "João", "joao@ex.com", "123", "PACIENTE"));


// 3) cadastrarExame
        Long idExame = exameDAO.create(new Exame(null, "Biópsia", LocalDate.now(), "NOVO", idPaciente));
        System.out.println("Exame criado ID=" + idExame);


// 4) capturarImagem
        System.out.println("Imagem capturada para o exame " + idExame + " (simulação)");


// 5) realizarAnaliseIA (regra de negócio)
        var analise = analiseService.analisar(idExame);
        System.out.printf("Resultado IA: %s | confiança: %.2f\n", analise.getResultado(), analise.getConfianca());


// 6) listarDados
        System.out.println("Usuários:" + usuarioDAO.findAll());
        System.out.println("Exames:" + exameDAO.findAll());
    }
}