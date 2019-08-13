package com.artemchep.basics_git.database;

import androidx.annotation.NonNull;

import com.artemchep.basics_git.domain.Post;

import java.util.ArrayList;
import java.util.List;

/**
 * Store implementation that does absolutely
 * everything.
 */
public class StoreManager implements Store {

    private List<Post> postList = new ArrayList<>();

    @Override
    public void insert(@NonNull Post post) {
        postList.add(post);
    }

    @NonNull
    @Override
    public List<Post> select() {
        return postList;
    }
}
