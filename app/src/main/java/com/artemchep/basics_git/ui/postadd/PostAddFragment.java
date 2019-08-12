package com.artemchep.basics_git.ui.postadd;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.artemchep.basics_git.App;
import com.artemchep.basics_git.R;
import com.artemchep.basics_git.database.Store;
import com.artemchep.basics_git.domain.Post;
import com.artemchep.basics_git.ui.postlist.PostListFragment;

public class PostAddFragment extends Fragment {

    private EditText postText;
    private Button saveButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post_add, container, false);
        postText = view.findViewById(R.id.post_text);
        saveButton = view.findViewById(R.id.save);
        return view;
    }

    @Override
    public void onViewCreated(final @NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });
    }

    private void save() {
        final String text = postText.getText().toString();
        if (text.length() == 0) {
            return;
        }

        final Store store = App.getStore(requireContext());
        store.insert(new Post(text));

        showPostListFragment();
    }

    private void showPostListFragment() {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, new PostListFragment());
        transaction.commit();
    }

}
