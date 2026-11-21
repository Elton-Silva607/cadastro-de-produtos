package test;

import dominio.Produto;

public class ProdutoTest01 {
    public static void main(String[] args) {
        Produto produto01 = new Produto();
        produto01.setNome("Teclado");
        produto01.setPreco(150);
        produto01.setQuantidade(5);

        Produto produto02 = new Produto();
        produto02.setNome("Mouse");
        produto02.setPreco(80);
        produto02.setQuantidade(10);

        exibirProduto("PRODUTO 01", produto01);
        exibirProduto("PRODUTO 02", produto02);

        System.out.println("\nTestando valores inválidos:");
        produto01.setPreco(-500);
        produto02.setQuantidade(-10);
        produto01.setNome(" ");
        if (!"Teclado".equals(produto01.getNome()) || produto01.calcularValorEstoque() != 750
                || produto02.calcularValorEstoque() != 800) {
            throw new AssertionError("O cadastro mudou depois de receber um valor inválido.");
        }

        produto01.adicionarEstoque(3);
        if (produto01.getQuantidade() != 8) {
            throw new AssertionError("O teclado deveria ter 8 unidades.");
        }
        System.out.println("Estoque do teclado após o desafio: " + produto01.getQuantidade());
        System.out.println("Testes concluídos.");
    }

    private static void exibirProduto(String titulo, Produto produto) {
        System.out.println("========== " + titulo + " ==========");
        System.out.println("Nome: " + produto.getNome());
        System.out.println("Preço: R$ " + produto.getPreco());
        System.out.println("Quantidade: " + produto.getQuantidade());
        System.out.println("Valor do estoque: R$ " + produto.calcularValorEstoque());
    }
}
