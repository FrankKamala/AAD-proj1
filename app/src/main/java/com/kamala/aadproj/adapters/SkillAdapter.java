package com.kamala.aadproj.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kamala.aadproj.R;
import com.kamala.aadproj.models.Skill;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SkillAdapter extends RecyclerView.Adapter<SkillAdapter.SkillViewHolder> {
    private List<Skill> skillList;

    public SkillAdapter(List<Skill> skillList, Context context) {
        this.skillList = skillList;
    }
    @NonNull
    @Override
    public SkillAdapter.SkillViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.skill_list, parent, false);
        return new SkillViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SkillAdapter.SkillViewHolder holder, int position) {
        holder.bindSkill(skillList.get(position));

    }

    @Override
    public int getItemCount() {
        return skillList.size();
    }

//    class
    static class SkillViewHolder extends RecyclerView.ViewHolder{
        //myViews
        @BindView(R.id.nameSkill) TextView mName;
         @BindView(R.id.skillScore) TextView mScore;
        @BindView(R.id.countrySkill) TextView mCountry;
    @BindView(R.id.badge)
    ImageView mBadge;

    public SkillViewHolder(@NonNull View itemView) {

        super(itemView);
        ButterKnife.bind(this,itemView);
    }
    void bindSkill(Skill skill){
        Picasso.get().load(skill.getBadgeUrl()).into(mBadge);
        mName.setText(skill.getName());
        mScore.setText(skill.getName());
        mCountry.setText(skill.getName());
    }
}
}
