# myHotWheels-JDBC
Projeto pessoal para guardar meus carrinhos e minhas coleções da HOTWHEELS usando JDBC (com padrão DAO com FactoryDAO) e mySQL como DB

A classe Carrinho possui a modelagem da entidade que irá representar os carrinhos HW e a classe Colecao possui a modelagem da entidade irá representar as coleções HW.

A interface CarrinhoDAO possui os seguintes métodos:

  void insert(Carrinho obj); -> Insere um carrinho

	void update(Carrinho obj); -> Altera um carrinho

	void deleteById(Integer id); -> Deleta um carrinho pelo ID

	Carrinho findById(Integer id); -> Busca e mostra um carrinho pelo ID

	List<Carrinho> findAll(); -> Busca e mostra todos os carrinhos do banco de dados

	List<Carrinho> showCarsByIdCollection(Integer id); -> Busca e mostra todos os carrinhos de uma determinada Coleção HotWheels (pelo ID)
  
  
A interface ColecaoDAO possui os seguintes métodos:

	void insert(Colecao obj); -> Insere uma coleção HW

	void update(Colecao obj); -> Altera uma coleção HW

	void deleteById(Integer id); -> Deleta uma coleção HW pelo ID

	Colecao findById(Integer id); -> Busca e mostra uma coleção HW pelo ID
	
	List<Colecao> findAll(); -> Busca e mostra todas as coleções HW do banco de dados
  
As classes CarrinhoDAOJDBC e ColecaoDAOJDBC possuem as implementações dos métodos. Tambem há um programa principal (Program.java) que mostra o funcionamento dos mesmos.

A classe DB.java que peguei do professor Nélio Alves do curso de Java 2020 na Udemy fornece uma conexão com um banco de dados. Ele carrega as configurações de conexão a partir do arquivo "db.properties" (usando o DriverManager do mySQL que baixei e integrei ao projeto). A função getConnection() retorna a conexão existente ou cria uma nova se ainda não existir. A função closeConnection() fecha a conexão. As funções closeStatement() e closeResultSet() servem para fechar os objetos Statement e ResultSet. A classe tambem vai lidar com as exceptions lançadas, jogando uma exception da classe DBException se algo der errado.
 
