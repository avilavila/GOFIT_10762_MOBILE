package com.example.gofit_10762.Member

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gofit_10762.BookingKelas.BookingKelas
import com.example.gofit_10762.BookingKelas.RClientBookingKelas
import com.example.gofit_10762.BookingKelas.ResponseCreateBookingKelas
import com.example.gofit_10762.R
import com.example.gofit_10762.databinding.FragmentDataBookingKelasBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataBookingKelasFragment : Fragment() {
    private var _binding: FragmentDataBookingKelasBinding? = null
    private val binding get() = _binding!!
    private val listBookingKelas = ArrayList<BookingKelas>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDataBookingKelasBinding.inflate(inflater, container, false)
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
        val call: Call<ResponseCreateBookingKelas> = RClientBookingKelas.apiService.getDataBooking(value)
        call?.enqueue(object : Callback<ResponseCreateBookingKelas> {
            override fun onResponse(call: Call<ResponseCreateBookingKelas>, response: Response<ResponseCreateBookingKelas>) {
                if (response.isSuccessful){
                    listBookingKelas.clear()
                    response.body()?.let {
                        listBookingKelas.addAll(it.data)
                    }
                    val adapter = BookingKelasAdapter(listBookingKelas, requireContext(),nama.toString()
                    )
                    binding.rvData.adapter = adapter
                    adapter.notifyDataSetChanged()
                    binding.progressBar.isVisible = false
                }
            }

            override fun onFailure(call: Call<ResponseCreateBookingKelas>, t: Throwable) {
            }
        })
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}