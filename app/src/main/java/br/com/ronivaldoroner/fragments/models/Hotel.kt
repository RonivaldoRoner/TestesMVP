package br.com.ronivaldoroner.fragments.models

data class Hotel(
    var id: Long = 0,
    var name: String = "",
    var address: String = "",
    var rating: Float = 0.0F
){
    override fun toString(): String = name
}