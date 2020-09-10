package com.kamala.aadproj.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kamala.aadproj.R;
import com.kamala.aadproj.models.Hours;
import com.kamala.aadproj.models.Skill;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HoursAdapter extends RecyclerView.Adapter<HoursAdapter.HoursViewHolder> {
    private List<Hours> learnList;

    public HoursAdapter(List<Hours> learnList, Context context)
    {
        this.learnList = learnList;
    }
    @NonNull
    @Override
    public HoursViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.skill_list, parent, false);
        return new HoursAdapter.HoursViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HoursViewHolder holder, int position) {
        holder.bindSkill(learnList.get(position));

    }

    @Override
    public int getItemCount() {
        return learnList.size();
    }

    public class HoursViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.nameSkill)
        TextView mName;
        @BindView(R.id.skillScore) TextView mScore;
        @BindView(R.id.countrySkill) TextView mCountry;
        public HoursViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void bindSkill(Hours hours) {
            mName.setText(hours.getName());
            mScore.setText(hours.getName());
            mCountry.setText(hours.getName());

        }
    }
}
