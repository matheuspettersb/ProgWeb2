package calc;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "calc.AreaServer")
public class AreaServerImpl implements AreaServer {

  public float areaQuadrado(float b) {
    return b*b;
  }

  //classes extra só pra teste
  public float areaTriangulo(float b, float h) {
	  return (b*h)/2;
  }
  public float areaTrapezio(float B, float b, float h) {
	  return ((B+b)*h)/2;
  }
}