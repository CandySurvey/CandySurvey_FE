package com.flatwater.candysurvey.produce

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.flatwater.candysurvey.MainActivity
import com.flatwater.candysurvey.R
import com.flatwater.candysurvey.adapter.CommonAdapter
import com.flatwater.candysurvey.databinding.ActivityProduceBinding
import com.flatwater.candysurvey.jsondata.*
import com.flatwater.candysurvey.setting.MyPageActivity
import com.flatwater.candysurvey.templatedata.CommonItem
import com.flatwater.candysurvey.templatedata.viewobject.*
import com.flatwater.candysurvey.viewModel.SurveyDataViewModel
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ProduceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProduceBinding

    private val dataSet = ArrayList<CommonItem>()

    // 설문 제목 초기화 선언 (지역함수에서 사용해야 하니까!)
    private var surveyTitle : String? = null

    // Json Data 입력 초기화 설정
    private var item : Items = Items("")
    private var question : Question = Question("", "", "", listOf(item))
    private var questions : Questions = Questions(listOf(question))
    private var survey : Survey = Survey("", "", questions)
    private var surveyJson : SurveyDataModel = SurveyDataModel(survey)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_produce)

        // MainActivity에서 SurveyTitle Data 받아오는 코드
        surveyTitle = intent.getStringExtra("surveyTitle")
        binding.surveyTitle.text = surveyTitle

        // 뒤로가기 버튼 연결
        binding.closeBtn.setOnClickListener{
            showBackDialog()
        }

        // 메인페이지 네비게이션 연결
        binding.navigateMainPage.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        // 마이페이지 네비게이션 연결
        binding.navigateMyPage.setOnClickListener {
            val intent = Intent(this, MyPageActivity::class.java)
            startActivity(intent)
            finish()
        }

        // 초기 제목 템플릿 자동으로 연결
        val rv_default = findViewById<RecyclerView>(R.id.surveyArea)
        dataSet.add(CommonItem("TITLE", TitleViewObject(null, null)))

        val adapter = CommonAdapter(dataSet)
        adapter.notifyDataSetChanged()

        rv_default.adapter = adapter
        rv_default.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        // 템플릿 다이얼로그 연결
        val menuDialog = MenuDialog(this)
        binding.plusBtn.setOnClickListener {
            menuDialog.showDialog()

            // questionType에 따라서 다른 Recyclerview 랜더링 해야함!
            menuDialog.setOnClickedListener(object : MenuDialog.ButtonClickListener{
                override fun onClicked(questionType : String) {
                    when(questionType){
                        "TITLE" -> {
                            dataSet.add(CommonItem(questionType, TitleViewObject(null, null)))
//                            Log.d("Json Data", "${dataSet[0]}")
                            adapter.notifyDataSetChanged()

                        }
                        "CONTOUR" -> Log.d("JSON Data", "구분선 템플릿 호출!")
                        "SHORT_ANS" -> {
                            dataSet.add(CommonItem(questionType, ShortAnswerViewObject(null)))
                            adapter.notifyDataSetChanged()
                        }
                        "LONG_ANS" -> {
                            dataSet.add(CommonItem(questionType, LongAnswerViewObject(null)))
                            adapter.notifyDataSetChanged()
                        }
                        "OPTIONAL" -> {
                            dataSet.add(CommonItem(questionType, OptionalViewObject(null)))
                            adapter.notifyDataSetChanged()
                        }
                        "DROPDOWN" -> {
                            dataSet.add(CommonItem(questionType, DropdownViewObject(null)))
                            adapter.notifyDataSetChanged()
                        }
                    }
                }
            })
        }

        // 저장 버튼 연결
        binding.saveBtn.setOnClickListener {
            showSaveDialog()
            adapter.notifyDataSetChanged()

            for(i in 0..(dataSet.size-1) ){

                Log.d("Json Data", "${dataSet[i]}")

                // CommonItem으로 접근하여 데이터 분리해서 SurveyDataModel에 연결하는 코드가 들어가야함!
                when(dataSet[i].questionType) {
                    "TITLE" -> {
                        Log.d("JSON Data", "제목 템플릿입니다!")
//                        Log.d("JSON Data", "${dataSet[i].questionObject}")
                    }
                    "CONTOUR" -> {
                        Log.d("JSON Data", "구분선 템플릿입니다!")
                    }
                    "SHORT_ANS" -> {
                        Log.d("JSON Data", "단답형 템플릿입니다!")
                    }
                    "LONG_ANS" -> {
                        Log.d("JSON Data", "장문형 템플릿입니다!")
                    }
                    "OPTIONAL" -> {
                        Log.d("JSON Data", "객관식 템플릿입니다!")
                    }
                    "DROPDOWN" -> {
                        Log.d("JSON Data", "드롭다운 템플릿입니다!")
                    }
                }
            }
        }

        // 공유하기 버튼 연결
        binding.shareBtn.setOnClickListener {
            // 공유하기 템플릿 만드는 로직이 들어가야 합니다.
            Toast.makeText(this, "공유하기 템플릿 띄워야함..", Toast.LENGTH_SHORT).show()
        }

        // 샘플 Json Data 설정 코드 (Retrofit2 적용해야함)
        item = Items("")
        question = Question("Title", "첫번째 설문입니다!", "", listOf(item))
        questions = Questions(listOf(question))
        Log.d("JSON Data", "$questions")

        survey = Survey("$surveyTitle", "첫번째 문제입니다!", questions)
        surveyJson = SurveyDataModel(survey)
        val surveyJsonData = Json.encodeToString(surveyJson)
        Log.d("JSON Data", surveyJsonData)

        // ViewModel 선언 & POST Request Test Code
        val viewModel = ViewModelProvider(this).get(SurveyDataViewModel::class.java)
        viewModel.requestPost()

    }

    // 저장 버튼 터치시 나타다는 다이얼로그
    private fun showSaveDialog(){

        val saveDialogView = LayoutInflater.from(this).inflate(R.layout.save_check_dialog, null)
        val saveBuilder = AlertDialog.Builder(this)
            .setView(saveDialogView)

        val alertSaveDialog = saveBuilder.show()

        alertSaveDialog.findViewById<Button>(R.id.yesBtn)?.setOnClickListener {
            Toast.makeText(this,"저장되었습니다!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        alertSaveDialog.findViewById<Button>(R.id.noBtn)?.setOnClickListener {
            // 원래 작업하던 페이지로 돌아가게 구현해야함!
            Toast.makeText(this,"원래대로 돌아갑니다!", Toast.LENGTH_SHORT).show()
            alertSaveDialog.dismiss()
        }
    }

    // 뒤로가기 버튼 터치시 나타나는 다이얼로그
    private fun showBackDialog(){

        val backDialogView = LayoutInflater.from(this).inflate(R.layout.back_check_dialog, null)
        val backBuilder = AlertDialog.Builder(this)
            .setView(backDialogView)

        val alertBackDialog = backBuilder.show()

        alertBackDialog.findViewById<Button>(R.id.yesBtn)?.setOnClickListener {
            Toast.makeText(this, "저장하지 않고 메인페이지로 되돌아갑니다!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        alertBackDialog.findViewById<Button>(R.id.noBtn)?.setOnClickListener {
            Toast.makeText(this, "다시 작업하던 화면으로 되돌아갑니다!", Toast.LENGTH_SHORT).show()
            alertBackDialog.dismiss()
        }
    }

}