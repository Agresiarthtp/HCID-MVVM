package com.kotlin.homecreditindonesia.viewmodel

import android.view.View
import androidx.databinding.ObservableInt
import androidx.lifecycle.MutableLiveData
import com.kotlin.homecreditindonesia.entity.*
import com.kotlin.homecreditindonesia.network.RestApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : BaseViewModel() {
    lateinit var isLoading: ObservableInt
    var mLiveDataProduct = MutableLiveData<List<ItemsItemProduct?>>()
    var mLiveDataArticle = MutableLiveData<List<ItemsItemArticle?>>()

    private fun setLoading(isTrue: Boolean) {
        isLoading = if (isTrue) {
            ObservableInt(View.VISIBLE)
        } else {
            ObservableInt(View.GONE)
        }
        notifyChange()
    }

    fun initData(api: RestApi) {
        getData(api)
    }

    private fun getData(api: RestApi) {
        setLoading(true)
        val mCallProduct = api.getDataProduct()
        val mCallArticle = api.getDataArticle()

        mCallProduct.enqueue(object : Callback<ResponseProduct> {
            override fun onFailure(call: Call<ResponseProduct>, t: Throwable) {
                setLoading(false)
            }

            override fun onResponse(
                call: Call<ResponseProduct>,
                response: Response<ResponseProduct>
            ) {
                response.body()?.data.let {
                    if (it?.get(0)?.section.equals("products")) {
                        mLiveDataProduct.postValue(response.body()?.data?.get(0)?.items)
                    } else {
                        mLiveDataProduct.postValue(response.body()?.data?.get(1)?.items)
                    }
                }
                setLoading(false)
            }

        })

        mCallArticle.enqueue(object : Callback<ResponseArticle> {
            override fun onFailure(call: Call<ResponseArticle>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<ResponseArticle>,
                response: Response<ResponseArticle>
            ) {
                response.body()?.data.let {
                    if (it?.get(0)?.section.equals("articles")) {
                        mLiveDataArticle.postValue(response.body()?.data?.get(0)?.items)
                    } else {
                        mLiveDataArticle.postValue(response.body()?.data?.get(1)?.items)
                    }
                }
            }

        })
    }
}