package com.artemchep.basics_git;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.artemchep.basics_git.ui.OnFragmentOpenListener;
import com.artemchep.basics_git.ui.postadd.PostAddFragment;
import com.artemchep.basics_git.ui.postlist.PostListFragment;

public class MainActivity extends AppCompatActivity implements OnFragmentOpenListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.content, new PostListFragment());
            transaction.commit();
        }
    }

    @Override
    public void onPostAddFragmentOpen() {
        PostAddFragment fragment = new PostAddFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onPostListFragmentOpen() {
        getSupportFragmentManager().popBackStack();
    }
}
