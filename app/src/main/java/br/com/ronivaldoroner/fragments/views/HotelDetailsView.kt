package br.com.ronivaldoroner.fragments.views

import br.com.ronivaldoroner.fragments.models.Hotel

interface HotelDetailsView {
    fun showHotelDetails(hotel: Hotel)
    fun errorHotelNotFound()
}