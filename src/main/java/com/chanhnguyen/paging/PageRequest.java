package com.chanhnguyen.paging;

import com.chanhnguyen.sorter.Sorter;

public class PageRequest implements Pageble {
	
	private Integer currentPage;
	private Integer limit;
	private Sorter sorter;


	public PageRequest() {
	}

	public PageRequest(Integer currentPage, Integer limit, Sorter sorter) {
		this.currentPage = currentPage;
		this.limit = limit;
		this.sorter = sorter;
	}

	@Override
	public Integer getCurrentPage() {
		return this.currentPage;
	}

	@Override
	public Integer getOffset() {
		//
		if (this.currentPage != null && this.limit != null) {
			return (this.currentPage - 1) * this.limit;
		}
		return null;
	}

	@Override
	public Integer getLimit() {
		return this.limit;
	}

	@Override
	public Sorter getSorter() {
		if (this.sorter != null) {
			return this.sorter;
		}
		return null;
	}

}
