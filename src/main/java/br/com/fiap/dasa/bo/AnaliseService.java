package br.com.fiap.dasa.bo;

import br.com.fiap.dasa.model.AnaliseIA;
import java.util.Random;

public class AnaliseService {

    public AnaliseIA analisar(Long exameId) {
        double confianca = 0.7 + new Random().nextDouble() * 0.3; // 70%–100%
        String resultado = confianca > 0.85 ? "Achado relevante" : "Sem alterações significativas";
        return new AnaliseIA(null, exameId, resultado, Math.round(confianca * 100.0) / 100.0);
    }
}
