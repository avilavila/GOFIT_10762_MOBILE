package com.example.gofit_10762.Member

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gofit_10762.BookingGym.BookingGym
import com.example.gofit_10762.BookingGym.RClientBookingGym
import com.example.gofit_10762.BookingGym.ResponseCreateBookingGym
import com.example.gofit_10762.R
import com.example.gofit_10762.databinding.ActivityDataBookingGymBinding
import com.example.gofit_10762.databinding.FragmentDataBookingGymBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Suppress("UNREACHABLE_CODE")

class DataBookingGymFragment : Fragment() {
    private var _binding: FragmentDataBookingGymBinding? = null
    private val binding get() = _binding!!
    private val listBookingGym = ArrayList<BookingGym>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDataBookingGymBinding.inflate(inflater, container, false)
        return binding.root
        getDataBooking()
    }
    override fun onStart() {
        super.onStart()
        getDataBooking()
    }
    private fun getDataBooking() {
        binding.rvData.setHasFixedSize(true)
        binding.rvData.layoutManager= LinearLayoutManager(context)
        val bundle = arguments
        val value = bundle?.getString("idUser")
        val nama = bundle?.getString("nama")
        binding.progressBar.visibility
        val call: Call<ResponseCreateBookingGym> = RClientBookingGym.apiService.getBookingGym()
        call?.enqueue(object : Callback<ResponseCreateBookingGym> {
            override fun onResponse(call: Call<ResponseCreateBookingGym>, response: Response<ResponseCreateBookingGym>) {
                if (response.isSuccessful){
                    listBookingGym.clear()
                    response.body()?.let {
                        listBookingGym.addAll(it.data)
                    }
                    val adapter = BookingGymAdapter(listBookingGym, requireContext(),nama.toString()
                    )
                    binding.rvData.adapter = adapter
                    adapter.notifyDataSetChanged()
                    binding.progressBar.isVisible = false
                }
            }

            override fun onFailure(call: Call<ResponseCreateBookingGym>, t: Throwable) {
            }
        })
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}