package br.com.model;

import java.util.List;

public record ResultadoArquivo(
        String nomeArquivo,
        List<Match> matches,
        long tempoProcessamentoMs,
        boolean sucesso,
        String mensagemErro
) {
    public int totalOcorrencias() {
        return matches != null ? matches.size() : 0;
    }
}
