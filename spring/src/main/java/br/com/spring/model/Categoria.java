package br.com.spring.model;

public enum Categoria {
    CELULAR("Celulares"),
    ELETRODOMESTICO("Eletrodomésticos"),
    INFORMATICA("Informatica"),
    LIVROS("Livros"),
    MOVEIS("Moveis");
    private String descricao;

    Categoria (String descricao){
        this.descricao = descricao;
    }
    public String getDescricao(){
        return this.descricao;
    }
}
