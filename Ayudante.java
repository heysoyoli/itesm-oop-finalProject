public class Ayudante{

	private String historia;
	//private String explicacion;

	public Ayudante(){}


	public String contarHistoria(int posicion){

		switch (posicion){
			case 0:
				historia = "Hola, me llamo Andres soy tu guia espiritual. No me subestimes. Espero poder ayudarte en este camino del aprendizaje. Sin embargo, no puedo pelear tus batallas." + "\n";
				break;
			case 1:
				historia = "Has encontrado esto en tu mochila... La respuesta cuando llegues al lugar en donde todo este despejado\n";
				break;
			case 2:
				historia = "Encontraste una pocion. Esto te ayudara a aguantar las llamas del infierno\n";
				break;
			case 3:
				historia = "Toma esto, te servira mas tarde, guardalo en tu mochila. Solo puedes tener hasta 4 objetos dentro de ella. El arma que has encontrado te ayudara a enfrentarte a los espiritus. danio que puedes hacer con esta arma es de 5 puntos por ataque. No podras usar tu arma mas de dos veces, usala sabiamente. Confia en tu conocimiento. Te enfrentaras a retos que reten tu intelecto.\n";
				break;
			case 15:
				historia = "Has llegado hasta aqui sin problema. Necesitaras mas poder para derrotar a los siguientes enemigos. Acabas de adquirir la habilidad de correccion de errores.\n";	
				break;
			case 23:
				historia = "Este es el lugar del que te hablaba. Habia oido de el solo en leyendas. Veamos que hay dentro.\n";
				break;
			case 24:
				historia = "Parece ser que para derrotarlo tendras que usar la mejor de tus habilidades. Creo en ti.\n";
				break;
			case 25:
				historia = "No fue tan dificil despues de todo. El camino del aprendizaje puede ser duro, pero trae grandes recompensas.\n";
				break;

			default:
				historia = "\n";
				break;
		}

		return historia;

	
	}

	public void explicarContenido(Casilla casilla){
		if(casilla.getTipoContenido() == 1){
			System.out.println("Derrota al enemigo!");
		}else if(casilla.getTipoContenido() == 0){
			System.out.println("Encontraste un nuevo item :)");
		}
	}

}