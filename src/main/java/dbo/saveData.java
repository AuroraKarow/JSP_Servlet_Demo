package dbo;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import entity.person;
import server.*;

@WebServlet("/save")
public class saveData extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        person en = new person();
        logID log = new logID("127.0.0.1:1433", "work", "sa", "123456");
        en.setName(req.getParameter("name"));
        en.setGender(req.getParameter("gender"));
        en.setAge(req.getParameter("age"));
        if (en.getAge() == "" || en.getGender() == "" || en.getName() == "") req.setAttribute("save_result", -1);
        else {
            try {
                sqlserver.go(log, 
                    "insert into dat" +
                    "(name, gender, age)values" +
                    "('" + en.getName() + "', '" + en.getGender() + "', '" + en.getAge() + "')" 
                ); req.setAttribute("save_result", 1);
            } catch (Exception e) {
                req.setAttribute("save_result", -1);
                e.printStackTrace();
            }
        } req.getRequestDispatcher("/service.jsp").forward(req, resp);
    }
}