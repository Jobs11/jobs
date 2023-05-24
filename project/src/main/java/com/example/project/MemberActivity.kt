package com.example.project

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import com.example.project.databinding.ActivityMemberBinding
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date

class MemberActivity : AppCompatActivity() {
    lateinit var binding: ActivityMemberBinding
    lateinit var filePath: String

    var myDB: DatabaseHelper? = null

    var id1: EditText? = null
    var pw1: EditText? = null
    var pw2: EditText? = null
    var name1: EditText? = null
    var phone1: EditText? = null
    var address1: EditText? = null
    var gender: RadioGroup? = null
    var joinmem: Button? = null
    var memhome: Button? = null
    var chooseGen: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemberBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myDB = DatabaseHelper(this)

        id1 = binding.id1
        pw1 = binding.pw1
        pw2 = binding.pw2
        name1 = binding.name1
        phone1 = binding.phone1
        address1 = binding.address1
        joinmem = binding.joinmem
        memhome = binding.memhome

        AddData()

        binding.gender.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.gender_male -> chooseGen = "남자"
                R.id.gender_female -> chooseGen = "여자"
            }
        }

        binding.memhome.setOnClickListener {
            val intent = Intent(this@MemberActivity, MainActivity::class.java)
            startActivity(intent) //인트로 실행 후 바로 MainActivity로 넘어감.
        }

        val requestGalleryLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult())
        {
            // it -> 사진 데이터
            try {
                //calRatio ->결괏값은 정수인데, 예를들어 4
                // option.inSampleSize = calRatio -> 의미가 , 1/4 비율로 줄인다.
                // 특정 값의 비율을 임의로 정해도 되지만, 특정 사이즈를 요구한 값이 있으면
                // 그 값에 맞추는 함수를 만들었다.  : calculateInSampleSize
                val calRatio = calculateInSampleSize(
                    // 실물의 사진의 높이를  반으로 줄이면서,
                    // inSampleSize 맞춰가는 과정.
                    it.data!!.data!!,
                    // 정적 res -> values -> dimens.xml 특정 크기를 정해서, 재사용했다.
                    // 그냥 하드코딩으로 150dp 주어도 상관 없음.
                    resources.getDimensionPixelSize(R.dimen.imgSize),
                    resources.getDimensionPixelSize(R.dimen.imgSize)
                )
                //BitmapFactory 사진을 읽는 업무, Options()를통해서, 크기를 지정.
                val option = BitmapFactory.Options()
                //
                option.inSampleSize = calRatio

                //inputStream : 사진을 바이트로 읽은 데이터가 있다.
                var inputStream = contentResolver.openInputStream(it.data!!.data!!)
                // 바이트 타입 -> bitmap 타입 형식으로 사진의 타입을 변경.
                // 사진의 결과는 원본 사이즈가 줄어서, bitmap 타입으로 변경 되었다.
                val bitmap = BitmapFactory.decodeStream(inputStream, null, option)
                inputStream!!.close()
                inputStream = null

                bitmap?.let {
                    // 이제 드디어 원하는 사진을 내가 원하는 크기에 맞게끔 할당.
                    //bitmap : 리사이즈가 된 사진이 들어 있다.
                    binding.proimg.setImageBitmap(bitmap)
                } ?: let{
                    Log.d("kkang", "bitmap null")
                }
            }catch (e: Exception){
                e.printStackTrace()
            }
        }

        binding.proimg.setOnClickListener {
            //gallery app........................
            // Intent.ACTION_PICK -> 갤러리 앱 호출, 두번째 매개변수의 타입을 보고 판단.
            // 두번째 매개변수의 타입을 보고 판단. : MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            // 속성의 값은 모든 이미지를 의미, MIMEType
            intent.type = "image/*"
            // 후처리 작업 시작. 현재 액티비티 -> 갤러리 앱 : 사진 선택 -> 현재 액티비티 돌아옴.
            // 위에 정의된 requestGalleryLauncher 코드로 갑니다.
            requestGalleryLauncher.launch(intent)
        }

        val requestCameraFileLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){
            val calRatio = calculateInSampleSize(
                Uri.fromFile(File(filePath)),
                resources.getDimensionPixelSize(R.dimen.imgSize),
                resources.getDimensionPixelSize(R.dimen.imgSize)
            )
            val option = BitmapFactory.Options()
            option.inSampleSize = calRatio
            val bitmap = BitmapFactory.decodeFile(filePath, option)
            bitmap?.let {
                binding.proimg.setImageBitmap(bitmap)
            }
        }


        binding.procam.setOnClickListener {
            //camera app......................
            //파일 준비...............
            val timeStamp: String =
                SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
            val storageDir: File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
            val file = File.createTempFile(
                "JPEG_${timeStamp}_",
                ".jpg",
                storageDir
            )
            filePath = file.absolutePath
            val photoURI: Uri = FileProvider.getUriForFile(
                this,
                "com.example.project.fileprovider",
                file
            )
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            intent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
            requestCameraFileLauncher.launch(intent)

        }

    }
    private fun calculateInSampleSize(fileUri: Uri, reqWidth: Int, reqHeight: Int): Int {
        //options , BitmapFactory 사진을 처리하는 업무, 그런데, Options 가 들어가면
        // 사진 처리 업무보다는 , 관련 옵션을 정한다.
        val options = BitmapFactory.Options()
        // inJustDecodeBounds = true 가되면, 본 업무 말고, 옵션만 처리한다.
        options.inJustDecodeBounds = true
        try {
            //contentResolver.openInputStream 선택된 사진을 바이트로 읽어서 바이트로 반환
            // inputStream: 사진이 바이트 형으로 읽어 놓은 상태.
            var inputStream = contentResolver.openInputStream(fileUri)

            //inJustDecodeBounds 값을 true 로 설정한 상태에서 decodeXXX() 를 호출.
            //로딩 하고자 하는 이미지의 각종 정보가 options 에 설정 된다.
            BitmapFactory.decodeStream(inputStream, null, options)
            inputStream!!.close()
            inputStream = null
        } catch (e: Exception) {
            e.printStackTrace()
        }
        //비율 계산........................
        // 읽은 사진의 가로 세로 정보를 , 재할당 height  width
        val (height: Int, width: Int) = options.run { outHeight to outWidth }
        // 원본 사이즈 그대로 , 즉, 비율이 줄지 않음.
        var inSampleSize = 1
        //inSampleSize 비율 계산
        //height 불러온 원본 사진의 실제 높이,
        // reqHeight : 내가 꾸미는 뷰의 높이 : 150dp
        // 예를들어 : 원본 사진 의 높이 2000
        // 원하는 사이즈 :150
        if (height > reqHeight || width > reqWidth) {

            // 반으로 줄이기.
            val halfHeight: Int = height / 2
            val halfWidth: Int = width / 2

            while (halfHeight / inSampleSize >= reqHeight && halfWidth / inSampleSize >= reqWidth) {
                inSampleSize *= 2
            }
        }
        return inSampleSize
    }

    fun AddData() {
        joinmem!!.setOnClickListener {
            val isInserted = myDB!!.insertData(
                id1!!.text.toString(),
                pw1!!.text.toString(),
                pw2!!.text.toString(),
                name1!!.text.toString(),
                phone1!!.text.toString(),
                address1!!.text.toString(),
                chooseGen!!.toString()
            )
            if (isInserted == true) {
                Toast.makeText(this@MemberActivity, "데이터추가 성공", Toast.LENGTH_LONG)
                    .show()
                val intent = Intent(this@MemberActivity, LoginActivity::class.java)
                startActivity(intent)
            }
            else Toast.makeText(this@MemberActivity, "데이터추가 실패", Toast.LENGTH_LONG).show()
        }
    }
}