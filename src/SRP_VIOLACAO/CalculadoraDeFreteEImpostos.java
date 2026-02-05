package SRP_VIOLACAO;

public class CalculadoraDeFreteEImpostos {
    public double calcularFrete(Pedido pedido) {
        if (pedido.getValorTotal() < 500.00) {
            return 50.00;
        } else {
            return 0.00;
        }
    }
    public double calcularImpostos(Pedido pedido) {
        return pedido.getValorTotal() * 0.15;
    }
}

