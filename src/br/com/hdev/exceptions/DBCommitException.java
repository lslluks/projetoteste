package br.com.hdev.exceptions;

/**
 * Classe que herda de Exception, respons�vel pelo tratamento de exce��es do Banco de Dados.
 * @author HDEV
 *
 */
public class DBCommitException extends Exception {

	public DBCommitException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DBCommitException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public DBCommitException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DBCommitException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DBCommitException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
