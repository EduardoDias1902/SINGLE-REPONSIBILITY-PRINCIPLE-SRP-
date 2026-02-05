package SRP_VIOLACAO;

public class ServicoDePedido {
    private ValidadorDeEstoque validadorDeEstoque;
    private CalculadoraDeFreteEImpostos calculadora;
    private PersistidorDePedido persistidor;
    private EnviadorDeEmail enviadorDeEmail;

    public ServicoDePedido() {
        this.validadorDeEstoque = new ValidadorDeEstoque();
        this.calculadora = new CalculadoraDeFreteEImpostos();
        this.persistidor = new PersistidorDePedido();
        this.enviadorDeEmail = new EnviadorDeEmail();
    }

    public double processarPedido(Pedido pedido) throws Exception {
        validadorDeEstoque.validarEstoque(pedido);

        double frete = calculadora.calcularFrete(pedido);
        double impostos = calculadora.calcularImpostos(pedido);
        double valorFinal = pedido.getValorTotal() + frete + impostos;

        pedido.setPago(true);

        persistidor.salvar(pedido, valorFinal);

        enviadorDeEmail.enviarEmail(pedido.getEmailCliente(), pedido.getId());

        return valorFinal;
    }
}

