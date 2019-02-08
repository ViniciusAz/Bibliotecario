// Autor: Vinicius Azevedo dos Santos
// Data: 08/02/2019
// Sistema controlador da biblioteca codifica e decodifica para salvar em arquivos
// realiza cadastros, retiradas e devolucoes de livros, faz a impressao das telas
// e menus no console;terminal, opera interagindo com o usuario

import java.util.Scanner;

public class Bibliotecario {

  // sistema de salvamento de arquivos
  private DataIO database;
  private String arquivo = "dados.txt";
  private Biblioteca bib;
  private Scanner input;

  public Bibliotecario() {
    bib = new Biblioteca();
    database = new DataIO();
    input = new Scanner(System.in);
  }

  public void executa() throws Exception {
    // comeca carregando as informacoes salvas
    carregar();

    // entra no looping de execucao
    while(true) {
      sistema();
    }
  }

  // exibe as opcoes e salva novas informacoes ao database
  private void sistema() throws Exception {
    String safe = "";
    char op = '0';
    int numero = 0;
    boolean check = false;
    String ano = "", autor = "";
    //Tela 1
    do {
      limpaConsole();
      System.out.println("Digite a opção correspondente: ");
      System.out.println("> [1] Retirar um livro");
      System.out.println("> [2] Devolver um livro");
      System.out.println("> [3] Doar um livro");
      System.out.println("> [9] Encerrar");
      System.out.print("Opção: "); safe = input.nextLine();
      if(safe.length() > 0) op = safe.charAt(0);

    } while(op != '1' && op != '2' && op != '3' && op != '9');

    switch(op) {
      case '1':
        // exibe os livros disponiveis
        System.out.println("\nOpção 1 : Retirar um livro");
        System.out.println("\nLivros disponíveis:");

        if(bib.existeLivroDisponivel()) {
          System.out.print(bib.disponiveis());
          System.out.println("Para voltar sem retirar digite [99999]");
          // check flag para saber se digitou numero de livro valido ou 99999
          check = false;
          // aguarda o usuario digitar uma opcao numerica
          do{
            System.out.print("Número do livro: "); safe = input.nextLine();
            // verificar se e numero
            if(safe.matches("[0-9]+")) {
              numero = Integer.parseInt(safe);
              // verifica cancelamento
              if(numero == 99999) {
                check = true;
              // verifica se e um livro valido e exibe as informacoes para o usuario
              } else {
                check = bib.check(numero);
                if(check) {
                  String[] info = bib.getInfo(numero);
                  System.out.println("\n - Livro selecionado:");
                  System.out.println("   - Número: " + String.format("%05d", numero));
                  System.out.println("   - Título: " + info[0]);
                  System.out.println("   - Autor: " + info[1]);
                  System.out.println("   - Ano: " + info[2]);
                  System.out.println("   - Status: " + info[3]);
                  System.out.print("   - Emprestado para: "); safe = input.nextLine();

                  System.out.println("\nPressione ENTER para continuar.");
                  input.nextLine();
                  bib.retirar(numero, safe);

                  System.out.println("\n>>>>>> Retirada bem sucedida!!!\n");
                  System.out.println("   - Número: " + String.format("%05d", numero));
                  System.out.println("   - Título: " + info[0]);
                  System.out.println("   - Autor: " + info[1]);
                  System.out.println("   - Ano: " + info[2]);
                  System.out.println("   - Status: Indisponível");
                  System.out.println("   - Emprestado para: " + safe);

                // se nao for um numero valido, informa que o livro nao existe
                // usuario pode digitar novo numero
                } else {
                  System.out.println("\nNumero de livro Indisponível.");
                }
              }
            }
          } while(!check);
        } else System.out.println("\n>>>>>> Não há livros disponíveis no momento.");
        break;

      case '2':
        System.out.println("\nOpção 2 : Devolver um livro");
        System.out.println("\nLivros para devolução:");
        if(bib.existeLivroEmprestado()) {
          System.out.println(bib.emprestados());
          System.out.println("Para voltar sem retirar digite [99999]");
          // check flag para saber se digitou numero de livro valido ou 99999
          check = false;
          // aguarda o usuario digitar uma opcao numerica
          do{
            System.out.print("Número do livro: "); safe = input.nextLine();
            // verificar se e numero
            if(safe.matches("[0-9]+")) {
              numero = Integer.parseInt(safe);
              // verifica cancelamento
              if(numero == 99999) {
                check = true;
              // verifica se e um livro valido e exibe as informacoes para o usuario
              } else {
                check = bib.checkIndisponivel(numero);
                if(check) {
                  String[] info = bib.getInfo(numero);
                  System.out.println("\n - Livro selecionado:");
                  System.out.println("   - Número: " + String.format("%05d", numero));
                  System.out.println("   - Título: " + info[0]);
                  System.out.println("   - Autor: " + info[1]);
                  System.out.println("   - Ano: " + info[2]);
                  System.out.println("   - Status: " + info[3]);
                  System.out.println("   - Emprestado para: " + info[4]);

                  System.out.println("\nPressione ENTER para continuar.");
                  input.nextLine();
                  bib.devolver(numero);

                  System.out.println("\n>>>>>> Devolução bem sucedida!!!\n");
                  System.out.println("   - Número: " + String.format("%05d", numero));
                  System.out.println("   - Título: " + info[0]);
                  System.out.println("   - Autor: " + info[1]);
                  System.out.println("   - Ano: " + info[2]);
                  System.out.println("   - Status: Disponível");
                  System.out.println("   - Emprestado para: ");

                // se nao for um numero valido, informa que o livro nao existe
                // usuario pode digitar novo numero
                } else {
                  System.out.println("\nNumero de livro Indisponível.");
                }
              }
            }
          } while(!check);
        } else System.out.println("\n>>>>>> Não há livros emprestados atualmente.");
        break;

      case '3':
        System.out.println("\nOpção 3 : Doar um livro");
        System.out.print("Título: "); safe = input.nextLine();
        System.out.print("Autor: "); autor = input.nextLine();
        System.out.print("Ano: "); ano = input.nextLine();
        if(ano.matches("[0-9]+")) numero = Integer.parseInt(ano);

        System.out.println("\nPressione ENTER para continuar.");
        input.nextLine();
        bib.add(safe, autor, numero);
        numero = bib.size(); // pega o numero do ultimo cadastrado para pegar infos
        String[] info = bib.getInfo(numero);

        System.out.println("\n>>>>>> Doação bem sucedida!!!\n");
        System.out.println("   - Número: " + String.format("%05d", numero));
        System.out.println("   - Título: " + info[0]);
        System.out.println("   - Autor: " + info[1]);
        System.out.println("   - Ano: " + info[2]);
        System.out.println("   - Status: " + info[3]);
        System.out.println("   - Emprestado para: " + info[4]);
        break;
      case '9':
        System.exit(0);
    }

    salvar();
    System.out.println("\nPressione ENTER para continuar.");
    input.nextLine();
  }

