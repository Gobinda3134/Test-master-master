package com.example.e_softwarica.model;

import java.util.List;

public class RoutineReceiveParams {

    private List<RoutineBean> routine;

    public List<RoutineBean> getRoutine() {
        return routine;
    }

    public void setNotice(List<RoutineBean> notice) {
        this.routine = routine;
    }

    public static class RoutineBean {


        /**
         * notice_id : 2
         * notice_title : test
         * notice_date : 2057/5/8
         * notice_url : https://esoftwaricabisu.000webhostapp.com/backend/download/Assignment-Presenation-Guideline.pdf
         */

        private String routine_id;
        private String college_batch;
        private String file_name;
        private String noticeurl;

        public String getRoutine_id() {
            return routine_id;
        }

        public void setRoutine_id(String routine_id) {
            this.routine_id = routine_id;
        }

        public String getCollege_batch() {
            return college_batch;
        }

        public void setCollege_batch(String college_batch) {
            this.college_batch = college_batch;
        }

        public String getFile_name() {
            return file_name;
        }

        public void setFile_name(String file_name) {
            this.file_name = file_name;
        }

        public String getNoticeurl() {
            return noticeurl;
        }

        public void setNoticeurl(String noticeurl) {
            this.noticeurl = noticeurl;
        }
    }
}

