package com.example.nda.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nda.MainActivity;
import com.example.nda.MyAdapter;
import com.example.nda.R;
import com.example.nda.RetroUser;
import com.example.nda.RetrofitClient;
import com.example.nda.VerDatos;

import android.os.Bundle;

import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {


   private MyAdapter myAdapter;
    private RecyclerView myRecyclerView;


    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        VerDatos service = RetrofitClient.getRetrofitInstance().create(VerDatos.class);
        Call<List<RetroUser>> call = service.getAllUsers();




        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);


        return root;
    }

    public void onResponse(Call<List<RetroUser>> call, Response<List<RetroUser>> response) {
        loadDataList(response.body());
    }


//Handle execution failures//

    public void onFailure(Call<List<RetroUser>> call, Throwable throwable) {

//If the request fails, then display the following toast//


    }

    private void loadDataList(List<RetroUser> usersList) {

//Get a reference to the RecyclerView//

        myRecyclerView = (RecyclerView) myRecyclerView.findViewById(R.id.myRecyclerView);
        myAdapter = new MyAdapter(usersList);

//Use a LinearLayoutManager with default vertical orientation//

        RecyclerView.LayoutManager layoutManager = new RecyclerView.LayoutManager() {

            @Override
            public RecyclerView.LayoutParams generateDefaultLayoutParams() {

                return null;
            }
        };
        myRecyclerView.setLayoutManager(layoutManager);

//Set the Adapter to the RecyclerView//

        myRecyclerView.setAdapter(myAdapter);
    }
}