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


## API de Gerenciamento de Usuários, Endereços e Eletrodomesticos

A API permite criar, recuperar, atualizar e deletar registros de Pessoas, Endereços e Eletrodomesticos.

## Pessoas

### Endpoint: http://localhost:8080/pessoas

#### GET - Listar todas as Pessoas

- **Exemplo de Requisição:** `GET /pessoas`

- **Exemplo de Resposta:**
```json
[
    {
        "id": 1,
        "nome": "Maria",
        "dataNascimento": "1990-05-15",
        "sexo": "FEMININO",
        "parentesco": "MÃE"
    },
    {
        "id": 2,
        "nome": "João",
        "dataNascimento": "1985-02-20",
        "sexo": "MASCULINO",
        "parentesco": "PAI"
    }
]

#### GET - Buscar Pessoa por ID
- **Exemplo de Requisição: ** GET /pessoas/1

- **Exemplo de Resposta:**
[
  {
      "id": 1,
      "nome": "Maria",
      "dataNascimento": "1990-05-15",
      "sexo": "FEMININO",
      "parentesco": "MÃE"
  }
]

#### GET - Buscar Pessoas por Parâmetros
- **Exemplo de Requisição: ** GET /pessoas?sexo=FEMININO&parentesco=MÃE

- **Exemplo de Resposta:**
[
    {
        "id": 1,
        "nome": "Maria",
        "dataNascimento": "1990-05-15",
        "sexo": "FEMININO",
        "parentesco": "MÃE"
    }
]

#### POST - Criar uma nova Pessoa

- **Exemplo de Requisição:** `POST /pessoas`

- **Corpo da Requisição:**
```json
{
    "nome": "Ana",
    "dataNascimento": "1995-08-10",
    "sexo": "FEMININO",
    "parentesco": "FILHA"
}

- **Exemplo de Resposta:**
[
  {
      "id": 3,
      "nome": "Ana",
      "dataNascimento": "1995-08-10",
      "sexo": "FEMININO",
      "parentesco": "FILHA"
  }
]

#### PUT - Atualizar Pessoa existente
** Exemplo de Requisição: **PUT /pessoas/2

- **Corpo da Requisição:**
```json

{
    "nome": "Carlos",
    "dataNascimento": "1980-03-25",
    "sexo": "MASCULINO",
    "parentesco": "PAI"
}

- **Exemplo de Resposta:**

[
  {
      "id": 2,
      "nome": "Carlos",
      "dataNascimento": "1980-03-25",
      "sexo": "MASCULINO",
      "parentesco": "PAI"
  }
]

#### DELETE - Excluir Pessoa por ID

** Exemplo de Requisição: ** DELETE /pessoas/3

- **Exemplo de Resposta:**
[
  {
      "message": "Pessoa excluída com sucesso"
  }
]


## Endereços

### Endpoint: http://localhost:8080/enderecos

#### GET - Listar todos os Endereços
- ** Exemplo de Requisição: ** GET /enderecos

- **Exemplo de Resposta:**

[
    {
        "id": 1,
        "rua": "Rua A",
        "numero": 123,
        "bairro": "Centro",
        "cidade": "Cidade",
        "estado": "Estado"
    },
    {
        "id": 2,
        "rua": "Rua B",
        "numero": 456,
        "bairro": "Bairro",
        "cidade": "Cidade",
        "estado": "Estado"
    }
]

#### GET - Buscar Endereço por ID
** Exemplo de Requisição: ** GET /enderecos/1

**Exemplo de Resposta:**

[
  {
      "id": 1,
      "rua": "Rua A",
      "numero": 123,
      "bairro": "Centro",
      "cidade": "Cidade",
      "estado": "Estado"
  }
]

#### POST - Criar um novo Endereço
** Exemplo de Requisição: ** POST /enderecos

- **Corpo da Requisição:**
```json
[
  {
      "rua": "Rua C",
      "numero": 789,
      "bairro": "Bairro Novo",
      "cidade": "Cidade Nova",
      "estado": "Estado Novo"
  }
]

**Exemplo de Resposta:**

