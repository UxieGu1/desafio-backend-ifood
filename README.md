# Desafio Técnico Java — Estágio Backend | iFood (Simulação)

> **Contexto:** Busca de pedidos em arquivos de processamento

---

## Regras do Desafio

### 1. Contextualização

Imagine que você foi contratado como estagiário de desenvolvimento em uma empresa responsável pelo processamento de grandes volumes de informações.

Essa empresa possui diversos arquivos de texto contendo registros de pessoas. Periodicamente, os funcionários precisam localizar determinados nomes nesses arquivos.

Atualmente, esse processo é realizado manualmente, exigindo que cada arquivo seja aberto e pesquisado individualmente.

Para automatizar essa atividade, a equipe de desenvolvimento solicitou a criação de uma aplicação Java capaz de pesquisar um nome em diferentes arquivos de texto.

Sua missão é desenvolver essa aplicação!

### 2. Objetivo do desafio

Desenvolver uma aplicação Java que permita pesquisar um determinado nome em três arquivos de texto.

O programa deverá identificar todas as linhas que contenham o nome pesquisado e apresentar os resultados no console.

Além disso, deverá informar a quantidade de ocorrências encontradas em cada arquivo e o tempo total necessário para realizar a pesquisa.

### 3. Requisitos funcionais

**RF01 — Definição do nome pesquisado**  
A aplicação deverá permitir definir o nome que será pesquisado nos arquivos.  
Para este desafio, o nome poderá ser informado diretamente no código ou solicitado ao usuário pelo console.  
*Exemplo:*
```text
Nome pesquisado: Dave
```

**RF02 — Leitura dos arquivos**  
A aplicação deverá realizar a leitura dos seguintes arquivos:
- `signatarios-fev-2002.txt`
- `signatarios-fev-2016.txt`
- `signatarios-out-2014.txt`

Cada arquivo contém uma lista de registros textuais.  
A aplicação deverá percorrer o conteúdo dos três arquivos para localizar o nome informado.

**RF03 — Identificação das ocorrências**  
Durante a leitura, o programa deverá verificar se cada linha contém o nome pesquisado.  
Quando encontrar uma correspondência, deverá apresentar:
- Nome do arquivo.
- Número da linha.
- Conteúdo completo da linha.

*Exemplo:*
```text
[signatarios-fev-2002.txt] Linha 15: Dave Smith
[signatarios-out-2014.txt] Linha 82: Dave Johnson
```

**RF04 — Contagem de ocorrências**  
Ao finalizar a pesquisa em cada arquivo, a aplicação deverá informar quantas linhas continham o nome pesquisado.  
*Exemplo:*
```text
Busca finalizada: signatarios-fev-2002.txt
Ocorrências: 1

Busca finalizada: signatarios-fev-2016.txt
Ocorrências: 0

Busca finalizada: signatarios-out-2014.txt
Ocorrências: 1
```

**RF05 — Processamento dos arquivos**  
A aplicação deverá ser capaz de executar as buscas nos três arquivos de maneira independente.  
O processamento de um arquivo não deverá depender dos resultados encontrados nos demais.

**RF06 — Tempo de execução**  
A aplicação deverá calcular e apresentar o tempo total necessário para concluir todas as pesquisas.  
*Exemplo:*
```text
Todas as buscas foram finalizadas.
Tempo total: 42 ms
```
O tempo deverá considerar o início do processamento até a conclusão das buscas nos três arquivos.

**RF07 — Tratamento de erros**  
Caso algum arquivo não exista ou não possa ser lido, a aplicação deverá apresentar uma mensagem informando o problema.  
*Exemplo:*
```text
Erro ao processar o arquivo: signatarios-fev-2016.txt
Motivo: Arquivo não encontrado.
```

### 4. Exemplo de funcionamento

Considere que o usuário deseja pesquisar o nome Dave.

A aplicação deverá apresentar um resultado semelhante ao seguinte:

```text
========================================
       SISTEMA DE BUSCA DE NOMES
========================================

Nome pesquisado: Dave

Iniciando pesquisa nos arquivos...

[signatarios-fev-2002.txt]
Linha 15: Dave Smith

[signatarios-out-2014.txt]
Linha 82: Dave Johnson

----------------------------------------
RESUMO DA PESQUISA
----------------------------------------

Arquivo: signatarios-fev-2002.txt
Ocorrências: 1

Arquivo: signatarios-fev-2016.txt
Ocorrências: 0

Arquivo: signatarios-out-2014.txt
Ocorrências: 1

----------------------------------------
Total de ocorrências: 2

Todas as buscas foram finalizadas.

Tempo total: 42 ms
========================================
```
*Observação: Os dados e o tempo apresentados são ilustrativos. Os resultados dependerão do conteúdo dos arquivos utilizados.*

### 5. Requisitos técnicos

Para desenvolver a solução, considere as seguintes orientações:

- Utilizar Java 21 ou superior.
- Desenvolver uma aplicação executada pelo console.
- Utilizar os recursos da linguagem Java para leitura de arquivos.
- Organizar o código em classes e métodos com responsabilidades bem definidas.
- Evitar duplicação desnecessária de código.
- Garantir que todos os arquivos sejam processados antes da apresentação do resultado final.
- Implementar tratamento de exceções para possíveis erros de leitura.

Não será necessário desenvolver interface gráfica, API REST ou utilizar banco de dados.

### 6. Diferenciais

Embora não sejam obrigatórios, os seguintes recursos poderão ser considerados diferenciais:

- Permitir pesquisar diferentes nomes sem alterar o código-fonte.
- Permitir adicionar novos arquivos à pesquisa.
- Organizar a solução utilizando orientação a objetos.
- Implementar testes automatizados.
- Utilizar mecanismos de concorrência para executar as buscas.
- Apresentar o tempo individual de processamento de cada arquivo.

### 7. Entrega

O candidato deverá disponibilizar:

- Código-fonte completo da aplicação.
- Arquivos de texto utilizados nos testes.
- Instruções básicas para executar o projeto.
- Um exemplo de saída da aplicação.

O projeto poderá ser disponibilizado em um repositório Git ou entregue em um arquivo compactado.

### 8. Considerações finais

Este desafio busca avaliar sua capacidade de compreender um problema, organizar uma solução e implementar funcionalidades utilizando a linguagem Java.

Não existe apenas uma maneira de resolver o problema.

O mais importante é que a aplicação funcione corretamente, apresente os resultados esperados e tenha um código organizado e compreensível.

Boa sorte e bom desenvolvimento!
