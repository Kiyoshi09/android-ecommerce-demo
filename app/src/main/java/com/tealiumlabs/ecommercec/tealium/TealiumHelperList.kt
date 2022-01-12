package com.tealiumlabs.ecommercec.tealium

import android.app.Application

object TealiumHelperList {
    private val tealiumInstances: MutableMap<String, TealiumHelperB> = mutableMapOf()

    var currentTealiumHelper: TealiumHelperB? = null

    fun update(
        application: Application,
        name: String,
    ): TealiumHelperB? {

        if (tealiumInstances.containsKey(name)) {
            currentTealiumHelper = tealiumInstances[name]

        } else {
            if( name.split(";").size == 4 ) {

                val acct = name.split(";")[0]
                val prof = name.split(";")[1]
                val ds = name.split(";")[2]
                val env = name.split(";")[3]

                if(acct.isNotEmpty() && prof.isNotEmpty() && env.isNotEmpty()) {
                    val _tealiumHelper = TealiumHelperB(
                        application = application,
                        name = name,
                        accountName = acct,
                        profileName = prof,
                        envName = ds,
                        dataSourceId = env,
                    )

                    _tealiumHelper.init()

                    tealiumInstances.put(name, _tealiumHelper)
                    currentTealiumHelper = _tealiumHelper
                }
            }
            else {
                currentTealiumHelper = null
            }
        }

        return currentTealiumHelper
    }
}