package com.example.is4448_ca2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import org.json.JSONException;

public class AddHeroFragment extends Fragment implements View.OnClickListener{

    Toolbar toolbar;
    Button btnAdd, btnCanel;
    EditText etName, etRealName;
    RatingBar rbRating;
    Spinner spTeam;

    public AddHeroFragment() {
    }

    public static AddHeroFragment newInstance() {
        AddHeroFragment fragment = new AddHeroFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_add_hero, container, false);
        toolbar = root.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        etName = root.findViewById(R.id.etName);
        etRealName = root.findViewById(R.id.etRealName);
        rbRating = root.findViewById(R.id.rbRating);
        spTeam = root.findViewById(R.id.spTeam);
        btnAdd = root.findViewById(R.id.btnAdd);
        btnCanel = root.findViewById(R.id.btnCancel);
        btnAdd.setOnClickListener(this);
        btnCanel.setOnClickListener(this);
        return root;
    }

    public final Handler myCallBack = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            HeroObject h = (HeroObject) msg.obj;
            Toast.makeText(getContext(), h.getName() + " added!", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                getActivity().onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAdd:
                String name, realName, team;
                float rating;
                name = etName.getText().toString().trim();
                realName = etRealName.getText().toString().trim();
                rating = rbRating.getRating();
                team = spTeam.getSelectedItem().toString();
                HeroObject h = new HeroObject(name, realName, rating, team);
                HeroAccessObject dao = new HeroAccessObject();
                try {
                    dao.insertHero(h, insertHeroCallback);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btnCancel:
                getActivity().onBackPressed();
                break;
        }
    }

    public final Handler insertHeroCallback = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Boolean error = (Boolean) msg.obj;
            if (error == false) {
                Toast.makeText(getContext(), "Hero added", Toast.LENGTH_SHORT).show();
                getActivity().getSupportFragmentManager().popBackStackImmediate();
            }else{
                Toast.makeText(getContext(), "Error occurred!", Toast.LENGTH_SHORT).show();
            }
        }
    };
}