//package com.example.mycapstone.reward.viewmodel
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import com.example.mycapstone.data.remote.retrofit.ApiConfig
//import com.example.mycapstone.data.remote.response.ClaimRewardResponse
//import com.example.mycapstone.data.remote.response.RewardListResponse
//import com.example.mycapstone.data.remote.response.UpdateRewardBalanceResponse
//import com.example.mycapstone.reward.db.Reward
//import com.example.mycapstone.reward.db.WasteItem
//import com.example.mycapstone.reward.repository.WasteRepository
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//
//class WasteViewModel: ViewModel() {
//    private val repository = WasteRepository()
//
//    private val _wasteHistory = MutableLiveData<List<WasteItem>>()
//    val wasteHistory: LiveData<List<WasteItem>> get() = _wasteHistory
//
////    private val _rewards = rewards
////    val rewards : LiveData<Call<RewardListResponse>> get() = _rewards
//
//    private val _ecoFriendlyRewards = MutableLiveData<List<Reward>>()
//    val ecoFriendlyRewards: LiveData<List<Reward>> get() = _ecoFriendlyRewards
//
//    // reward update
//    private val _totalPoints = MutableLiveData<Int>()
//    val totalPoints: LiveData<Int> get() = _totalPoints
//
//    private val _claimableRewards = MutableLiveData<List<Reward>>()
//    val claimableRewards: LiveData<List<Reward>> get() = _claimableRewards
//
//    private val _apiResponse = MutableLiveData<String>()
//    val apiResponse: LiveData<String> get() = _apiResponse
//
//    fun loadWasteHistory(){
//        _wasteHistory.value = repository.getWasteHistory()
//    }
//
//    fun getRewards(rewards: String){
//        val client = ApiConfig.getApiService().getRewards(rewards)
//        client.enqueue(object : Callback<RewardListResponse> {
//            override fun onResponse(
//                call: Call<RewardListResponse>,
//                response: Response<RewardListResponse>
//            ) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onFailure(call: Call<RewardListResponse>, t: Throwable) {
//                TODO("Not yet implemented")
//            }
//
//        })
//    }
//
//    fun loadEcoFriendlyRewards(){
//        _ecoFriendlyRewards.value = repository.getEcoFriendly()
//    }
//
//    fun addWasteItem(wasteItem: WasteItem){
//        repository.addWasteItem(wasteItem)
//        loadWasteHistory()
//    }
//
//    fun updateTotalPoints(token: String, points: Int){
//        ApiConfig.getApiService().updateRewardBalance(token, points).enqueue(object : Callback<UpdateRewardBalanceResponse> {
//            override fun onResponse(
//                call: Call<UpdateRewardBalanceResponse>,
//                response: Response<UpdateRewardBalanceResponse>
//            ) {
//                if (response.isSuccessful){
//                    _totalPoints.value = response.body()?.rewards_balance
//                    _apiResponse.value = response.body()?.message
//                }else{
//                    _apiResponse.value = "Error: ${response.body()?.toString()}"
//                }
//            }
//
//            override fun onFailure(call: Call<UpdateRewardBalanceResponse>, t: Throwable) {
//                _apiResponse.value = "Failure: ${t.message}"
//            }
//
//        })
//    }
//
//    fun claimReward(rewardId: String) {
//        ApiConfig.getApiService().claimReward(rewardId).enqueue(object : Callback<ClaimRewardResponse> {
//            override fun onResponse(call: Call<ClaimRewardResponse>, response: Response<ClaimRewardResponse>) {
//                if (response.isSuccessful) {
//                    _apiResponse.value = response.body()?.message
//                } else {
//                    _apiResponse.value = "Error: ${response.errorBody()?.string()}"
//                }
//            }
//
//            override fun onFailure(call: Call<ClaimRewardResponse>, t: Throwable) {
//                _apiResponse.value = "Failure: ${t.message}"
//            }
//        })
//    }
//
//    fun loadClaimableRewards(point: Int){
//        _claimableRewards.value = repository.getRewards().filter { it.pointRequired <= point }
//    }
//}