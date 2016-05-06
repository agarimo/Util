package server.socket;

import java.io.Serializable;

/**
 *
 * @author Agarimo
 */
public enum ServerResponse implements Serializable {
    CONECTED {
        @Override
        public String toString() {
            return "CONECTED";
        }
    },
    DISCONECTED {
        @Override
        public String toString() {
            return "DISCONECTED";
        }
    },
    STATUS {
        @Override
        public String toString() {
            return "STATUS";
        }
    },
    OK {
        @Override
        public String toString() {
            return "OK";
        }
    },
    ERROR {
        @Override
        public String toString() {
            return "ERROR";
        }
    };
}
