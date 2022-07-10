package model.excecoes;

public class DominioException extends Exception {
	/**
	 * como essa é uma classe serializable e 
	 * por isso deve ter um número de versão.
	 */
	private static final long serialVersionUID = 1L;
	 
		public DominioException(String msg) {
			super(msg);
		}
	
	}
