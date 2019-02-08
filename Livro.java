// Autor: Vinicius Azevedo dos Santos
// Data: 07/02/2019
// Objeto Livro guarda informacoes do livro e status de locacao

public class Livro {

  private int numero;
  private String titulo;
  private Autor autor;
  private int ano;
  private boolean status; // true disponivel, false emprestado
  private String pessoa; // quem esta com o livro

  public Livro(int numero, String titulo, Autor autor, int ano) {
    this.numero = numero;
    this.titulo = titulo;
    this.autor = autor;
    this.ano = ano;
    status = true;
    pessoa = "";
  }

  public int getNumero() { return numero; }
  public String getTitulo() { return titulo; }
  public Autor getAutor() { return autor; }
  public int getAno() { return ano; }
  public boolean getStatus() { return status; }
  public String getPessoa() { return pessoa; }

  public void setTitulo(String titulo) { this.titulo = titulo; }
  public void setAutor(String nome) { this.autor = autor; }
  public void setAno(int ano) { this.ano = ano; }
  public void setStatus(boolean status) { this.status = status; }
  public void setPessoa(String pessoa) { this.pessoa = pessoa; }

  public String toString() {
    return titulo + " - Autor: " + autor + " - Ano: " + ano;
  }

}
