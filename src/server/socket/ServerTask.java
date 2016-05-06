package server.socket;

import java.io.Serializable;

/**
 *
 * @author Agarimo
 */
public enum ServerTask implements Serializable {
    BOE {
        @Override
        public String toString() {
            return "BOE";
        }
    },
    BOE_CLASIFICACION {
        @Override
        public String toString() {
            return "BOE_CLASIFICACION";
        }
    },
    ESTRUCTURAS {
        @Override
        public String toString() {
            return "ESTRUCTURAS";
        }
    },
    ESTRUCTURAS_PENDIENTES {
        @Override
        public String toString() {
            return "ESTRUCTURAS_PENDIENTES";
        }
    },
    FASES {
        @Override
        public String toString() {
            return "FASES";
        }
    };
}
