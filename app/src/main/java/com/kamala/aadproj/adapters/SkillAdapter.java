package com.kamala.aadproj.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kamala.aadproj.R;
import com.kamala.aadproj.models.Skill;

import java.util.List;

public class SkillAdapter extends RecyclerView.Adapter<SkillAdapter.SkillViewHolder> {
    private List<Skill> skillList;

    public SkillAdapter(List<Skill> invoiceList, Context context) {
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

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
