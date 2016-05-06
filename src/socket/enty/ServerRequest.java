package socket.enty;

import java.io.Serializable;

/**
 *
 * @author Agarimo
 */
public enum ServerRequest implements Serializable {
    CONNECT {
        @Override
        public String toString() {
            return "CONNECT";
        }
    },
    DISCONECT {
        @Override
        public String toString() {
            return "DISCONECT";
        }
    },
    STATUS {
        @Override
        public String toString() {
            return "STATUS";
        }
    },
    RUN_TASK {
        @Override
        public String toString() {
            return "RUN_TASK";
        }
    };
}
