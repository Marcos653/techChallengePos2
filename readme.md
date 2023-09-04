# Relatório Técnico: Desenvolvimento de API REST com Spring Boot

## Introdução

Este repositório contém o relatório técnico detalhando o desenvolvimento de uma API REST utilizando o framework Spring Boot. O documento aborda as tecnologias e ferramentas utilizadas, desafios enfrentados e soluções implementadas, bem como a mudança da abordagem de arquitetura de microserviços para um design monolítico.

## Tecnologias e Ferramentas Utilizadas

Durante o processo de desenvolvimento da API, foram empregadas diversas tecnologias e ferramentas para garantir a eficiência e qualidade do sistema. As principais incluem:

- **Spring Boot:** Framework escolhido para criar a API, proporcionando configuração simplificada e eficiência no desenvolvimento.

- **Spring Data:** Módulo utilizado para a integração com o banco de dados, simplificando operações de acesso a dados.

- **Lombok:** Biblioteca que automatiza a geração de código repetitivo, reduzindo a verbosidade do código.

- **Banco de Dados H2:** Banco de dados em memória utilizado durante o desenvolvimento inicial para facilitar a configuração e teste.

- **Postman:** Ferramenta utilizada para testar manualmente os endpoints da API, assegurando sua funcionalidade.

## Mudança da Abordagem de Arquitetura

Inicialmente, o projeto foi planejado com uma abordagem de arquitetura de microserviços. No entanto, uma mudança para um design monolítico foi adotada devido às complexidades das dependências entre as APIs. Em uma arquitetura de microserviços, cada serviço opera de maneira independente, mas observou-se que o projeto atual não era ideal para essa abordagem.

## Desafios e Soluções Implementadas

O desenvolvimento da API enfrentou diversos desafios, que foram abordados com soluções específicas:

1. **Gestão de Relacionamentos Familiares:** Foi implementada uma estrutura flexível para criar relações familiares entre pessoas e endereços, permitindo relacionamentos dinâmicos.

2. **Lógica de Geração Automática de Relacionamentos:** A geração automática de relacionamentos familiares foi alcançada com regras lógicas complexas que analisavam os dados das entidades.

3. **Associação de Pessoas a Endereços:** Uma estratégia de modelagem foi adotada para permitir a associação de pessoas a endereços por meio de uma relação bidirecional.

4. **Validações Complexas:** Validações personalizadas foram implementadas para manter a integridade dos dados e relacionamentos.

5. **Mudança da Arquitetura:** A transição da arquitetura de microserviços para monolítica exigiu reorganização do planejamento e avaliação dos componentes.

## Conclusão

Este repositório reflete o progresso até a data atual e será atualizado à medida que novos avanços forem alcançados no desenvolvimento da API. O relatório técnico detalha as tecnologias, desafios e soluções envolvidas, bem como a mudança de abordagem da arquitetura, fornecendo insights valiosos sobre o processo de desenvolvimento.

