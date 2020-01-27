package com.cerberus.securitycheck

data class Breaches (
    val Name: String,
    val Title: String,
    val Domain: String,
    val BreachDate: String,
    val PwnCount: Int,
    val Description: String,
    val LogoPath: String
)