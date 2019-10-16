package com.cardfit.project.controller;

import java.io.IOException;

import org.elasticsearch.search.SearchHits;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cardfit.project.service.CardService;


@RestController
@Component
public class CardController {
	public CardController() {
		System.out.println("*** Start CardController ***");
	}
//	private ELConfiguration elConfig;
	
	
	@Autowired
	private CardService service;

	
	//-------------------- ���񽺿��� ����Ǽ��³��� JSONArray�� �ٲ㼭 ����Ʈ�� �ѷ��ִ� ��-----------------
	
	// ���� ���1 : �� ī�� �˻�
	@GetMapping("/searchMyCardByCardName")
	public SearchHits searchMyCardByCardName() throws IOException{
		JSONArray result = new JSONArray();
		System.out.println("--����");
		SearchHits hitsResult = service.cardNameSearch("cardname", "����");
		System.out.println("--��");
		//result = (JSONArray)hitsResult;
		return hitsResult;
	}
	
	// ���� ���2 : ī�� ��õ(üũ�ڽ�)
	@GetMapping("/recommendCardByCheckBox")
	public JSONArray recommendCardByCheckBox(String[] terms) {
		JSONArray result = new JSONArray();
		return result;
	}
	
//	@GetMapping("/searchAllAboutBankByIndex")
//	public Object searchAllAboutBankByIndex(@RequestParam String index, @RequestParam String type, @RequestParam String id ) throws IOException {
//		GetRequest request = new GetRequest("shinhan","_doc","1");
//		GetResponse response = null;
//		try(RestHighLevelClient client = clientConnection())
//		{
//			response = client.get(request, RequestOptions.DEFAULT);
//			client.close();
//		}catch (ElasticsearchException e) {
//			if(e.status() == RestStatus.NOT_FOUND) {
//				System.out.println("client ���� ����");
//			}
//		}
//		return response.isExists() ? response : null;
//	}
//	
//	//index, cardname(ī���)���� ī�� �˻��ϱ�
//	//@GetMapping("/cardInfo")
//	public JSONObject getCardfromIndex(String cardName) {
//		JSONObject info = null;
//		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//		searchSourceBuilder.query(QueryBuilders.termQuery("cardname", cardName));
//		return info;
//	}
//	
//	//multi Query
//	@PostMapping("/multiQ")
//	@ResponseStatus(HttpStatus.OK)
//	public SearchResponse getAllMatchedInfo() {
//		System.out.println("getAllMatchedInfo ����");
//		
//	}
	
	
}
