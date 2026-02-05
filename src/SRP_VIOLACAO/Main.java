package SRP_VIOLACAO;

public class Main {
    public static void main(String[] args) {
        Pedido pedido1 = new Pedido("PED-123", 600.00, 5, "cliente@email.com");

        ServicoDePedido servicoDePedido = new ServicoDePedido();

        try {
            double total = servicoDePedido.processarPedido(pedido1);
            System.out.println("Resultado final: Pedido processado com sucesso! Total: R$" + total);
        } catch (Exception e) {
            System.out.println("Erro ao processar pedido: " + e.getMessage());
        }
    }
}

