package com.example.e_softwarica.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_softwarica.NewsDescriptionActivity;
import com.example.e_softwarica.R;
import com.example.e_softwarica.model.NoticeReceiveParams;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NoticeAdapter.ViewHolder> {

private ArrayList<NoticeReceiveParams.NoticeBean> notice = new ArrayList<>();
        Context context;

public NewsAdapter(ArrayList<NoticeReceiveParams.NoticeBean> all_notice, Context context) {
        this.notice = all_notice;
        this.context = context;
        }

@Override
public NoticeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_notice_single_item, parent, false);
        NoticeAdapter.ViewHolder holder = new NoticeAdapter.ViewHolder(view);
        return holder;
        }

@Override
public void onBindViewHolder(NoticeAdapter.ViewHolder holder, int position) {


final NoticeReceiveParams.NoticeBean pos = notice.get(position);
        //  holder.id.setText(pos.getTrainingTitleID());

        holder.title.setText(pos.getNotice_title());
        holder.date.setText(pos.getNotice_date());


        holder.view.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        Intent in = new Intent(v.getContext(), NewsDescriptionActivity.class);

        //in.putExtra("obj",pos);
        v.getContext().startActivity(in);
        }
        });

        holder.download.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        String pdfURL = pos.getNotice_url();

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
        return notice.size();
        }

public static class ViewHolder extends RecyclerView.ViewHolder {
    TextView title, date;
    Button view, download;

    public ViewHolder(final View itemView) {
        super(itemView);


        title = (TextView) itemView.findViewById(R.id.notice_title);
        date = itemView.findViewById(R.id.notice_date);
        view = (Button) itemView.findViewById(R.id.btnView);
        download = (Button) itemView.findViewById(R.id.btnDownload);
    }
}
}


