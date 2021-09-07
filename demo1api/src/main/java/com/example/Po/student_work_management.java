package com.example.Po;

public class student_work_management{
    private int worksid;

    private int studentid;

    private String workstitle;

    private String workscontext;

    public String getWorkstitle() {
        return workstitle;
    }

    public void setWorkstitle(String workstitle) {
        this.workstitle = workstitle;
    }

    public String getWorkscontext() {
        return workscontext;
    }

    public void setWorkscontext(String workscontext) {
        this.workscontext = workscontext;
    }

    public int getWorksid() {
        return worksid;
    }

    public void setWorksid(int worksid) {
        this.worksid = worksid;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }
}