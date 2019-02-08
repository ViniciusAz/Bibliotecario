// Autor: Vinicius Azevedo dos Santos
// Data: 07/02/2019
// Objeto Autor armazena informacoes id e nome

public class Autor {

  private int id;
  private String nome;

  public Autor (int id, String nome) {
    this.id = id;
    this.nome = nome;
  }

  public String getNome() { return nome; }
  public int getId() { return id; }

  public void setNome(String nome) { this.nome = nome; }

  public String toString() {
    return nome;
  }

}
