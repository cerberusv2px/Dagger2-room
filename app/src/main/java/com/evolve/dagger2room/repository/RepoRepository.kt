package com.evolve.dagger2room.repository

import com.evolve.dagger2room.model.Repo

/**
 * Created by sujin on 2/20/18.
 */
interface RepoRepository {

    fun insert(vararg repo: Repo)
    fun update(vararg repo: Repo)
    fun delete(vararg repo: Repo)
    fun getAll(): List<Repo>
    fun getById(id: String): Repo
}