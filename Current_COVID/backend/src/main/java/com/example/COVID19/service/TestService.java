package com.example.COVID19.service;

import com.example.COVID19.model.C_CovidDto;
import com.example.COVID19.repository.C_Covid;
import com.example.COVID19.repository.C_CovidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Service
public class TestService {

    @Autowired
    C_CovidRepository repository;

    public List saveFromApi() throws Exception{

        // 본인이 받은 api키를 추가
        String key = "5lBEJMUflpy%2BpVCw4PlMxO64hHY1LwPai%2Fc1pKww9rnUF5n07l8w3oUVARU4h4s277M%2B3h1%2B32CNYwXkT2H2%2Bg%3D%3D";

        // parsing할 url 지정(API 키 포함해서)

        String SeoulDate = String.valueOf(Integer.parseInt(LocalDate.now(ZoneId.of("Asia/Seoul")).toString().replaceAll("-",""))-1);

        StringBuilder urlBuilder = new StringBuilder("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "="+key); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("startCreateDt", "UTF-8") + "=" + URLEncoder.encode("20200310", "UTF-8")); /*검색할 생성일 범위의 시작*/
        urlBuilder.append("&" + URLEncoder.encode("endCreateDt", "UTF-8") + "=" + URLEncoder.encode(SeoulDate, "UTF-8")); /*검색할 생성일 범위의 종료*/

        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
//            System.out.println("Response code: " + conn.getResponseCode());   //200, 300 404 등
        BufferedReader rd;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        List<C_CovidDto> list = getResultList(sb.toString());
//        System.out.println("list = " + list); //파싱 결과 확인
        return list;
    }

    private  List<C_CovidDto> getResultList(String data) throws Exception {

//결과값을 넣어줄 map을 선언해줍니다.
        List<C_CovidDto> result = new ArrayList<>();

        InputSource is = new InputSource(new StringReader(data));

//Document 클래스로 xml데이터를 취득합니다.
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);

//xPath 팩토리로 객체를 만듭니다.
        XPath xpath = XPathFactory.newInstance().newXPath();

//xPath를 컴파일한 후에 node단위로 데이터를 수집합니다.
        NodeList nodeList = (NodeList) xpath.compile("/response/body/items/item").evaluate(document, XPathConstants.NODESET);
        int nodeListCount = nodeList.getLength();
        for (int i = 0; i < nodeListCount; i++) {
            NodeList childNode = nodeList.item(i).getChildNodes();
            C_Covid c_Covid = new C_Covid();
            int childNodeCount = childNode.getLength();
            for (int j = 0; j < childNodeCount; j++) {
                c_Covid.setData(childNode.item(j).getNodeName(), childNode.item(j).getTextContent());
            }
            repository.save(c_Covid);
//            result.add(c_Covid);
        }


        return result;
    }

    /*public List getData(String index, String size, String startCreateDt, String endCreateDt)throws Exception {

        // 본인이 받은 api키를 추가
        String key = "5lBEJMUflpy%2BpVCw4PlMxO64hHY1LwPai%2Fc1pKww9rnUF5n07l8w3oUVARU4h4s277M%2B3h1%2B32CNYwXkT2H2%2Bg%3D%3D";

        // parsing할 url 지정(API 키 포함해서)

        StringBuilder urlBuilder = new StringBuilder("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson"); URL
        urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "="+key); Service Key
        urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode(index, "UTF-8")); 페이지번호
        urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode(size, "UTF-8")); 한 페이지 결과 수
        urlBuilder.append("&" + URLEncoder.encode("startCreateDt", "UTF-8") + "=" + URLEncoder.encode(startCreateDt, "UTF-8")); 검색할 생성일 범위의 시작
        urlBuilder.append("&" + URLEncoder.encode("endCreateDt", "UTF-8") + "=" + URLEncoder.encode(endCreateDt, "UTF-8")); 검색할 생성일 범위의 종료

        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
//            System.out.println("Response code: " + conn.getResponseCode());   //200, 300 404 등
        BufferedReader rd;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        List<C_CovidDto> list = getResultList(sb.toString());
//        System.out.println("list = " + list); //파싱 결과 확인
        return list;
    }*/

    public Object getListPage(int index, int size, String startCreateDt, String endCreateDt) {
        PageRequest pageRequest = PageRequest.of(index,size,Sort.by("seq").descending());
        return repository.findAll(pageRequest).getContent();
    }
}

