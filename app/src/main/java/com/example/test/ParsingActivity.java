package com.example.test;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class ParsingActivity extends AppCompatActivity {
    //XmlPullParser xpp;
    TextView text; //textview
    String data; //xml데이터 저장변수
    String body_code; //메인액티비티의 부위 검색 코드 저장 변수 string형태로 사용해야 됨
    Double user_lat=((GPSActivity)GPSActivity.context).latitude;
    Double user_long=((GPSActivity)GPSActivity.context).longitude;
    String st_lat = String.valueOf(user_lat);
    String st_long = String.valueOf(user_long);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parsing);

        text= (TextView)findViewById(R.id.result); //textview부분 검색 결과가 나옴 id가 result 스크롤뷰 속에 포함
        body_code=((MainPageActivity)MainPageActivity.context).body_num; //body액티비티의 부위 검색 코드 변수 불러옴
        body_code=((detailpageActivity)detailpageActivity.context).body_num;
    }

    //parseBt 클릭시 파싱 시작
    public void mOnClick(View v){
        switch (v.getId()){
            case R.id.parseBt:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        data=getXmlData(); //xml데이터가 data에 저장됨

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                text.setText(data);
                            } //textview에 data결과보여줌
                        });
                    }
                }).start();
                break;
        }
    }

    String getXmlData(){
        StringBuffer buffer=new StringBuffer();

        String code = body_code; //body_code의 변수 머리01,팔02... 저장변수
        //queryUrl의 dgsbjtCd는 진료과목코드 +기호로 감싸서 집어넣음
        String queryUrl="http://apis.data.go.kr/B551182/hospInfoService1/getHospBasisList1?&dgsbjtCd="+code+"&xPos="+st_long+"&yPos="+st_lat+"&radius=3000&ServiceKey=r9jyL2NkpVcuBVGBhXuqt9zUm1Tx8jqODswH9bpdadQR7PPHpy52GCsO9%2Bwb%2FBB%2BCj6LePdP6vOzak4vPDz35Q%3D%3D";
        try{
            URL url= new URL(queryUrl);//문자열로 된 요청 url을 URL 객체로 생성.
            InputStream is= url.openStream(); //url위치로 입력스트림 연결

            XmlPullParserFactory factory= XmlPullParserFactory.newInstance();//xml파싱을 위한
            XmlPullParser xpp= factory.newPullParser();
            xpp.setInput( new InputStreamReader(is, "UTF-8") ); //inputstream 으로부터 xml 입력받기

            String tag;

            xpp.next();
            int eventType= xpp.getEventType();
            while( eventType != XmlPullParser.END_DOCUMENT ){
                switch( eventType ){
                    case XmlPullParser.START_DOCUMENT:
                        buffer.append("파싱 시작...\n\n");
                        break;

                    case XmlPullParser.START_TAG:
                        tag= xpp.getName();//테그 이름 얻어오기

                        if(tag.equals("item")) ;// 첫번째 검색결과
                        else if(tag.equals("addr")){
                            buffer.append("주소 : ");
                            xpp.next();
                            buffer.append(xpp.getText());//title 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n"); //줄바꿈 문자 추가
                        }
                        else if(tag.equals("telno")){
                            buffer.append("전화번호 :");
                            xpp.next();
                            buffer.append(xpp.getText());//mapy 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n"); //줄바꿈 문자 추가
                        }
                        /*else if(tag.equals("XPos")){
                            buffer.append("위도 :");
                            xpp.next();
                            buffer.append(xpp.getText());//mapy 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n"); //줄바꿈 문자 추가
                        }
                        else if(tag.equals("YPos")){
                            buffer.append("경도 :");
                            xpp.next();
                            buffer.append(xpp.getText());//mapy 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n"); //줄바꿈 문자 추가
                        }*/
                        else if(tag.equals("yadmNm")){
                            buffer.append("병원명 :");
                            xpp.next();
                            buffer.append(xpp.getText());//mapy 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n"); //줄바꿈 문자 추가
                        }


                        break;

                    case XmlPullParser.TEXT:
                        break;

                    case XmlPullParser.END_TAG:
                        tag= xpp.getName(); //테그 이름 얻어오기

                        if(tag.equals("item")) buffer.append("\n");// 첫번째 검색결과종료..줄바꿈
                        break;
                }

                eventType= xpp.next();
            }

        } catch (Exception e){
            e.printStackTrace();
        }

       // buffer.append("파싱 끝\n");
        return buffer.toString();//StringBuffer 문자열 객체 반환

    }//getXmlData method....
}
