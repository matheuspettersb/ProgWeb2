package Area;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

public class AreaClient {
	  public static void main(String args[]) throws Exception {
		    URL url = new URL("http://127.0.0.1:9878/area?wsdl");
		    QName qname = new QName("http://area/","AreaServerImplService");
		    Service ws = Service.create(url, qname);
		    AreaServer a = ws.getPort(AreaServer.class);

		    System.out.println("Quadrado (5; 25): " + a.areaQuadrado(5));
		    System.out.println("Triangulo (b=3, h=4; 12): " + a.areaTriangulo(3,4));
		    System.out.println("Trapezio (B=4, b=3, h=2): " + a.areaTrapezio(4,3,2));
		  }
}
