package erlisa;

import java.util.ArrayList;

public class GradeBook {
	private ArrayList<Student> gradeBook = new ArrayList<Student>();

	public GradeBook() {
	}

	public void addStudent(Student a) {
		gradeBook.add(a);
	}

	public Student getStudent(int index) {
		return gradeBook.get(index);
	}

	public void removeStudent(int index) {
		gradeBook.remove(index);
	}

	public int size() {
		return gradeBook.size();
	}
}
