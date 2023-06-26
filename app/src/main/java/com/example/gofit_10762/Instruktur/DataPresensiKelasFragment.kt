package com.example.gofit_10762.Instruktur

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
import com.example.gofit_10762.databinding.FragmentDataPresensiKelasBinding
import com.shashank.sony.fancytoastlib.FancyToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Suppress("UNREACHABLE_CODE")
class DataPresensiKelasFragment : Fragment() {
    private var _binding: FragmentDataPresensiKelasBinding? = null
    private val binding get() = _binding!!
    private val listPresensiKelas = ArrayList<BookingKelas>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDataPresensiKelasBinding.inflate(inflater, container, false)
        return binding.root
        getDataBookingPresensi()
    }
    override fun onStart() {
        super.onStart()
        getDataBookingPresensi()
    }
    private fun getDataBookingPresensi() {
        binding.rvData.setHasFixedSize(true)
        binding.rvData.layoutManager= LinearLayoutManager(context)
        val bundle = arguments
        val activity: BerandaInstrukturActivity? = activity as BerandaInstrukturActivity?
        val value = activity!!.getIdUser()
        val nama = bundle?.getString("nama")
        binding.progressBar.visibility
        val call: Call<ResponseCreateBookingKelas> = RClientBookingKelas.apiService.getDataBookingInstruktur(value)
        call?.enqueue(object : Callback<ResponseCreateBookingKelas> {
            override fun onResponse(call: Call<ResponseCreateBookingKelas>, response: Response<ResponseCreateBookingKelas>) {
                if (response.body()!!.stt == false){
                    listPresensiKelas.clear()
                    FancyToast.makeText(
                        activity, response.body()!!.message,
                        FancyToast.LENGTH_LONG,
                        FancyToast.ERROR,true).show()
                } else {
                    listPresensiKelas.clear()
                    response.body()?.let {
                        listPresensiKelas.addAll(it.data)
                    }
                    val adapter = BookingPresensiKelasAdapter(listPresensiKelas, requireContext(),nama.toString()
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