package com.fpttelecom.train.android.view.sample_view

import androidx.fragment.app.viewModels
import com.fpttelecom.train.android.api.RequestState
import com.fpttelecom.train.android.api.UiState
import com.fpttelecom.train.android.base.BaseFragment
import com.fpttelecom.train.android.databinding.FragmentSampleBinding
import com.fpttelecom.train.android.extensions.handleStateFlow
import com.fpttelecom.train.android.extensions.initLaunch
import com.fpttelecom.train.android.extensions.launchWhenCreated
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class SampleFragment : BaseFragment<FragmentSampleBinding>() {

    private val viewModel by viewModels<SampleViewModel>()

    override fun getViewBinding() = FragmentSampleBinding.inflate(layoutInflater)

    override fun initViewModel() {
        //Setup fields
        launchWhenCreated {

        }
        initLaunch({
            viewModel.uiStateSample.collect {
                handleStateFlow(it,
                    { getVB().tvSample.text = "Update text SUCCESS with viewmodel 456" },
                    { getVB().tvSample.text = "Update text ERROR with viewmodel 123" })
            }
        },{
            viewModel.isLoading.collect {

            }
        })



        viewModel.getSomething()
    }

//    private fun handleStateSample(uiState: UiState<Any>) {
//        when (uiState.state) {
//            RequestState.SUCCESS -> {
//                getVB().tvSample.text = "Update text SUCCESS with viewmodel"
//            }
//            RequestState.ERROR -> {
//                getVB().tvSample.text = "Update text ERROR with viewmodel"
//            }
//            RequestState.NON -> {
//                getVB().tvSample.text = "Update text NON with viewmodel"
//            }
//        }
//    }

    override fun initView() {
        getVB().tvSample.text = "Update text with ViewBinding"
    }

    override fun clickView() {

    }

    override fun flowOnce() {

    }

    override fun onComeBack() {

    }
}