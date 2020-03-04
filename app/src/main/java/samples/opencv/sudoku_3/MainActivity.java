package samples.opencv.sudoku_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

//ボタンのIDは共有できる

public class MainActivity extends AppCompatActivity {

    //アプリ開始
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._0_activity_main);//activity_mainを表示
        //3秒たったら、自動的にホーム画面に飛ばす
        SetSudokuHomeAuto();
    }
    //3秒間、skipボタンを押さなかったら数独ホームに移動する
    private void SetSudokuHomeAuto(){
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                // ここに5秒後に実行したい処理 数独ホームの表示
                setContentView(R.layout._1_sudoku_home);
                SetSudokuDemoTrainOriginal();
            }
        }, 3000);
    }
    //_1_sudoku_homeのボタンによって別のページに行く
    private void SetSudokuDemoTrainOriginal(){
        //sudoku_home内のボタンをクリックしたら移動する
        Button button_sudoku_demo_demo = this.findViewById(R.id.button_sudoku_demo_demo);
        button_sudoku_demo_demo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //クリックしたら飛ぶレイアウトページを選択する
                setContentView(R.layout._2_1_sudoku_demo);
                _1_sudoku_demo();
                BackSudokuHomeFromA(R.id.button_to_sudoku_home_from_demo);
            }
        });
        //sudoku_home内のbutton_sudoku_train_ボタンをクリックしたら移動する
        Button button_sudoku_train_ = this.findViewById(R.id.button_sudoku_train_);
        button_sudoku_train_.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //クリックしたら飛ぶレイアウトページを選択する トレーニング選択肢にいく
                setContentView(R.layout._2_2_sudoku_training_samples);
                _2_sudoku_training_samples();
                BackSudokuHomeFromA(R.id.button_to_sudoku_home_from_demo);
            }
        });
        //sudoku_home内のbutton_sudoku_original_ボタンをクリックしたら移動する
        Button button_sudoku_original_ = this.findViewById(R.id.button_sudoku_original_);
        button_sudoku_original_.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //クリックしたら飛ぶレイアウトページを選択する オリジナル問題にいく
                setContentView(R.layout._2_3_sudoku_original_question);
                //初期化処理が必要
                SS.Button_No_back = 1;//今の値
                _3_sudoku_original();//ただフラグメントを設置しただけ
                BackSudokuHomeFromA(R.id.button_to_sudoku_home_from_demo);
            }
        });
        //sudoku_home内のbutton_sudoku_quiz_ボタンをクリックしたら移動する
        Button button_sudoku_quiz_ = this.findViewById(R.id.button_sudoku_quiz);
        button_sudoku_quiz_.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //クリックしたら飛ぶレイアウトページを選択する オリジナル問題にいく
                setContentView(R.layout._2_4_sudoku_quiz);
                //_3_sudoku_original();
                BackSudokuHomeFromA(R.id.button_to_sudoku_home_from_demo);
            }
        });
        //sudoku_home内のbutton_sudoku_quiz_ボタンをクリックしたら移動する
        Button button_sudoku_profile_ = this.findViewById(R.id.button_sudoku_maker_profile);
        button_sudoku_profile_.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //クリックしたら飛ぶレイアウトページを選択する オリジナル問題にいく
                setContentView(R.layout._2_5_sudoku_maker_profile);
                //_3_sudoku_original();
                BackSudokuHomeFromA(R.id.button_to_sudoku_home_from_demo);
            }
        });
    }

    //数独クラスを定義
    public class_sudoku SS = new class_sudoku();

    /**数独の入力ボタンと解析ボタンの色を反映**/
    public void Input_1(View v) {
        //解析実行ボタン１がtrueだったら、解析ボタンを実行できる
        if(SS.booleans_btn_als_step_[1]){
            //今のボタン
            SS.Button_No_now = 1;
            //前のボタンと一致していなかったら色を変える
            OnBnClickedButtonNoChanger();
            //前のボタンとして保存
            SS.Button_No_back = 1;
        }
    }
    public void Input_2(View v) {
        //解析実行ボタン１がtrueだったら、解析ボタンを実行できる
        if(SS.booleans_btn_als_step_[1]) {
            //今のボタン
            SS.Button_No_now = 2;
            //前のボタンと一致していなかったら色を変える
            OnBnClickedButtonNoChanger();
            //前のボタンとして保存
            SS.Button_No_back = 2;
        }
    }
    public void Input_3(View v) {
        //解析実行ボタン１がtrueだったら、解析ボタンを実行できる
        if(SS.booleans_btn_als_step_[1]) {
            //今のボタン
            SS.Button_No_now = 3;
            //前のボタンと一致していなかったら色を変える
            OnBnClickedButtonNoChanger();
            //前のボタンとして保存
            SS.Button_No_back = 3;
        }
    }
    public void Input_4(View v) {
        //解析実行ボタン１がtrueだったら、解析ボタンを実行できる
        if(SS.booleans_btn_als_step_[1]) {
            //今のボタン
            SS.Button_No_now = 4;
            //前のボタンと一致していなかったら色を変える
            OnBnClickedButtonNoChanger();
            //前のボタンとして保存
            SS.Button_No_back = 4;
        }
    }
    public void Input_5(View v) {
        //解析実行ボタン１がtrueだったら、解析ボタンを実行できる
        if(SS.booleans_btn_als_step_[1]) {
            //今のボタン
            SS.Button_No_now = 5;
            //前のボタンと一致していなかったら色を変える
            OnBnClickedButtonNoChanger();
            //前のボタンとして保存
            SS.Button_No_back = 5;
        }
    }
    public void Input_6(View v) {
        //解析実行ボタン１がtrueだったら、解析ボタンを実行できる
        if(SS.booleans_btn_als_step_[1]) {
            //今のボタン
            SS.Button_No_now = 6;
            //前のボタンと一致していなかったら色を変える
            OnBnClickedButtonNoChanger();
            //前のボタンとして保存
            SS.Button_No_back = 6;
        }
    }
    public void Input_7(View v) {
        //解析実行ボタン１がtrueだったら、解析ボタンを実行できる
        if(SS.booleans_btn_als_step_[1]) {
            //今のボタン
            SS.Button_No_now = 7;
            //前のボタンと一致していなかったら色を変える
            OnBnClickedButtonNoChanger();
            //前のボタンとして保存
            SS.Button_No_back = 7;
        }
    }
    public void Input_8(View v) {
        //解析実行ボタン１がtrueだったら、解析ボタンを実行できる
        if(SS.booleans_btn_als_step_[1]) {
            //今のボタン
            SS.Button_No_now = 8;
            //前のボタンと一致していなかったら色を変える
            OnBnClickedButtonNoChanger();
            //前のボタンとして保存
            SS.Button_No_back = 8;
        }
    }
    public void Input_9(View v) {
        //解析実行ボタン１がtrueだったら、解析ボタンを実行できる
        if(SS.booleans_btn_als_step_[1]) {
            //今のボタン
            SS.Button_No_now =9;
            //前のボタンと一致していなかったら色を変える
            OnBnClickedButtonNoChanger();
            //前のボタンとして保存
            SS.Button_No_back =9;
        }
    }

    /*数独デモの入力*/
    public void demo_input(View v){
        //数独の初期値を代入
        SS.set_demo_input();
        //for文でボタンに数独を
        for (int tate_ = 1; tate_ <= 9; tate_++) {
            for (int yoko_ = 1; yoko_ <= 9; yoko_++) {
                //もし0であったら入力しない
                if (SS.s[tate_][yoko_] != 0) {
                    //初期値の値をボタンに反映
                    Button t = findViewById(SS.button_s[tate_][yoko_]);
                    t.setText(String.valueOf(SS.s[tate_][yoko_]));
                }
            }
        }
    }
    //解析マップを表示
    public void show_rlt_map(int number_) {
        for (int tate_ = 1; tate_ <= 9; tate_++) {
            for (int yoko_ = 1; yoko_ <= 9; yoko_++) {
                //反映させるTextViewを指定
                TextView t = findViewById(SS.tv_rlt_s[tate_][yoko_]);
                //初期化されたnum_workingの値と解析の値が一致していたら空文字
                if(SS.num_working[tate_][yoko_][number_].equals(String.valueOf(number_)))
                {
                    t.setText("");
                }
                else{
                    t.setText(SS.num_working[tate_][yoko_][number_]);
                }
                //指定した数字があると、それは書き残しておく
                if (SS.s[tate_][yoko_] == number_) {
                    t.setText(String.valueOf(SS.s[tate_][yoko_]));
                }
            }
        }
    }
    //解析マップを表示
    public void show_rlt_map_with_specified_number(int number_) {
        for (int tate_ = 1; tate_ <= 9; tate_++) {
            for (int yoko_ = 1; yoko_ <= 9; yoko_++) {
                //反映させるTextViewを指定
                TextView t = findViewById(SS.tv_rlt_s[tate_][yoko_]);
                //解析した文字列を代入
                t.setText(SS.num_working[tate_][yoko_][number_]);
                //指定した数字があると、それは書き残しておく
                if (SS.s[tate_][yoko_] == number_) {
                    t.setTextColor(Color.RED);
                    t.setText(String.valueOf(SS.s[tate_][yoko_]));
                    t.setTextColor(Color.BLACK);
                }
                //初期化されたnum_workingの値と解析の値が一致していたら空文字
                if(SS.num_working[tate_][yoko_][number_].equals("M"))
                {
                    t.setText("確");
                }
            }
        }
    }
    //解析マップを表示
    public void show_rlt_map_with_all_specified_number_() {
        for(int number_ = 1; number_ <= 9; number_++) {
            for (int tate_ = 1; tate_ <= 9; tate_++) {
                for (int yoko_ = 1; yoko_ <= 9; yoko_++) {
                    //反映させるTextViewを指定
                    TextView t = findViewById(SS.tv_rlt_s[tate_][yoko_]);
                    //解析した文字列を代入
                    //t.setText(SS.num_working[tate_][yoko_][number_]);
                    //指定した数字があると、それは書き残しておく
                    if (SS.s[tate_][yoko_] == number_) {
                        t.setTextColor(Color.RED);
                        t.setText(String.valueOf(SS.s[tate_][yoko_]));
                        t.setTextColor(Color.BLACK);
                    }
                    //初期化されたnum_workingの値と解析の値が一致していたら空文字
                    if (SS.num_working[tate_][yoko_][number_].equals("M")) {
                        t.setText("確");
                    }
                }
            }
        }
    }
    //解析マップを初期化して表示
    public void show_rls_map_init(){
        for (int tate_ = 1; tate_ <= 9; tate_++) {
            for (int yoko_ = 1; yoko_ <= 9; yoko_++) {
                //特徴マップ 初期化
                TextView t = findViewById(SS.tv_rlt_s[tate_][yoko_]);
                //文字数字が確定していたら、その値を代入
                if (SS.s[tate_][yoko_] == 0) {
                    t.setText("");
                }
                else{
                    t.setText(String.valueOf(SS.s[tate_][yoko_]));
                }
            }
        }
    }
    //解析結果をテキストに表示
    public void show_als_tv_states(int SS_comment_result_num){
        TextView t = findViewById(R.id.tv_als_states);
        if(SS_comment_result_num > 0){
            t.setText("解析結果　解析できました");
        }
        else{
            t.setText("解析結果　解析できませんでした");
        }
    }

    //解析結果マップに表示
    public void show_sudoku_rlt_table(){
        for (int tate_ = 1; tate_ <= 9; tate_++) {
            for (int yoko_ = 1; yoko_ <= 9; yoko_++) {
                //初期値の値をテキストに反映
                TextView t = findViewById(SS.tv_rlt_s[tate_][yoko_]);
                //数独の数値が0だったら入力文字列を空("")にする
                if (SS.s[tate_][yoko_] == 0) {
                    t.setText("");
                }
                else{
                    t.setText(String.valueOf(SS.s[tate_][yoko_]));
                }
            }
        }
    }


    //ここで数独内での数字で全て使われたらボタンに数字を消す
    public void delete_button_number_name(){
        for (int number_ = 1; number_ <= 9; number_++) {
            //消去する番号のカウンター
            int delete_number_counter = 0;
            //int* intptr = &delete_number_counter;
            for (int tate_ = 1; tate_ <= 9; tate_++) {
                for (int yoko_ = 1; yoko_ <= 9; yoko_++) {
                    //番号と数字が一致した回数
                    if (SS.s[tate_][yoko_] == number_) {
                        delete_number_counter++;
                    }
                }
            }
            //数字のカウンターが9個だったら、ボタンの文字を消す
            if (delete_number_counter == 9) {
                //解析数字ボタンを指定
                Button btn = findViewById(SS.input_number[number_]);
                btn.setText("");//空文字を入力
                //ボタンを消去するようにうごく
                SS.delete_btn_number[number_] = true;
            }
        }
    }



    //1~9までのボタンの簡単処理をまとめる
    public void btn_number_1_9_easy(View v) {
        for (int time_ = 1; time_ <= 10; time_++) {
            for (int number_ = 1; number_ <= 9; number_++) {//1~9

                SS._1_initialize();
                SS._2_1_Nth_0_1_checker_1_TEISU(number_);
                SS._2_2_Nth_0_1_checker_2_area_3_3(number_);
                SS._2_3_Nth_0_1_checker_3_row_col_3_3(number_);
                SS._2_4_special_delete_ver2(number_);
                SS._2_5_change_1_to_number_in_3_3_blocks(number_);

            }
        }
        show_rls_map_init();
    }


    //トレーニング問題
    public void btn_trn_1(View v) {
        /**前半**/
        //数独の初期値を代入
        SS.set_demo_input_1();
        /**後半**/
        //数独の解析マップの初期化をする
        SS.Button_No_back = 1;//今の値
        setContentView(R.layout._3_1_1_demo_result_demo);//クリックしたら飛ぶレイアウトページを選択する
        fgm_sudoku_rlt_map_demo_demo_();//解析結果マップ
        fgm_sudoku_input_table_3_3_();//3*3インプット数独表
        fgm_sudoku_analysis_step_demo();//解析手順　ただの解析ボタンの状態

        //解析手順をクリックしては消してという、フラグメントオブフラグメントの処理をする
        //1つ目のボタンを表示
        fgm_sudoku_view_step_1_();

        //3秒間、skipボタンを押さなかったら数独ホームに移動する
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                // ここに5秒後に実行したい処理 数独ホームの表示
                //数独の解析テキストにマルチスレッドで書き込んでいる
                for (int tate_1 = 1; tate_1 <= 9; tate_1++) {
                    for (int yoko_1 = 1; yoko_1 <= 9; yoko_1++) {
                        //もし0であったら入力しない
                        if (SS.s[tate_1][yoko_1] != 0) {
                            //初期値の値をテキストに反映
                            TextView t = findViewById(SS.tv_rlt_s[tate_1][yoko_1]);
                            t.setText(String.valueOf(SS.s[tate_1][yoko_1]));
                            //初期化する
                            //●初期値
                            SS._1_initialize();
                        }
                    }
                }
                //数独の解析マップの初期化をする
                SS.Button_No_back = 1;//今の値
            }
        }, 2000);
    }


    //数独オリジナル用の入力ボタン
    public void OnBnClickedButtonNoChanger() {
        Button btn_set_now = findViewById(SS.input_number[SS.Button_No_now]);//今のボタン
        Button btn_set_back = findViewById(SS.input_number[SS.Button_No_back]);//前のボタン
        //今の値と前の値が一致しなかったら、
        if (SS.Button_No_back != SS.Button_No_now) {
            //前のボタンの名前も変更する button_rectangle_cyan
            //リソースから作成したDrawableのリソースを取得
            Drawable btn_clr_now = ResourcesCompat.getDrawable(getResources(), R.drawable.btn_rtgl_green_yellow, null);
            //ボタンにDrawableを適用する
            btn_set_back.setBackground(btn_clr_now);
            //今のボタンの名前に変更すし、前のボタンの名前も変更する
            //リソースから作成したDrawableのリソースを取得
            Drawable btn_color_back = ResourcesCompat.getDrawable(getResources(), R.drawable.btn_rtgl_sky_blue, null);
            //ボタンにDrawableを適用する
            btn_set_now.setBackground(btn_color_back);
        }
    }
    //数独ホームに特定場所から移動
    private void BackSudokuHomeFromA(int A){
        Button button_to_sudoku_home_from_demo = this.findViewById(A);
        button_to_sudoku_home_from_demo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //クリックしたら飛ぶレイアウトページを選択する
                setContentView(R.layout._1_sudoku_home);
                SetSudokuDemoTrainOriginal();//数独ホーム画面に移動する
            }
        });
    }
    //数独トレーニングホームから戻る
    private void _2_sudoku_training_samples() {
//        Button button_to_sudoku_home_from_demo = this.findViewById(R.id.button_to_sudoku_home_from_demo);
//        button_to_sudoku_home_from_demo.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                //クリックしたら飛ぶレイアウトページを選択する
//                setContentView(R.layout._1_sudoku_home);
//                SetSudokuDemoTrainOriginal();//数独ホーム画面に移動する
//            }
//        });
    }
    //数独デモ
    private void _3_sudoku_original(){
        fgm_sudoku_table_();//1
        fgm_sudoku_input_number_();//2
        fgm_sudoku_analysis_states_();//3
    }
    //数独オリジナル
    private void _1_sudoku_demo(){
        fgm_sudoku_table_demo_();//フラグメント1 数独表
        fgm_sudoku_analysis_states_demo_();//フラグメント2 数独の解析ボタン
    }

    //デモ数独のデモの解析結果を示す
    public void lets_analysis_demo(View v){
        //数独の解析マップの初期化をする
        SS.Button_No_back = 1;//今の値
        setContentView(R.layout._3_1_1_demo_result_demo);//クリックしたら飛ぶレイアウトページを選択する
        fgm_sudoku_rlt_map_demo_demo_();//解析結果マップ
        fgm_sudoku_input_table_3_3_();//3*3インプット数独表
        fgm_sudoku_analysis_step_demo();//解析手順　ただの解析ボタンの状態
        //解析手順をクリックしては消してという、フラグメントオブフラグメントの処理をする
        fgm_sudoku_view_step_1_(); //1つ目のボタンを表示
        //3秒間、skipボタンを押さなかったら数独ホームに移動する
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                // ここに5秒後に実行したい処理 数独ホームの表示
                //数独の解析テキストにマルチスレッドで書き込んでいる
                for (int tate_1 = 1; tate_1 <= 9; tate_1++) {
                    for (int yoko_1 = 1; yoko_1 <= 9; yoko_1++) {
                        //もし0であったら入力しない
                        if (SS.s[tate_1][yoko_1] != 0) {
                            //初期値の値をテキストに反映
                            TextView t = findViewById(SS.tv_rlt_s[tate_1][yoko_1]);
                            t.setText(String.valueOf(SS.s[tate_1][yoko_1]));
                            //初期化する
                            SS._1_initialize();
                        }
                    }
                }
                //数独の解析マップの初期化をする
                SS.Button_No_back = 1;//今の値
            }
        }, 2000);
    }

    //そのマスに数字が1,2,3,4,5,6,7,8,9だっらた
    public void btn_special_als(View v){
        SS._1_initialize();//初期化
        for (int number_ = 1; number_ <= 9; number_++) {//1~9
            SS._2_1_Nth_0_1_checker_1_TEISU(number_);
            SS._2_2_Nth_0_1_checker_2_area_3_3(number_);
            SS._2_3_Nth_0_1_checker_3_row_col_3_3(number_);
            SS._2_4_special_delete_ver2(number_);
        }
        SS.decliment_3N_to_2N();
        for (int number_ = 1; number_ <= 9; number_++) {//1~9
            SS._2_5_change_1_to_number_in_3_3_blocks(number_);
        }
        //全体の特徴量マップの中に1があったら定数に変化
        SS.find_1_in_each_f_map();
        //SS.special_special_();//そのマスに数字が1,2,3,4,5,6,7,8,9だっらた
        show_rlt_map_with_all_specified_number_();
    }

    public void btn_als_perfectly(View v) {

    }

    //クリックしたら実行してマルチスレッドで次のボタンを表示させる
    public void als_step_demo_1_(View v) {
        // //指定したボタン数字はいくつなのか	ANALYSIS_Button_No_back
        SS._2_1_Nth_0_1_checker_1_TEISU(SS.Button_No_back);
        //それに対する関数処理をまとめる
        show_rlt_map(SS.Button_No_back);//解析マップを表示
        fgm_sudoku_view_step_2_();//ボタン１のフラグメントをボタン2のフラグメントに置換
    }
    public void als_step_demo_2_(View v) {

        int als_number_ = 2;//ボタン番号
        //3*3エリアにあると表示
        SS._2_2_Nth_0_1_checker_2_area_3_3(SS.Button_No_back);
        show_rlt_map(SS.Button_No_back);//解析マップを表示
        fgm_sudoku_view_step_3_();//ボタン１のフラグメントをボタン2のフラグメントに置換
    }
    public void als_step_demo_3_(View v){
        SS._2_3_Nth_0_1_checker_3_row_col_3_3(SS.Button_No_back);
        show_rlt_map(SS.Button_No_back);//解析マップを表示
        fgm_sudoku_view_step_4_(); //ボタン１のフラグメントをボタン2のフラグメントに置換
    }
    public void als_step_demo_4_(View v){
       //空白のマスに指定した数字が入る候補とする
        show_rlt_map_with_specified_number(SS.Button_No_back);
        fgm_sudoku_view_step_5_();//ボタン１のフラグメントをボタン2のフラグメントに置換
    }
    public void als_step_demo_5_(View v){
        SS._2_4_special_delete_ver2(SS.Button_No_back);
        //空白のマスに指定した数字が入る候補とする
        show_rlt_map_with_specified_number(SS.Button_No_back);
        fgm_sudoku_view_step_6_();//ボタン１のフラグメントをボタン2のフラグメントに置換
    }
    public void als_step_demo_6_(View v){
        //3*3ボックス内に指定数字が1つのみだったら確定
        SS._2_5_change_1_to_number_in_3_3_blocks(SS.Button_No_back);
        //確定した数字があるかどうかを表示
        show_als_tv_states(SS.comment_result_num);
        //数独内での数字で全て使われたらボタンに数字を消す
        delete_button_number_name();
        //空白のマスに指定した数字が入る候補とする
        show_rlt_map_with_specified_number(SS.Button_No_back);
        fgm_sudoku_view_step_7_();//ボタン１のフラグメントをボタン2のフラグメントに置換
    }
    public void als_step_demo_7_(View v){//初期化
        SS._1_initialize();//初期化
        //数独の解析マップ　きれいに初期化する
        show_rls_map_init();
        fgm_sudoku_view_step_1_();//ボタン１のフラグメントをボタン2のフラグメントに置換
    }


    /*********************************画面から元に戻るボタン*******************************/
    public void return_home(View v){
        setContentView(R.layout._1_sudoku_home);
        SetSudokuDemoTrainOriginal();//数独ホーム画面
        SS.sudoku_initialize();//数独初期化
    }
    /*********************************フラグメント****************************************/
    //フラグメント 特徴マップ
    private void fgm_sudoku_input_table_3_3_() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fgm_sudoku_input_table_3_3, new fgm_sudoku_input_table_3_3());
        transaction.commit();//処理実行
    }
    //解析ステップをクリックと同時に遷移
    private void fgm_sudoku_view_step_1_() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fgm_of_fgm_btn_als_step_1, new fgm_sudoku_view_step_1());
        transaction.commit();//処理実行
    }
    private void fgm_sudoku_view_step_2_() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fgm_of_fgm_btn_als_step_1, new fgm_sudoku_view_step_2());
        transaction.commit();//処理実行
    }
    private void fgm_sudoku_view_step_3_() {//同じフラグメントに別のボタンを配置する
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fgm_of_fgm_btn_als_step_1, new fgm_sudoku_view_step_3());
        transaction.commit();//処理実行
    }
    private void fgm_sudoku_view_step_4_() {//同じフラグメントに別のボタンを配置する
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fgm_of_fgm_btn_als_step_1, new fgm_sudoku_view_step_4());
        transaction.commit();//処理実行
    }
    private void fgm_sudoku_view_step_5_() {//同じフラグメントに別のボタンを配置する
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fgm_of_fgm_btn_als_step_1, new fgm_sudoku_view_step_5());
        transaction.commit();//処理実行
    }
    private void fgm_sudoku_view_step_6_() {//同じフラグメントに別のボタンを配置する
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fgm_of_fgm_btn_als_step_1, new fgm_sudoku_view_step_6());
        transaction.commit();//処理実行
    }
    private void fgm_sudoku_view_step_7_() {//同じフラグメントに別のボタンを配置する
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fgm_of_fgm_btn_als_step_1, new fgm_sudoku_view_step_7());
        transaction.commit();//処理実行
    }
    //フラグメント 特徴マップ
    private void fgm_sudoku_analysis_step_demo() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fgm_btn_als_step_demo, new fgm_sudoku_analysis_step_demo());
        transaction.commit();//処理実行
    }
    //フラグメント 特徴マップ
    private void fgm_sudoku_rlt_map_demo_demo_() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_button_sudoku_demo_rlt_map_demo, new fgm_sudoku_rlt_map_demo());
        transaction.commit();//処理実行
    }
    //ボタン数独のフラグメントを作成
    private void fgm_sudoku_table_demo_() {
        Fragment fragment_button_sudoku_demo_demo;//フラグメントのオブジェクト化
        fragment_button_sudoku_demo_demo = new fgm_sudoku_table();//javaクラスから生成させる
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();//FragmentTransactionを生成
        transaction.replace(R.id.fragment_button_sudoku_demo, fragment_button_sudoku_demo_demo);
        transaction.commit();//処理実行
    }
    //ボタン数独のフラグメントを作成
    private void fgm_sudoku_analysis_states_demo_() {
        Fragment fragment_sudoku_analysis_states_demo;//フラグメントのオブジェクト化
        fragment_sudoku_analysis_states_demo = new fgm_sudoku_analysis_states_demo();//javaクラスから生成させる
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();//FragmentTransactionを生成
        transaction.replace(R.id.fragment_button_sudoku_analysis_states_demo, fragment_sudoku_analysis_states_demo);
        transaction.commit();//処理実行
    }
    //ボタン数独のフラグメントを作成
    private void fgm_sudoku_input_number_() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();//FragmentTransactionを生成
        transaction.replace(R.id.fragment_button_sudoku_input, new fgm_sudoku_input_number());//割り当てる
        transaction.commit();//処理実行
    }
    //ボタン数独のフラグメントを作成
    private void fgm_sudoku_analysis_states_() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();//FragmentTransactionを生成
        transaction.replace(R.id.fragment_button_sudoku_analysis_states, new fgm_sudoku_analysis_states());//割り当てる
        transaction.commit();//処理実行
    }
    //ボタン数独のフラグメントを作成
    private void fgm_sudoku_table_() {
        Fragment fgm_sudoku_table_;//フラグメントのオブジェクト化
        fgm_sudoku_table_ = new fgm_sudoku_table();//javaクラスから生成させる
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();//FragmentTransactionを生成
        transaction.replace(R.id.fragment_button_sudoku, fgm_sudoku_table_);//割り当てる
        transaction.commit();//処理実行
    }



}
