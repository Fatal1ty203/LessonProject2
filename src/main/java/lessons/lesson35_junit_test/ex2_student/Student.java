package lessons.lesson35_junit_test.ex2_student;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private List<Subject> subjectList = new ArrayList<>();



    public void add(Subject subject){

        if (subject==null) {
            throw new SubjectIsNullException("subject is null");
        }
        if(subject.name == null) throw new SubjectNameIsNullException("subject name is null");
        subjectList.add(subject);
    }

    public Subject get(int index){
        return subjectList.get(index);
    }

    public double getAverageMark()
    {
        return subjectList.stream().mapToDouble(subject->subject.mark).average().orElse(0);
    }

    public int size(){
        return subjectList.size();
    }
}
