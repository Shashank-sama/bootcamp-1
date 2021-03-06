package com.dsc.android.bootcamp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private List<RecyclerViewdata> userList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView = findViewById(R.id.recycler_view);
//        createMockList();
        apicall();
        setUpRecyclerView();

    }

    private void apicall() {
        ApiServices apiServices = AppClient.getInstance().createService(ApiServices.class);
        Call<UserWrapper> call = apiServices.getUserList();
        call.enqueue(new Callback<UserWrapper>() {
            @Override
            public void onResponse(Call<UserWrapper> call, Response<UserWrapper> response) {
                if (response.isSuccessful()){
                    if (response.body() != null){
                        userList.addAll(response.body().getRecyclerViewdata());
                    }
                }
            }

            @Override
            public void onFailure(Call<UserWrapper> call, Throwable t) {

            }
        });
    }

 /*   private void createMockList() {
        RecyclerViewdata data;
        data = new RecyclerViewdata("https://bit.ly/2NT7svr", "Shashank Mishra", "1111111007");
        mockDataList.add(data);
        data = new RecyclerViewdata("https://bit.ly/2NT7svr", "Prateek Kocher", "2222222222");
        mockDataList.add(data);
        data = new RecyclerViewdata("https://bit.ly/2NT7svr", "Rajat Mishra", "3333333333");
        mockDataList.add(data);
        data = new RecyclerViewdata("https://bit.ly/2NT7svr", "Aman Gupta", "4444444444");
        mockDataList.add(data);
        data = new RecyclerViewdata("https://bit.ly/2NT7svr", "Shubham Khandekar", "5555555555");
        mockDataList.add(data);
        data = new RecyclerViewdata("https://bit.ly/2NT7svr", "Harshit Dubey", "6666666666");
        mockDataList.add(data);
        data = new RecyclerViewdata("https://bit.ly/2NT7svr", "Shivam Manihar Sahu", "7777777777");
        mockDataList.add(data);

    }
    */

    private void setUpRecyclerView() {
        recyclerViewAdapter = new RecyclerViewAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.setRecyclerViewdataList(userList);
        recyclerViewAdapter.notifyDataSetChanged();
    }
}
