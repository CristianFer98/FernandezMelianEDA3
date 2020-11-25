package ar.edu.unlam.pb2.eva03;

public class NoEstaPreparado extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoEstaPreparado (Integer numeroDeSocio) {
		super("El deportista" + numeroDeSocio + " No esta preparado");
	}
}
