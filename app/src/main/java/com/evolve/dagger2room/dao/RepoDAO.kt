package com.evolve.dagger2room.dao

import android.arch.persistence.room.*
import com.evolve.dagger2room.model.Repo

/**
 * Created by sujin on 2/20/18.
 */
@Dao
interface RepoDAO {

    @Query("SELECT * FROM repo")
    fun getAllRepo(): List<Repo>

    @Query("SELECT * FROM repo where id=:id")
    fun getRepoById(id: String): Repo

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg repos: Repo)

    @Update
    fun update(vararg repos: Repo)

    @Delete
    fun delete(vararg repos: Repo)
}