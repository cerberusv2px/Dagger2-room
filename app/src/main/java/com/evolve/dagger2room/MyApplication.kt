package com.evolve.dagger2room

import android.app.Application
import com.facebook.stetho.Stetho

/**
 * Created by sujin on 2/20/18.
 */

class MyApplication : Application() {

    /* companion object {
         lateinit var repoComponent: RepoComponent
     }*/

    override fun onCreate() {
        super.onCreate()
        //initDagger()
        initStetho()
    }


    /*private fun initDagger() {
        repoComponent = DaggerRepoComponent.builder()
                .contextModule(ContextModule(this))
                .repoModule(RepoModule())
                .build()
    }*/

    private fun initStetho() {
        val builder = Stetho.newInitializerBuilder(this)
        builder.enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
        builder.enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
        val initializer = builder.build()
        Stetho.initialize(initializer)
    }
}