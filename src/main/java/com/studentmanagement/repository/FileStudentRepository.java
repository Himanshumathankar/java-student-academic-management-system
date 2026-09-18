package com.studentmanagement.repository;
import com.studentmanagement.exception.*; import com.studentmanagement.model.Student; import com.studentmanagement.utility.FileManager; import java.nio.file.Path; import java.util.*;
/** CSV-backed student repository with an in-memory lookup map. */
public class FileStudentRepository implements StudentRepository {
    private final Path file; private final Map<String,Student> students=new LinkedHashMap<>();
    public FileStudentRepository(Path file){this.file=file; for(String[] r:FileManager.readCsv(file,5)) students.put(r[0],new Student(r[0],r[1],r[2],r[3],Integer.parseInt(r[4])));}
    public void add(Student s){if(students.containsKey(s.getId()))throw new DuplicateStudentException(s.getId());students.put(s.getId(),s);save();}
    public Optional<Student> findById(String id){return Optional.ofNullable(students.get(id));} public List<Student> findAll(){return new ArrayList<>(students.values());}
    public void update(Student s){if(!students.containsKey(s.getId()))throw new StudentNotFoundException(s.getId());students.put(s.getId(),s);save();}
    public void delete(String id){if(students.remove(id)==null)throw new StudentNotFoundException(id);save();}
    public void save(){FileManager.writeCsv(file,students.values().stream().map(s->new String[]{s.getId(),s.getName(),s.getEmail(),s.getDepartment(),String.valueOf(s.getSemester())}).toList());}
}
