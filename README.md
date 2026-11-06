# PoC – Testes e Validação de Classes com TDD

## 1. Sobre o projeto

Esta Proof of Concept (PoC) foi desenvolvida como parte da atividade prática de Garantia da Qualidade de Software, com o objetivo de aplicar a abordagem **Test-Driven Development (TDD)** na implementação e validação de classes Java.

O projeto contempla três classes principais: `Cliente`, `FaturaCliente` e `ContaCliente`. A partir da estrutura inicial fornecida, foram implementadas validações para impedir estados inconsistentes e comportamentos inválidos durante a criação e a atualização dos objetos.

## 2. Tecnologias e ferramentas

- **Java:** implementação das classes e regras de negócio.
- **Maven:** gerenciamento do projeto e das dependências.
- **JUnit 5 (Jupiter):** criação e execução dos testes automatizados.
- **JaCoCo:** análise de cobertura de testes.
- **Checkstyle:** verificação de padrões e qualidade do código.
- **Git e GitHub:** versionamento e gerenciamento do desenvolvimento.

## 3. Classes e validações implementadas

### Cliente

Responsável por representar os dados de um cliente.

Foram implementadas as seguintes validações:

- O nome não pode ser nulo, vazio ou composto apenas por espaços.
- O desconto deve estar entre 0% e 100%, inclusive.
- As validações são aplicadas tanto no construtor quanto nos métodos de atualização.
- O gênero deve corresponder a um dos valores permitidos: `m`, `f` ou `nd`.

### FaturaCliente

Responsável por representar uma fatura vinculada a um cliente.

Foram implementadas as seguintes validações e tratamentos:

- O valor da fatura não pode ser negativo.
- Valores `NaN` e infinitos não são permitidos.
- O valor zero é permitido.
- As validações são aplicadas tanto no construtor quanto no método `setValor`.
- O cálculo do valor com desconto exige que exista um cliente associado à fatura. Caso contrário, é lançada uma `IllegalStateException`.

### ContaCliente

Responsável por representar a conta de um cliente e suas operações financeiras.

Foram implementadas as seguintes validações:

- O saldo inicial não pode ser negativo, `NaN` ou infinito.
- O saldo pode ser atualizado somente com valores finitos e não negativos.
- Depósitos devem possuir valores finitos e estritamente positivos.
- Saques com valores `NaN` ou infinitos são rejeitados.
- Saques superiores ao saldo disponível não alteram o saldo.
- Saques com valor zero ou negativo não alteram o saldo.
- É permitido sacar o valor total disponível na conta.
- Depósitos que produzam estouro numérico e resultem em saldo infinito são rejeitados, preservando o saldo anterior.

## 4. Estratégia de testes

O desenvolvimento seguiu a abordagem **Test-Driven Development (TDD)**, utilizando o ciclo:

1. **Red:** criação de um teste para uma regra ainda não implementada, verificando sua falha.
2. **Green:** implementação da menor alteração necessária para fazer o teste passar.
3. **Refactor:** revisão e melhoria do código, preservando o comportamento validado pelos testes.

Os testes foram organizados por classe, em correspondência com as classes de produção:

- `ClienteTest`
- `FaturaClienteTest`
- `ContaClienteTest`

Foram contemplados cenários válidos e inválidos, incluindo valores-limite, valores nulos, valores negativos e números não finitos (`NaN` e `Infinity`).

## 5. Organização do projeto

```text
Pratica07-TDD/
└── tdd_pratica7/
    ├── pom.xml
    └── src/
        ├── main/
        │   └── java/
        │       └── com/gqs/pratica7/tdd/
        │           ├── Cliente.java
        │           ├── FaturaCliente.java
        │           └── ContaCliente.java
        └── test/
            └── java/
                └── com/gqs/pratica7/tdd/
                    ├── ClienteTest.java
                    ├── FaturaClienteTest.java
                    └── ContaClienteTest.java
```

## 6. Versionamento

O desenvolvimento foi organizado em branches específicas por classe e etapa de trabalho, permitindo isolar as alterações e integrar cada conjunto de funcionalidades à branch principal (`main`).

Os commits seguem a convenção **Conventional Commits**, distinguindo alterações de implementação (`feat`), testes (`test`), correções (`fix`), refatorações (`refactor`) e documentação (`docs`).

## 7. Considerações finais

A PoC demonstra a aplicação prática do TDD na construção de regras de validação e na prevenção de comportamentos inconsistentes.

A utilização de testes automatizados permitiu identificar falhas antes da implementação das respectivas correções e verificar se as alterações preservavam os comportamentos já estabelecidos.

O projeto também evidencia a importância de testar não apenas os cenários esperados, mas também valores-limite, entradas inválidas e situações excepcionais que podem comprometer a integridade dos objetos.