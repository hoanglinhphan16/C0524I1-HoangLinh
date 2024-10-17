package com.example.demo4;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "TranslateServlet", value = "/translate")
public class HelloServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html");
//
//        // Hello
//        PrintWriter out = response.getWriter();
//        Date date = new Date();
//        out.println("<html><body>");
//        out.println("<h1>" + date + "</h1>");
//        out.println("</body></html>");
    }

    public void destroy() {
    }
    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//
//        PrintWriter writer = respone.getWriter();
//        writer.println("<html>");
//        if ("hoanglinh".equals(username) && "culinhxd123".equals(password)) {
//            writer.println("<h1>Welcome " + username + "</h1>");
//        } else {
//            writer.println("<h1>Login error</h1>");
//        }
//        writer.println("</html>");
        Map<String, String> dictionary = new HashMap<String, String>();
        dictionary.put("hello", "xin chao");
        dictionary.put("book", "quyen sach");
        dictionary.put("world","the gioi");
        dictionary.put("computer", "may tinh");

        String search = request.getParameter("txtSearch");
        String result = dictionary.get(search);

        if (result != null) {
            request.setAttribute("result", result);

        } else {
            result = "Cant find";
            request.setAttribute("result", result);
        }
        request.getRequestDispatcher("dictionary.jsp").forward(request, response);
    }
}