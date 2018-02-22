package com.evolve.dagger2room.di.component

import com.evolve.dagger2room.MainActivity
import com.evolve.dagger2room.di.module.RepoModule
import com.evolve.dagger2room.repository.impl.RepoRepositoryImpl
import dagger.Component
import javax.inject.Singleton

/**
 * Created by sujin on 2/20/18.
 */
@Singleton
@Component(modules = arrayOf(RepoModule::class))
interface RepoComponent {

    fun getRepoImpl(activity: MainActivity): RepoRepositoryImpl
}