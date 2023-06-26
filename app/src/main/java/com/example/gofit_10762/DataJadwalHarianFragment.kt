package com.example.gofit_10762

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gofit_10762.JadwalHarian.JadwalHarian
import com.example.gofit_10762.JadwalHarian.RClientJadwalHarian
import com.example.gofit_10762.JadwalHarian.ResponseCreateJadwalHarian
import com.example.gofit_10762.Kelas.Kelas
import com.example.gofit_10762.Kelas.RClientKelas
import com.example.gofit_10762.databinding.FragmentDataJadwalHarianBinding
import com.shashank.sony.fancytoastlib.FancyToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Suppress("UNREACHABLE_CODE")
class DataJadwalHarianFragment : Fragment() {
    private var _binding: FragmentDataJadwalHarianBinding? = null
    private val binding get() = _binding!!
    private val listJadwalHarian = ArrayList<JadwalHarian>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDataJadwalHarianBinding.inflate(inflater, container, false)
        return binding.root
        getDataJadwalHarian()
    }
    override fun onStart() {
        super.onStart()
        getDataJadwalHarian()
    }
    private fun getDataJadwalHarian() {
        binding.rvData.setHasFixedSize(true)
        binding.rvData.layoutManager= LinearLayoutManager(context)
        val bundle = arguments
        val value = bundle?.getString("idUser")
        val nama = bundle?.getString("nama")
        binding.progressBar.visibility
        val call: Call<ResponseCreateJadwalHarian> = RClientJadwalHarian.apiService.getJadwalHarian()
        call?.enqueue(object : Callback<ResponseCreateJadwalHarian> {
            override fun onResponse(call: Call<ResponseCreateJadwalHarian>, response: Response<ResponseCreateJadwalHarian>) {
                if (response.isSuccessful){
                    listJadwalHarian.clear()
                    response.body()?.let {
                        listJadwalHarian.addAll(it.data)
                    }
                    val adapter = JadwalHarianAdapter(listJadwalHarian, requireContext(),nama.toString()
                    )
                    binding.rvData.adapter = adapter
                    adapter.notifyDataSetChanged()
                    binding.progressBar.isVisible = false
                }
            }

            override fun onFailure(call: Call<ResponseCreateJadwalHarian>, t: Throwable) {
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