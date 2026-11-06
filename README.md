# PoC – Testes e Validação de Classes com TDD

Esta Proof of Concept (PoC) foi desenvolvida como parte da atividade prática de Garantia da Qualidade de Software, com o objetivo de aplicar a abordagem **Test-Driven Development (TDD)** na implementação e validação de classes Java.

O projeto contempla três classes principais: `Cliente`, `FaturaCliente` e `ContaCliente`. A partir da estrutura inicial fornecida, foram implementadas validações para impedir estados inconsistentes e comportamentos inválidos durante a criação e a atualização dos objetos.

**Tecnologias e ferramentas**

Java – implementação das classes e regras de negócio.

Maven – gerenciamento do projeto e das dependências.

JUnit 5 (Jupiter) – criação e execução dos testes automatizados.

JaCoCo – análise de cobertura de testes.

Checkstyle – verificação de padrões e qualidade do código.

Git e GitHub – versionamento e gerenciamento do desenvolvimento.

**Classes e validações implementadas**

**Cliente**

Responsável por representar os dados de um cliente. Foram implementadas validações para impedir a criação ou atualização de clientes com nomes nulos, vazios ou compostos apenas por espaços. O desconto deve permanecer entre 0% e 100%, inclusive. Também foi mantida a validação dos valores permitidos para o gênero (`m`, `f` ou `nd`).

**FaturaCliente**

Responsável por representar uma fatura vinculada a um cliente. Foram implementadas validações para impedir valores negativos ou não finitos (`NaN` e `Infinity`), permitindo valores iguais a zero. Também foi tratado o cenário em que se tenta calcular o valor com desconto sem que exista um cliente associado à fatura, lançando uma `IllegalStateException`.

**ContaCliente**

Responsável por representar a conta de um cliente e suas operações financeiras. Foram implementadas validações para impedir saldos negativos ou não finitos, tanto na criação quanto na atualização da conta. Os depósitos devem possuir valores finitos e positivos. Saques com valores não finitos são rejeitados, enquanto saques negativos, iguais a zero ou superiores ao saldo disponível não alteram o saldo. Também foi implementada uma proteção contra estouro numérico em depósitos que poderiam resultar em um saldo infinito.

**Estratégia de testes**

O desenvolvimento seguiu a abordagem **Test-Driven Development (TDD)**, utilizando o ciclo Red, Green e Refactor.

Inicialmente, era criado um teste que representava o comportamento esperado e verificava sua falha (Red). Em seguida, era implementada a alteração mínima necessária para que o teste passasse (Green). Por fim, o código era revisado em busca de oportunidades de melhoria, preservando os comportamentos já validados (Refactor).

Os testes foram organizados por classe, em correspondência com as classes de produção: `ClienteTest`, `FaturaClienteTest` e `ContaClienteTest`.

Foram contemplados cenários válidos e inválidos, incluindo valores-limite, valores nulos, valores negativos e números não finitos.

**Versionamento**

O desenvolvimento foi organizado em branches específicas por classe e etapa de trabalho, permitindo isolar as alterações e integrar cada conjunto de funcionalidades à branch principal (`main`).

Os commits seguem a convenção **Conventional Commits**, distinguindo alterações de implementação (`feat`), testes (`test`), correções (`fix`), refatorações (`refactor`) e documentação (`docs`).

**Considerações finais**

A PoC demonstra a aplicação prática do TDD na construção de regras de validação e na prevenção de comportamentos inconsistentes.

A utilização de testes automatizados permitiu identificar falhas antes da implementação das respectivas correções e verificar se as alterações preservavam os comportamentos já estabelecidos.

O projeto também evidencia a importância de testar não apenas os cenários esperados, mas também valores-limite, entradas inválidas e situações excepcionais que podem comprometer a integridade dos objetos.
