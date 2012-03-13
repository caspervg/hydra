package be.ugent.zeus.resto.client.data.services;

import java.util.ArrayList;

import be.ugent.zeus.resto.client.data.NewsItem;
import be.ugent.zeus.resto.client.data.caches.Cache;
import be.ugent.zeus.resto.client.data.caches.NewsCache;

public class NewsIntentService extends AbstractNewsIntentService {

	@Override
	public boolean filter(String path) {
		return path.startsWith("News");
	}

	@Override
	public String cacheKey() {
		return "newsItemList";
	}

	@Override
	public Cache<ArrayList<NewsItem>> getCache() {
		return NewsCache.getInstance(this);
	}
}
