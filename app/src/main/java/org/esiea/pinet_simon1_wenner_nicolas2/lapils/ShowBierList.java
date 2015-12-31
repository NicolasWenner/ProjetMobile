package org.esiea.pinet_simon1_wenner_nicolas2.lapils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ShowBierList extends AppCompatActivity {

    public RecyclerView my_rcv ;
    public RecyclerView.Adapter my_adapter;
    private RecyclerView.LayoutManager my_manager;
    public JSONArray tab = new JSONArray();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bier_list);

        my_rcv = (RecyclerView) findViewById(R.id.rv_biere);
        my_manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
       JSONArray tab = getBiersFromFile();

        my_adapter = new BiersAdapter(tab);
        my_rcv.setAdapter(my_adapter);
        my_rcv.setHasFixedSize(true);
        my_rcv.setLayoutManager(my_manager);

    }

    private class BiersAdapter  extends RecyclerView.Adapter<BiersAdapter.BierHolder> {

        private JSONArray Biers ;
    public BiersAdapter(JSONArray Bier_array){

        this.Biers=Bier_array;
    }
        public void setNewBier (JSONArray some) {
            this.Biers = some;
            my_adapter.notifyDataSetChanged();
        }

        @Override
        public BierHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View bierview = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_bier_element,parent,false);
            return new BierHolder(bierview);
        }

        @Override
        public void onBindViewHolder(BierHolder holder, int position) {
            JSONObject one_bier=new JSONObject();
            one_bier=null;
            String bier_name= null;

            try {
                one_bier = (JSONObject)Biers.get(position);
                bier_name = one_bier.getString("name");
                holder.name.setText(bier_name);


            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        @Override
        public int getItemCount() {

            Log.d("TAG", "item size" + Biers.length());
            return Biers.length();
        }

        public class BierHolder extends RecyclerView.ViewHolder {
            public TextView name;
            public BierHolder(View itemView) {
                super(itemView);
                name = (TextView) itemView.findViewById(R.id.rv_biere_element_name);
            }
        }

    }

    public JSONArray getBiersFromFile(){
        try{
            InputStream is = new FileInputStream(getCacheDir()+"/"+"bieres.json");
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            return new JSONArray(new String(buffer,"UTF-8")); //construction du tableau
                    }catch(IOException e){
            e.printStackTrace();
            return new JSONArray();
                    }catch(JSONException e){
            e.printStackTrace();
            return new JSONArray();
        }
    }
}
