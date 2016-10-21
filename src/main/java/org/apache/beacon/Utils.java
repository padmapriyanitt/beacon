package org.apache.beacon;

import java.util.Collection;

import org.springframework.stereotype.Component;
@Component
public class Utils {
	public long getIterableSize(Iterable values) {
		if (values==null){
			return 0;
		}
		if (values instanceof Collection<?>) {
			return ((Collection<?>) values).size();
		}
		long size = 0L;
		for (Object value : values) {
			size++;
		}
		return size;
	}

}
