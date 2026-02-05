# SINGLE-REPONSIBILITY-PRINCIPLE-SRP-
 
# Refatoração SRP: Processamento de Pedido

Apliquei o **Princípio da Responsabilidade Única (SRP)** para organizar melhor o código da classe `ProcessadorDePedido`.

## Antes vs. Depois

**Antes:** A classe `ProcessadorDePedido` fazia tudo sozinha (estoque, cálculos, banco de dados e e-mail).

**Agora:** Dividi as tarefas em classes especialistas, coordenadas pelo `ServicoDePedido`.

### Novas Classes
* **ValidadorDeEstoque:** Confere se há itens disponíveis.
* **CalculadoraDeFreteEImpostos:** Calcula os valores finais.
* **PersistidorDePedido:** Salva o pedido no banco de dados.
* **EnviadorDeEmail:** Envia a confirmação para o cliente.

## Benefícios
* **Manutenção:** Mais fácil de alterar uma regra sem quebrar o resto.
* **Testes:** Cada classe pode ser testada isoladamente.
* **Flexibilidade:** Facilita trocas futuras (ex: mudar o banco de dados).

