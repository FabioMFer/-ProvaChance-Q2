# language: pt

Funcionalidade: test
	I want to use this template for my feature file

Esquema do Cenário: Fazer Login com número da Conta e senha
Dado Eu quero acessar o sistema usando o número da conta <conta_original> e senha <senha_original>
Quando Eu informei a conta <conta> e a senha <senha> 
Então  Eu recebo a mensagem de status <status>

Exemplos:
 | conta_original | senha_original | conta  |   senha   |        status          |  
 |  0             | 123ab&120      | 0      | 123ab&120 | Acesso com sucesso     |
 |  1             | qwer12&%       | 1      | qwer12&%  | Acesso com sucesso     |
 |  0             | 123ab&120      | 0      | qwer12&%  | Acesso negado          |
 |  0             | 123ab&120      | 2      | 123ab&120 | Conta inexistente      |