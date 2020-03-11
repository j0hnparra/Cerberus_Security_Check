package com.cerberus.securitycheck.models

data class Breaches (
    val LogoPath: String,
    val Name: String,
    val Domain: String,
    val PwnCount: Int,
    val BreachDate: String,
    val Description: String
)