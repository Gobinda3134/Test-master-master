package com.example.e_softwarica.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_softwarica.NoticeDescriptionActivity;
import com.example.e_softwarica.R;
import com.example.e_softwarica.RoutineDescriptionActivity;
import com.example.e_softwarica.model.NoticeReceiveParams;
import com.example.e_softwarica.model.RoutineReceiveParams;

import java.util.ArrayList;

public class RoutineAdapter extends RecyclerView.Adapter<RoutineAdapter.ViewHolder> {

    private ArrayList<RoutineReceiveParams.RoutineBean> routine = new ArrayList<>();
    Context context;

    public RoutineAdapter(ArrayList<RoutineReceiveParams.RoutineBean> all_routine, Context context) {
        this.routine = all_routine;
        this.context = context;
    }

    @Override
    public RoutineAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_routine_single_item, parent, false);
        RoutineAdapter.ViewHolder holder = new RoutineAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        final RoutineReceiveParams.RoutineBean pos = routine.get(i);
        //  holder.id.setText(pos.getTrainingTitleID());

       viewHolder.batch.setText(pos.getCollege_batch());


        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(v.getContext(), RoutineDescriptionActivity.class);

                //in.putExtra("obj",pos);
                v.getContext().startActivity(in);
            }
        });

        viewHolder.download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pdfURL = pos.getNoticeurl();

                Toast.makeText(
                        context,
                        "You Cannot Download PDF",
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
        return routine.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView batch, fileName;
        Button view, download;

        public ViewHolder(final View itemView) {
            super(itemView);


            batch = (TextView) itemView.findViewById(R.id.routine_batch);
            //fileName = itemView.findViewById(R.id.ro);
            view = (Button) itemView.findViewById(R.id.btnView);
            download = (Button) itemView.findViewById(R.id.btnDownload);
        }
    }
}
