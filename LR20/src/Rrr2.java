import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import oracle.jdbc.pool.OracleDataSource;

public class Rrr2 extends HttpServlet implements Servlet {


    static String SqlPersonNumber = "{?=call get_price(?)}";

    protected void doGet(HttpServletRequest rq,
                          HttpServletResponse rs)
            throws ServletException, IOException {
        //rs.setCharacterEncoding("CP1251");
        PrintWriter pw = rs.getWriter();
        try {
            OracleDataSource ods = new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@172.20.10.4:1521:orcl");
            ods.setUser("system");
            ods.setPassword("Password123");
            Connection conn = ods.getConnection();

            CallableStatement stm = conn.prepareCall(SqlPersonNumber);
            stm.registerOutParameter(1, Types.INTEGER);
            stm.setString(2, "AI-92");
            stm.execute();
            Integer rc = stm.getInt(1);
            pw.println("price of selected fuel :"+rc+"$");

            conn.close();
        }catch (SQLException e) {
            System.out.println("Rrr:doGet:SQLException:" + e);
        }
    }

}