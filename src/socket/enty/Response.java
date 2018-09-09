package socket.enty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Agárimo
 */
public class Response implements Serializable {

    ServerResponse response;
    List parametros;

    public Response(ServerResponse status) {
        this.response = status;
        this.parametros = new ArrayList();
    }

    public Response(ServerResponse status, List parametros) {
        this.response = status;
        this.parametros = parametros;
    }

    public ServerResponse getResponse() {
        return response;
    }

    public void setResponse(ServerResponse response) {
        this.response = response;
    }

    public List getParametros() {
        return parametros;
    }

    public void setParametros(List parametros) {
        this.parametros = parametros;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.response);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Response other = (Response) obj;
        if (this.response != other.response) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Response{" + "response=" + response + ", parametros=" + parametros + '}';
    }
}
