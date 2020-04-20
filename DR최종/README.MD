<!-- Heading -->
# Weather-based clothing recommendations app
# **목차**
 * ##  개요
 * ## 어플소개
    * ### 로고소개
    * ### 스플래쉬
    * ### 인트로화면
 * ## 구현동영상
 * ## 사용도구
 * ## 유사어플 차이점
 * ## 개발 이유
 * ## 세부내용
    * ### 기능소개
      1. 데이터베이스
      2. API(날씨) 및 날씨 적용 방법
      3. 실시간 채팅
      4. 자료수집
      5. 딥러닝
      6. 구글스피치
      7. 언어변경

    

---

# **개요** 
* ### 개발기간  2019.03.06~2019.06.12
* ### 개발목적 : 날씨에 따른 옷 추천 어플 제작
* ### 주요기능 <br>
  * ### 현재 날씨 보기: 내 현재 도시 에 따른 날씨 확인
  * ### 상세 1주일 예보 : 선택한 위치의 1주일 기상예보 및 최저 최고 온도 확인
  * ### 날씨 옷 추천 : 날씨 온도에 따른 국가별 옷 랜덤 추천
  * ### 구글 스피치 : 음성 으로 옷 검색 가능
  * ### 딥러닝 : 카메라로 로고 인식
  * ### 로그인 : 데이터 베이스 이용해서 로그인 및 회원가입 기능 가능
  * ### 즐겨찾기 : 사용자가 마음에드는 옷을 선택하여 추가목록 생성
  * ### 언어 변경 : 한국어,일본어,영어 사용 가능
