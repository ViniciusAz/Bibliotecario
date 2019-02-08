// Autor: Vinicius Azevedo dos Santos
// Data: 07/02/2019
// Colecao de objeto Livro

import java.util.List;
import java.util.ArrayList;

public class Biblioteca {

  private List<Livro> livros;
  private int numero;
  private Autores autores = new Autores();
  private int contaEmprestados;

  public Biblioteca() {
    livros = new ArrayList<Livro>();
    numero = 0;
    contaEmprestados = 0;
  }

  // commando add cadastra novo livro "doacao", recebe titulo, autor (string), ano
  // percorre a lista de livros para encontrar algum ja cadastrado,
  // se nao encontrar, entao cadastra um novo
  public void add(String titulo, String autor, int ano) {
    for (Livro l : livros) {
      if(l.getTitulo().equalsIgnoreCase(titulo)) {
        System.err.println("Livro já cadastrado.");
        return;
      }
		}
    livros.add(new Livro(++numero, titulo, autores.get(autor), ano));
  }

  public int size() {
    return numero;
  }

  public boolean existeLivroDisponivel() {
    if(numero - contaEmprestados > 0) return true;
    return false;
  }

  public boolean existeLivroEmprestado() {
    if(contaEmprestados > 0) return true;
    return false;
  }

  // retorna um array com informacoes do livro
  public String[] getInfo(int numero) {
    String[] info = new String[5];
    for (Livro l : livros) {
      if(l.getNumero() == numero) {
        info[0] = l.getTitulo();
        info[1] = l.getAutor().getNome();
        info[2] = Integer.toString(l.getAno());
        if(l.getStatus())
          info[3] = "Disponível";
        else info[3] = "Indisponível";
        info[4] = l.getPessoa();
      }
		}
    return info;
  }

  // baixa toda a informacao cadastrada para salvar
  public String[][] backup() {
    String[][] bkp = new String[numero][5];
    for (int i = 0; i < livros.size(); i++) {
      bkp[i][0] = livros.get(i).getTitulo();
      bkp[i][1] = livros.get(i).getAutor().getNome();
      bkp[i][2] = Integer.toString(livros.get(i).getAno());
      if(livros.get(i).getStatus()) {
        bkp[i][3] = "1";
        bkp[i][4] = "";
      } else /*nao tem emprestimo*/ {
        bkp[i][3] = "0";
        bkp[i][4] = livros.get(i).getPessoa();
      }
    }
    return bkp;
  }

  // verifica na lista se o livro existe, em seguida se esta disponivel ou nao
  public boolean check(int numero) {
    for (Livro l : livros) {
      if(l.getNumero() == numero)
        if(l.getStatus())
          return true;
        else return false;
		}
    return false;
  }

  // verifica na lista se o livro existe, em seguida se esta disponivel ou nao
  public boolean checkIndisponivel(int numero) {
    for (Livro l : livros) {
      if(l.getNumero() == numero)
        if(!l.getStatus())
          return true;
        else return false;
		}
    return false;
  }

  // busca o objeto livro, altera o status para false e adiciona nome de pessoa
  public void retirar(int numero, String nome) {
    for (Livro l : livros) {
      if(l.getNumero() == numero) {
        l.setStatus(false);
        l.setPessoa(nome);
        contaEmprestados++;
        break;
      }
    }
  }

  // busca o objeto livro, altera o status para true e remove nome de pessoa
  public void devolver(int numero) {
    for (Livro l : livros) {
      if(l.getNumero() == numero) {
        l.setStatus(true);
        l.setPessoa("");
        contaEmprestados--;
        break;
      }
    }
  }

  public Autores getAutores() {
    return autores;
  }

  // gera uma lista com todos os livros disponiveis para emprestimo
  public String disponiveis() {
    String disp = "";
    for (Livro l : livros) {
      if(l.getStatus()) // true disponivel
        disp += "> [" + String.format("%05d", l.getNumero()) + "] " + l + "\n";
		}
    return disp;
  }

  // retorna uma lista com todos os livros emprestados
  public String emprestados() {
    String emp = "";
    for (Livro l : livros) {
      if(!l.getStatus()) // false retirado
        emp += "> [" + String.format("%05d", l.getNumero()) + "] " + l + "\n";
		}
    return emp;
  }

  public String toString() {
    String impressao = "";
    for (Livro l : livros) {
      impressao += l + "\n";
		}
    return impressao;
  }
}
