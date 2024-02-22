package kr.or.iei.search.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.iei.store.model.dto.Store;
import kr.or.iei.store.model.service.StoreService;

@Controller
@RequestMapping(value = "/search")
public class SearchController {
	@Autowired
	private StoreService storeService;
	
	
	@GetMapping(value="/searchStoreBySubway")
	public String searchStorePageBySubway() {
		return "search/searchStoreBySubway";
	}
	
	@GetMapping(value="/searchStore")
	public String searchStore() {
		return "search/searchStore";
	}
	
	@ResponseBody
	@GetMapping(value = "/ajaxSelectTop5Store")
	public List ajaxSelectTop5Store(String stationName) {
		int number = 5;
		List list = storeService.selectTopStore(stationName,number);
		if(list.isEmpty()) {
			return null;
		}else {
			System.out.println(list);
			return list;
		}
	}
	
	//@ResponseBody
	//@GetMapping(value = "")
	
	@GetMapping(value="storeDetail")
	public String storeDetail() {
		return "search/storeDetail";
	}
	
}
