package server.socket;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Agárimo
 */
public class Request implements Serializable {
    
    
    ServerRequest request;
    List parametros;
    
    public Request(ServerRequest request){
        this.request=request;
        this.parametros=new ArrayList();
    }
    
    public Request(ServerRequest request, List parametros){
        this.request=request;
        this.parametros=parametros;
    }

    public ServerRequest getRequest() {
        return request;
    }

    public void setRequest(ServerRequest request) {
        this.request = request;
    }

    public List getParametros() {
        return parametros;
    }

    public void setParametros(List parametros) {
        this.parametros = parametros;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.request);
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
        final Request other = (Request) obj;
        if (this.request != other.request) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Request{" + "request=" + request + ", parametros=" + parametros + '}';
    }
}
