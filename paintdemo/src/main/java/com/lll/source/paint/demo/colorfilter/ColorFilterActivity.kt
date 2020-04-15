package com.lll.source.paint.demo.colorfilter

import android.os.Bundle
import android.util.Pair
import androidx.appcompat.app.AppCompatActivity
import com.lll.source.paint.demo.databinding.ActivityColorFilterBinding
import com.lll.source.paint.demo.utils.ColorFilter

class ColorFilterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityColorFilterBinding

    private val filters: MutableList<Pair<String, FloatArray>> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityColorFilterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        filters.add(Pair<String, FloatArray>("黑白", ColorFilter.colormatrix_heibai))
        filters.add(Pair<String, FloatArray>("复古", ColorFilter.colormatrix_fugu))
        filters.add(Pair<String, FloatArray>("哥特", ColorFilter.colormatrix_gete))
        filters.add(Pair<String, FloatArray>("传统", ColorFilter.colormatrix_chuan_tong))
        filters.add(Pair<String, FloatArray>("淡雅", ColorFilter.colormatrix_danya))
        filters.add(Pair<String, FloatArray>("光晕", ColorFilter.colormatrix_guangyun))
        filters.add(Pair<String, FloatArray>("胶片", ColorFilter.colormatrix_fanse))
        filters.add(Pair<String, FloatArray>("褐片", ColorFilter.colormatrix_hepian))
        filters.add(Pair<String, FloatArray>("怀旧", ColorFilter.colormatrix_huaijiu))
        filters.add(Pair<String, FloatArray>("胶片2", ColorFilter.colormatrix_jiao_pian))
        filters.add(Pair<String, FloatArray>("蓝调", ColorFilter.colormatrix_landiao))
        filters.add(Pair<String, FloatArray>("浪漫", ColorFilter.colormatrix_langman))
        filters.add(Pair<String, FloatArray>("锐色", ColorFilter.colormatrix_ruise))
        filters.add(Pair<String, FloatArray>("梦幻", ColorFilter.colormatrix_menghuan))
        filters.add(Pair<String, FloatArray>("清宁", ColorFilter.colormatrix_qingning))
        filters.add(Pair<String, FloatArray>("夜色", ColorFilter.colormatrix_yese))
        binding.recycler.adapter = ColorFilterAdapter(layoutInflater, filters)
    }

}