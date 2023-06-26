package com.example.gofit_10762.Instruktur

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gofit_10762.PresensiInstruktur.HistoriInstruktur
import com.example.gofit_10762.PresensiInstruktur.RClientPresensiInstruktur
import com.example.gofit_10762.PresensiInstruktur.ResponseHistoriInstruktur
import com.example.gofit_10762.R
import com.example.gofit_10762.databinding.FragmentDataHistoriInstrukturBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Suppress("UNREACHABLE_CODE")
class DataHistoriInstrukturFragment : Fragment() {
    private var _binding: FragmentDataHistoriInstrukturBinding? = null
    private val binding get() = _binding!!
    private val listHistori = ArrayList<HistoriInstruktur>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDataHistoriInstrukturBinding.inflate(inflater, container, false)
        return binding.root
        getDataHistori()
    }
    override fun onStart() {
        super.onStart()
        getDataHistori()
    }
    private fun getDataHistori() {
        binding.rvData.setHasFixedSize(true)
        binding.rvData.layoutManager= LinearLayoutManager(context)
        val bundle = arguments
        val value = bundle?.getString("idUser")
        val nama = bundle?.getString("nama")
        binding.progressBar.visibility
        val call: Call<ResponseHistoriInstruktur>? = RClientPresensiInstruktur.apiService.getHistori(
            value!!
        )
        call?.enqueue(object : Callback<ResponseHistoriInstruktur> {
            override fun onResponse(call: Call<ResponseHistoriInstruktur>, response: Response<ResponseHistoriInstruktur>) {
                if (response.isSuccessful){
                    listHistori.clear()
                    response.body()?.let {
                        listHistori.addAll(it.data)
                    }
                    val adapter = HistoriInstrukturAdapter(listHistori, requireContext(),nama.toString()
                    )
                    binding.rvData.adapter = adapter
                    adapter.notifyDataSetChanged()
                    binding.progressBar.isVisible = false
                }
            }

            override fun onFailure(call: Call<ResponseHistoriInstruktur>, t: Throwable) {
            }
        })
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}