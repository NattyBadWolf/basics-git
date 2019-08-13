package com.artemchep.basics_git;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
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
            showFragment(new PostListFragment());
        }
    }

    @Override
    public void onPostAddFragmentOpen() {
        PostAddFragment fragment = new PostAddFragment();
        showFragment(fragment);
    }

    @Override
    public void onPostListFragmentOpen() {
        PostListFragment fragment = new PostListFragment();
        showFragment(fragment);
    }

    private void showFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, fragment);
        transaction.commit();
    }
}
