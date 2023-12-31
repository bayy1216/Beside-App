package com.beside.hackathon.data.api

import com.beside.hackathon.data.model.cardnews.CardNewsUrls
import com.beside.hackathon.data.model.cardnews.SummaryUrls
import com.beside.hackathon.data.model.common.OffsetPagination
import com.beside.hackathon.data.model.home.SchoolRanking
import com.beside.hackathon.data.model.home.TotalRanking
import com.beside.hackathon.data.model.home.UserProfile
import com.beside.hackathon.data.model.quiz.Quiz
import com.beside.hackathon.data.model.quiz.QuizSubmitRequest
import com.beside.hackathon.data.model.quiz.QuizSubmitResponse
import com.beside.hackathon.data.model.quizhistory.CorrectQuiz
import com.beside.hackathon.data.model.quizhistory.QuizHistory
import com.beside.hackathon.data.model.record.CardNewsRecord
import com.beside.hackathon.data.model.record.SummaryRecord
import com.beside.hackathon.data.model.user.JwtToken
import com.beside.hackathon.data.model.user.LoginRequest
import com.beside.hackathon.data.model.user.SignUpRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {


    @GET("/quiz/today")
    suspend fun getTodayQuiz(): Quiz

    @POST("/quiz/submit")
    suspend fun submitQuiz(@Body quizSubmitRequest: QuizSubmitRequest): QuizSubmitResponse

    @GET("/quiz/{quizId}")
    suspend fun getCorrectQuiz(@Path("quizId") quizId: Long): CorrectQuiz

    @GET("/cardnews/today")
    suspend fun getTodayCardNews(): CardNewsUrls
    @GET("/summary/today")
    suspend fun getTodaySummary(): SummaryUrls

    @GET("/profile")
    suspend fun getProfile(): UserProfile

    @GET("/rank/total")
    suspend fun getTotalRanking(
        @Query("interest") interest: String
    ): TotalRanking

    @GET("/rank/school")
    suspend fun getSchoolRanking(
        @Query("interest") interest: String
    ): SchoolRanking

    @GET("/record/quiz")
    suspend fun getQuizHistory(
        @Query("pageNum") page: Int,
    ): OffsetPagination<QuizHistory>







    //로그인&회원가입
    @POST("/users")
    @Headers("Auth: false")
    suspend fun signUp(@Body() signUpRequest: SignUpRequest)

    @POST("/login/form")
    @Headers("Auth: false")
    suspend fun login(@Body() loginRequest: LoginRequest) : JwtToken

    @GET("/users/account-name")
    @Headers("Auth: false")
    suspend fun idValidation(@Query("account") account:String):Boolean

    @GET("/users/nickname")
    @Headers("Auth: false")
    suspend fun nicknameValidation(@Query("nickname") nickname:String):Boolean



    //
    @GET("/record/cardnews")
    suspend fun getCardNewsRecord(@Query("pageNum") page: Int): OffsetPagination<CardNewsRecord>

    @GET("/record/summaries")
    suspend fun getSummariesRecord(@Query("pageNum") page: Int): OffsetPagination<SummaryRecord>


}