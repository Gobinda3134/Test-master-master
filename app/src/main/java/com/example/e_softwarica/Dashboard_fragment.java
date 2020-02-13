package com.example.e_softwarica;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;



public class Dashboard_fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup group, Bundle b) {
        View rootView = inflater.inflate(R.layout.dashboard_fragment, group, false);

        ImageView img_training=(ImageView) rootView.findViewById(R.id.training_image);
        ImageView img_gallery=(ImageView) rootView.findViewById(R.id.gallery_image);
        ImageView img_notice=(ImageView) rootView.findViewById(R.id.notice_image);
        ImageView img_library=(ImageView) rootView.findViewById(R.id.library_image);
        ImageView img_news=(ImageView) rootView.findViewById(R.id.news_image);
        ImageView img_events=(ImageView) rootView.findViewById(R.id.events_image);

        LinearLayout training=(LinearLayout) rootView.findViewById(R.id.training_layout);
        LinearLayout gallery=(LinearLayout) rootView.findViewById(R.id.gallery_layout);
        LinearLayout library=(LinearLayout) rootView.findViewById(R.id.library_layout);
        LinearLayout notice=(LinearLayout) rootView.findViewById(R.id.notice_layout);
        LinearLayout news=(LinearLayout) rootView.findViewById(R.id.news_layout);
        LinearLayout events=(LinearLayout) rootView.findViewById(R.id.events_layout);

        training.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = new Intent(getContext(), GalleryActivity.class);
                startActivity(in);
            }
        });

        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = new Intent(getContext(), CoursesActivity.class);
                startActivity(in);


            }
        });


        notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = new Intent(getContext(), AssignmentActivity.class);
                startActivity(in);

            }
        });

        library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = new Intent(getContext(), RoutineActivity.class);
                startActivity(in);
            }

        });

        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = new Intent(getContext(), NewsActivity.class);
                startActivity(in);


            }
        });

        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = new Intent(getContext(), ClubActivity.class);
                startActivity(in);
            }
        });

        img_training.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getContext(), GalleryActivity.class);
                startActivity(in);
            }
        });

        img_gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getContext(), CoursesActivity.class);
                startActivity(in);
            }
        });

        img_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getContext(), AssignmentActivity.class);
                startActivity(in);
            }
        });

        img_library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = new Intent(getContext(), RoutineActivity.class);
                startActivity(in);
            }

        });

        img_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = new Intent(getContext(), NewsActivity.class);
                startActivity(in);


            }
        });

        img_events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = new Intent(getContext(), ClubActivity.class);
                startActivity(in);
            }
        });

        return rootView;
    }

}

