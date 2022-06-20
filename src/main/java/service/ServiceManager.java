package service;

public class ServiceManager {
	
	private ServiceComponente sc;
	private ServiceJuego sj;
	
	public ServiceManager() {
		sc = new ServiceComponente();
		sj = new ServiceJuego();
	}

	public ServiceComponente getSc() {
		return sc;
	}

	public ServiceJuego getSj() {
		return sj;
	}

}
