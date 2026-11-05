package br.com;

import br.com.model.Match;
import br.com.model.ResultadoArquivo;
import br.com.service.OrquestradorBusca;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrquestradorBusca orquestradorBusca = new OrquestradorBusca();

        String mensagem1 = """
                ========================================
                       SISTEMA DE BUSCA DE NOMES
                ========================================
                """;

        String mensagem2 = """
                ----------------------------------------
                RESUMO DA PESQUISA
                ----------------------------------------
                """;

        System.out.println(mensagem1);
        System.out.println("\nNome pesquisado: ");
        String nomePesquisado = scanner.nextLine();

        List<Path> arquivos = List.of(
                Paths.get("src/main/resources/signatarios-fev-2002.txt"),
                Paths.get("src/main/resources/signatarios-fev-2016.txt"),
                Paths.get("src/main/resources/signatarios-out-2014.txt")
        );

        long tempoTotalInicio = System.currentTimeMillis();

        List<ResultadoArquivo> resultados = orquestradorBusca.executarBuscaParalela(arquivos, nomePesquisado);

        long tempoTotalFim = System.currentTimeMillis();


        int totalOcorrenciasGeral = 0;

        for (ResultadoArquivo resultado : resultados) {
            if(!resultado.sucesso()){
                System.out.println("Erro ao processar o arquivo:\n" + resultado.nomeArquivo());
                System.out.println("Motivo: " + resultado.mensagemErro() + "\n");
                continue;
            }

            if (resultado.totalOcorrencias() > 0) {
                System.out.println("[" + resultado.nomeArquivo() + "]");
                for (Match match : resultado.matches()){
                    System.out.println("Linha " + match.numeroLinha() + ": "+ match.conteudo());
                }
                System.out.println();
            }
            totalOcorrenciasGeral += resultado.totalOcorrencias();
        }
        System.out.println(mensagem2);
        for (ResultadoArquivo resultado : resultados) {
            System.out.println("Arquivo: " + resultado.nomeArquivo());
            System.out.println("Ocorrências: " + resultado.totalOcorrencias());
            System.out.println("Tempo individual: "+ resultado.tempoProcessamentoMs() + "ms\n");
        }

        System.out.println("----------------------------------------");
        System.out.println("Total de ocorrências: " + totalOcorrenciasGeral + "\n");
        System.out.println("Todas as buscas foram finalizadas.\n");
        System.out.println("Tempo total: " + (tempoTotalFim - tempoTotalInicio) + " ms");
        System.out.println("========================================");


        scanner.close();
    }
}