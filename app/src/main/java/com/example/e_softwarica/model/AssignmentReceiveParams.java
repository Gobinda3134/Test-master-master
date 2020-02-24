package com.example.e_softwarica.model;

import java.io.Serializable;
import java.util.List;

public class AssignmentReceiveParams {


    private List<AssignmentBean> assignment;

    public List<AssignmentBean> getAssignment() {
        return assignment;
    }

    public void setAssignment(List<AssignmentBean> assignment) {
        this.assignment = assignment;
    }

    public static class AssignmentBean implements Serializable {


        private String assignment_id;
        private String assignment_subject;
        private String assignment_year;
        private String assignment_deadline;
        private String assignment_cycle;
        private String assignmenturl;

        public String getAssignment_id() {
            return assignment_id;
        }

        public void setAssignment_id(String assignment_id) {
            this.assignment_id = assignment_id;
        }

        public String getAssignment_subject() {
            return assignment_subject;
        }

        public void setAssignment_subject(String assignment_subject) {
            this.assignment_subject = assignment_subject;
        }

        public String getAssignment_year() {
            return assignment_year;
        }

        public void setAssignment_year(String assignment_year) {
            this.assignment_year = assignment_year;
        }

        public String getAssignment_deadline() {
            return assignment_deadline;
        }

        public void setAssignment_deadline(String assignment_deadline) {
            this.assignment_deadline = assignment_deadline;
        }

        public String getAssignment_cycle() {
            return assignment_cycle;
        }

        public void setAssignment_cycle(String assignment_cycle) {
            this.assignment_cycle = assignment_cycle;
        }

        public String getAssignmenturl() {
            return assignmenturl;
        }

        public void setAssignmenturl(String assignmenturl) {
            this.assignmenturl = assignmenturl;
        }
    }
}
