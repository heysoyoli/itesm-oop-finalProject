public class PoolPreguntas
{
	private Pregunta[] preguntas;

	public PoolPreguntas(){
		this.preguntas = new Pregunta[12];
		//this.humano = humano;
	}

	public Pregunta[] getPreguntas(){
		return preguntas;
	}

	/*public void setHumano(Humano humano){
		this.humano = humano;
	}

	public Humano getHumano(){
		return humano;
	}*/

	public void crearPreguntas(){

		preguntas[0] = new Pregunta("¿Que es una clase?", "A) Una clase es una plantilla o molde.", "B) Tareas que realizan los objetos.", "C) Una instancia.", "a" );
		preguntas[1] = new Pregunta("¿Que es un metodo?", "A) Una clase es una plantilla o molde.", "B) Tareas que realizan los objetos.", "C) Una instancia.", "b" );
		preguntas[2] = new Pregunta(" Que es un objeto?", "A) Una clase es una plantilla o molde.", "B) Tareas que realizan los objetos.", "C) Una instancia de una clase.", "c" );

		preguntas[3] = new Pregunta("¿Que son los getters y setters?", "A) Una clase es una plantilla o molde.", "B) Metodos de acceso a variables privadas", "C) Variables publicas", "b" );
		preguntas[4] = new Pregunta("¿Que es el argumento de un mensaje?", "A) Metodo de acceso a variables privadas.", "B) Tareas que realizan los objetos.", "C) Un valor que le pasamos a un objeto.", "c");
		preguntas[5] = new Pregunta("¿Qué se busca identificar con el método gramatical?", "A) Varibles y Metodos", "B) Tareas que realizan los objetos.", "C) Posibles Objetos y Metodos", "c" );

		preguntas[6] = new Pregunta("¿Que constituyen los nombres en el metodo gramatical?", "A) Objetos", "B) Metodos.", "C) Variables", "a" );
		preguntas[7] = new Pregunta("¿Que constituyen los verbos en el metodo gramatical??", "A) Metodos", "B) Objetos.", "C) Variables", "a" );
		preguntas[8] = new Pregunta("¿Cuáles son los dos tipos de relación que hay entre las clases de un programa?", "A) Publica y Privada", "B) Agregacion y Composicion", "C) Metodo y Objeto", "b" );

		preguntas[9] = new Pregunta("Es un tipo de modificador de acceso", "A) Metodo", "B) Abstract", "C) Public.", "c" );
		preguntas[10] = new Pregunta("Es un tipo de modificador de acceso", "A) Private", "B) Class", "C) Void", "a" );
		preguntas[11] = new Pregunta("Es un tipo de modificador de acceso", "A) Projected", "B) Protected", "C) Ejected", "b" );

}
}