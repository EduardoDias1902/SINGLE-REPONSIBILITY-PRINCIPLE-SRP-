package SRP_VIOLACAO;

public class ValidadorDeEstoque {
    public void validarEstoque(Pedido pedido) throws Exception {
        if (pedido.getQuantidadeItens() > 100) {
            throw new Exception("Estoque insuficiente para a quantidade solicitada.");
        }
    }
}

