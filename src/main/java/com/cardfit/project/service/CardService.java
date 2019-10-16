package com.cardfit.project.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.script.ScriptType;
import org.elasticsearch.script.mustache.MultiSearchTemplateRequest;
import org.elasticsearch.script.mustache.MultiSearchTemplateResponse;
import org.elasticsearch.script.mustache.MultiSearchTemplateResponse.Item;
import org.elasticsearch.script.mustache.SearchTemplateRequest;
import org.elasticsearch.script.mustache.SearchTemplateResponse;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cardfit.project.config.ELConfiguration;

@Service
@Component
public class CardService {
	public CardService() {
		System.out.println("---- Service started ----");
	}

	@Autowired
	private ELConfiguration elConfig;
	// �� ī��˻�
	public SearchHits cardNameSearch(String fieldName, String queryTerm) {
		RestHighLevelClient client = elConfig.clientConnection();
		SearchRequest searchRequest = new SearchRequest();
		SearchResponse searchResponse = new SearchResponse();
		JSONArray result = new JSONArray();
		try {
			SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
			searchSourceBuilder.query(QueryBuilders.matchPhraseQuery(fieldName, queryTerm));
			searchRequest.source(searchSourceBuilder);
			searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
			client.close();
			
			SearchHit[] searchHits = searchResponse.getHits().getHits();
			for (SearchHit hit : searchHits) {
				System.out.println(hit.getSourceAsString());
				System.out.println(hit.getId());
			}
		}catch (IOException e) {
			System.out.println("�߻��� ���� : " + e.getMessage());
			//e.printStackTrace();
		}
		return searchResponse.getHits();
	}
	
	//ī�� ��õ(üũ�ڽ�)
//	public static SearchHits checkSearch() throws IOException {
//		RestHighLevelClient client = createConnection();
//		SearchRequest searchRequest = new SearchRequest();
//		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//		searchSourceBuilder.query(QueryBuilders.wildcardQuery("benefit.cafe", "*"));
//		searchSourceBuilder.query(QueryBuilders.wildcardQuery("benefit.onshop", "*"));
//		searchRequest.source(searchSourceBuilder);
//		SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
//		client.close();
//		SearchHit[] searchHits = searchResponse.getHits().getHits();
//		for (SearchHit hit : searchHits) {
//			System.out.println(hit.getSourceAsString());
//			System.out.println(hit.getId());
//
//		}
//		return searchResponse.getHits();
//	}

}
