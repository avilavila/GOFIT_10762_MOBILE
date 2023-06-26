package com.example.gofit_10762.Member

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gofit_10762.R
import com.example.gofit_10762.User.RClientUser
import com.example.gofit_10762.User.ResponseCreateMember
import com.example.gofit_10762.databinding.FragmentProfilMemberBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfilMemberFragment : Fragment() {
    private var _binding: FragmentProfilMemberBinding? = null
    private val binding get() = _binding!!
    private var idUser: String = ""
    private var nama: String = ""
    private var jabatan: String = ""
    private var username: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val ft = parentFragmentManager.beginTransaction()
        ft.detach(this).attach(this).commit()

        val activity: BerandaMemberActivity? = activity as BerandaMemberActivity?
        _binding = FragmentProfilMemberBinding.inflate(inflater, container, false)
        idUser = activity!!.getIdUser()
        nama = activity!!.getNama()
        jabatan = activity!!.getJabatan()
        username = activity!!.getUsername()
        val call: Call<ResponseCreateMember?>? = RClientUser.apiService.getMember(idUser)
        call?.enqueue(object : Callback<ResponseCreateMember?> {
            override fun onResponse(call: Call<ResponseCreateMember?>, response: Response<ResponseCreateMember?>) {
                if (response.isSuccessful){
                    response.body()?.let {
                        binding.txtNama.setText(it.data.nama_member)
                        binding.txtId.setText(it.data.id_member)
                        binding.txtAlamat.setText(it.data.alamat_member)
                        binding.txtTanggalLahir.setText(it.data.tanggal_lahir_member)
                        binding.txtNoTelp.setText(it.data.telepon_member)
                        binding.txtEmail.setText(it.data.email_member)
                        binding.txtKadaluarsa.setText(it.data.tanggal_kadaluarsa_member)
                        binding.txtDeposit.setText("Rp. " + it.data.saldo_deposit)
                    }
                }
            }

            override fun onFailure(call: Call<ResponseCreateMember?>, t: Throwable) {
            }
        })

        binding.btnPaket.setOnClickListener {
            val intent = Intent(requireActivity(), ListPaketActivity::class.java)
            intent.putExtra("idUser", idUser)
            intent.putExtra("nama", nama)
            intent.putExtra("jabatan", jabatan)
            intent.putExtra("username", username)
            startActivity(intent)
        }

        binding.btnHistoriGym.setOnClickListener {
            val intent = Intent(requireActivity(), HistoriGymActivity::class.java)
            intent.putExtra("idUser", idUser)
            intent.putExtra("nama", nama)
            intent.putExtra("jabatan", jabatan)
            intent.putExtra("username", username)
            startActivity(intent)
        }

        binding.btnHistoriKelas.setOnClickListener {
            val intent = Intent(requireActivity(), HistoriKelasActivity::class.java)
            intent.putExtra("idUser", idUser)
            intent.putExtra("nama", nama)
            intent.putExtra("jabatan", jabatan)
            intent.putExtra("username", username)
            startActivity(intent)
        }

        return binding.root
    }
}