package dao;

public interface Conexao {

	public void fecharConexao();

	public void iniciarTransacao();
	public void commit();
	public void rollback();
	public boolean transacaoAtiva();
}
