package com.example.gofit_10762.ManajerOperasional

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gofit_10762.JadwalHarian.ResponseCreateJadwalHarian
import com.example.gofit_10762.PresensiInstruktur.RClientPresensiInstruktur
import com.example.gofit_10762.R
import com.example.gofit_10762.databinding.FragmentDataPresensiInstrukturBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataPresensiInstrukturFragment : Fragment() {
    private var _binding: FragmentDataPresensiInstrukturBinding? = null
    private val binding get() = _binding!!
    private val listJadwalHarian = ArrayList<com.example.gofit_10762.PresensiInstruktur.JadwalHarian>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDataPresensiInstrukturBinding.inflate(inflater, container, false)
        return binding.root
        getDataIzin()
    }
    override fun onStart() {
        super.onStart()
        getDataIzin()
    }
    private fun getDataIzin() {
        binding.rvData.setHasFixedSize(true)
        binding.rvData.layoutManager= LinearLayoutManager(context)
        val bundle = arguments
        val value = bundle?.getString("idUser")
        val nama = bundle?.getString("nama")
        binding.progressBar.visibility
        val call: Call<com.example.gofit_10762.PresensiInstruktur.ResponseCreateJadwalHarian>? = RClientPresensiInstruktur.apiService.getData("blank")
        call?.enqueue(object :
            Callback<com.example.gofit_10762.PresensiInstruktur.ResponseCreateJadwalHarian> {
            override fun onResponse(call: Call<com.example.gofit_10762.PresensiInstruktur.ResponseCreateJadwalHarian>, response: Response<com.example.gofit_10762.PresensiInstruktur.ResponseCreateJadwalHarian>) {
                if (response.isSuccessful){
                    listJadwalHarian.clear()
                    response.body()?.let {
                        listJadwalHarian.addAll(it.data)
                    }
                    val adapter = PresensiInstrukturAdapter(listJadwalHarian, requireContext(),nama.toString()
                    )
                    binding.rvData.adapter = adapter
                    adapter.notifyDataSetChanged()
                    binding.progressBar.isVisible = false
                }
            }

            override fun onFailure(call: Call<com.example.gofit_10762.PresensiInstruktur.ResponseCreateJadwalHarian>, t: Throwable) {
            }
        })
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}