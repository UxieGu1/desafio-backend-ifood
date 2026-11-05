package br.com.service;

import br.com.model.ResultadoArquivo;

import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class OrquestradorBusca {

    public List<ResultadoArquivo> executarBuscaParalela(List<Path> arquivos, String nomeProcurado) {
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {

            List<CompletableFuture<ResultadoArquivo>> futures = arquivos.stream()
                    .map(arquivo -> CompletableFuture.supplyAsync(() ->
                            BuscadorArquivo.buscarPorNome(arquivo, nomeProcurado), executor))
                    .toList();

            return futures.stream()
                    .map(CompletableFuture::join)
                    .collect(Collectors.toList());
        }
    }
}
