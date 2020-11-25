package ar.edu.unlam.pb2.eva03;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import ar.edu.unlam.pb2.eva03.enumeradores.TipoDeEvento;
import ar.edu.unlam.pb2.eva03.interfaces.ICiclista;
import ar.edu.unlam.pb2.eva03.interfaces.ICorredor;
import ar.edu.unlam.pb2.eva03.interfaces.INadador;

public class Club {

	private String nombre;
	private Set<Deportista> socios;
	private Map<TipoDeEvento, Evento> competencias;

	public Club(String nombre) {
		this.nombre = nombre;
		socios = new TreeSet<Deportista>();
		competencias = new HashMap<TipoDeEvento, Evento>();

	}

	public Boolean agregarDeportista(Deportista deportista) {
		return socios.add(deportista);

	}

	public Integer getCantidadSocios() {

		return socios.size();
	}

	public void crearEvento(TipoDeEvento carreraNatacionEnAguasAbiertas, String descripcion) {
		Evento nuevoEvento = new Evento(carreraNatacionEnAguasAbiertas, descripcion);
		competencias.put(carreraNatacionEnAguasAbiertas, nuevoEvento);

	}

	public Boolean inscribirEnEvento(TipoDeEvento tipoDeEvento, Deportista celeste) throws NoEstaPreparado {
		if (competencias.get(tipoDeEvento).getTipo() == TipoDeEvento.CARRERA_NATACION_EN_PICINA
				|| competencias.get(tipoDeEvento).getTipo() == TipoDeEvento.CARRERA_NATACION_EN_AGUAS_ABIERTAS) {

			if (celeste instanceof INadador == false) { //si no es nadador
				throw new NoEstaPreparado(celeste.getNumeroDeSocio());

			}
		}
		if (competencias.get(tipoDeEvento).getTipo() == TipoDeEvento.CARRERA_10K
				|| competencias.get(tipoDeEvento).getTipo() == TipoDeEvento.CARRERA_21K
				|| competencias.get(tipoDeEvento).getTipo() == TipoDeEvento.CARRERA_42K
				|| competencias.get(tipoDeEvento).getTipo() == TipoDeEvento.CARRERA_5K) {
			if (celeste instanceof ICorredor == false) { // si no es corredor
				throw new NoEstaPreparado(celeste.getNumeroDeSocio());

			}
		}

		if (competencias.get(tipoDeEvento).getTipo() == TipoDeEvento.TRIATLON_IRONMAN
				|| competencias.get(tipoDeEvento).getTipo() == TipoDeEvento.TRIATLON_MEDIO
				|| competencias.get(tipoDeEvento).getTipo() == TipoDeEvento.TRIATLON_OLIMPICO
				|| competencias.get(tipoDeEvento).getTipo() == TipoDeEvento.TRIATLON_SHORT) {
			if (celeste instanceof INadador == false && celeste instanceof ICiclista ==false) {// si no es nadador ni ciclista

				throw new NoEstaPreparado(celeste.getNumeroDeSocio());
			}
		}
		competencias.get(tipoDeEvento).getParticipantes().put(1, celeste);//se agrega a celeste
		return true;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Deportista> getSocios() {
		return socios;
	}

	public void setSocios(Set<Deportista> socios) {
		this.socios = socios;
	}

	public Map<TipoDeEvento, Evento> getCompetencias() {
		return competencias;
	}

	public void setCompetencias(Map<TipoDeEvento, Evento> competencias) {
		this.competencias = competencias;
	}
	
	

}
