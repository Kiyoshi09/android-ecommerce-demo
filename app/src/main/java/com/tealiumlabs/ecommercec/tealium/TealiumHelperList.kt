package com.tealiumlabs.ecommercec.tealium

import android.app.Application
import com.tealiumlabs.ecommercec.model.EcommViewModel

object TealiumHelperList {
    private val tealiumInstances: MutableMap<String, TealiumHelperB> = mutableMapOf()

    fun request(
        application: Application,
        name: String,
        viewModel: EcommViewModel,
    ): TealiumHelperB? {
        var tealiumHelper: TealiumHelperB? = null

        if (tealiumInstances.containsKey(name)) {
            tealiumHelper = tealiumInstances[name]

        } else {
            val acct = name.split(";")[0]
            val prof = name.split(";")[1]
            val ds = name.split(";")[2]
            val env = name.split(";")[3]

            viewModel.tealiumAccount.value = acct
            viewModel.tealiumProfile.value = prof
            viewModel.tealiumDataSource.value = ds
            viewModel.tealiumEnvironment.value = env

            if(acct.isNotEmpty() && prof.isNotEmpty() && ds.isNotEmpty() && env.isNotEmpty()) {
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
                tealiumHelper = _tealiumHelper
            }
        }

        return tealiumHelper
    }
}