package com.artemchep.basics_git.ui.postlist;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.artemchep.basics_git.App;
import com.artemchep.basics_git.R;
import com.artemchep.basics_git.database.Store;
import com.artemchep.basics_git.ui.OnFragmentOpenListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class PostListFragment extends Fragment {

    private PostListAdapter mAdapter;
    private FloatingActionButton addPostButton;

    private OnFragmentOpenListener onAddPostFragmentOpen;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post_list, container, false);
        addPostButton = view.findViewById(R.id.add_post);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mAdapter = new PostListAdapter();

        final RecyclerView recyclerView = view.findViewById(R.id.post_list_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(mAdapter);

        addPostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAddPostFragmentOpen.onPostAddFragmentOpen();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        final Store store = App.getStore(requireContext());
        mAdapter.submitList(store.select());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onAddPostFragmentOpen = (OnFragmentOpenListener)getActivity();
    }
}