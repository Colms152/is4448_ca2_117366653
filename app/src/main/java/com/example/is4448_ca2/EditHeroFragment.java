package com.example.is4448_ca2;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;


public class EditHeroFragment extends Fragment {
    Toolbar toolbar;
    EditText etName, etRealName;
    RatingBar rbRating;
    Spinner spTeam;

    private static final String ARG_HERO = "hero";
    private HeroObject hero;

    public EditHeroFragment() {
    }

    public static EditHeroFragment newInstance(HeroObject hero) {
        EditHeroFragment fragment = new EditHeroFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_HERO, hero);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        if (getArguments() != null) {
            hero = getArguments().getParcelable(ARG_HERO);
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_edit_hero, container, false);
        toolbar = root.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setHasOptionsMenu(true);

        etName = root.findViewById(R.id.etName);
        etRealName = root.findViewById(R.id.etRealName);
        rbRating = root.findViewById(R.id.rbRating);
        spTeam = root.findViewById(R.id.spTeam);

        initValues();
        return root;
    }

    private void initValues() {
        etName.setText(hero.getName());
        etRealName.setText(hero.getRealName());
        rbRating.setRating(hero.getRating());
        String compareValue = String.valueOf(hero.getTeam());
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.teams, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTeam.setAdapter(adapter);
        if (compareValue != null) {
            int spinnerPosition = adapter.getPosition(compareValue);
            spTeam.setSelection(spinnerPosition);
        }
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_done, menu);
        return;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                getActivity().onBackPressed();
                return true;
            case R.id.action_save:
                HeroAccessObject dao = new HeroAccessObject();
                String name, realName, team;
                float rating;
                name = etName.getText().toString().trim();
                realName = etRealName.getText().toString().trim();
                rating = rbRating.getRating();
                team = spTeam.getSelectedItem().toString();
                hero.setName(name);
                hero.setRating(rating);
                hero.setRealName(realName);
                hero.setTeam(team);
                dao.updateHero(hero, updateHeroCallback);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    public final Handler updateHeroCallback = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Boolean error = (Boolean) msg.obj;
            if (error == false) {
                Toast.makeText(getContext(), "Hero updated", Toast.LENGTH_SHORT).show();
                getActivity().getSupportFragmentManager().popBackStackImmediate();
            } else {
                Toast.makeText(getContext(), "Error occurred!", Toast.LENGTH_SHORT).show();
            }
        }
    };
}