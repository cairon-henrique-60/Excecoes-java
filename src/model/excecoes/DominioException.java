package model.excecoes;

public class DominioException extends Exception {
	/**
	 * como essa � uma classe serializable e 
	 * por isso deve ter um n�mero de vers�o.
	 */
	private static final long serialVersionUID = 1L;
	 
		public DominioException(String msg) {
			super(msg);
		}
	
	}
