# tqi_evolution_backend_2021

Uma empresa de empréstimo precisa criar um sistema de análise de crédito para fornecer aos seus clientes as seguintes funcionalidades:
i. Cadastro de clientes
    O cliente pode cadastrar: nome, e-mail, CPF, RG, endereço completo, renda e senha.
ii. Login
    A autenticação será realizada por e-mail e senha.
iii. Solicitação de empréstimo
    Para solicitar um empréstimo, precisamos do valor do empréstimo, data da primeira parcela e quantidade de parcelas.
    O máximo de parcelas será 60 e a data da primeira parcela deve ser no máximo 3 meses após o dia atual.
iv. Acompanhamento das solicitações de empréstimo
    O cliente pode visualizar a lista de empréstimos solicitados por ele mesmo e também os detalhes de um de seus empréstimos.
    Na listagem, devemos retornar no mínimo o código do empréstimo, o valor e a quantidade de parcelas.
    No detalhe do empréstimo, devemos retornar: código do empréstimo, valor, quantidade de parcelas, data da primeira parcela, e-mail do cliente e renda do cliente.

Restrições
1. A implementação deve utilizar linguagem Java ou Kotlin.
2. Use todos os seus conhecimentos adquiridos no bootcamp para explorar bem a solução. Não se preocupe, porque não existe certo ou errado. Só queremos conhecer um pouco mais sobre você.
3. Utilize o GitHub para repositório de código.

## Tecnologias Utilizadas
Para este projeto foram utilizado as ferramentas Spring Boot com a linguagem Java, banco de dados MySQL, Spring Data JPA, Spring Security, Spring Web e Validation.

## Como testar
#Para teste é necessário acessar os seguintes end-points
1. **``POST localhost:8080/clients``**: Para cadastrar clientes.
2. **``GET localhost:8080/clients``**: Lista detalhes do cliente cadastrado.
3. **``PUT localhost:8080/clients/{id}`` ou ``DELETE localhost:8080/clients/{id}``**: Para atualizar ou deletar um cliente.
5. **``POST localhost:8080/clients/{idCli}/loans?create={idCliente}``**: Para solicitar um empréstimo.
6. **``GET localhost:8080/clients/{idCli}/loans``**: Lista todos os empréstimos feitos por um cliente.
7. **``GET localhost:8080/clients/{idCli}/loans/{idLoan}``**: Para ver o detalhe de um empréstimo.
