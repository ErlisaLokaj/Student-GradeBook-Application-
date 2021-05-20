package erlisa;

import java.util.ArrayList;

public class Student {
	private String name;
	private String surname;
	private ArrayList<CompletedExam> exams = new ArrayList<CompletedExam>();

	public Student(String n, String s) {
		name = n;
		surname = s;
	}

	public void addExam(Exam e, double earnedPoints) {
		exams.add(new CompletedExam(e, earnedPoints));
	}

	public String getName() {
		return name;
	}

	public void setName(String n) {
		name = n;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String s) {
		surname = s;
	}

	public CompletedExam getExam(int index) {
		return exams.get(index);
	}

	public int getNumberOfExams() {
		return exams.size();
	}
}