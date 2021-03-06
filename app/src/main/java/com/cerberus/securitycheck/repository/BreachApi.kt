package com.cerberus.securitycheck.repository

import com.cerberus.securitycheck.models.Breaches
import retrofit2.Call
import retrofit2.http.*

interface BreachApi {

    @Headers("user-agent: CerberusSecurityCheck", "hibp-api-key: 6e81e0b041604619be5d7243417c17c4")
    @GET("breachedaccount/{account} ?truncateResponse=false")
    fun getBreaches(
        @Path("account", encoded = true) pwnAccount: String):

    Call<List<Breaches>>

}

// api_key_tyler = 9ef8326cf22845298e6e5de82bd0e49e
// api_key_john = dc89a9bb9eea467692d2a030107bb16a