package com.kamala.aadproj;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.kamala.aadproj.adapters.HoursAdapter;
import com.kamala.aadproj.adapters.SkillAdapter;
import com.kamala.aadproj.models.Hours;
import com.kamala.aadproj.models.Skill;
import com.kamala.aadproj.network.DetailApi;
import com.kamala.aadproj.network.DetailClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AFragment newInstance(String param1, String param2) {
        AFragment fragment = new AFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    private HoursAdapter mLearnAdapter;
    private List<Hours> mhours;
    private View root;
    @BindView(R.id.recycleHours)
    RecyclerView mLearnRecycler;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_a, container, false);

        ButterKnife.bind(this, view);
        loadLearners();



        return view;
    }

    private void loadLearners() {
        DetailApi service = DetailClient.getClient();
        Call<List<Hours>> call = service.getDetailHours();
        call.enqueue(new Callback<List<Hours>>() {
            @Override
            public void onResponse(Call<List<Hours>> call, Response<List<Hours>> response) {
                if (response.isSuccessful()) {
                    mhours = response.body();


                    mLearnAdapter = new HoursAdapter(mhours, getActivity());
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
                    mLearnRecycler.setLayoutManager(layoutManager);
                    mLearnRecycler.setHasFixedSize(true);
                    mLearnRecycler.setAdapter(mLearnAdapter);
                    mLearnAdapter.notifyDataSetChanged();
                }
            }



            @Override
            public void onFailure(Call<List<Hours>> call, Throwable t) {
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

            loadLearners();
            snackbar.dismiss();
        });
        snackbar.show();
    }


    }
