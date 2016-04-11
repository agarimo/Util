package sql;

import java.sql.*;

/**
 *
 * @author Agarimo
 */
public class Sql {

    private final Connection con;
    private Statement stmt;

    /**
     * Constructor de clase.
     *
     * @param conexion
     * @throws SQLException
     */
    public Sql(Conexion conexion) throws SQLException {
        con = DriverManager.getConnection(conexion.getRuta(), conexion.getUsuario(), conexion.getPass());
    }

    public Connection getCon() {
        return con;
    }

    public Statement getStmt() {
        return stmt;
    }

    /**
     * Método que ejecuta una query pasada como parámetro.
     *
     * @param query Query a ejecutar.
     * @throws SQLException
     */
    public void ejecutar(String query) throws SQLException {
        stmt = con.createStatement();
//        bool = stmt.execute(query);
        stmt.executeUpdate(query);
    }

    /**
     * Método que ejecuta una query pasada como parámetro.
     *
     * @param query Query a ejecutar.
     * @return Devuelve un resultset con el resultado de la query.
     * @throws SQLException
     */
    public ResultSet ejecutarQueryRs(String query) throws SQLException {
        ResultSet result;
        stmt = con.createStatement();
        result = stmt.executeQuery(query);

        return result;
    }

    /**
     * Método que devuelve el id del elemento de búsqueda de la query
     *
     * @param query Query a ejecutar
     * @return Devuelve un int con el valor del id del elemento buscado
     * @throws SQLException
     */
    public int buscar(String query) throws SQLException {
        int id;
        try (ResultSet result = ejecutarQueryRs(query)) {
            if (result.next()) {
                id = result.getInt(1);
            } else {
                id = -1;
            }
        }
        return id;
    }

    public String getString(String query) throws SQLException {
        String str;
        try (ResultSet result = ejecutarQueryRs(query)) {
            if (result.next()) {
                str = result.getString(1);
            } else {
                str = null;
            }
        }
        return str;
    }

    public int getInt(String query) throws SQLException {
        int id;
        try (ResultSet result = ejecutarQueryRs(query)) {
            if (result.next()) {
                id = result.getInt(1);
            } else {
                id = -1;
            }
        }
        return id;
    }

    public double getDouble(String query) throws SQLException {
        double id;
        try (ResultSet result = ejecutarQueryRs(query)) {
            if (result.next()) {
                id = result.getDouble(1);
            } else {
                id = -1;
            }
        }
        return id;
    }

    /**
     * Método que devuelve el id del último registro añadido a la BBDD
     *
     * @return Devuelve un int con el valor del id del último registro añadido
     * @throws SQLException
     */
    public int ultimoRegistro() throws SQLException {
        int a = -1;
        String query = "SELECT last_insert_id()";

        ResultSet result = ejecutarQueryRs(query);
        if (result.next()) {
            a = result.getInt(1);
        } else {
            System.out.println("exception");
        }

        return a;
    }

    /**
     * Mëtodo que cierra la conexión con la BBDD
     *
     * @throws SQLException
     */
    public void close() throws SQLException {
        if (stmt != null) {
            stmt.close();
        }
        con.close();
    }
}
