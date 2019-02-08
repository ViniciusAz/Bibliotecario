// Autor: Vinicius Azevedo dos Santos
// Data: 31/08/2018
// Realiza a leitura e escrita em arquivo de texto, adaptado para este projeto

import java.io.*;

public class DataIO {

  FileReader fr;
  FileWriter fw;

  public DataIO() {
  }

  //Recebe nome do arquivo como parametro e retorna uma string com conteudo
  public String read(String file) throws Exception {
    fr = new FileReader(new File(file));
    String texto = "";
    int i = fr.read();
    while(i != -1)
    {
      texto += (char)i;
      i = fr.read();
    }
    fr.close();
    //System.out.println("Arquivo de Entrada : " + file);
    return texto;
  }

  //Recebe um Texto como parametro e cria um arquivo com o texto como conteudo
  public void write(String file, String texto) throws Exception {

    File f = new File(file);
    fw = new FileWriter(f);

    // escreve em arquivo
    fw.write(texto);
    fw.close();
  }

}
