package com.evolve.dagger2room

import android.app.Application
import com.evolve.dagger2room.di.component.DaggerRepoComponent
import com.evolve.dagger2room.di.component.RepoComponent
import com.evolve.dagger2room.di.module.ContextModule
import com.evolve.dagger2room.di.module.RepoModule
import com.facebook.stetho.Stetho

/**
 * Created by sujin on 2/20/18.
 */
class MyApplication : Application() {

    //private lateinit var mRepoComponent: RepoComponent

    override fun onCreate() {
        super.onCreate()
       // initDagger()
        initStetho()
    }
/*

    fun getRepoComponent(): RepoComponent {
        return mRepoComponent
    }

    private fun initDagger() {
        mRepoComponent = DaggerRepoComponent
                .builder()
                .contextModule(ContextModule(this))
                .build()
    }
*/

    private fun initStetho() {
        val builder = Stetho.newInitializerBuilder(this)
        builder.enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
        builder.enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
        val initializer = builder.build()
        Stetho.initialize(initializer)
    }
}