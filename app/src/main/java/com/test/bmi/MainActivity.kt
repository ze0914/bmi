import android.R
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    var h //宣告全域變數
            : EditText? = null
    var w //宣告全域變數
            : EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        h = findViewById<View>(R.id.et1) as EditText // 取得身高物件
        w = findViewById<View>(R.id.et2) as EditText // 取得體重物件
        val submit =
            findViewById<View>(R.id.button1) as Button // 取得按鈕物件 如果ID有誤請回到res->Layout查看預設Button是多少

        // 按下按鈕 觸發事件
        submit.setOnClickListener {
            //判斷條件 身高 跟 體重 都有輸入值才執行
            if (!("" == h!!.text.toString() || "" == w!!.text.toString())) {
                var fh = h!!.editableText.toString().toFloat() // 取得 身高輸入值
                val fw = w!!.editableText.toString().toFloat() // 取得 體重輸入值
                val fresult: Float // BMI值 計算結果
                val result =
                    findViewById<View>(R.id.tv3) as TextView // 取得 顯示結果 物件
                fh = fh / 100 // 計算BMI
                fh = fh * fh // 計算BMI
                val nf = NumberFormat.getInstance() // 數字格式
                nf.maximumFractionDigits = 2 // 限制小數第二位
                fresult = fw / fh // 計算BMI
                result.text = nf.format(fw / fh.toDouble()) + "" // 顯示BMI計算結果
                val dia =
                    findViewById<View>(R.id.tv4) as TextView // 取得 顯示診斷 物件

                // 診斷結果 顯示
                if (fresult < 18.5) dia.text =
                    "體重過輕" else if (18.5 <= fresult && fresult < 24) dia.text =
                    "正常範圍" else if (24 <= fresult && fresult < 27) dia.text =
                    "過    重" else if (27 <= fresult && fresult < 30) dia.text =
                    "輕度肥胖" else if (30 <= fresult && fresult < 35) dia.text =
                    "中度肥胖" else if (fresult >= 35) dia.text =
                    "重度肥胖        "
            }
        }
    }
}