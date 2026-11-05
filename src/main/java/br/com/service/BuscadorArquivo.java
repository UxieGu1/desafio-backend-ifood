package br.com.service;

import br.com.model.Match;
import br.com.model.ResultadoArquivo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class BuscadorArquivo {

    public static ResultadoArquivo buscarPorNome(Path caminhoArquivo, String nomeProcurado) {
        long tempoInicio = System.currentTimeMillis();
        List<Match> matches = new ArrayList<>();
        String nomeArquivo = caminhoArquivo.getFileName().toString();

        String nomeLimpo = removerAcentos(nomeProcurado).toLowerCase().trim();

        try(BufferedReader reader = Files.newBufferedReader(caminhoArquivo)) {
            String linha;
            int numeroLinha = 1;

            while ((linha = reader.readLine()) != null) {
                String linhaLimpa = removerAcentos(linha).toLowerCase();

                if (linhaLimpa.contains(nomeLimpo)) {
                    matches.add(new Match(numeroLinha, linha));
                }
                numeroLinha++;
            }
            long tempoFim = System.currentTimeMillis();
            return new ResultadoArquivo(nomeArquivo, matches, (tempoFim - tempoInicio), true, null);
        } catch (IOException e) {
            long tempoFim = System.currentTimeMillis();
            return new ResultadoArquivo(nomeArquivo, matches, (tempoFim - tempoInicio), false, "Arquivo não encontrado ou erro de leitura.");
        }
    }

    private static String removerAcentos(String texto) {
        if (texto == null) return "";
        String textoNormalizado = Normalizer.normalize(texto, Normalizer.Form.NFD);
        // Usa uma Expressão Regular para remover as marcações de acento
        return textoNormalizado.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }
}