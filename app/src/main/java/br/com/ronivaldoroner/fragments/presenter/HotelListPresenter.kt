package br.com.ronivaldoroner.fragments.presenter

import br.com.ronivaldoroner.fragments.models.Hotel
import br.com.ronivaldoroner.fragments.views.HotelListView
import br.com.ronivaldoroner.fragments.ropositories.HotelRepository

class HotelListPresenter(
    private val view: HotelListView,
    private val repository: HotelRepository
) {
    fun searchHotels(term: String) {
        repository.search(term) { hotels -> view.showHotels(hotels) }
    }

    fun showHotelDetails(hotel: Hotel) {
        view.showHotelDetails(hotel)
    }
}