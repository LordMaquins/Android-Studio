package com.example.PowerRangers;

public class Jogador {
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private String idade;
    private String resposta;

    public Jogador(int id, String nome, String email, String telefone, String idade, String resposta) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.idade = idade;
        this.resposta = resposta;
    }
    public Jogador( String nome, String email, String telefone, String idade, String resposta) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.idade = idade;
        this.resposta = resposta;
    }

    public Jogador(String nome, String resposta){
        this.nome = nome;
        this.resposta = resposta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }



   public String getResposta(){
        return resposta;
   }
   public void setResposta(String resposta){
        this.resposta = resposta;
   }


}
