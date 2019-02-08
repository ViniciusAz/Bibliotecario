#Bibliotecario

Nome: Vinícius Azevedo dos Santos.

Optei por fazer o exercício da Biblioteca, dentre os dois que foram disponibilizados

Modelei meu problema em :

Livro: contem todas informações básicas que foram disponibilizadas e controle de emprestimos por livro

Autor: Fiz um Objeto Autor, para ter controle de cadastro de autores, também caso queira procurar obras de um determinado autor seria possível.

Autores: coleção de autor

Biblioteca: coleção de livros, contém métodos para cadastrar o empréstimo, devolução e doação de livros, entre outros metodos de busca para fazer o backup dos dados.

DataIO: classe padrão para realizar escrita em arquivo de texto .txt e salvar as informações para uma proxima execução do programa.

Bibliotecario:
- o controlador central de todo o sistema
- faz a interação com o usuário realizando validações e chamada dos outros métodos
- comunica-se diretamente com a classe Biblioteca realizando as operações e dados em memória
- CODIFICA o os dados para adequar ao padrão criado para salvar em arquivo de texto
- recebe a leitura do arquivo de texto de DECODIFICA para inicializar na memória

main: apenas inicializa o programa

dados.txt: arquivo de texto onde será armazenado dos dados durante a execução
	
