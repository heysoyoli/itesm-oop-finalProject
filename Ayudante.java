public class Ayudante{

	private String historia;
	//private String explicacion;


	public String contarHistoria(Humano humano){
		int pos = humano.getPos();

		switch (pos){
			case 0:
				historia = "Hola, me llamo Andres soy tu guia espiritual. No me subestimes. Espero poder ayudarte en este camino del aprendizaje. Sin embargo, no puedo pelear tus batallas.";
				break;
			case 1:
				historia = "Has encontrado esto en tu mochila... La respuesta cuando llegues al lugar en donde todo este despejado";
				break;
			case 2:
				historia = "Encontraste una pocion. Esto te ayudara a aguantar las llamas del infierno";
				break;
			case 3:
				historia = "Toma esto, te servira mas tarde, guardalo en tu mochila. Solo puedes tener hasta 4 objetos dentro de ella. El arma que has encontrado te ayudara a enfrentarte a los espiritus. danio que puedes hacer con esta arma es de 5 puntos por ataque. No podras usar tu arma mas de dos veces, usala sabiamente. Confia en tu conocimiento. Te enfrentaras a retos que reten tu intelecto.";

				break;
			case 15:
				historia = "Has llegado hasta aqui sin problema. Necesitaras mas poder para derrotar a los siguientes enemigos. Acabas de adquirir la habilidad de correccion de errores.";	
				break;
			case 23:
				historia = "Este es el lugar del que te hablaba. Habia oido de el solo en leyendas. Veamos que hay dentro.";
				break;
			case 24:
				historia = "Parece ser que para derrotarlo tendras que usar la mejor de tus habilidades. Creo en ti.";
				break;
			case 25:
				historia = "No fue tan dificil despues de todo. El camino del aprendizaje puede ser duro, pero trae grandes recompensas.";
				break;

			default:
				historia = "No hay nada aqui";
				break;
		}

		System.out.println( pos + " " + historia );
		return historia;
	}

}