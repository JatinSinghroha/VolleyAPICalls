package com.jatinsinghroha.volleyapicalls;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.skydoves.powerspinner.PowerSpinnerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class IndianStatesAPIExample extends AppCompatActivity {

    Button fetchBtn;
    PowerSpinnerView indianStatesSpinner, listOfDistrictsSpinner;

    List<StateItem> listOfStateItems;
    List<String> listOfStateNames;

    List<DistrictItem> listOfDistrictItems;
    List<String> listOfDistrictNames;

    RecyclerView mDistrictListRV;
    RVDistrictsAdapter mRVDistrictsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indian_states_apiexample);

        mDistrictListRV = findViewById(R.id.districtsRV);

        listOfStateItems = new ArrayList<>();
        listOfStateNames = new ArrayList<>();

        listOfDistrictItems = new ArrayList<>();
        listOfDistrictNames = new ArrayList<>();

        mRVDistrictsAdapter = new RVDistrictsAdapter(listOfDistrictItems);

        mDistrictListRV.setAdapter(mRVDistrictsAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        mDistrictListRV.setLayoutManager(layoutManager);

        mDistrictListRV.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        fetchBtn = findViewById(R.id.fetchBtn);
        indianStatesSpinner = findViewById(R.id.listOfStatesSpinner);
        listOfDistrictsSpinner = findViewById(R.id.listOfDistrictsSpinner);

        fetchBtn.setOnClickListener(v -> {
            getStatesOfIndia();
        });

        indianStatesSpinner.setOnSpinnerItemSelectedListener((i, o, position, t1) ->
                getDistrictsOfAState(listOfStateItems.get(position).getState_id()));
    }

    private void getStatesOfIndia() {
        listOfStateItems.clear();
        String apiUrl = "https://cdn-api.co-vin.in/api/v2/admin/location/states/";

        RequestQueue requestQueue = Volley.newRequestQueue(IndianStatesAPIExample.this);

        JsonObjectRequest getStates = new JsonObjectRequest(Request.Method.GET, apiUrl, null, response -> {
            try {
                JSONArray states = response.getJSONArray("states");

                for(int i = 0; i < states.length(); i++){
                    JSONObject stateObject = (JSONObject) states.get(i);
                    listOfStateItems.add(new StateItem((int) stateObject.get("state_id"), (String) stateObject.get("state_name")));
                }

                setItemsInStatesSpinner();


            } catch (JSONException e) {
                e.printStackTrace();
            }
            catch (Exception e){
                e.printStackTrace();
            }

        }, error -> {


        });

        requestQueue.add(getStates);
    }

    private void setItemsInStatesSpinner() {
        listOfStateNames.clear();
        for(int i = 0; i < listOfStateItems.size(); i++){

            listOfStateNames.add(listOfStateItems.get(i).getState_name());

        }
        indianStatesSpinner.setItems(listOfStateNames);
    }

    private void getDistrictsOfAState(int id){
        listOfDistrictItems.clear();
        String districtAPIURL = "https://cdn-api.co-vin.in/api/v2/admin/location/districts/"+id;

        RequestQueue requestQueue = Volley.newRequestQueue(IndianStatesAPIExample.this);

        JsonObjectRequest getDistrictRequest =
                new JsonObjectRequest(Request.Method.GET,
                        districtAPIURL, null,
                        response -> {
                        try{
                            JSONArray districts = response.getJSONArray("districts");

                            for (int i = 0; i < districts.length(); i++) {
                                JSONObject district = (JSONObject) districts.get(i);
                                listOfDistrictItems.add(new DistrictItem(
                                        (int) district.get("district_id"),
                                        (String) district.get("district_name")
                                ));
                            }

                            setUpDistrictsSpinner();

                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }

                        },
                        error -> {
                            Toast.makeText(IndianStatesAPIExample.this,
                                    "Error with District Request", Toast.LENGTH_LONG).show();
                        });

        requestQueue.add(getDistrictRequest);
    }

    private void setUpDistrictsSpinner() {
        listOfDistrictNames.clear();

        for(int i=0; i< listOfDistrictItems.size(); i++){
            listOfDistrictNames.add(listOfDistrictItems.get(i).getDistrict_name());
        }

        listOfDistrictsSpinner.setItems(listOfDistrictNames);

        mRVDistrictsAdapter.notifyDataSetChanged();
    }

    /**
     * 5 Parameters
     * 1 -> Request.Method.GET = Same
     * 2 -> API URL = Different
     * 3 -> null = Same
     * 4 -> Response = Different
     * 5 -> Error = Same
     *
     *
     * Dangerous Permissions:
     * - Camera
     * - location
     * - Storage
     * - Mic
     *
     * Non-Dangerous Permissions:
     * - Internet
     * - Dial Phone Call
     * 
     */

}