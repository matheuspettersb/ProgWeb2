package calc;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

class CalculadoraClient {

  public static void main(String args[]) throws Exception {
	//declara um WebService
    URL url = new URL("http://127.0.0.1:9879/calc?wsdl");
    QName qname = new QName("http://calc/","CalculadoraServerImplService");
    Service ws = Service.create(url, qname);
    Calculadora calc = ws.getPort(Calculadora.class);
    
    //declarando o segundo WebService, do segundo endpoint
    URL url1 = new URL("http://127.0.0.1:9879/area?wsdl");
    QName qname1 = new QName("http://calc/","AreaServerImplService"); //continua "calc" pq é o do pacote, n do endpoint
    Service ws1 = Service.create(url1, qname1);
    AreaServer area = ws1.getPort(AreaServer.class);

    System.out.println("Soma (5+1): " + calc.soma(5,1));
    System.out.println("Subtracao (5-1): " + calc.subtracao(5,1));
    System.out.println("Multiplicacao (5*1): " + calc.multiplicacao(5,1));
    System.out.println("Divisao (5/1): " + calc.divisao(5,1));
    System.out.println("Maior (12>9): " + calc.maior(9,12));
    System.out.println("-----------------");
    System.out.println("Area Quadrado (5): "+area.areaQuadrado(5));
    System.out.println("Area Triangulo (3,4; =6): "+area.areaTriangulo(3, 4));
    System.out.println("Area Trapezio(4,3,2; =7): "+area.areaTrapezio(4, 3, 2));

  }
}