  // carrega informacoes
  private void carregar() throws Exception {
    // pega os dados do arquivo, se nao encontrou, entao vai fazer a inicializacao padrao
    String dados = database.read(arquivo);
    String xTit = "", xAut = "", xAno = "", xStat = "", xNome = "";
    int xxAno = 0, xAux = 0;

    if(dados.length() == 0) {
      bib.add("Como fazer sentido e bater o martelo", "Alexandro Aolchique", 2017);
      bib.add("Código Limpo", "Tio Bob", 2001);
      bib.add("Basquete 101", "Hortência Marcari", 2010);

    } else /* carregou informacoes do arquivo, vai tratar */ {
      // padrao do arquivo que eu criei ^^xTit^^xAut^^xAno^^xTit^^xAut^^xAno^^Status^^Nome...
      // xAux para controlar qual info esta lendo 1 = titulo, 2 = autor, 3 = ano, 4 = status, 5 = nome
      for (int i = 0; i < dados.length(); i++) {
        // se xAux 6, entao ja leu 5 informacoes, logo cadastra e volta xAux 1
        if(xAux == 6 || i == dados.length()-2) {
          // converte ano pra int
          xxAno = Integer.parseInt(xAno);
          // cadastra livro
          bib.add(xTit, xAut, xxAno);
          // cadastra retirada (caso exista) 0 retirado,  1 disponivel
          if(xStat.equals("0")) bib.retirar(bib.size(), xNome);
          xAux = 1;
          xTit = xAut = xAno = xStat = xNome = "";
        }
        // se encontou um ^ entao incrementa o xAux e pula 1 iteracao do laco
        if(dados.charAt(i) == '^') {
          i++;
          xAux++;
        } else /* aqui estamos coletando a informacao do texto */ {
          if(xAux == 1) xTit += dados.charAt(i);
          else if(xAux == 2) xAut += dados.charAt(i);
          else if(xAux == 3) xAno += dados.charAt(i);
          else if(xAux == 4) xStat += dados.charAt(i);
          else /*xAux == 5*/ xNome += dados.charAt(i);
        } //else
      } //for
    } //else
  }

  // transforma o sistema em um padrao para ser salvo em arquivo
  private void salvar() throws Exception {
    String saida = "";
    String[][] bibMatrix = bib.backup();

    for (int i = 0; i < bib.size(); i++) {
      for (int j = 0; j < 5; j++) {
        saida += "^^" + bibMatrix[i][j];
      }
    }

    database.write(arquivo, saida);

  }

  private void limpaConsole() {
    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
    "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
    "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
  }
}
