/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 579957
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        if (action != null && action.equals("logout")) {
            request.getSession().removeAttribute("username");
            request.getSession().removeAttribute("itemList");
            request.setAttribute("message", "You have successfully logged out.");
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
        
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if (username != null) {
            request.setAttribute("username", username);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);     
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        
        switch(action) {
            case("register"): {
                String username = request.getParameter("username");
                if (username == null || username.isEmpty()) {
                    request.setAttribute("message", "Invalid Login");
                    getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                }
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                response.sendRedirect("ShoppingList");
                break;
            }

            case("add"): {
                HttpSession session = request.getSession();
                String item = request.getParameter("item");
                ArrayList<String> list = (ArrayList<String>)session.getAttribute("itemList");
                if(list==null) {
                    list = new ArrayList<>();
                }
                list.add(item);
                session.setAttribute("itemList", list);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);            
                break;
            }

            case("delete"): {
                String items = request.getParameter("items");
                if (items != null) {
                    ArrayList<String> list = (ArrayList<String>) request.getSession().getAttribute("itemList");
                    Iterator i = list.iterator();
                    while (i.hasNext()) {
                        String next = (String) i.next();
                        if (next.equals(items)) {
                            i.remove();
                        }
                    }

                    request.getSession().setAttribute("itemList", list);
                    getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                    break;
                }
            }
        }
    }
}
    
    
