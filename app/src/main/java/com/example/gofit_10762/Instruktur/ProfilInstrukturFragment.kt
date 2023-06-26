package com.example.gofit_10762.Instruktur

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gofit_10762.IzinInstruktur.Instruktur
import com.example.gofit_10762.IzinInstruktur.RClientIzinInstruktur
import com.example.gofit_10762.IzinInstruktur.ResponseCreateInstruktur
import com.example.gofit_10762.R
import com.example.gofit_10762.databinding.FragmentProfilInstrukturBinding
import com.shashank.sony.fancytoastlib.FancyToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfilInstrukturFragment : Fragment() {
    private var _binding: FragmentProfilInstrukturBinding? = null
    private val binding get() = _binding!!
    private var idUser: String = ""
    private var nama: String = ""
    private var jabatan: String = ""
    private var username: String = ""
    private val listInstruktur = ArrayList<Instruktur>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val ft = parentFragmentManager.beginTransaction()
        ft.detach(this).attach(this).commit()

        val activity: BerandaInstrukturActivity? = activity as BerandaInstrukturActivity?
        _binding = FragmentProfilInstrukturBinding.inflate(inflater, container, false)
        idUser = activity!!.getIdUser()
        nama = activity!!.getNama()
        jabatan = activity!!.getJabatan()
        username = activity!!.getUsername()

        val call: Call<ResponseCreateInstruktur> = RClientIzinInstruktur.apiService.getInstruktur(idUser)
        call?.enqueue(object : Callback<ResponseCreateInstruktur> {
            override fun onResponse(call: Call<ResponseCreateInstruktur>, response: Response<ResponseCreateInstruktur>) {

                if (response.isSuccessful){
                    response.body()?.let {
                        binding.txtNama.setText(it.data.nama_instruktur)
                        binding.txtId.setText(it.data.id_instruktur)
                        binding.txtAlamat.setText(it.data.alamat_instruktur)
                        binding.txtTanggalLahir.setText(it.data.tanggal_lahir_instruktur)
                        binding.txtNoTelp.setText(it.data.telepon_instruktur)
                        binding.txtEmail.setText(it.data.email_instruktur)
                        binding.txtKeterlambatan.setText(it.data.keterlambatan + " detik")
                    }
                }
            }

            override fun onFailure(call: Call<ResponseCreateInstruktur>, t: Throwable) {
            }
        })

        binding.btnHistoriInstruktur.setOnClickListener {
            val intent = Intent(requireActivity(), HistoriInstrukturActivity::class.java)
            intent.putExtra("idUser", idUser)
            intent.putExtra("nama", nama)
            intent.putExtra("jabatan", jabatan)
            intent.putExtra("username", username)
            startActivity(intent)
        }

        return binding.root
    }
}