package org.mak.sample.springdata.jpa.generic.config.aspect;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @author aa.azizkhani
 *
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RowFilter {

	private String filterName;
	private Map<String, Object> filterValues;
	private boolean enabled = true;

	public RowFilter(String filterName, Map<String, Object> filterValues) {
		super();
		this.filterName = filterName;
		this.filterValues = filterValues;
		this.enabled = true;
	}

}
