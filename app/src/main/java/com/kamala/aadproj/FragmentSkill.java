package com.kamala.aadproj;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.kamala.aadproj.adapters.SkillAdapter;
import com.kamala.aadproj.models.Skill;
import com.kamala.aadproj.network.DetailApi;
import com.kamala.aadproj.network.DetailClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentSkill extends Fragment {

    private SkillAdapter sAdapter;
    private List<Skill> skills;
    private View root;
    @BindView(R.id.recycleSkill)
    RecyclerView mSkillRecycler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_skill, container, false);
        ButterKnife.bind(this, rootView);
        loadDetails();
        return rootView;

    }

    private void loadDetails() {

        DetailApi service = (DetailApi) DetailClient.getClient().getDetailSkill();
        Call<List<Skill>> call = service.getDetailSkill();
        call.enqueue(new Callback<List<Skill>>() {
            @Override
            public void onResponse(Call<List<Skill>> call, Response<List<Skill>> response) {
                if (response.isSuccessful()) {
                    skills = response.body();


                    sAdapter = new SkillAdapter(skills, root.getContext());
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(root.getContext(), LinearLayoutManager.VERTICAL, false);
                    mSkillRecycler.setLayoutManager(layoutManager);
                    mSkillRecycler.setHasFixedSize(true);
                    mSkillRecycler.setAdapter(sAdapter);
                    sAdapter.notifyDataSetChanged();
                }
            }


            @Override
            public void onFailure(Call<List<Skill>> call, Throwable t) {
                showSnack();

            }


        });

    }
    private void showSnack() {
        View rootView = root;
        Snackbar snackbar = Snackbar.make(rootView,
                "Network error!.", Snackbar.LENGTH_INDEFINITE);
        snackbar.setActionTextColor(getResources().getColor(R.color.design_default_color_error));
        snackbar.setAction("Please Retry", v -> {

            loadDetails();
            snackbar.dismiss();
        });
        snackbar.show();
    }
}