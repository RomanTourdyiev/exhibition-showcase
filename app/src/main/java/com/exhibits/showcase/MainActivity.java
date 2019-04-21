package com.exhibits.showcase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.exhibits.fileexhibitsloader.ExhibitsLoaderImpl;
import com.exhibits.model.Exhibit;

import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LinearLayoutManager linearLayoutManager;
    private RVAdapter adapter;
    private ExhibitsLoaderImpl exhibitsLoader;

    private RecyclerView recyclerView;

    private List<Exhibit> exhibits = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        exhibitsLoader = new ExhibitsLoaderImpl();

        findViews();
        initViews();
        populateList();
    }

    private void findViews() {
        recyclerView = findViewById(R.id.recycler_view);
    }

    private void initViews() {
        // recycler
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new RVAdapter(exhibits);
        recyclerView.setAdapter(adapter);
    }

    private void populateList() {

        exhibits.clear();
        try {
            InputStream inputStream = getResources().getAssets().open("source.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            exhibits.addAll(exhibitsLoader.getExhibitList(new String(buffer, StandardCharsets.UTF_8)));

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        adapter.notifyDataSetChanged();
    }
}
