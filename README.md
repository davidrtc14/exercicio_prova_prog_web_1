# Exercício 1 — Sistema de Pedidos de Produtos

Aplicação web desenvolvida com **Spring Boot** e **Thymeleaf** que simula um sistema de pedidos com cálculo automático de preços e descontos progressivos.

## 🛠️ Tecnologias

- Java 25
- Spring Boot 4.0.5
- Spring MVC + Thymeleaf
- Lombok
- Maven

## 📋 Funcionalidades

- Exibição de tabela de produtos com faixas de preço por código
- Formulário para realização de pedidos (código + quantidade)
- Cálculo automático de:
  - Preço total (preço unitário × quantidade)
  - Desconto progressivo sobre o valor total
  - Preço final após desconto
- Validação de código de produto inválido com exibição de mensagem de erro

## 💰 Regras de Negócio

**Tabela de Preços por Código:**

| Código     | Preço Unitário |
|------------|----------------|
| 1 a 10     | R$ 10,00       |
| 11 a 20    | R$ 15,00       |
| 21 a 30    | R$ 20,00       |
| 31 a 40    | R$ 30,00       |

**Tabela de Descontos:**

| Preço Total da Nota       | Desconto |
|---------------------------|----------|
| Até R$ 250,00             | 5%       |
| Entre R$ 250,00 e R$ 500,00 | 10%    |
| Acima de R$ 500,00        | 15%      |

## 🗂️ Estrutura do Projeto

```
src/main/java/com/davidrtc14/exercicio1/
├── Exercicio1Application.java          # Classe principal
├── controller/
│   └── ProdutoController.java          # Rotas GET /produtos e POST /pedido
├── model/
│   ├── Produto.java                    # Entidade produto (código, preço)
│   └── Pedido.java                     # Entidade pedido com lógica de cálculo
└── utils/
    └── ListaProdutos.java              # Lista em memória dos 40 produtos

src/main/resources/
├── templates/
│   └── produtos.html                   # Página principal (Thymeleaf)
└── static/
    └── styles.css                      # Estilos da aplicação
```

## 🚀 Como Executar

**Pré-requisitos:** Java 25 e Maven instalados.

```bash
# Clonar/extrair o projeto e entrar na pasta
cd exercicio_prova_prog_web_1

# Executar com Maven Wrapper
./mvnw spring-boot:run
```

Acesse: [http://localhost:8080/produtos](http://localhost:8080/produtos)

## 🔗 Endpoints

| Método | Rota      | Descrição                                |
|--------|-----------|------------------------------------------|
| GET    | /produtos | Exibe a tabela de produtos e o formulário|
| POST   | /pedido   | Processa o pedido e exibe o resultado    |
