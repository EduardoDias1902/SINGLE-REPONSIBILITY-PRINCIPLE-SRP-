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
        // Validação de estoque
        validadorDeEstoque.validarEstoque(pedido);

        // Cálculo de frete e impostos
        double frete = calculadora.calcularFrete(pedido);
        double impostos = calculadora.calcularImpostos(pedido);
        double valorFinal = pedido.getValorTotal() + frete + impostos;

        // Simulação de pagamento e atualização de status
        pedido.setPago(true);

        // Persistência no banco de dados
        persistidor.salvar(pedido, valorFinal);

        // Envio de e-mail de confirmação
        enviadorDeEmail.enviarEmail(pedido.getEmailCliente(), pedido.getId());

        return valorFinal;
    }
}

