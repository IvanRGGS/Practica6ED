package calcualdora;

import java.util.Scanner;

public class CerebroCalculadoraED {

	//Creamos los atributos y el escaner
	private double resultado, numero1, numero2;
	private String[] historial;
	Scanner tecladoCce = new Scanner(System.in);

	//Iniciamos el array y el resultado
	CerebroCalculadoraED() {
		historial = new String[5];
		resultado = 0;
	}

	//Metodo para que la calculadora realice la operación dependiendo del número introducido
	public void procesarOperacion(String op) {
		Operaciones operacion;
		System.out.println("proceso " + op);
		switch (op) {
		case "1":
			pedirDosNumeros();
			operacion = Operaciones.SUMAR;
			operarSuma(operacion);
			break;
		case "2":
			pedirDosNumeros();
			operacion = Operaciones.RESTAR;
			operarResta(operacion);
			break;
		case "3":
			pedirDosNumeros();
			operacion = Operaciones.MULTIPLICAR;
			operarMultiplica(operacion);
			break;
		case "4":
			pedirDosNumeros();
			operacion = Operaciones.DIVIDIR;
			operarDivide(operacion);
			break;
		case "5":
			pedirUnNumero();
			operacion = Operaciones.SUMAR_RES;
			operarSumaRes(operacion);
			break;
		case "6":
			pedirUnNumero();
			operacion = Operaciones.RESTAR_RES;
			operarRestaRes(operacion);
			break;
		case "7":
			pedirUnNumero();
			operacion = Operaciones.MULTIPLICAR_RES;
			operarMultiplicaRes(operacion);
			break;
		case "8":
			pedirUnNumero();
			operacion = Operaciones.DIVIDIR_RES;
			operarDivideRes(operacion);
			break;
		case "9":
			operacion = Operaciones.RESULTADO;
			mostrarResultadoActual(operacion);
			break;
		case "10":
			operacion = Operaciones.RANDOM;
			numeroAleatorio(operacion);
			break;
		case "11":
			operacion = Operaciones.HISTORIAL;
			operarHistorial(operacion);
			break;
		
		}
	}

	//Metodo de suma
	private void operarSuma(Operaciones op) {
		infoOperacion(op);
		this.resultado = this.numero1 + this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
	
	//Metodo de resta
	private void operarResta(Operaciones op) {
		infoOperacion(op);
		this.resultado = this.numero1 - this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
	
	//Metodo de multiplicación
	private void operarMultiplica(Operaciones op) {
		infoOperacion(op);
		this.resultado = this.numero1 * this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
	
	//Metodo de división
	private void operarDivide(Operaciones op) {
		infoOperacion(op);
		this.resultado = this.numero1 / this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
	
	//Metodo para sumar al resultado
	private void operarSumaRes(Operaciones op) {
		infoOperacion(op);
		this.resultado = this.resultado + this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
	
	//Metodo para restar al resultado
	private void operarRestaRes(Operaciones op) {
		infoOperacion(op);
		this.resultado = this.resultado - this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
	
	//Metodo para multiplicar al resultado
	private void operarMultiplicaRes(Operaciones op) {
		infoOperacion(op);
		this.resultado = this.resultado * this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
	
	//Metodo para dividir al resultado
	private void operarDivideRes(Operaciones op) {
		infoOperacion(op);
		this.resultado = this.resultado / this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
	
	//Metodo para restar al resultado actual
	private void mostrarResultadoActual(Operaciones op) {
		infoOperacion(op);
		System.out.println("El valor actual del resultado es: " + this.resultado + "\n");
	}
	
	//Metodo para generar un número aleatorio
	private void numeroAleatorio(Operaciones op) {
		infoOperacion(op);
		this.resultado = (double)(Math.random()*100+1);
		System.out.println("El número aleatorio generado es: " + this.resultado + "\n");
		anadirHistorialAleatorio(op);
	}
	
	//Metodo que muestra las cinco últimas operaciones realizadas
	private void operarHistorial(Operaciones op) {
		System.out.println("*** Historial de las cinco últimas operaciones ***");
		for (String hist : historial) {
			System.out.println(hist);
		}
		System.out.println("\n");
	}
	
	//Metodo que muestra la información de la operación
	private void infoOperacion(Operaciones op) {
		System.out.println("//////////////////////////////");
		System.out.println("-> " + op.getNombre() + " - " + op.getInfo());
	}
	
	//Metodo para pedir un número en las operaciones para operar al resultado
	private void pedirUnNumero() {
		System.out.println("Introduce el número: ");
		this.numero1 = this.resultado;
		this.numero2 = tecladoCce.nextDouble();
	}
	
	//Metodo para pedir dos numeros para las operaciones normales
	private void pedirDosNumeros() {
		System.out.println("Introduce el primer número: ");
		this.numero1 = tecladoCce.nextDouble();
		System.out.println("Introduce el segundo número: ");
		this.numero2 = tecladoCce.nextDouble();
	}
	
	//Metodo que se encarga de mostrar el resultado actual por pantalla
	private void mostrarResultado(Operaciones op) {
		System.out.println("El resultado de la operación " + op.getNombre().toLowerCase() + " es:");
		System.out.println(Double.toString(numero1) + " " + op.getSimbolo() + " " + Double.toString(numero2) + " = "
		+ Double.toString(resultado) + "\n");
	}
	
	//Metodo que se encarga de meter cada operación realizada al historial
	private void anadirHistorial(Operaciones op) {
		String nuevaOperacion = op.getNombre() + " -> " + Double.toString(numero1) + " " + op.getSimbolo() + " " + Double.toString(numero2) + " = "
				+ Double.toString(resultado);
		this.historial[4] = this.historial[3];
		this.historial[3] = this.historial[2];
		this.historial[2] = this.historial[1];
		this.historial[1] = this.historial[0];
		this.historial[0] = nuevaOperacion;
	}
	
	//Metodo que muestra una operación aleatoria del historial
	public void anadirHistorialAleatorio(Operaciones op) {
		String nuevaOperacion = op.getNombre() + " -> " + Double.toString(resultado);
		this.historial[4] = this.historial[3];
		this.historial[3] = this.historial[2];
		this.historial[2] = this.historial[1];
		this.historial[1] = this.historial[0];
		this.historial[0] = nuevaOperacion;
	}


}
