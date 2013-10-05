package nz.co.aetheric.shiva.persist.api;

import java.util.List;

public interface QueryManager<QueryType extends Query<?, ResultType>, ResultType> {

	public QueryType getQuery();

	public ResultType getResult(QueryType query);

	public ResultType getFirstResult(QueryType query);

	public List<ResultType> getResultList(QueryType query);

	public PaginatedResultList<ResultType> getPaginatedResultList(QueryType query, int max, int start);

}