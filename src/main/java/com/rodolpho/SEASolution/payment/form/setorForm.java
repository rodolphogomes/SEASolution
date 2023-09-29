package com.rodolpho.SEASolution.payment.form;

import javax.validation.constraints.NotBlank;

public class setorForm {

    @NotBlank
    private String nome;

    public setorForm() {

    }

    public setorForm(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
