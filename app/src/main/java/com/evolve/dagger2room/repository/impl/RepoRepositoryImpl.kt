package com.evolve.dagger2room.repository.impl

import android.content.Context
import com.evolve.dagger2room.RepoDatabase
import com.evolve.dagger2room.RepoDatabase.Companion.instance
import com.evolve.dagger2room.model.Repo
import com.evolve.dagger2room.repository.RepoRepository
import javax.inject.Inject

/**
 * Created by sujin on 2/20/18.
 */
class RepoRepositoryImpl @Inject constructor(context: Context) : RepoRepository {

    var instance = RepoDatabase.getInstance(context)

    override fun insert(vararg repo: Repo) {
        instance.getRepoDAO().insert(*repo)
    }

    override fun update(vararg repo: Repo) {
        instance.getRepoDAO().update(*repo)
    }

    override fun delete(vararg repo: Repo) {
        instance.getRepoDAO().delete(*repo)
    }

    override fun getAll(): List<Repo> {
        return instance.getRepoDAO().getAllRepo()
    }

    override fun getById(id: String): Repo {
        return instance.getRepoDAO().getRepoById(id)
    }
}