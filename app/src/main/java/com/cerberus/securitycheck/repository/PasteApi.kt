package com.cerberus.securitycheck.repository

import com.cerberus.securitycheck.models.Pastes
import retrofit2.Call
import retrofit2.http.*

interface PasteApi {

    @Headers("user-agent: CerberusSecurityCheck", "hibp-api-key: dc89a9bb9eea467692d2a030107bb16a")
    @GET("pasteaccount/{account} ")
    fun getPastes(
        @Path("account", encoded = true) pasteAccount: String):

            Call<List<Pastes>>

}

// api_key_tyler = 9ef8326cf22845298e6e5de82bd0e49e
// api_key_john = dc89a9bb9eea467692d2a030107bb16a