[
  {
      "id": 3,
      "rua": "Rua C",
      "numero": 789,
      "bairro": "Bairro Novo",
      "cidade": "Cidade Nova",
      "estado": "Estado Novo"
  }
]

#### PUT - Atualizar Endereço existente

** Exemplo de Requisição: ** PUT /enderecos/2

- **Corpo da Requisição:**
```json
[
  {
      "rua": "Rua D",
      "numero": 555,
      "bairro": "Bairro Atualizado",
      "cidade": "Cidade Atualizada",
      "estado": "Estado Atualizado"
  }
]

**Exemplo de Resposta:**

[
  {
      "id": 2,
      "rua": "Rua D",
      "numero": 555,
      "bairro": "Bairro Atualizado",
      "cidade": "Cidade Atualizada",
      "estado": "Estado Atualizado"
  }
]

#### DELETE - Excluir Endereço por ID

** Exemplo de Requisição: **DELETE /enderecos/3

**Exemplo de Resposta:**

[
  {
      "message": "Endereço excluído com sucesso"
  }
]


## Eletrodomésticos

### Endpoint: http://localhost:8080/eletrodomesticos

#### GET - Listar todos os Eletrodomésticos
** Exemplo de Requisição: **GET /eletrodomesticos

**Exemplo de Resposta:**

[
    {
        "id": 1,
        "nome": "Geladeira",
        "modelo": "Modelo 1",
        "marca": "Marca A",
        "tensao": "VOLTAGEM110",
        "potencia": 150,
        "tempoDeUso": 5.5,
        "casaId": 1
    },
    {
        "id": 2,
        "nome": "Fogão",
        "modelo": "Modelo 2",
        "marca": "Marca B",
        "tensao": "VOLTAGEM220",
        "potencia": 200,
        "tempoDeUso": 3.0,
        "casaId": 2
    }
]

#### GET - Buscar Eletrodoméstico por ID
** Exemplo de Requisição: ** GET /eletrodomesticos/1

**Exemplo de Resposta:**
[
  {
      "id": 1,
      "nome": "Geladeira",
      "modelo": "Modelo 1",
      "marca": "Marca A",
      "tensao": "VOLTAGEM110",
      "potencia": 150,
      "tempoDeUso": 5.5,
      "casaId": 1
  }
]

#### POST - Criar um novo Eletrodoméstico

** Exemplo de Requisição: ** POST /eletrodomesticos

- **Corpo da Requisição:**
```json
[
  {
      "nome": "Micro-ondas",
      "modelo": "Modelo X",
      "marca": "Marca Y",
      "tensao": "VOLTAGEM220",
      "potencia": 800,
      "tempoDeUso": 2.5,
      "casaId": 1
  }
]

**Exemplo de Resposta:**
[
  {
      "id": 3,
      "nome": "Micro-ondas",
      "modelo": "Modelo X",
      "marca": "Marca Y",
      "tensao": "VOLTAGEM220",
      "potencia": 800,
      "tempoDeUso": 2.5,
      "casaId": 1
  }
]


#### PUT - Atualizar Eletrodoméstico existente

** Exemplo de Requisição: ** PUT /eletrodomesticos/2

- **Corpo da Requisição:**
```json
[
  {
      "nome": "Lavadora",
      "modelo": "Modelo Z",
      "marca": "Marca X",
      "tensao": "VOLTAGEM110",
      "potencia": 400,
      "tempoDeUso": 4.0,
      "casaId": 2
  }
]

**Exemplo de Resposta:**

[
  {
      "id": 2,
      "nome": "Lavadora",
      "modelo": "Modelo Z",
      "marca": "Marca X",
      "tensao": "VOLTAGEM110",
      "potencia": 400,
      "tempoDeUso": 4.0,
      "casaId": 2
  }
]


#### DELETE - Excluir Eletrodoméstico por ID

** Exemplo de Requisição: ** DELETE /eletrodomesticos/3

**Exemplo de Resposta:**
[
  {
      "message": "Eletrodoméstico excluído com sucesso"
  }
]



OBS: Certifique-se de que a API esteja em execução e que os endpoints estejam corretos para obter os resultados esperados.
