// Autor: Vinicius Azevedo dos Santos
// Data: 07/02/2019
// Colecao de autores

import java.util.List;
import java.util.ArrayList;

public class Autores {

  private List<Autor> autores;
  private int id;

  public Autores() {
    autores = new ArrayList<Autor>();
    id = 0;
  }

  // comando add privado, quero primeiro usar get, se nao encontrar, add novo
  private void add(String nome) {
    autores.add(new Autor(++id, nome));
  }

  // comando get recebe o nome ou trecho do nome do autor, varre a lista de autores,
  // se encontrar um correspondente retorna, caso contrario add novo e retorna
  public Autor get(String nome) {
    for (Autor a : autores) {
      if(a.getNome().contains(nome)) {
        return a;
      }
    }
    add(nome);
    return autores.get(autores.size()-1);
  }

  public String toString() {
    String impressao;
    if (id == 0) {
      impressao = "> Nenhum autor cadastrado.";
    } else {
      impressao = "> Autores : \n";
      for (int i = 0; i < autores.size(); i++) {
        impressao += autores.get(i) + "\n";
      }
    }
    return impressao;
  }
}
