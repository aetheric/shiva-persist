package nz.co.aetheric.shiva.persist.api;

import java.util.List;

public class PaginatedResultList<ResultType> {
	private final List<ResultType> results;
	private final int total;

	public PaginatedResultList(List<ResultType> results, int total) {
		this.results = results;
		this.total = total;
	}

	public List<ResultType> getResults() {
		return this.results;
	}

	public int getTotal() {
		return this.total;
	}

}