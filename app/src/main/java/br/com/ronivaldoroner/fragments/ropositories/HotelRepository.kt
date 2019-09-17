package br.com.ronivaldoroner.fragments.ropositories

import br.com.ronivaldoroner.fragments.models.Hotel

interface HotelRepository {
    fun save(hotel: Hotel)
    fun remove(vararg hotels: Hotel)
    fun hotelById(id: Long, callback:(Hotel?) -> Unit)
    fun search(term: String, callback: (List<Hotel>)-> Unit)
}