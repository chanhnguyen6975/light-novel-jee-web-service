package com.chanhnguyen.paging;

import com.chanhnguyen.sorter.Sorter;

public interface Pageble {
	Integer getCurrentPage();
	Integer getOffset();
	Integer getLimit();
	Sorter getSorter();
}
