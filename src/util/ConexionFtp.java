/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Objects;

/**
 *
 * @author Agarimo
 */
public class ConexionFtp {
    String host;
    int port;
    String user;
    String pass;
    
    
    public ConexionFtp(){
        
    }

    public ConexionFtp(String host, String user, String pass) {
        this.host = host;
        this.port = 21;
        this.user = user;
        this.pass = pass;
    }

    public ConexionFtp(String host, int port, String user, String pass) {
        this.host = host;
        this.port = port;
        this.user = user;
        this.pass = pass;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.host);
        hash = 97 * hash + this.port;
        hash = 97 * hash + Objects.hashCode(this.user);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ConexionFtp other = (ConexionFtp) obj;
        if (!Objects.equals(this.host, other.host)) {
            return false;
        }
        if (this.port != other.port) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        return true;
    }
}
