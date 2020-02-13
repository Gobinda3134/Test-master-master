package com.example.e_softwarica.adapter;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_softwarica.AssignmentDescriptionActivity;
import com.example.e_softwarica.Downloader;
import com.example.e_softwarica.R;
import com.example.e_softwarica.model.AssignmentReceiveParams;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class AssignmentAdapter extends RecyclerView.Adapter<AssignmentAdapter.ViewHolder> {
    private ArrayList<AssignmentReceiveParams.AssignmentBean> events=new ArrayList<>();
    Context context;
    public AssignmentAdapter(ArrayList<AssignmentReceiveParams.AssignmentBean> all_events,Context context)
    {
        this.events=all_events;
        this.context=context;
    }

    @Override
    public AssignmentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_assignment_single_item,parent,false);
        AssignmentAdapter.ViewHolder holder=new AssignmentAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(AssignmentAdapter.ViewHolder holder, int position) {


        final AssignmentReceiveParams.AssignmentBean pos=events.get(position);
        //  holder.id.setText(pos.getTrainingTitleID());

        holder.title.setText(pos.getAssignment_subject());
        holder.cycle.setText(pos.getAssignment_cycle());
        holder.deadline.setText(pos.getAssignment_deadline());

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(v.getContext(), AssignmentDescriptionActivity.class);

                in.putExtra("obj",pos);
                v.getContext().startActivity(in);
            }
        });

        holder.download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pdfURL = pos.getAssignmenturl();

                    Toast.makeText(
                            context,
                            "User Cannot Download PDF",
                            Toast.LENGTH_SHORT).show();

              }
        });

       /* holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(v.getContext(), Events_Description_Activity.class);

                in.putExtra("obj",pos);
                v.getContext().startActivity(in);
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView title,cycle,deadline;
        Button view,download;

        public ViewHolder(final View itemView) {
            super(itemView);


            title=(TextView)itemView.findViewById(R.id.assn_name);
            cycle = itemView.findViewById(R.id.ass_cycle);
            deadline = itemView.findViewById(R.id.ass_deadline);
            view=(Button) itemView.findViewById(R.id.btnView);
            download=(Button) itemView.findViewById(R.id.btnDownload);
        }
    }
}



