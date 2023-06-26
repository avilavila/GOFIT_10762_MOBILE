package com.example.gofit_10762

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gofit_10762.Kelas.Kelas
import com.example.gofit_10762.Kelas.RClientKelas
import com.example.gofit_10762.Kelas.ResponseCreateKelas
import com.example.gofit_10762.databinding.FragmentDataPricelistBinding
import com.shashank.sony.fancytoastlib.FancyToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Suppress("UNREACHABLE_CODE")
class DataPricelistFragment : Fragment() {
    private var _binding: FragmentDataPricelistBinding? = null
    private val binding get() = _binding!!
    private val listPricelist = ArrayList<Kelas>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDataPricelistBinding.inflate(inflater, container, false)
        return binding.root
        getDataKelas()
    }
    override fun onStart() {
        super.onStart()
        getDataKelas()
    }
    private fun getDataKelas() {
        binding.rvData.setHasFixedSize(true)
        binding.rvData.layoutManager= LinearLayoutManager(context)
        val bundle = arguments
        val value = bundle?.getString("idUser")
        val nama = bundle?.getString("nama")
        binding.progressBar.visibility
        val call: Call<ResponseCreateKelas> = RClientKelas.apiService.getKelas()
        call?.enqueue(object : Callback<ResponseCreateKelas> {
            override fun onResponse(call: Call<ResponseCreateKelas>, response: Response<ResponseCreateKelas>) {
                if (response.isSuccessful){
                    listPricelist.clear()
                    response.body()?.let {
                        listPricelist.addAll(it.data)
                    }
                    val adapter = KelasAdapter(listPricelist, requireContext(),nama.toString()
                    )
                    binding.rvData.adapter = adapter
                    adapter.notifyDataSetChanged()
                    binding.progressBar.isVisible = false
                }
            }

            override fun onFailure(call: Call<ResponseCreateKelas>, t: Throwable) {
                FancyToast.makeText(
                    context!!, t.message,
                    FancyToast.LENGTH_LONG,
                    FancyToast.SUCCESS,true).show()
            }
        })
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}