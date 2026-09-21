package Servlet;

import Dao.UserDao;
import Entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/users/*")
public class UserServlet extends HttpServlet {

    private UserDao userDAO;

    @Override
    public void init() {
        userDAO = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getPathInfo();
        if (action == null || action.equals("/")) {
            action = "/list";
        }

        switch (action) {
            case "/new":
                showNewForm(request, response);
                break;
            case "/insert":
                insertUser(request, response);
                break;
            case "/delete":
                deleteUser(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/update":
                updateUser(request, response);
                break;
            case "/list":
            default:
                listUsers(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    //---------- 1. Render blank form for inserting a new user
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/user-form.jsp").forward(request, response);
    }

    //------------ 2. Insert user into DB
    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User newUser = new User(null,name, email, password);
        userDAO.saveUser(newUser);

        response.sendRedirect(request.getContextPath() + "/users/list");
    }

    //-------------------- 3. Render edit form populated with existing user data
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        User existingUser = userDAO.getUserById(id);

        request.setAttribute("user", existingUser);
        request.getRequestDispatcher("/user-form.jsp").forward(request, response);
    }

    //----------------------- 4. Update user details in DB
    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User(id, name, email, password);
        userDAO.updateUser(user);

        response.sendRedirect(request.getContextPath() + "/users/list");
    }

    //--------------------------- 5. Delete user from DB
    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        userDAO.deleteUser(id);

        response.sendRedirect(request.getContextPath() + "/users/list");
    }

    //---------------------------- 6. Fetch all users and forward to list view
    private void listUsers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Debug print statement to verify list size in console
        List<User> listUser = null;
        System.out.println("DEBUG: Retrieved users count = " + (listUser != null ? listUser.size() : 0));

        listUser = userDAO.getAllUsers();
        request.setAttribute("listUser", listUser);
        request.getRequestDispatcher("/user-list.jsp").forward(request, response);
    }
}
