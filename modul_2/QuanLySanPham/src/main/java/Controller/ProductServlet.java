package Controller;

import Model.Product;
import Service.ProductService;
import Service.ProductiplmProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/Products")
public class ProductServlet extends HttpServlet {

    ProductService productService = new ProductiplmProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "create":
                showCreateForm(request,response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
            case "delete":
                showDeleteForm(request,response);
                break;
            case "viewid":
                showViewidForm(request,response);
                break;
            case "viewname":
                showListProductByName(request,response);
                break;
            default:
                listProduct(request,response);
                break;

        }

    }

    private void showListProductByName(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("viewname");
        List<Product> products = productService.searchByName(name);
        request.setAttribute("products",products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/list.jsp");
        try {
            dispatcher.forward(request,response);
        }catch (IOException | ServletException e){
            e.printStackTrace();
        }
    }

    private void showViewidForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.searchByID(id);
        request.setAttribute("product" , product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/viewid.jsp");
        try {
            dispatcher.forward(request,response);
        }catch (IOException | ServletException e){
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.searchByID(id);
        request.setAttribute("product" , product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/delete.jsp");
        try {
            dispatcher.forward(request,response);
        }catch (IOException | ServletException e){
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.searchByID(id);
        request.setAttribute("product" , product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/edit.jsp");
        try {
            dispatcher.forward(request,response);
        }catch (IOException | ServletException e){
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        try {
            dispatcher.forward(request,response);
        }catch (IOException | ServletException e){
            e.printStackTrace();
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = new ArrayList<>(productService.list());
        request.setAttribute("products" ,products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");

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
                createProduct(request,response);
                break;
            case "edit":
                updateProduct(request,response);
                break;
            case "delete":
                deleteProduct(request,response);
                break;
            case "viewId":
                break;
            case "viewName":
                break;
            default:
                listProduct(request,response);
                break;

        }

    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product= productService.searchByID(id);
        productService.remove(product);
        request.setAttribute("message","successful deleted");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/delete.jsp");
        try {
            dispatcher.forward(request,response);
        }catch (IOException |ServletException e){
            e.printStackTrace();
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        String maker = request.getParameter("maker");
        Product product = new Product(id,name,price,description,maker);

        productService.update(product);
        request.setAttribute("message","successful updated");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/edit.jsp");
        try {
            dispatcher.forward(request,response);
        }catch (IOException |ServletException e){
            e.printStackTrace();
        }

    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String maker = request.getParameter("maker");
        double price = Double.parseDouble(request.getParameter("price"));

        Product product = new Product(id,name,price,description,maker);
        productService.create(product);

        request.setAttribute("message", "New product was created");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/create.jsp");

        try {
            dispatcher.forward(request,response);
        }catch (IOException |ServletException e){
            e.printStackTrace();
        }
    }
}
