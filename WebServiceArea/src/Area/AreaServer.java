package Area;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface AreaServer{
	@WebMethod float areaQuadrado(float b);
	@WebMethod float areaTriangulo(float b, float h);
	@WebMethod float areaTrapezio(float B, float b, float h);
}