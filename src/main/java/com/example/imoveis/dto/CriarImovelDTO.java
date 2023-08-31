package com.example.imoveis.dto;

import com.example.imoveis.model.Imovel;
import lombok.Data;

@Data
public class CriarImovelDTO {
    private String descricao;
    private String endereco;
    private String tipo;
    private Double preco;

    public Imovel toImovel() {
        Imovel imovel = new Imovel(); // cria o imovel
        // atualiza os valores
        imovel.setDescricao(this.getDescricao());
        imovel.setEndereco(this.getEndereco());
        imovel.setTipo(this.getTipo());
        imovel.setPreco(this.getPreco());

        return imovel;
    }
}
