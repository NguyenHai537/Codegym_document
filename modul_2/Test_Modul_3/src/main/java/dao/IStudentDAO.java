package dao;

import model.Student;

import java.util.List;

public interface IStudentDAO {

    void createStudent(Student student);


    boolean deleteStudent(int id);

    boolean updateStudent(Student student);

    Student selectStudentId(int id);

    List<Student> selectAllStudent();

    List<Student> selectStudentByName(String name);
}
