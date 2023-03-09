package dao;

import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IStudentDAO{

    private String jdbcURL = "jdbc:mysql://localhost:3306/testmodul3?useSSL=false";
    private String jdbcUserName = "root";
    private String jdbcPassword = "Tuila7582621";

    private static final String INSERT_student_SQL =  "INSERT INTO student (name, date, address,phone,email,classroom) VALUES (?, ?, ?, ?,?,?);";
    private static final String SELECT_student_BY_ID = "select name, date, address,phone,email,classroom from student where id =?;";
    private static final String SELECT_ALL_student = "select * from student;";
    private static final String DELETE_student_SQL = "delete from student where id = ?;";
    private static final String UPDATE_student_SQL = "update student set name = ?,date= ?, address =?, phone=?,email=?,classroom=? where id = ?;";
    private static final String SELECT_student_By_Name = "select * from student where name = ?";

    public StudentDAO() {
    }

    protected Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL,jdbcUserName,jdbcPassword);
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void createStudent(Student student) {
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_student_SQL)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getDate());
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setString(4, student.getPhone());
            preparedStatement.setString(5, student.getEmail());
            preparedStatement.setString(6, student.getClassroom());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public boolean deleteStudent(int id) {
        boolean rowDelete = false;
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DELETE_student_SQL);){
            preparedStatement.setInt(1,id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return rowDelete;
    }

    @Override
    public boolean updateStudent(Student student) {
        boolean rowUpdate = false;
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_student_SQL);) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getDate());
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setString(4, student.getPhone());
            preparedStatement.setString(5, student.getEmail());
            preparedStatement.setString(6, student.getClassroom());
            preparedStatement.setInt(7, student.getId());

            rowUpdate = preparedStatement.executeUpdate()>0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return rowUpdate;
    }

    @Override
    public Student selectStudentId(int id) {
        Student student = null;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_student_BY_ID)){
            preparedStatement.setInt(1,id);

            ResultSet rs =preparedStatement.executeQuery();

            while (rs.next()){
                String name = rs.getString("name");
                String date = rs.getString("date");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String classroom = rs.getString("classroom");
                 student = new Student(id,name,date,address,phone,email,classroom);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public List<Student> selectAllStudent() {
        List<Student> students = new ArrayList<>();

        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_student);){
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String date = rs.getString("date");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String classroom = rs.getString("classroom");
                Student student = new Student(id,name,date,address,phone,email,classroom);
                students.add(student);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public List<Student> selectStudentByName(String name) {
        List<Student> students = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_student_By_Name)){
            preparedStatement.setString(1,name);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                String name1 = rs.getString("name");
                String date = rs.getString("date");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String classroom = rs.getString("classroom");
                Student student = new Student(id,name1,date,address,phone,email,classroom);
                students.add(student);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return students;

    }
}
