package br.com.ronivaldoroner.fragments.presenter

import br.com.ronivaldoroner.fragments.views.HotelDetailsView
import br.com.ronivaldoroner.fragments.ropositories.HotelRepository

class HotelDetailsPresenter(
    private val view: HotelDetailsView,
    private val repository: HotelRepository
) {
    fun loadHotelDetails(id: Long) {
        repository.hotelById(id) {
            if (it != null) {
                view.showHotelDetails(it)
            } else {
                view.errorHotelNotFound()
            }
        }
    }
}