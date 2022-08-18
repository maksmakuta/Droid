package ua.makuta.storylog.fragment.info

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import ua.makuta.storylog.R
import ua.makuta.storylog.Utils.toLog
import ua.makuta.storylog.core.CoreFragment
import ua.makuta.storylog.model.Model

class FInfo : CoreFragment() {

    private lateinit var title  : TextView
    private lateinit var date   : TextView
    private lateinit var api    : TextView
    private lateinit var log    : TextView
    private lateinit var ad     : AdView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        title = view.findViewById(R.id.info_header)
        date = view.findViewById(R.id.info_date)
        api = view.findViewById(R.id.info_api)
        log = view.findViewById(R.id.info_log)
        ad = view.findViewById(R.id.ad_info)

        ad.loadAd(AdRequest.Builder().build())

        val type = requireArguments().getBoolean("type")
        val model : Model = requireArguments().getSerializable("model") as Model

        title.text = os(type) + " " + model.version
        date.text = model.date
        if(type) {
            api.text = model.api.toString()
        }else{
            view.findViewById<TextView>(R.id.view_api).text = "Build"
            api.text = model.codename
        }
        log.text = " - ${model.logs.toLog()}"
    }

    private fun os(type : Boolean) : String{
        return if(type){
            getString(R.string.android)
        }else{
            getString(R.string.ios)
        }
    }

}