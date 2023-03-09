package controller;

import dao.StudentDAO;
import model.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/Students")


public class StudentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private StudentDAO studentDAO;

    public void init(){studentDAO = new StudentDAO();}
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ( action == null){
            action ="";
        }
        switch (action){
            case "create":
                showCreateForm(request,response);
                break;
            case "delete":
                showDeleteForm(request,response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
            case "viewid":
                showStudentByID(request,response);
                break;
            case "viewname":
                showStudentByName(request,response);
                break;
            default:
                listStudent(request,response);
                break;
        }

    }

    private void showStudentByName(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("viewname");
        List<Student> students = studentDAO.selectStudentByName(name);
        request.setAttribute("students", students);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/listStudent.jsp");
        try {
            dispatcher.forward(request,response);
        }catch (IOException | ServletException e){
            e.printStackTrace();
        }
    }

    private void showStudentByID(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("viewid"));
        Student student = studentDAO.selectStudentId(id);
        List<Student> students = new ArrayList<>();
        students.add(student);
        request.setAttribute("students", students);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/listStudent.jsp");
        try {
            dispatcher.forward(request,response);
        }catch (IOException | ServletException e){
            e.printStackTrace();
        }

    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentDAO.selectStudentId(id);
        request.setAttribute("student", student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/edit.jsp");
        try {
            dispatcher.forward(request,response);
        }catch (IOException | ServletException e){
            e.printStackTrace();
        }

    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentDAO.selectStudentId(id);
        request.setAttribute("student", student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/delete.jsp");
        try {
            dispatcher.forward(request,response);
        }catch (IOException | ServletException e){
            e.printStackTrace();
        }

    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/create.jsp");
        try {
            dispatcher.forward(request,response);
        }catch (IOException | ServletException e){
            e.printStackTrace();
        }

    }

    private void listStudent(HttpServletRequest request, HttpServletResponse response) {
        List<Student> students = studentDAO.selectAllStudent();
        request.setAttribute("students", students);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/listStudent.jsp");
        try {
            dispatcher.forward(request,response);
        }catch (IOException | ServletException e){
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action){
            case "create":
                createStudent(request,response);
                break;
            case "delete":
                deleteStudent(request,response);
                break;
            case "edit":
                editStudent(request,response);
                break;
        }

    }

    private void editStudent(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String date = request.getParameter("date");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String classroom = request.getParameter("classroom");

        studentDAO.updateStudent(new Student(id,name,date,address,phone,email,classroom));
        request.setAttribute("message","Successful updated");
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/edit.jsp");
        try {
            dispatcher.forward(request,response);
        }catch (IOException | ServletException exception){
            exception.printStackTrace();
        }

    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        studentDAO.deleteStudent(id);
        try {
            response.sendRedirect("/Students");
        }catch (IOException e){
            e.printStackTrace();
        }


    }

    private void createStudent(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String date = request.getParameter("date");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String classroom = request.getParameter("classroom");

        studentDAO.createStudent(new Student(name,date,address,phone,email,classroom));
        request.setAttribute("message","Successful created");
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/create.jsp");
        try {
            dispatcher.forward(request,response);
        }catch (IOException | ServletException exception){
            exception.printStackTrace();
        }

    }
}
