public class Pregunta
{
	protected String a, b, c;
	protected String pregunta, correcta;
	
	public Pregunta(String pregunta, String a, String b, String c, String correcta)
	{
		this.pregunta = pregunta;
		this.a = a;
		this.b = b;
		this.c = c;
		this.correcta = correcta;

	}
	
	public void setPregunta(String pregunta)
	{
		this.pregunta = pregunta;
	}

	public String getPregunta()
	{
		return pregunta;
	}
	
	public void setA(String a)
	{
		this.a = a;
	}

	public String getA()
	{
		return a;
	}

		public void setB(String b)
	{
		this.b = b;
	}

	public String getB()
	{
		return b;
	}

		public void setC(String c)
	{
		this.c = c;
	}

	public String getC()
	{
		return c;
	}

	public void setCorrecta(String correcta){
		this.correcta = correcta;
	}

	public String getCorrecta(){
		return correcta;
	}

	
}