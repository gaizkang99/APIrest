package exception;

import java.util.Arrays;
import java.util.List;

public class LogicExceptions {

	public static final int ID_INEXISTENTE = 0;
	public static final int FALTA_DE_BODY = 1;
	public static final int CAMPOS_VACIOS = 2;
	
	private int value;
	
	public LogicExceptions (int value) {
		this.value = value;
	}
	
	private List<String> message = Arrays.asList(
			"<< El id es inexistente en base de datos >>",
			"<< Falta algún campo en el json que llega en el body >>",
			"<< Campos informados pero vacíos >>"
			);
	
	
	public String getMessage() {
		return message.get(value);
	}
	
}
