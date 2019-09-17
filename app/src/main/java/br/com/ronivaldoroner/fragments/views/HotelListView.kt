package br.com.ronivaldoroner.fragments.views

import br.com.ronivaldoroner.fragments.models.Hotel

interface HotelListView {
    fun showHotels(hotels: List<Hotel>)
    fun showHotelDetails(hotel: Hotel)
}