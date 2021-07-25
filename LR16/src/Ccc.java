import jspclass.CBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Ccc extends HttpServlet implements Servlet {

    CBean Cb;
    public void init() throws ServletException {
        super.init();
        Cb = new CBean(null, null, null);
        ServletContext sc1 = getServletContext();
        sc1.setAttribute("atrABean", Cb);
    }

    protected void service(HttpServletRequest rq, HttpServletResponse rs)
            throws ServletException, IOException {
        if(rq.getMethod().equals("GET") || rq.getMethod().equals("POST"))
        {
            if(rq.getParameter("CBean").equals("new")) {

                Cb = new CBean(rq.getParameter("Value1"), rq.getParameter("Value2"), rq.getParameter("Value3"));
                //  а ссылку на объект записывает в атрибут контекста с именем  atrCBean
                ServletContext sc = getServletContext();
                sc.setAttribute("atrABean", Cb);

                //Сервлет Ccc  переопределяет запрос на jsp-страницу с именем Ccc.jsp.
                RequestDispatcher rd = rq.getRequestDispatcher("Ccc.jsp");
                rd.forward(rq, rs);
            } else {//ТУТ OLD
                if(rq.getMethod().equals("GET")){//если get запрос
                    RequestDispatcher rd = rq.getRequestDispatcher("Ccc.jsp");
                    rd.forward(rq, rs);
                } else {//если post запрос
                    ServletContext sc = getServletContext();//атрибут контекста
                    Cb = (CBean)sc.getAttribute("atrABean");//берем атрибут
                    String val;
                    if( !(val = rq.getParameter("Value1")).equals(""))//если не пусто
                        Cb.SetValue1(val);//устанавливаем значение
                    if( !(val = rq.getParameter("Value2")).equals(""))//если не пусто
                        Cb.SetValue2(val);//устанавливаем значение
                    if( !(val = rq.getParameter("Value3")).equals(""))//если не пусто
                        Cb.SetValue3(val);//устанавливаем значение

                    RequestDispatcher rd = rq.getRequestDispatcher("Ccc.jsp");
                    rd.forward(rq, rs);
                }
            }
        }
    }
}