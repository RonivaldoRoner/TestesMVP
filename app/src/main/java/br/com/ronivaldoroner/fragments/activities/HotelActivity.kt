package br.com.ronivaldoroner.fragments.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import br.com.ronivaldoroner.fragments.*
import br.com.ronivaldoroner.fragments.fragments.HotelDetailsFragment
import br.com.ronivaldoroner.fragments.fragments.HotelListFragment
import br.com.ronivaldoroner.fragments.models.Hotel

class HotelActivity : AppCompatActivity(),
    HotelListFragment.OnHotelClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel)
    }

    override fun onHotelClick(hotel: Hotel) {
        if (isTablet())
            showDetailsFragment(hotel.id)
        else
            showDetailsActivity(hotel.id)
    }

    private fun showDetailsActivity(hotelId: Long) {
        HotelDetailsActivity.open(this, hotelId)
    }

    private fun isTablet() = findViewById<View>(R.id.details) != null


    private fun showDetailsFragment(hotelId: Long) {
        val fragment =
            HotelDetailsFragment.newIntance(hotelId)
        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.details, fragment,
                HotelDetailsFragment.TAG_DETAILS
            )
            .commit()
    }
}
