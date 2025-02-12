package br.com.ronivaldoroner.fragments.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.ronivaldoroner.fragments.fragments.HotelDetailsFragment
import br.com.ronivaldoroner.fragments.R

class HotelDetailsActivity : AppCompatActivity() {
    private val hotelId: Long by lazy {
        intent.getLongExtra(EXTRA_HOTEL_ID, -1)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel_details)
        if (savedInstanceState == null) {
            showHotelDetailsFragment()
        }
    }

    private fun showHotelDetailsFragment() {
        val fragment =
            HotelDetailsFragment.newIntance(hotelId)

        supportFragmentManager.beginTransaction()
            .replace(
                R.id.details, fragment,
                HotelDetailsFragment.TAG_DETAILS
            )
            .commit()
    }

    companion object {
        private const val EXTRA_HOTEL_ID = "hotel_id"
        fun open(context: Context, hotelId: Long) {
            context.startActivity(
                Intent(context, HotelDetailsActivity::class.java)
                    .apply { putExtra(EXTRA_HOTEL_ID, hotelId) }
            )
        }
    }
}
