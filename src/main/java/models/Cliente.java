package models;
public class Cliente {
private int idade;
private String nome;
private String genero;
private int cpf;
public Cliente() {
super();
this.idade = 0;
this.nome = "";
this.genero = "";
this.cpf = 0;
}
public Cliente(int idade, String nome, String genero, int cpf) {
this.idade = idade;
this.nome = nome;
this.genero = genero;
this.cpf = cpf;
}
public int getIdade() {
return idade;
}
public void setIdade(int idade) {
this.idade = idade;
}
public String getNome() {
return nome;
}
public void setNome(String nome) {
this.nome = nome;
}
public String getGenero() {
return genero;
}
public void setGenero(String genero) {
this.genero = genero;
}
public int getCpf() {
return cpf;
}
public void setCpf(int cpf) {
this.cpf = cpf;
}
@Override
public String toString() {
return "Cliente [idade=" + idade + ", nome=" + nome + ", genero=" + genero + ", cpf=" + cpf + "]";
}
}