# **어플소개**
### 이 어플은 날씨API를 이용하여 날씨와 온도를 사용자에게 명시해주며, 그에 맞는 의상을 소개해주는 어플리케이션을 구현하였다.
### 1. 로고 소개
   <br> ![스마트폰 화면](https://user-images.githubusercontent.com/48273829/59201701-f7036300-8bd5-11e9-8316-6e93c4c42d5e.jpg)
   <br>![어플로고](https://user-images.githubusercontent.com/48273829/59193796-cf0a0480-8bc1-11e9-950a-8d351e1bc659.png)<br>
### **DR**[Dull Routine]은 **'지루한 일상'** 이라는 의미로
### 기존의  지루한 일상에서 옷에 새로운 변화를 줌으로서 새로운 <br> 재미를 찾을 수 있는 취지에서 프로그래밍 되었습니다.
### 2. 스플래쉬
![어플 스플래쉬](https://user-images.githubusercontent.com/48273829/59195476-0d55f280-8bc7-11e9-8b87-f2742ca7431b.gif)<br>
### 3. 인트로화면
![KakaoTalk_20190613_123829582](https://user-images.githubusercontent.com/48273803/59402322-c17a9780-8dd8-11e9-8898-8b0d292ecd72.png)
![KakaoTalk_20190613_123850577](https://user-images.githubusercontent.com/48273803/59402324-c2132e00-8dd8-11e9-9469-896aa89ef81f.png)
![KakaoTalk_20190613_123900938](https://user-images.githubusercontent.com/48273803/59402327-c3445b00-8dd8-11e9-85a3-7cd85333ac46.png)
# 구현동영상
[YOUTUBE](https://www.youtube.com/watch?v=TtmAVXDuu-A)
# **사용도구**
 
* ### 날씨 : [Open Weather Map Weather API](https://"www.openweathermap.org),Butter Knife,Retrofit,Gson,Picasso
* ### 언어 : Java
* ### 데이터베이스 : Firebase
* ### 딥러닝 : MobileNet, Colab, ANACONDA, CUDA, Tensorflow
# **유사어플차이점**
# **개발이유**
### 현대 사회에서 의상은 개인의 인상을 바꿔 줄 수 있는 영향력을 가졌다. 그런 이유로 사람들은 상황에 따라 적절한 의상을 선택을 하게 된다. 여러 가지 요인을 고려를 하지만 개인이 의상을 선택하는 경우에 최우선으로 고려하는 것은 날씨 및 해당 일의 온도이다. 날씨 API를 이용하여 일주일 간 날씨 및 온도를 표기해주며, 그 값에 맞는 의상을 소개해주는 어플리케이션을 구현하였다.
# **세부내용**
  ## **1. 데이터 베이스**
  * FireBase를 이용한 회원가입<br>
    >FireBase 란 .
     <br> 웹과 모바일 개발에 필요한 기능을 제공하는 서비스이다, 쉽게말해 백엔드 개발을 통해 서버를 따로 설계, 구현하지 않고 프론트엔드 개발에 지원 된다.
    >
    ![firebase](https://user-images.githubusercontent.com/48505768/59397781-dd763d00-8dc8-11e9-8138-a62324693554.jpg) https://firebase.google.com/

    ---------------------------------------------------------------------------------------------------------
    ## **How to use Firebase** 
    
    1.![1번](https://user-images.githubusercontent.com/48505768/59419439-eafde800-8e05-11e9-89af-d70cae708aee.JPG)

    2.![2번](https://user-images.githubusercontent.com/48505768/59419722-70819800-8e06-11e9-9fbb-620742981b72.JPG)


    3.![3번](https://user-images.githubusercontent.com/48505768/59419723-711a2e80-8e06-11e9-8cde-15478123edd8.JPG)
    
    4.![4번](https://user-images.githubusercontent.com/48505768/59419725-71b2c500-8e06-11e9-8b37-f7ddf3eccea1.JPG)

    5.![5번](https://user-images.githubusercontent.com/48505768/59419726-724b5b80-8e06-11e9-9fe5-270c12cb5cf0.JPG)

    6.![6번](https://user-images.githubusercontent.com/48505768/59419729-72e3f200-8e06-11e9-80f5-facfb6e03a29.JPG)

    7.![7번](https://user-images.githubusercontent.com/48505768/59419732-74151f00-8e06-11e9-928b-e2cb68723a5f.JPG)

    8.![8번](https://user-images.githubusercontent.com/48505768/59419734-74adb580-8e06-11e9-89c2-977492678714.JPG)

    9.![9번](https://user-images.githubusercontent.com/48505768/59419735-75464c00-8e06-11e9-852f-223b3cc7c89d.JPG)

    10.![10번](https://user-images.githubusercontent.com/48505768/59419737-75dee280-8e06-11e9-8794-5d5ae859dc0b.JPG)

    11.![11번](https://user-images.githubusercontent.com/48505768/59419740-75dee280-8e06-11e9-809b-3afb079c3a20.JPG)

    12.![12번](https://user-images.githubusercontent.com/48505768/59419742-77100f80-8e06-11e9-809f-608a1530b596.JPG)

    -----------------------------------------------------------------------------------------
* SignUpActivity
    ``` h
    // Email 과 Password를 입력 받고 Firebase에 등록
    public class SignUpActivity extends AppCompatActivity {
     ...   
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_sign_up);

    firebaseAuth = FirebaseAuth.getInstance(); // FireBase의 Authentication 초기화

    ...

    signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.length()>0 && password.length()>0 && passwordCheck.length()>0 ){
                        firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(),      password.getText().toString()) 
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) { ... }
                                    else{...}
                                    .
                                    .
                                    .
    ```
* LoginActivity
    ``` h
    // 등록된 Email 과 Password로 로그인
    public class loginActivity extends AppCompatActivity {
        ...
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        firebaseAuth = FirebaseAuth.getInstance();// FireBase의 Authentication 초기화


        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userEmail.length() > 0 && userPass.length() > 0) {
                    firebaseAuth.signInWithEmailAndPassword(userEmail.getText().toString(), userPass.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {...}
                                    else {...}
                                    .
                                    .
                                    .
    ```
* PasswordResetActivity
    ```h
    // 등록된 이메일로 비밀번호 재설정 메일을 보냄
    public class PasswordResetActivity extends AppCompatActivity {
        ...
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_reset);
        firebaseAuth = FirebaseAuth.getInstance();// FireBase의 Authentication 초기화
        private void send(){
        String email = ((EditText)findViewById(R.id.sendEmail)).getText().toString();

        if (email.length() > 0 ) {
            firebaseAuth.sendPasswordResetEmail(email)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                startToast("이메일을 전송했습니다.");
                            }
                        }
                    });
        }else {
            startToast("이메일을 입력해 주세요.");
        }
    }
    .
    .
    ```
   [PasswordResetActivity 실행 영상]( https://youtu.be/dngd3xg8J1U)

   Firebase의 Authentication 사용을 위해 `Gradle(app)` 에 아래 코드 추가 및 Firebase 내 설정
   ```
   dependencies {
        ...
   implementation 'com.google.firebase:firebase-auth:16.0.5'
        ...
   }
   ```
   
   ![Capture1](https://user-images.githubusercontent.com/48505768/59420665-3fa26280-8e08-11e9-8d61-6dd436bff1e9.PNG)

   `사용 설정 클릭'

   ![캡처3](https://user-images.githubusercontent.com/48505768/59420669-40d38f80-8e08-11e9-94b0-a87cfc3e2464.PNG)

   
   Firebase -> Authentication -> 로그인방법 -> 이메일 / 비밀번호 설정 활성화


* MemberinitActivity
   ```h
   public class MemberInitActivity extends AppCompatActivity {
       ...
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_member_init);
      ...

    private void profileUpdate(){
      ...

        if (name.length() > 0 && phoneNumber.length() > 9 && brithDay.length() > 5 && address.length() >0) {
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            MemberInfo memberInfo = new MemberInfo(name , phoneNumber , brithDay , address);
            if (user != null) {
                db.collection("users").document(user.getUid()).set(memberInfo)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                ...
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                                ...
                            }
                        });
            }

        }else {

        }
   ```
   ![캡처4](https://user-images.githubusercontent.com/48505768/59421218-31a11180-8e09-11e9-9afd-f449d2d069e6.PNG)
  Check Firebase Realtime Database : Tool -> Firebase -> Realtime Database -> 
   `Connect your app to Firebase` & `Add the Realtime Database to your app` 
  ## **2. API(날씨) 및 날씨 적용 방법**
* 날씨 사용한 도구
    * OpenWeatherMap - Weather API 사용
    * Butter Knife - 필드나 메소드를 안드로이드 뷰에 어노테이션(@)을 이용하여 편하게 접근 할 수 있도록 도와주는 안드로이드 라이브러리 입니다.
    * Retrofit2 - 안드로이드 스튜디오 에서 API를 편하게 사용할 수있는 라이브러리입니다.이 어플 에서는 http클라이언트를 위해 사용 했습니다.
    * Gson - Java객체를 Json으로 변환 하거나 Json을 Java객체로 변환 해주는 라이브러리 입니다
    * Picasso - 외부에서 이미지를 불러와야 할 경우 유용하게 사용할 수 있는 라이브러리 입니다. 이 어플 에서는 openweathermap에서 아이콘을 가져오거나 데이터베이스에서 이미지를 가져와서 날씨에 맞춰 랜덤으로 변형 할때 사용 했습니다.
* 날씨를 어플리케이션에 접목 시키기 위해서는 먼저 날씨 API 가 필요하다
  
  * 날씨 API 가져오는 방법<br>
    1. openweathermap | https://openweathermap.org/ 접속
    ![openweather1](https://user-images.githubusercontent.com/48273829/59374950-088c6c80-8d88-11e9-8f8a-61bd00b246ee.JPG)
    2. Create an Account 클릭 후 회원가입
    ![openweather2](https://user-images.githubusercontent.com/48273829/59375580-6c636500-8d89-11e9-850d-50178cab8921.JPG)
    3. API Keys 클릭
    ![openweather3](https://user-images.githubusercontent.com/48273829/59376428-07107380-8d8b-11e9-9c4f-0c61513b1b34.JPG)
    4. Name에 이름 입력후 Generate
    ![openweather4](https://user-images.githubusercontent.com/48273829/59376205-a3864600-8d8a-11e9-91a7-02c277c392e7.JPG)
*  날씨 API 구동 원리 
    1. 상단에 API 클릭
    ![openweather1](https://user-images.githubusercontent.com/48273829/59374950-088c6c80-8d88-11e9-8f8a-61bd00b246ee.JPG)
    2. 5 day / 3 hour forecast 클릭(일주일 날씨와 3시간 마다 날씨 정보 받기 사용)
    ![openweather5](https://user-images.githubusercontent.com/48273829/59378809-2b228380-8d90-11e9-861b-dbe49f03e732.JPG)
    3. CityName으로 구현하였기떄문에 By City Name 클릭
    ![openweather6](https://user-images.githubusercontent.com/48273829/59378812-2cec4700-8d90-11e9-8be8-97391f150fe9.JPG)
    4. https://samples.openweathermap.org/data/2.5/forecast?q=London,us&mode=xml&appid=b6907d289e10d714a6e88b30761fae22 방식으로 구현
    ![openweather7](https://user-images.githubusercontent.com/48273829/59378815-2e1d7400-8d90-11e9-8da0-467f5b73262f.png)
    5. Retrofit을 이용하여 API를 API Class에 접목<br>
    BASE URL을 두고 발급받은 API를 입력하고 밑에 있는 WeatherService interface를 사용하기 위하여 retrofitdmf 초기화 해줍니다.
   ```
   //API
    public class API {
    public static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    public static final String KEY = "자신의 API 를 입력해주세요";


    private static Retrofit retrofit = null;

    public static Retrofit getApi(){
        if(retrofit == null){
            retrofit =new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
   }
    ```
    6. 전에  4. 에 봤던 방식을 사용하기 위하여 WeatherService interface 작성
    ```
    //WeatherSerivces
    public interface WeatherServices {
    @GET("forecast/daily")
    Call<CityWeather> getWeatherCity (@Query("q") String city, @Query("APPID")String key, @Query("units") String units , @Query("cnt") int days);
   }
   ```

## 날씨 구현 레이아웃 및 중요 코드 설명 ##
_______
* 코드를 구현하기전에 gradle->defendencies에 추가
```
implementation 'com.android.support:design:26.0.0'
implementation 'com.android.support:cardview-v7:26.0.0'
implementation 'com.jakewharton:butterknife:8.8.1'
annotationProcessor 'com.jakewharton:butterknife-compiler:8.8.1'
implementation 'com.squareup.retrofit2:retrofit:2.3.0'
implementation 'com.squareup.retrofit2:converter-gson:2.3.0'
implementation 'com.google.code.gson:gson:2.8.0'
implementation 'com.squareup.picasso:picasso:2.5.2' 
```
1. FloatingActionButton![날씨 추가](https://user-images.githubusercontent.com/48273829/59200581-8c512800-8bd3-11e9-83e2-8e0a8136c3fd.png)을 누르고 Dialog를 통해 CityName입력 후 ADD클릭<br>
    ![weather2](https://user-images.githubusercontent.com/48273829/59401549-0c46e000-8dd6-11e9-9d3a-af7ffe650305.JPG) ![weather](https:user-images.githubusercontent.com/48273829/59381773-39c06900-8d97-11e9-8524-42f989fd298c.JPG)
   ```
   //버튼을 누르면 다이얼로그 실행
   public void showAlertAddCity(String title, String message){
        AlertDialog.Builder mbuilder = new AlertDialog.Builder(this);
        if(title!=null) mbuilder.setTitle(title);
        if(message!=null) mbuilder.setMessage(message);
        final View view = LayoutInflater.from(this).inflate(R.layout.dialog_add_city,null);
        mbuilder.setView(view);
        final TextView editTextAddCityName = view.findViewById(R.id.editTextAddCityName);
        Bundle intent = getIntent().getExtras();
        editTextAddCityName.setText(intent.getString("address"));
        final InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);

        mbuilder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                cityToAdd = editTextAddCityName.getText().toString();
                addCity(cityToAdd);
                imm.toggleSoftInput(InputMethodManager.HIDE_NOT_ALWAYS,0);
            }
        });
        mbuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                dialogInterface.cancel();
                imm.toggleSoftInput(InputMethodManager.HIDE_NOT_ALWAYS,0);
                Toast.makeText(MainActivity.this,"Cancel",Toast.LENGTH_LONG).show();
            }
        });
        final AlertDialog dialog= mbuilder.create();
        dialog.show();
    }
    ```
2. CardView를 통해 메인에 띄어준다<br>
    ![weather3](https://user-images.githubusercontent.com/48273829/59401598-36989d80-8dd6-11e9-8ca8-5c9b80f93433.JPG)
    
    ```
     public void addCity(String cityName){
         Call<CityWeather> cityWeather = weatherServices.getWeatherCity(cityName, API.KEY, "metric",6);
        cityWeather.enqueue(new Callback<CityWeather>() {
            @Override
            public void onResponse(Call<CityWeather> call, Response<CityWeather> response) {
                if(response.code()==200){
                    CityWeather cityWeather = response.body();
                    cities.add(cityWeather);
                    adapter.notifyItemInserted(cities.size()-1);
                    recyclerView.scrollToPosition(cities.size()-1);
                    Toast.makeText(MainActivity.this,"Add new weather and slide to check",Toast.LENGTH_LONG).show();
                     }else{
                    Toast.makeText(MainActivity.this,"Sorry, city not found",Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<CityWeather> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Sorry, weather services are currently unavailable",Toast.LENGTH_LONG).show();
            }
        });
    }

    ```
    3. 날씨 온도에 따라 중복없이 옷 추천
        * 한국 영국 일본 계절별 사진(URL) 배열 정리 
            * 한국 봄 옷 (30장) , 영국 봄 옷(30장), 일본 봄 옷(30장)
            * 한국 여름 옷(15장), 영국 여름 옷(15장), 일본 여름 옷(15장)
            * 한국 겨울 옷(15장), 영국 겨울 옷(15장), 일본 겨울 옷(15장)
            ```
            //한국 봄 옷 30장
             List<String> urlImage = new ArrayList<String>();
            urlImage.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2FCardigan.PNG?alt=media&token=7971b062-a7e5-403e-ab53-f32686867b78");
            urlImage.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EA%B0%80%EC%A3%BD%EC%9E%90%EC%BC%93.PNG?alt=media&token=721f4ca6-61dc-45ae-ba29-51498cb4f2c5");
            urlImage.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EA%B2%80%EC%A0%95%EC%83%89%20%EA%B0%80%EB%94%94%EA%B1%B41.PNG?alt=media&token=e45b9a96-8d5e-4af4-aaed-123f3323b959");
             urlImage.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EA%B2%80%EC%A0%95%EC%83%89%ED%8B%B0%20%EB%B2%A0%EC%9D%B4%EC%A7%80%EB%B0%94%EC%A7%801.PNG?alt=media&token=788524b9-164a-4494-a5b3-ee38b34b1ad5");
            urlImage.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EA%B2%80%EC%A0%95%EC%9E%90%EC%BC%931.PNG?alt=media&token=cfa33c06-2e8f-4430-82f6-67548f8c400c");
            urlImage.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EA%B2%80%EC%A0%95%EC%9E%90%EC%BC%931.PNG?alt=media&token=cfa33c06-2e8f-4430-82f6-67548f8c400c");
            urlImage.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EB%84%A4%EC%9D%B4%EB%B9%84%20%ED%8A%B8%EB%A0%8C%EC%B9%98%EC%BD%94%ED%8A%B81.PNG?alt=media&token=f39e0def-24f5-4659-bb00-7ec9517abc04");
            urlImage.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EB%85%B9%EC%83%89%EB%A7%A8%ED%88%AC%EB%A7%A81.PNG?alt=media&token=7d049315-bfc4-4d63-b903-c932646499de");
            urlImage.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EB%8B%88%ED%8A%B8%EC%A1%B0%EB%81%BC.PNG?alt=media&token=4146442c-b22b-4d26-a668-796fc07884e4");
            urlImage.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EB%8D%B0%EC%9D%BC%EB%A6%AC%20%EC%9E%90%EC%BC%93.PNG?alt=media&token=8f94bdac-8c36-4b93-9a24-2eecbb9295ce");
             List<String> urlImage1 = new ArrayList<String>();
             urlImage1.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EB%A1%B1%EA%B0%80%EB%94%94%EA%B1%B4.PNG?alt=media&amp;token=63d6dfa6-ee9c-43cd-8a18-41b93d4ad27f");
            urlImage1.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EB%A1%B1%EA%B0%80%EB%94%94%EA%B1%B41.PNG?alt=media&amp;token=4ec2c413-479e-447c-9752-6782d37a3a21");
            urlImage1.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EB%A3%A8%EC%A6%88%ED%95%8F%20%EB%A7%A8%ED%88%AC%EB%A7%A8.PNG?alt=media&amp;token=2990c995-10e9-49ae-915b-9f688e29401f");
            urlImage1.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EB%A7%A8%ED%88%AC%EB%A7%A8.PNG?alt=media&amp;token=5fcee143-a80e-44ff-abb7-55d72d301dae");
            urlImage1.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EB%A7%A8%ED%88%AC%EB%A7%A81.PNG?alt=media&amp;token=7235c886-6429-45a2-9f84-269379830698");
             urlImage1.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EB%B8%8C%EC%9D%B4%EB%84%A5%20%EB%8B%88%ED%8A%B8.PNG?alt=media&amp;token=bb97136a-487d-45f6-9210-6db72f19fec6");
            urlImage1.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EB%B8%8C%EC%9D%B4%EB%84%A5%20%EB%A7%A8%ED%88%AC%EB%A7%A8.PNG?alt=media&amp;token=775d4add-887a-43c0-8a98-b20c88c0ee25");
            urlImage1.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EC%8A%A4%ED%94%84%EB%9D%BC%EC%9D%B4%ED%8A%B8%20%EB%8B%88%ED%8A%B8.PNG?alt=media&amp;token=1bf32775-a15a-4b1b-8a7a-7c74846ba9e5");
            urlImage1.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EC%96%91%ED%84%B8%EC%9E%90%EC%BC%931.PNG?alt=media&amp;token=d1a4d538-e9e8-4ec5-9051-616748c2f4ec");
            urlImage1.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EC%9E%90%EC%BC%93.PNG?alt=media&amp;token=0170c1cd-ab71-4088-8578-3e861d60b523");
             List<String> urlImage2 = new ArrayList<String>();
            urlImage2.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EC%9E%90%EC%BC%931.PNG?alt=media&amp;token=e05edd01-8957-4598-9d5f-38d1b404b165");
            urlImage2.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EC%B2%AD%EC%9E%90%EC%BC%93%20%ED%9B%84%EB%93%9C1.PNG?alt=media&amp;token=3b471ebf-4ab0-4b1d-bc0e-fdb7f4304437");
            urlImage2.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EC%B2%AD%EC%B2%AD%20%ED%8C%8C%EC%88%80.PNG?alt=media&amp;token=48cabc99-7727-4b90-80c4-a4f095f09bc1");
            urlImage2.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%EC%B2%B4%ED%81%AC%EB%82%A8%EB%B0%A91.PNG?alt=media&amp;token=44262985-e14b-4558-b950-8edec8cff30f");
            urlImage2.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%ED%8A%B8%EB%A0%8C%EC%B9%98%EC%BD%94%ED%8A%B8.PNG?alt=media&amp;token=d4a78863-5379-42c4-80ec-b4f84afc8f99");
            urlImage2.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%ED%8A%B8%EB%A0%8C%EC%B9%98%EC%BD%94%ED%8A%B81.PNG?alt=media&amp;token=2eee56a4-8927-4427-a377-70bade85f268");
            urlImage2.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%ED%8C%A8%EB%94%A9%EC%A1%B0%EB%81%BC1.PNG?alt=media&amp;token=b9f50334-8a25-4faa-aab2-69751e70929a");
            urlImage2.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%ED%95%AD%EA%B3%B5%EC%A0%90%ED%8D%BC.PNG?alt=media&amp;token=f703bc18-de27-469a-91fa-e50414e9f2f3");
            urlImage2.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%ED%9B%84%EB%91%90%ED%8B%B0.PNG?alt=media&amp;token=324b95aa-14e5-4149-ad8b-313847146386");
            urlImage2.add("https://firebasestorage.googleapis.com/v0/b/signup-2b39d.appspot.com/o/image%2FKorea%2Fspring%2F%ED%9B%84%EB%93%9C%ED%8B%B01.PNG?alt=media&amp;token=61d4ab1c-ca78-4c37-9571-61276761b6a2");
            ```
        * 구역별 ID 값 지정
        ```
        //한국 3장
        imageView=(ImageView)findViewById(R.id.imageView_01);
        imageView1=(ImageView)findViewById(R.id.imageView_02);
        imageView2=(ImageView)findViewById(R.id.imageView_03);
        //영국 3장
        imageView3=(ImageView)findViewById(R.id.imageView_04);
        imageView4=(ImageView)findViewById(R.id.imageView_05);
        imageView5=(ImageView)findViewById(R.id.imageView_06);
        //일본 3장
        imageView6=(ImageView)findViewById(R.id.imageView_07);
        imageView7=(ImageView)findViewById(R.id.imageView_08);
        imageView8=(ImageView)findViewById(R.id.imageView_09);
        ```
        * 랜덤 변수
         ```
          r = new Random();
         ```
        * CardView에 Temp값 :(int)cityWeather.getWeeklyWeather().get(0).getTemp().getDay()을 계절별로 if문을 써서배열에 저장되어잇는 이미지(URL)를 중복 없이 랜덤으로 각 ID값에 지정<br>
        ``` 
        ///봄
        if((int)cityWeather.getWeeklyWeather().get(0).getTemp().getDay()>=11&&(int)cityWeather.getWeeklyWeather().get(0).getTemp().getDay()<=24){
                        //배열에있는 이미지를 랜덤으로 저장
                        String randomImage = urlImage.get(r.nextInt(urlImage.size()));
                        String randomImage1 = urlImage1.get(r.nextInt(urlImage1.size()));
                        String randomImage2 = urlImage2.get(r.nextInt(urlImage2.size()));

                        String randomImage3 = urlImage3.get(r.nextInt(urlImage3.size()));
                        String randomImage4 = urlImage4.get(r.nextInt(urlImage4.size()));
                        String randomImage5 = urlImage5.get(r.nextInt(urlImage6.size()));

                        String randomImage6 = urlImage6.get(r.nextInt(urlImage6.size()));
                        String randomImage7 = urlImage7.get(r.nextInt(urlImage7.size()));
                        String randomImage8 = urlImage8.get(r.nextInt(urlImage8.size()));
                        //한국 봄
                        Picasso.get().load(randomImage).into(imageView);
                        Picasso.get().load(randomImage1).into(imageView1);
                        Picasso.get().load(randomImage2).into(imageView2);
                        //영국 봄
                        Picasso.get().load(randomImage3).into(imageView3);
                        Picasso.get().load(randomImage4).into(imageView4);
                        Picasso.get().load(randomImage5).into(imageView5);
                        //일본 봄
                        Picasso.get().load(randomImage6).into(imageView6);
                        Picasso.get().load(randomImage7).into(imageView7);
                        Picasso.get().load(randomImage8).into(imageView8);
                    }
    
        ```
        ![weather4](https://user-images.githubusercontent.com/48273829/59402102-0ce07600-8dd8-11e9-8548-d9d45720380c.JPG)
        ![weather5](https://user-images.githubusercontent.com/48273829/59402103-0e11a300-8dd8-11e9-8618-5a18a24d5c7d.JPG)
        ![weather6](https://user-images.githubusercontent.com/48273829/59402104-0eaa3980-8dd8-11e9-964b-ffa7ec55afb2.JPG)

        ```
        //여름
         if((int)cityWeather.getWeeklyWeather().get(0).getTemp().getDay()>=25){
                        String randomImage =  urlImage9.get(r.nextInt(urlImage9.size()));
                        String randomImage1 = urlImage10.get(r.nextInt(urlImage10.size()));
                        String randomImage2 = urlImage11.get(r.nextInt(urlImage11.size()));

                        String randomImage3 = urlImage12.get(r.nextInt(urlImage12.size()));
                        String randomImage4 = urlImage13.get(r.nextInt(urlImage13.size()));
                        String randomImage5 = urlImage14.get(r.nextInt(urlImage14.size()));

                        String randomImage6 = urlImage15.get(r.nextInt(urlImage15.size()));
                        String randomImage7=  urlImage16.get(r.nextInt(urlImage16.size()));
                        String randomImage8 = urlImage17.get(r.nextInt(urlImage17.size()));
                        //한국 여름
                        Picasso.get().load(randomImage).into(imageView);
                        Picasso.get().load(randomImage1).into(imageView1);
                        Picasso.get().load(randomImage2).into(imageView2);
                        //영국 여름
                        Picasso.get().load(randomImage3).into(imageView3);
                        Picasso.get().load(randomImage4).into(imageView4);
                        Picasso.get().load(randomImage5).into(imageView5);
                        //일본 여름
                        Picasso.get().load(randomImage6).into(imageView6);
                        Picasso.get().load(randomImage7).into(imageView7);
                        Picasso.get().load(randomImage8).into(imageView8);
                    }

        ```
        ![weather7](https://user-images.githubusercontent.com/48273829/59402162-3dc0ab00-8dd8-11e9-99f2-09c9b7eeea2b.JPG)
        ![weather8](https://user-images.githubusercontent.com/48273829/59402163-3e594180-8dd8-11e9-85a3-88e8a52bdf99.JPG)
        ![weather9](https://user-images.githubusercontent.com/48273829/59402164-3ef1d800-8dd8-11e9-9623-b940e0ed9dee.JPG)

        ```
        //겨울
        if((int)cityWeather.getWeeklyWeather().get(0).getTemp().getDay()<=10){
                        String randomImage =  urlImage18.get(r.nextInt(urlImage18.size()));
                        String randomImage1 = urlImage19.get(r.nextInt(urlImage19.size()));
                        String randomImage2 = urlImage20.get(r.nextInt(urlImage20.size()));

                        String randomImage3 = urlImage21.get(r.nextInt(urlImage21.size()));
                        String randomImage4 = urlImage22.get(r.nextInt(urlImage22.size()));
                        String randomImage5 = urlImage23.get(r.nextInt(urlImage23.size()));

                        String randomImage6 = urlImage24.get(r.nextInt(urlImage24.size()));
                        String randomImage7=  urlImage25.get(r.nextInt(urlImage25.size()));
                        String randomImage8 = urlImage26.get(r.nextInt(urlImage26.size()));
                        //한국 겨울
                        Picasso.get().load(randomImage).into(imageView);
                        Picasso.get().load(randomImage1).into(imageView1);
                        Picasso.get().load(randomImage2).into(imageView2);
                        //영국 겨울
                        Picasso.get().load(randomImage3).into(imageView3);
                        Picasso.get().load(randomImage4).into(imageView4);
                        Picasso.get().load(randomImage5).into(imageView5);
                        //일본 겨울
                        Picasso.get().load(randomImage6).into(imageView6);
                        Picasso.get().load(randomImage7).into(imageView7);
                        Picasso.get().load(randomImage8).into(imageView8);
                    }
        ```
        ![weather10](https://user-images.githubusercontent.com/48273829/59402198-57fa8900-8dd8-11e9-9996-44882faa264a.JPG)
        ![weather11](https://user-images.githubusercontent.com/48273829/59402199-58931f80-8dd8-11e9-951c-d261a6bcb2b4.JPG)
        ![weather12](https://user-images.githubusercontent.com/48273829/59402201-592bb600-8dd8-11e9-937e-d3916253d2b6.JPG)

        

    4. CardView를 클릭하면 7일치 날씨 정보 확인가능<br>
    ![weather1](https://user-images.githubusercontent.com/48273829/59383393-cddfff80-8d9a-11e9-98f0-24d5f819dfa3.JPG)
    ```
     adapter = new CityWeatherAdapter(cities, R.layout.weather_card, this, new CityWeatherAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(CityWeather cityWeather, int position, View clickView) {
                Intent intent = new Intent(MainActivity.this, WeatherDetails.class);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                        MainActivity.this,clickView,
                        "weatherCardTransition");

                intent.putExtra("city",  cityWeather);
                startActivity(intent,options.toBundle());
            }
        });

    ```
   
# 4. **실시간채팅**

 <br>![실시간 데이터 베이스](https://user-images.githubusercontent.com/48505912/59396919-b8cc9600-8dc5-11e9-9431-84397660bdac.PNG)
  <br>
  실시간 채팅 기능을 실현하기 위하여 파이어베이스에서 제공하는 Realtime Database 기능이 필요.

  <br>![image](https://user-images.githubusercontent.com/48505912/59397044-2e386680-8dc6-11e9-857f-b239c7be16eb.png)
<br> 실시간 데이터베이스의 규칙<br>
.read는 사용자가 데이터를 읽을 수 있는 조건을 기술한다.<br>
.write사용자가 데이터를 쓸 수 있는 조건을 기술한다.<br>

<br>
<br>
app-level build.gradle -> implementation 'com.google.firebase:firebase-database:11.0.2' 라는 dependency 추가

<br><br>
![image](https://user-images.githubusercontent.com/48505912/59398532-86259c00-8dcb-11e9-8579-2512e7879c07.png)
<br>

ChatDTO 생성 -> DTO(Data Transfer Object) 데이터를 오브젝트로 변경
<br>유저의 이름과 채팅 메세지를 담을 수 있다.

<br>



<br>

![image](https://user-images.githubusercontent.com/48505912/59399742-1bc32a80-8dd0-11e9-856d-2c3c79fe0de2.png)
<br>
데이터 송신

<br>

![image](https://user-images.githubusercontent.com/48505912/59399576-7a3bd900-8dcf-11e9-8a37-65d286fb6874.png)

<br>
 데이터 수신 <br>
ChildEventListener: Child에서 일어나는 change들을 감지 <br>
onChildAdded(): 리스트의 아이템을 검색하거나 아이템의 추가가 있을때 수신<br>
onChildChanged(): 아이템의 변화가 있을때 수신<br>
onChildRemoved(): 아이템이 삭제되었을때 수신<br>
onChildMoved(): 순서가 있는 리스트에서 순서가 변경되었을 때 수신<br>

<br>

![image](https://user-images.githubusercontent.com/48505912/59398767-6773d500-8dcc-11e9-9777-ed4611b84728.png)
<br> 시작 화면

<br>

![image](https://user-images.githubusercontent.com/48505912/59398956-25975e80-8dcd-11e9-88b5-698447a3336f.png)
<br>
채팅을 치면 데이터베이스에 쌓임.


  ## **4. 언어변경**
  <br>
  
  ![image](https://user-images.githubusercontent.com/48505912/59400786-92155c00-8dd3-11e9-922c-cf9b4d14ddd3.png)
<br>
res/values/strings -> New -> Values resource file

<br>

![image](https://user-images.githubusercontent.com/48505912/59400978-2384ce00-8dd4-11e9-8a3f-8d1ec5c819d6.png)
<br>
Locale 항목에서 원하는 언어 선택 가능

<br>

![image](https://user-images.githubusercontent.com/48505912/59401040-5e870180-8dd4-11e9-91e6-2e78d2bbcb92.png)
<br>
언어를 국가에 맞춰서 바꿔준다.

<br>

![image](https://user-images.githubusercontent.com/48505912/59401226-fb499f00-8dd4-11e9-8d99-eab279c10d44.png)
<br>
sharedPreferences -> Boolean, Integer, Float, Long, String 데이터 타입 같은 간단한 값을 저장하기 위해 사용






  ## **5. 자료수집**
  <br>이미지 수집할수있는 구글의 확장 프로그램입니다. 사이트의 이미지를 손쉽게 다운받게 해줍니다.
  ![이미지 다운로더](https://user-images.githubusercontent.com/48505912/59402269-8a0beb00-8dd8-11e9-9f59-1645b350bd56.JPG)
  ![이미지 다운로더 위치](https://user-images.githubusercontent.com/48505912/59402404-16b6a900-8dd9-11e9-885c-727fbbe94f02.JPG)
  ![이미지 다운로더 실행](https://user-images.githubusercontent.com/48505912/59402366-f1299f80-8dd8-11e9-8a94-17d9b9975466.JPG)

  
<br>옷에대한 자료수집. 첫번째로 국가.세부적으로는 계절별로 모았다<br>


![다운로드 (16)](https://user-images.githubusercontent.com/48505912/59402186-4e712100-8dd8-11e9-822b-ebe53159a4c3.jpg)
![겨울니트](https://user-images.githubusercontent.com/48505912/59402205-5d57d380-8dd8-11e9-9d97-9f2e8c30fca5.jpg)

![8](https://user-images.githubusercontent.com/48505912/59402494-757c2280-8dd9-11e9-869e-9afe53e98a17.JPG)
<br>처음은 옷에대한 수집을 진행했고 그다음으로 모델 수집과 모델옷에대해 자료수집을 진행했다.<>


<br>로고에대한 자료수집.딥러닝에 쓰일 로고 를 수천장씩 수집했다.<br>
![images - 2019-05-15T154116 463](https://user-images.githubusercontent.com/48505912/59402130-2681bd80-8dd8-11e9-8430-4e6a4832eb8e.jpg)
![FILA0693](https://user-images.githubusercontent.com/48505912/59402230-6a74c280-8dd8-11e9-973d-928d0e378d76.jpg)
![GUESS0001](https://user-images.githubusercontent.com/48505912/59402470-55e4fa00-8dd9-11e9-9225-d1c9dc4253a9.jpg)<br>
## **6. 딥러닝**
 * 딥러닝 환경구축
    * Manifest
        * uses-permission android:name="android.permission.CAMERA
        * uses-feature android:name="android.hardware.camera
        * uses-feature android:name="android.hardware.camera.autofocus
    * 사용된 딥러닝 환경<br>
    ![캡처](https://user-images.githubusercontent.com/48273803/59388899-f4586780-8da7-11e9-9185-ac55d2056c41.PNG)

    * ANACONDA <br>
    ![970eda25bcc65296690ac7714a66bbf5](https://user-images.githubusercontent.com/48273803/59389009-3b465d00-8da8-11e9-8e1e-4910eec0efaf.png) <br>
   
   
    * PC 환경구축 <br>
    ![2435B63956B78A8F19](https://user-images.githubusercontent.com/48273803/59389241-d3444680-8da8-11e9-957f-3ed14f17f3d5.png) <br>
    ![2541AC4356B78A9016](https://user-images.githubusercontent.com/48273803/59389345-0b4b8980-8da9-11e9-8a45-950395c11553.png) <br>
    ![23049E4056B78A900F](https://user-images.githubusercontent.com/48273803/59389397-2a4a1b80-8da9-11e9-9d89-44dc617674f6.png) <br>
    Path에 Anaconda3, Anaconda3\Scripts, Anaconda3\Library\bin 경로 추가 <br>
    <Anaconda Prompt 실행>
    ![다운로드](https://user-images.githubusercontent.com/48273803/59389664-d1c74e00-8da9-11e9-860d-cc4d8504a6d8.png) <br>
    [Anaconda 업데이트] Conda update –n base conda<br>
    [Python Package 업데이트] Conda update –all <br>
    [Anaconda 가상환경 생성] conda create –name 가상환경명  python=3.5 <br>
    * CUDA Toolkit 9.0ver<br>
    ![27014](https://user-images.githubusercontent.com/48273803/59387912-595e8e00-8da5-11e9-80a0-a3b1da04c7c2.png) <br>
    

    Anaconda와 마찬가지로 시스템 변수 path 추가 <br>
    ![23049E4056B78A900F](https://user-images.githubusercontent.com/48273803/59389397-2a4a1b80-8da9-11e9-9d89-44dc617674f6.png)<br>
    CUDA\v9.0\bin, CUDA\v9.0\library <br>
    시스템변수 CUDA_PATH_V9_0, CUDA_PATH, CUDA_HOME 추가
    * cuDNN 9.0 ver<br>
    ![cuDNN_logo_white_on_black_1432x920](https://user-images.githubusercontent.com/48273803/59387950-73986c00-8da5-11e9-938d-dd1593823525.png)
    <br>
    
    * Python 및 Tensorflow 개발환경 구축
    ![다운로드](https://user-images.githubusercontent.com/48273803/59389664-d1c74e00-8da9-11e9-860d-cc4d8504a6d8.png) <br>
   
    <br> 설치 완료 후 가상환경에서 작업을 권장
    <br>activate 가상환경명
    
    * Anaconda Bazel
    ![0_Y37Qx5-GpDz4Of3n](https://user-images.githubusercontent.com/48273803/59391006-e7d70d80-8dad-11e9-9e46-903b3cf091ff.png) <br>
    https://anaconda.org/conda-forge/bazel <br>
    [Anaconda Prompt] conda install -c conda-forge bazel
    * MobileNet<br>
    ![images (1)](https://user-images.githubusercontent.com/48273803/59388031-ab9faf00-8da5-11e9-9adc-5b1462a4420a.png)<br>

```
    """
MobileNet v2.
As described in https://arxiv.org/abs/1801.04381
  Inverted Residuals and Linear Bottlenecks: Mobile Networks for Classification, Detection and Segmentation
"""

from __future__ import absolute_import
from __future__ import division
from __future__ import print_function

from collections import namedtuple, OrderedDict

import functools
import tensorflow as tf

slim = tf.contrib.slim

Conv = namedtuple('Conv', ['kernel', 'stride', 'channel'])
InvertedBottleneck = namedtuple('InvertedBottleneck', ['up_sample', 'channel', 'stride', 'repeat'])

# Sequence of layers, described in Table 2
_CONV_DEFS = [
    Conv(kernel=[3, 3], stride=2, channel=32),              # first block, input 224x224x3
    InvertedBottleneck(up_sample=1, channel=16, stride=1, repeat=1),  # second block, input : 112x112x32
    InvertedBottleneck(up_sample=6, channel=24, stride=2, repeat=2),  # third block, input: 112x112x16
    InvertedBottleneck(up_sample=6, channel=32, stride=2, repeat=3),  # fourth block, input: 56x56x24
    InvertedBottleneck(up_sample=6, channel=64, stride=2, repeat=4),  # fifth block, input: 28x28x32
    InvertedBottleneck(up_sample=6, channel=96, stride=1, repeat=3),  # sixth block, input: 28x28x64
    InvertedBottleneck(up_sample=6, channel=160, stride=2, repeat=3),  # seventh block, input: 14x14x96
    InvertedBottleneck(up_sample=6, channel=320, stride=1, repeat=1),  # eighth block, input: 7x7x160
    Conv(kernel=[1, 1], stride=1, channel=1280),
    # AvgPool(kernel=[7, 7]),
    # Conv(kernel=[1, 1], stride=1, channel='num_class')
]


def mobilenet_v2_base(inputs,
                      final_endpoint='Conv2d_13_pointwise',
                      min_depth=8,
                      depth_multiplier=1.0,
                      conv_defs=None,
                      scope=None):
    if depth_multiplier <= 0:
        raise ValueError('depth_multiplier is not greater than zero.')

    depth = lambda d: max(int(d * depth_multiplier), min_depth)
    end_points = OrderedDict()

    if conv_defs is None:
        conv_defs = _CONV_DEFS

    net = inputs
    with tf.variable_scope(scope, 'MobilenetV2', [inputs]):
        with slim.arg_scope([slim.conv2d, slim.separable_conv2d], padding='SAME'):
            for i, conv_def in enumerate(conv_defs):

                end_point = ''
                if isinstance(conv_def, Conv):
                    end_point = 'Conv2d_%d' % i
                    num_channel = depth(conv_def.channel)
                    net = slim.conv2d(net, num_channel, conv_def.kernel,
                                      activation_fn=tf.nn.relu6,
                                      stride=conv_def.stride,
                                      scope=end_point)
                    end_points[end_point] = net
                elif isinstance(conv_def, InvertedBottleneck):
                    stride = conv_def.stride

                    if conv_def.repeat <= 0:
                        raise ValueError('repeat value of inverted bottleneck should be greater than zero.')

                    for j in range(conv_def.repeat):
                        end_point = 'InvertedBottleneck_%d_%d' % (i, j)
                        prev_output = net
                        net = slim.conv2d(net, conv_def.up_sample * net.get_shape().as_list()[-1], [1, 1],
                                          activation_fn=tf.nn.relu6,
                                          scope=end_point + '_inverted_bottleneck')
                        end_points[end_point + '_inverted_bottleneck'] = net
                        net = slim.separable_conv2d(net, None, [3, 3],
                                                    depth_multiplier=1,
                                                    stride=stride,
                                                    activation_fn=tf.nn.relu6,
                                                    scope=end_point + '_dwise')
                        end_points[end_point + '_dwise'] = net

                        num_channel = depth(conv_def.channel)
                        net = slim.conv2d(net, num_channel, [1, 1],
                                          activation_fn=None,
                                          scope=end_point + '_linear')
                        end_points[end_point + '_linear'] = net

                        if stride == 1:
                            if prev_output.get_shape().as_list()[-1] != net.get_shape().as_list()[-1]:
                                # Assumption based on previous ResNet papers: If the number of filters doesn't match,
                                # there should be a conv 1x1 operation.
                                # reference(pytorch) : https://github.com/MG2033/MobileNet-V2/blob/master/layers.py#L29
                                prev_output = slim.conv2d(prev_output, num_channel, [1, 1],
                                                          activation_fn=None,
                                                          biases_initializer=None,
                                                          scope=end_point + '_residual_match')

                            # as described in Figure 4.
                            net = tf.add(prev_output, net, name=end_point + '_residual_add')
                            end_points[end_point + '_residual_add'] = net

                        stride = 1
                else:
                    raise ValueError('CONV_DEF is not valid.')

                if end_point == final_endpoint:
                    break

    return net, end_points


def mobilenet_v2_cls(inputs,
                     num_classes=1000,
                     dropout_keep_prob=0.999,
                     is_training=True,
                     min_depth=8,
                     depth_multiplier=1.0,
                     conv_defs=None,
                     prediction_fn=tf.contrib.layers.softmax,
                     reuse=None,
                     scope='MobilenetV2'):
    input_shape = inputs.get_shape().as_list()
    if len(input_shape) != 4:
        raise ValueError('Invalid input tensor rank, expected 4, was: %d' %
                         len(input_shape))

    with tf.variable_scope(scope, 'MobilenetV2', [inputs], reuse=reuse) as scope:
        with slim.arg_scope([slim.batch_norm, slim.dropout], is_training=is_training):
            net, end_points = mobilenet_v2_base(inputs, scope=scope,
                                                min_depth=min_depth,
                                                depth_multiplier=depth_multiplier,
                                                conv_defs=conv_defs)
            with tf.variable_scope('Logits'):
                # class
                if num_classes:
                    net = slim.dropout(net, keep_prob=dropout_keep_prob, is_training=is_training, scope='Dropout_1')
                    # global pool
                    # Issue #1 : https://github.com/ildoonet/tf-mobilenet-v2/issues/1
                    net = tf.reduce_mean(net, [1, 2], keepdims=True, name='Global_pool')
                    end_points['Global_pool'] = net

                    # classification
                    net = slim.dropout(net, keep_prob=dropout_keep_prob, is_training=is_training, scope='Dropout_2')
                    net = slim.conv2d(net, num_classes, [1, 1], activation_fn=None,
                                      normalizer_fn=None, scope='Conv2d_1c_1x1')
                    net = slim.flatten(net, scope='Flatten')
                    end_points['Logits'] = net

                    if prediction_fn:
                        end_points['Predictions'] = prediction_fn(net, scope='Predictions')        return net, end_pointsdef wrapped_partial(func, *args, **kwargs):
    partial_func = functools.partial(func, *args, **kwargs)    functools.update_wrapper(partial_func, func)    return partial_funcmobilenet_v2_cls_075 = wrapped_partial(mobilenet_v2_cls, depth_multiplier=0.75)mobilenet_v2_cls_050 = wrapped_partial(mobilenet_v2_cls, depth_multiplier=0.50)mobilenet_v2_cls_025 = wrapped_partialmobilenet_v2_cls, depth_multiplier=0.25)def mobilenet_v2_arg_scope(is_training=True,
                           weight_decay=0.0004,
                           stddev=0.01,
                           regularize_depthwise=False):
    """Defines the default MobilenetV2 arg scope.
    Args:
      is_training: Whether or not we're training the model.
      weight_decay: The weight decay to use for regularizing the model.
      stddev: The standard deviation of the trunctated normal weight initializer.
      regularize_depthwise: Whether or not apply regularization on depthwise.
    Returns:
      An `arg_scope` to use for the mobilenet v2 model.
    """
    batch_norm_params = {
        'is_training': is_training,
        'center': True,
        'scale': True,
        'decay': 0.999,
        'epsilon': 0.0001,
        'fused': True,
        'zero_debias_moving_mean': True
    }

    # Set weight_decay for weights in Conv and DepthSepConv layers.
    weights_init = tf.truncated_normal_initializer(stddev=stddev)
    regularizer = tf.contrib.layers.l2_regularizer(weight_decay)
    if regularize_depthwise:
        depthwise_regularizer = regularizer
    else:
        depthwise_regularizer = None
    with slim.arg_scope([slim.conv2d, slim.separable_conv2d],
                        weights_initializer=weights_init,
                        normalizer_fn=slim.batch_norm,
                        normalizer_params=batch_norm_params):
        with slim.arg_scope([slim.batch_norm], **batch_norm_params):
            with slim.arg_scope([slim.conv2d], weights_regularizer=regularizer):
                with slim.arg_scope([slim.separable_conv2d], weights_regularizer=depthwise_regularizer) as sc:
                    return sc
```

<br> ![KakaoTalk_20190613_103513669](https://user-images.githubusercontent.com/48273803/59397314-2200d900-8dc7-11e9-82e4-ffd69722ad59.jpg)


    학습이 완료되면 label과 tffile이 출력<br>
![다운로드](https://user-images.githubusercontent.com/48273803/59397113-5f189b80-8dc6-11e9-8d91-a5e93462205f.jpg)


* Colab<br>
![3213](https://user-images.githubusercontent.com/48273803/59395063-0ee90b80-8dbd-11e9-8b1d-7e36e4c6f8c1.PNG)<br>

   * 성능<br>
   RAM : 13GB <br>
   저장공간 : 33GB
   * GPU 사용법<br>
   수정 > 노트설정 > 하드웨어 가속기 GPU 선택
   * GoogleDrive <br>
   https://drive.google.com/<br>
   ![캡처421](https://user-images.githubusercontent.com/48273803/59395195-a8182200-8dbd-11e9-82c2-13717584b8e8.PNG)<br>
   ![Inked캡처ee_LI](https://user-images.githubusercontent.com/48273803/59395511-4c4e9880-8dbf-11e9-9c96-b4fb7c141310.jpg)<br>
   수집한 데이터셋 압축 후 구글드라이브 업로드<br>
   *공유 : 모든 사용자가 볼 수 있음
   <br>링크 복사
```
   _URL = "https://docs.google.com/uc?export=ID값" 
   zip_file = tf.keras.utils.get_file(origin=_URL, 
                                   fname="압축파일명", 
                                   extract=True)<br>base_dir = os.path.join(os.path.dirname(zip_file), '하위 폴더명')
```

```
IMAGE_SIZE = 224
BATCH_SIZE = 64

datagen = tf.keras.preprocessing.image.ImageDataGenerator(
    rescale=1./255, 
    validation_split=0.2)

train_generator = datagen.flow_from_directory(
    base_dir,
    target_size=(IMAGE_SIZE, IMAGE_SIZE),
    batch_size=BATCH_SIZE, 
    subset='training')

val_generator = datagen.flow_from_directory(
    base_dir,
    target_size=(IMAGE_SIZE, IMAGE_SIZE),
    batch_size=BATCH_SIZE, 
    subset='validation')
```
* BATCH_SIZE = epochs를 나누어 실행하는 횟수 
* validation_slit = 비교데이터 
```
model = tf.keras.Sequential([
  base_model,
  tf.keras.layers.Conv2D(32, 3, activation='relu'),
  tf.keras.layers.Dropout(0.2),
  tf.keras.layers.GlobalAveragePooling2D(),
  tf.keras.layers.Dense(5, activation='softmax')
])
```
* Dense = 클래스 개수와 동일하게 설정
```
epochs = 10

history = model.fit(train_generator, 
                    epochs=epochs, 
                    validation_data=val_generator)
```
* epochs = 학습 횟수<br>
경로 : lite\examples\image_classification\android\app\src\main\assets <br>(Models.tffile, labels)
<br>
![asdfasdfasdfsadfsa](https://user-images.githubusercontent.com/48273803/59400965-18ca3900-8dd4-11e9-82f2-d94f48d43086.jpg)
<br>브랜드, 브랜드의 시장점유율, 로고 유사도 순 출력


## **7. 구글스피치**
![KakaoTalk_20190613_121350958](https://user-images.githubusercontent.com/48273803/59401303-3d72e080-8dd5-11e9-8687-fe6b5a18d0ee.png) <br>
검색에 여러 브랜드의 리스트를 제시해주고<br>
브랜드명 검색 가능<br>

* GoogleSpeech
<br>uses-permission android:name="android.permission.INTERNET <br>

```
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Search = (EditText)findViewById(R.id.search);
            if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {

                match_text_dialog = new Dialog(SearchActivity.this);
                match_text_dialog.setContentView(R.layout.activity_dialog_matches_frag);
                match_text_dialog.setTitle("찾으시는 내용이 있나요?");
                textlist = (ListView)match_text_dialog.findViewById(R.id.list);
            matches_text = data
                    .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, matches_text);
            textlist.setAdapter(adapter);
            textlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    Search.setText(matches_text.get(position));
                    match_text_dialog.hide();
                }
            });
            match_text_dialog.show();

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }
        super.onActivityResult(requestCode, resultCode, data);
    }
```
리스트뷰
```
public void search(String charText) {

        // 문자 입력시마다 리스트를 지우고 새로 뿌려준다.
        list.clear();

        // 문자 입력이 없을때는 모든 데이터를 보여준다.
        if (charText.length() == 0) {
            list.addAll(arraylist);
        }
        // 문자 입력을 할때..
        else
        {
            // 리스트의 모든 데이터를 검색한다.
            for(int i = 0;i < arraylist.size(); i++)
            {
                // arraylist의 모든 데이터에 입력받은 단어(charText)가 포함되어 있으면 true를 반환한다.
                if (arraylist.get(i).toLowerCase().contains(charText))
                {
                    // 검색된 데이터를 리스트에 추가한다.
                    list.add(arraylist.get(i));
                }
            }
        }
        // 리스트 데이터가 변경되었으므로 아답터를 갱신하여 검색된 데이터를 화면에 보여준다.
        adapter.notifyDataSetChanged();
    }
```

  ## **8. 유사어플과의 차이점**<br>
  ![KakaoTalk_20190613_033425856](https://user-images.githubusercontent.com/48273803/59402439-3cdc4900-8dd9-11e9-9e9f-c83aa0c87404.png)
  ![KakaoTalk_20190613_033431666](https://user-images.githubusercontent.com/48273803/59402442-3d74df80-8dd9-11e9-8869-7beb233ab67c.png)
  * 날씨에 따라 바뀌는 추천 코디
  * 로고 검색
  * 한국 뿐만이 아닌 영국, 일본 또한 대상으로 자국의 날씨로 해외의 코디를 체험 가능
