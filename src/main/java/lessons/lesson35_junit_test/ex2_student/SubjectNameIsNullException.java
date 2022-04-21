package lessons.lesson35_junit_test.ex2_student;

public class SubjectNameIsNullException extends RuntimeException{

    public SubjectNameIsNullException(String message) {
        super(message);
    }
}
