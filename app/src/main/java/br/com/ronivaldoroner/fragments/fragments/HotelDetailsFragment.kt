package br.com.ronivaldoroner.fragments.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.ronivaldoroner.fragments.*
import br.com.ronivaldoroner.fragments.models.Hotel
import br.com.ronivaldoroner.fragments.presenter.HotelDetailsPresenter
import br.com.ronivaldoroner.fragments.ropositories.MemoryRepository
import br.com.ronivaldoroner.fragments.views.HotelDetailsView
import kotlinx.android.synthetic.main.fragment_hotel_details.*

class HotelDetailsFragment: Fragment(), HotelDetailsView {

    private val presenter = HotelDetailsPresenter(
        this,
        MemoryRepository
    )
    private var hotel: Hotel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_hotel_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.loadHotelDetails(arguments?.getLong(EXTRA_HOTEL_ID, -1)?: -1)
    }

    override fun showHotelDetails(hotel: Hotel) {
        this.hotel = hotel
        txtName.text = hotel.name
        txtAddress.text = hotel.address
        rtbRating.rating = hotel.rating
    }

    override fun errorHotelNotFound() {
        txtName.text = getString(R.string.error_hotel_not_found)
        txtAddress.visibility = View.GONE
        rtbRating.visibility = View.GONE
    }

    companion object{
        const val TAG_DETAILS = "tegDetalhe"
        private const val EXTRA_HOTEL_ID = "hotelId"

        fun newIntance(id: Long) = HotelDetailsFragment().apply {
            arguments = Bundle().apply {
                putLong(EXTRA_HOTEL_ID, id)
            }
        }
    }
}