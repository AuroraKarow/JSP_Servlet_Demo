package dbo;

import java.io.*;
import java.sql.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import entity.person;
import server.*;

@WebServlet("/retrieve")
public class retrieveData extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cond = " where ";
        // select * from dat where name like %name% and gender like %gender% and age
        // like %age%
        if (req.getParameter("name") != "") {
            cond += "name like '%" + req.getParameter("name") + "%' and ";
        }
        if (req.getParameter("gender") != "") {
            cond += "gender = '" + req.getParameter("gender") + "' and ";
        }
        if (req.getParameter("age") != "") {
            cond += "age = '" + req.getParameter("age") + "' and ";
        }
        if (cond != " ")
            cond = cond.substring(0, cond.length() - 4);
        logID log = new logID("127.0.0.1:1433", "work", "sa", "123456");
        try {
            ResultSet rs = sqlserver.go(log, "select * from dat" + cond);
            if(rs.next()){
                req.setAttribute("retr_result", 1);
                List<person> list = new ArrayList<>();
                do{
                    person en = new person();
                    en.setName(rs.getString("name"));
                    en.setAge(rs.getString("age"));
                    en.setGender(rs.getString("gender"));
                    list.add(en);
                }while(rs.next());
                System.out.println("- SOAP Frame -");
                for(var temp : list){
                    System.out.println("[name][" + temp.getName() + ']');
                    System.out.println("[gender][" + temp.getGender() + ']');
                    System.out.println("[age][" + temp.getAge() + ']');
                    System.out.println();
                }
                req.setAttribute("rs_list", list);
            }else req.setAttribute("retr_result", -1);
        } catch (Exception e) {
            req.setAttribute("retr_result", -1);
            e.printStackTrace();
        }req.getRequestDispatcher("/clients.jsp").forward(req, resp);
    }
}