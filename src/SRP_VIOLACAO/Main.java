package SRP_VIOLACAO;

public class Main {
    public static void main(String[] args) {
        // Criação do pedido
        Pedido pedido1 = new Pedido("PED-123", 600.00, 5, "cliente@email.com");

        // Instanciando o serviço que orquestra o processamento do pedido
        ServicoDePedido servicoDePedido = new ServicoDePedido();

        try {
            // Processando o pedido
            double total = servicoDePedido.processarPedido(pedido1);
            System.out.println("Resultado final: Pedido processado com sucesso! Total: R$" + total);
        } catch (Exception e) {
            System.out.println("Erro ao processar pedido: " + e.getMessage());
        }
    }
}

