package com.example.e_softwarica.model;

import java.io.Serializable;
import java.util.List;

public class NewsReceiveParams implements Serializable {

    private List<NoticeReceiveParams.NoticeBean> notice;

    public List<NoticeReceiveParams.NoticeBean> getNotice() {
        return notice;
    }

    public void setNotice(List<NoticeReceiveParams.NoticeBean> notice) {
        this.notice = notice;
    }

    public static class NoticeBean {
        /**
         * notice_id : 2
         * notice_title : test
         * notice_date : 2057/5/8
         * notice_url : https://esoftwaricabisu.000webhostapp.com/backend/download/Assignment-Presenation-Guideline.pdf
         */

        private String notice_id;
        private String notice_title;
        private String notice_date;
        private String notice_url;

        public String getNotice_id() {
            return notice_id;
        }

        public void setNotice_id(String notice_id) {
            this.notice_id = notice_id;
        }

        public String getNotice_title() {
            return notice_title;
        }

        public void setNotice_title(String notice_title) {
            this.notice_title = notice_title;
        }

        public String getNotice_date() {
            return notice_date;
        }

        public void setNotice_date(String notice_date) {
            this.notice_date = notice_date;
        }

        public String getNotice_url() {
            return notice_url;
        }

        public void setNotice_url(String notice_url) {
            this.notice_url = notice_url;
        }
    }
}
